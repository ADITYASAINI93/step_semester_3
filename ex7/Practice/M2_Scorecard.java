class Scorecard {
    private final int totalQuestions;
    private boolean[] results;
    private int recordedCount;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.recordedCount = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (this.recordedCount < this.totalQuestions) {
            this.results[this.recordedCount] = isCorrect;
            this.recordedCount++;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < this.recordedCount; i++) {
            if (this.results[i]) {
                score++;
            }
        }
        return score;
    }

    public int getTotalQuestions() {
        return this.totalQuestions;
    }
}

public class M2_Scorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);

        System.out.println("Score: " + sc.getScore()); // Expected: 3
        System.out.println("Total questions: " + sc.getTotalQuestions()); // Expected: 4

        // Try to record more answers than allowed
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        System.out.println("Score after trying to record extra: " + sc.getScore()); // Expected: still 3
    }
}