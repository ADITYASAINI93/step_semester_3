/**
 * Problem 2 - Duplicate Player Pick Checker
 * Check for duplicate player names using nested loops (no Collections).
 */
public class Problem2 {

    /**
     * Finds the first duplicate player name in the lineup using nested loops.
     * Compares every name against every other name that comes after it.
     *
     * @param playerNames array of player names to check
     * @return "Duplicate Found: <name>" if duplicate exists, "No Duplicates Found" otherwise
     */
    static String findDuplicatePick(String[] playerNames) {
        // Compare each name against names that come after it
        for (int i = 0; i < playerNames.length; i++) {
            for (int j = i + 1; j < playerNames.length; j++) {
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Test case 1 - has duplicate
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println("Test 1: " + findDuplicatePick(lineup1));
        // Expected: Duplicate Found: Kohli

        // Test case 2 - no duplicates
        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println("Test 2: " + findDuplicatePick(lineup2));
        // Expected: No Duplicates Found

        // Test case 3 - duplicate at end
        String[] lineup3 = {"Player1", "Player2", "Player3", "Player1"};
        System.out.println("Test 3: " + findDuplicatePick(lineup3));
        // Expected: Duplicate Found: Player1

        // Test case 4 - case sensitive (Kohli vs kohli)
        String[] lineup4 = {"Kohli", "kohli", "Rohit"};
        System.out.println("Test 4: " + findDuplicatePick(lineup4));
        // Expected: No Duplicates Found

        // Test case 5 - multiple duplicates, first one reported
        String[] lineup5 = {"A", "B", "A", "B"};
        System.out.println("Test 5: " + findDuplicatePick(lineup5));
        // Expected: Duplicate Found: A

        // Test case 6 - empty array
        String[] lineup6 = {};
        System.out.println("Test 6: " + findDuplicatePick(lineup6));
        // Expected: No Duplicates Found

        // Test case 7 - single element
        String[] lineup7 = {"Single"};
        System.out.println("Test 7: " + findDuplicatePick(lineup7));
        // Expected: No Duplicates Found
    }
}