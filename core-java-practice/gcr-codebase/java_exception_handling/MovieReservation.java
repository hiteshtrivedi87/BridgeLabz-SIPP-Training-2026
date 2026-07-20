public class MovieReservation {
    
    private static final int[] SEATS = {101, 102, 103, 104, 105};

    public static int getSeat(int index) {
        try {
            return SEATS[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Invalid seat selection. Position " + index + " does not exist.");
            return -1; 
        }
    }

    public static void main(String[] args) {
        int seat1 = getSeat(2);
        System.out.println("Result: " + seat1); 

        int seat2 = getSeat(8);
        System.out.println("Result: " + seat2); 
    }
}