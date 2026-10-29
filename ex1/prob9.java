package ex1;


public class prob9 {

    static void analyzeInventory(int[] sectionA, int[] sectionB) {
        int totalA = 0;
        int totalB = 0;

        for (int quantity : sectionA)
            totalA += quantity;

        for (int quantity : sectionB)
            totalB += quantity;

        String status = (totalA == totalB)
                        ? "Balanced" : "Not Balanced";

        int maxQuantity = sectionA[0];
        String maxSection = "Section A";
        int maxIndex = 0;

        for (int i = 0; i < sectionA.length; i++) {
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxIndex = i;
            }

            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxIndex = i;
            }
        }

        System.out.println("Section A Total: " + totalA
            + " | Section B Total: " + totalB
            + " | Status: " + status);

        System.out.println("Highest Quantity: " + maxQuantity
            + " (" + maxSection + ", Item " + (maxIndex + 1) + ")");
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};

        analyzeInventory(sectionA, sectionB);
    }
}
