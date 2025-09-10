import java.util.*;

public class FirstFit {
    static class Partition {
        int partitionNumber;
        int size;
        boolean free;
        int jobNumber; // -1 if free
        int jobSize;
        int internalFragmentation;

        Partition(int partitionNumber, int size) {
            this.partitionNumber = partitionNumber;
            this.size = size;
            this.free = true;
            this.jobNumber = -1;
            this.jobSize = 0;
            this.internalFragmentation = 0;
        }
    }

    static class Job {
        int jobNumber;
        int size;
        String status; // 'Waiting', 'Never be Accommodated', 'Allocated'
        int allocatedPartition; // -1 if not allocated

        Job(int jobNumber, int size) {
            this.jobNumber = jobNumber;
            this.size = size;
            this.status = "Waiting";
            this.allocatedPartition = -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int totalMemory = 0;
        while (true) {
            System.out.print("Enter total memory size (1000 - 2000 KB): ");
            if (sc.hasNextInt()) {
                int t = sc.nextInt();
                if (t >= 1000 && t <= 2000) {
                    totalMemory = t;
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("Invalid input. Please enter a value between 1000 and 2000.");
        }

        int numPartitions = 0;
        while (true) {
            System.out.print("Enter number of partitions: ");
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n > 0) {
                    numPartitions = n;
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("Invalid input. Please enter a positive integer.");
        }

        Partition[] partitions = new Partition[numPartitions];
        int partitionTotal = 0;
        for (int i = 0; i < numPartitions; i++) {
            while (true) {
                System.out.print("Enter size for Partition " + (i + 1) + " (100 - 500 KB): ");
                if (sc.hasNextInt()) {
                    int sz = sc.nextInt();
                    if (sz >= 100 && sz <= 500 &&
                            partitionTotal + sz <= totalMemory) {
                        partitions[i] = new Partition(i + 1, sz);
                        partitionTotal += sz;
                        break;
                    }
                } else {
                    sc.next();
                }
                System.out.println("Invalid input. Please enter a value between 100 and 500, and total must not exceed "
                        + totalMemory + " KB.");
            }
        }

        int numJobs = 0;
        while (true) {
            System.out.print("Enter number of jobs: ");
            if (sc.hasNextInt()) {
                int n = sc.nextInt();
                if (n > 0) {
                    numJobs = n;
                    break;
                }
            } else {
                sc.next();
            }
            System.out.println("Invalid input. Please enter a positive integer.");
        }

        Job[] jobs = new Job[numJobs];
        for (int i = 0; i < numJobs; i++) {
            while (true) {
                System.out.print("Enter size for Job " + (i + 1) + " (>= 1 KB): ");
                if (sc.hasNextInt()) {
                    int sz = sc.nextInt();
                    if (sz >= 1) {
                        jobs[i] = new Job(i + 1, sz);
                        break;
                    }
                } else {
                    sc.next();
                }
                System.out.println("Invalid input. Please enter a value >= 1.");
            }
        }

        // Allocation Phase
        for (Job job : jobs) {
            int maxPartitionSize = Arrays.stream(partitions).mapToInt(p -> p.size).max().orElse(0);
            if (job.size > maxPartitionSize) {
                job.status = "Never be Accommodated";
                continue;
            }

            boolean allocated = false;
            for (Partition partition : partitions) {
                if (partition.free && partition.size >= job.size) {
                    // Allocate
                    job.allocatedPartition = partition.partitionNumber;
                    job.status = "Allocated";
                    allocated = true;

                    partition.free = false;
                    partition.jobNumber = job.jobNumber;
                    partition.jobSize = job.size;
                    partition.internalFragmentation = partition.size - job.size;
                    break;
                }
            }
            if (!allocated && !job.status.equals("Never be Accommodated")) {
                job.status = "Waiting";
            }
        }

        printMemoryTable(partitions, jobs, totalMemory);

        sc.close();
    }

    static void printMemoryTable(Partition[] partitions, Job[] jobs, int totalMemory) {
        String line = "------------------------------------------------------------------------------------------------";
        System.out.println("\nMemory Allocation Table:");
        System.out.println(line);
        System.out.printf("| %-14s | %-14s | %-10s | %-10s | %-8s | %-21s |\n",
                "Partition No.", "Partition Size", "Job No.", "Job Size", "Status", "Internal Frag");
        System.out.println(line);

        int totalUsedMemory = 0;
        int totalInternalFrag = 0;

        for (Partition partition : partitions) {
            String status = partition.free ? "Free" : "Busy";
            String jobNo = partition.free ? "-" : String.valueOf(partition.jobNumber);
            String jobSize = partition.free ? "-" : String.valueOf(partition.jobSize);
            int frag = partition.free ? 0 : partition.internalFragmentation;
            if (!partition.free) {
                totalUsedMemory += partition.jobSize;
                totalInternalFrag += partition.internalFragmentation;
            }
            System.out.printf("| %-14d | %-14d | %-10s | %-10s | %-8s | %-21d |\n",
                    partition.partitionNumber, partition.size, jobNo, jobSize, status, frag);
        }

        System.out.println(line);
        System.out.printf("Total Memory: %d KB\n", totalMemory);
        System.out.printf("Total Used Memory: %d KB\n", totalUsedMemory);
        System.out.printf("Total Internal Fragmentation: %d KB\n\n", totalInternalFrag);

        System.out.println("Job Statuses:");
        for (Job job : jobs) {
            switch (job.status) {
                case "Allocated":
                    System.out.printf("Process/Job %d: Allocated to Partition %d\n", job.jobNumber,
                            job.allocatedPartition);
                    break;
                case "Never be Accommodated":
                    System.out.printf("Process/Job %d: Never be Accommodated\n", job.jobNumber);
                    break;
                case "Waiting":
                default:
                    System.out.printf("Process/Job %d: Waiting\n", job.jobNumber);
                    break;
            }
        }
    }
}