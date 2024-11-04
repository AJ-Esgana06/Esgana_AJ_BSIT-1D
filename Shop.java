public class Main {
    public static void main (String[] args) {
        int books = 150;
        int pen = 10;
        int notebooks = 25;
        double discount = .15;
        
        double Total = (books * 2) + (pen * 5) + (notebooks * 3);
        
        System.out.println(Total);
        if (Total >= 350) { 
        double discountedPrice = Total * discount;
        System.out.println("DiscountAmount: " + discountedPrice );
        System.out.println("Total Bills: " + (Total - discountedPrice));
        System.out.println("Got Discount ");
        } else {
            System.out.println("No Discount");
        }
    }
}