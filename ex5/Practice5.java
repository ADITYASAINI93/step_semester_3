import java.util.Arrays;

/**
 * Practice Problem 5 - Placement Drive Shortlisting & Ranking Engine
 * Candidate class with overloaded isEligible methods and Comparable implementation.
 */
class Candidate implements Comparable<Candidate> {
    private String name;
    private double cgpa;
    private int codingScore;

    /**
     * Constructor for Candidate.
     */
    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getCgpa() {
        return cgpa;
    }

    public int getCodingScore() {
        return codingScore;
    }

    /**
     * Composite score = CGPA * 10 + codingScore
     * This gives weight to both CGPA (0-10 scale, so *10 = 0-100) and coding score (0-100)
     */
    public double getCompositeScore() {
        return cgpa * 10 + codingScore;
    }

    /**
     * Overloaded isEligible - CGPA-only quick filter.
     * Candidates with CGPA >= 7.5 are eligible regardless of coding score.
     */
    static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    /**
     * Overloaded isEligible - combined CGPA and coding score filter.
     * Candidates with CGPA >= 6.5 AND codingScore >= 60 are eligible.
     */
    static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    /**
     * Compares candidates by composite score in descending order.
     * Higher composite score comes first.
     */
    @Override
    public int compareTo(Candidate other) {
        // Descending order: higher composite score first
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }

    @Override
    public String toString() {
        return name + " (" + getCompositeScore() + ")";
    }
}

public class Practice5 {

    /**
     * Filters eligible candidates and ranks them by composite score descending.
     *
     * @param candidates array of Candidate objects
     * @return formatted string with ranked candidate names and composite scores
     */
    static String shortlistAndRank(Candidate[] candidates) {
        // First, count how many candidates are eligible
        int eligibleCount = 0;
        for (Candidate c : candidates) {
            boolean eligible;
            // Use CGPA-only rule if CGPA >= 7.5, else combined rule
            if (Candidate.isEligible(c.getCgpa())) {
                eligible = true;
            } else {
                eligible = Candidate.isEligible(c.getCgpa(), c.getCodingScore());
            }
            if (eligible) {
                eligibleCount++;
            }
        }

        // Create array of eligible candidates
        Candidate[] eligibleCandidates = new Candidate[eligibleCount];
        int index = 0;
        for (Candidate c : candidates) {
            boolean eligible;
            if (Candidate.isEligible(c.getCgpa())) {
                eligible = true;
            } else {
                eligible = Candidate.isEligible(c.getCgpa(), c.getCodingScore());
            }
            if (eligible) {
                eligibleCandidates[index++] = c;
            }
        }

        // Sort using Arrays.sort - Candidate implements Comparable
        Arrays.sort(eligibleCandidates);

        // Build result string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < eligibleCandidates.length; i++) {
            if (i > 0) {
                result.append(" | ");
            }
            result.append(i + 1).append(". ").append(eligibleCandidates[i].toString());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test case from problem
        Candidate[] candidates1 = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };
        System.out.println("Test 1: " + shortlistAndRank(candidates1));
        // Expected: 1. Aisha (122.0) | 2. Rohit (133.0) | 3. Karan (95.0)
        // Wait, let me recalculate composite scores:
        // Aisha: 8.2 * 10 + 40 = 82 + 40 = 122
        // Rohit: 6.8 * 10 + 65 = 68 + 65 = 133
        // Meena: 6.0 * 10 + 90 = 60 + 90 = 150 (but not eligible - CGPA < 6.5)
        // Karan: 7.5 * 10 + 20 = 75 + 20 = 95
        // Eligible: Aisha (CGPA >= 7.5), Rohit (CGPA >= 6.5 and coding >= 60), Karan (CGPA >= 7.5)
        // Sorted by composite: Rohit (133), Aisha (122), Karan (95)
        // Expected: 1. Rohit (133.0) | 2. Aisha (122.0) | 3. Karan (95.0)

        // Test case 2 - all CGPA eligible
        Candidate[] candidates2 = {
            new Candidate("A", 8.0, 30),
            new Candidate("B", 9.0, 20),
            new Candidate("C", 7.5, 40)
        };
        System.out.println("Test 2: " + shortlistAndRank(candidates2));
        // A: 80+30=110, B: 90+20=110, C: 75+40=115
        // Expected: 1. C (115.0) | 2. A (110.0) | 3. B (110.0)

        // Test case 3 - only combined rule eligible
        Candidate[] candidates3 = {
            new Candidate("X", 7.0, 70),   // CGPA >= 6.5, coding >= 60
            new Candidate("Y", 6.8, 65),   // CGPA >= 6.5, coding >= 60
            new Candidate("Z", 6.0, 90)    // CGPA < 6.5, NOT eligible
        };
        System.out.println("Test 3: " + shortlistAndRank(candidates3));
        // X: 70+70=140, Y: 68+65=133
        // Expected: 1. X (140.0) | 2. Y (133.0)

        // Test case 4 - borderline CGPA but low coding score
        Candidate[] candidates4 = {
            new Candidate("Fit", 7.0, 70),     // eligible via combined
            new Candidate("NotFit", 7.0, 50)   // CGPA >= 6.5 but coding < 60
        };
        System.out.println("Test 4: " + shortlistAndRank(candidates4));
        // Expected: 1. Fit (140.0)

        // Test case 5 - empty array
        Candidate[] candidates5 = {};
        System.out.println("Test 5: " + shortlistAndRank(candidates5));
        // Expected: (empty string)

        // Test case 6 - single eligible candidate
        Candidate[] candidates6 = {
            new Candidate("Solo", 8.0, 50)
        };
        System.out.println("Test 6: " + shortlistAndRank(candidates6));
        // Expected: 1. Solo (130.0)
    }
}