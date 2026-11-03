import java.util.Arrays;

/**
 * Problem 5 - Fantasy League Auto-Draft Ranking Engine
 * Player class with overloaded isDraftable methods and Comparable implementation.
 */
class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    /**
     * Constructor for Player.
     */
    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public double getBattingAverage() {
        return battingAverage;
    }

    public boolean isInjured() {
        return injured;
    }

    /**
     * Overloaded isDraftable - experience-only rule for established players.
     * Players with 10+ matches are draftable regardless of fitness.
     */
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Overloaded isDraftable - combined matches and fitness rule.
     * Players with 5+ matches AND not injured are draftable.
     */
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    /**
     * Compares players by fantasy points (batting average) in descending order.
     * Higher batting average comes first.
     */
    @Override
    public int compareTo(Player other) {
        // Descending order: higher batting average first
        return Double.compare(other.battingAverage, this.battingAverage);
    }

    @Override
    public String toString() {
        return name;
    }
}

public class Problem5 {

    /**
     * Filters draftable players and ranks them by fantasy points (batting average) descending.
     *
     * @param players array of Player objects
     * @return formatted string with ranked player names
     */
    static String draftAndRank(Player[] players) {
        // First, count how many players are draftable
        int draftableCount = 0;
        for (Player p : players) {
            boolean draftable;
            // Use experience-only rule if matches >= 10, else combined rule
            if (Player.isDraftable(p.getMatchesPlayed())) {
                draftable = true;
            } else {
                draftable = Player.isDraftable(p.getMatchesPlayed(), p.isInjured());
            }
            if (draftable) {
                draftableCount++;
            }
        }

        // Create array of draftable players
        Player[] draftablePlayers = new Player[draftableCount];
        int index = 0;
        for (Player p : players) {
            boolean draftable;
            if (Player.isDraftable(p.getMatchesPlayed())) {
                draftable = true;
            } else {
                draftable = Player.isDraftable(p.getMatchesPlayed(), p.isInjured());
            }
            if (draftable) {
                draftablePlayers[index++] = p;
            }
        }

        // Sort using Arrays.sort - Player implements Comparable
        Arrays.sort(draftablePlayers);

        // Build result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftablePlayers.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(draftablePlayers[i].getName());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test case from problem
        Player[] players1 = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        System.out.println("Test 1: " + draftAndRank(players1));
        // Expected: 1. Rahul | 2. Virat | 3. Dev
        // Explanation: Virat (15 matches >= 10) and Dev (12 matches >= 10) clear experience-only bar
        // Rahul (7 matches < 10, but >= 5 and not injured) clears combined rule
        // Sameer (3 matches < 5) clears neither rule

        // Test case 2 - all experienced players
        Player[] players2 = {
            new Player("A", 10, 40.0, true),
            new Player("B", 15, 50.0, false),
            new Player("C", 12, 30.0, true)
        };
        System.out.println("Test 2: " + draftAndRank(players2));
        // Expected: 1. B | 2. A | 3. C (all have >= 10 matches)

        // Test case 3 - no experienced, only combined rule
        Player[] players3 = {
            new Player("X", 5, 50.0, false),
            new Player("Y", 7, 40.0, false),
            new Player("Z", 4, 60.0, false)  // Only 4 matches, fails combined rule
        };
        System.out.println("Test 3: " + draftAndRank(players3));
        // Expected: 1. X | 2. Y (Z has < 5 matches)

        // Test case 4 - injured players with combined rule
        Player[] players4 = {
            new Player("Fit", 6, 45.0, false),
            new Player("Injured", 8, 55.0, true)  // >=5 matches but injured
        };
        System.out.println("Test 4: " + draftAndRank(players4));
        // Expected: 1. Fit (Injured fails combined rule due to injury)

        // Test case 5 - empty array
        Player[] players5 = {};
        System.out.println("Test 5: " + draftAndRank(players5));
        // Expected: (empty string)

        // Test case 6 - single draftable player
        Player[] players6 = {
            new Player("Solo", 10, 50.0, true)
        };
        System.out.println("Test 6: " + draftAndRank(players6));
        // Expected: 1. Solo
    }
}