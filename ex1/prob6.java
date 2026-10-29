package ex1;


public class prob6 {

    static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            boolean alreadyPrinted = false;

            // Check whether this number appeared earlier
            for (int k = 0; k < i; k++) {
                if (seatNumbers[k] == seatNumbers[i]) {
                    alreadyPrinted = true;
                    break;
                }
            }

            if (alreadyPrinted)
                continue;

            // Check for duplicates after the current position
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println(
                        "Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                    break;
                }
            }
        }

        if (!found)
            System.out.println("No Duplicate Seats Found");
    }

    public static void main(String[] args) {
        int[] seats = {101, 102, 103, 102, 105};
        checkDuplicateSeats(seats);
    }
}
