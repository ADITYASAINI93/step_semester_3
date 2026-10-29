package ex2;
public class p2 {

    static String reverseEachWord(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            StringBuilder reversed = new StringBuilder();

            for (int j = words[i].length() - 1; j >= 0; j--) {
                reversed.append(words[i].charAt(j));
            }

            if (i > 0) {
                result.append(" ");
            }

            result.append(reversed);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String sentence = "hello club";
        System.out.println(reverseEachWord(sentence));
    }
}