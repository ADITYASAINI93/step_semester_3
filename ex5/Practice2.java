/**
 * Practice Problem 2 - Duplicate Team Name Finder
 * Find first duplicate team name using nested loops.
 */
public class Practice2 {

    /**
     * Finds the first duplicate team name using nested loops.
     * Compares each name against names that come after it.
     *
     * @param teamNames array of team names to check
     * @return "Duplicate Found: <name>" or "No Duplicates Found"
     */
    static String findDuplicateTeam(String[] teamNames) {
        for (int i = 0; i < teamNames.length; i++) {
            for (int j = i + 1; j < teamNames.length; j++) {
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        return "No Duplicates Found";
    }

    public static void main(String[] args) {
        // Test case 1 - duplicate exists
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println("Test 1: " + findDuplicateTeam(teams1));
        // Expected: Duplicate Found: ByteForce

        // Test case 2 - no duplicates
        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println("Test 2: " + findDuplicateTeam(teams2));
        // Expected: No Duplicates Found

        // Test case 3 - duplicate at end
        String[] teams3 = {"TeamA", "TeamB", "TeamC", "TeamA"};
        System.out.println("Test 3: " + findDuplicateTeam(teams3));
        // Expected: Duplicate Found: TeamA

        // Test case 4 - case sensitive
        String[] teams4 = {"Team", "team", "TEAM"};
        System.out.println("Test 4: " + findDuplicateTeam(teams4));
        // Expected: No Duplicates Found

        // Test case 5 - multiple duplicates, first one
        String[] teams5 = {"A", "B", "A", "B"};
        System.out.println("Test 5: " + findDuplicateTeam(teams5));
        // Expected: Duplicate Found: A

        // Test case 6 - empty array
        String[] teams6 = {};
        System.out.println("Test 6: " + findDuplicateTeam(teams6));
        // Expected: No Duplicates Found
    }
}