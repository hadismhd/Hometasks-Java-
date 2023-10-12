import java.util.Arrays;

public class WordSort {
    public static void main(String[] args) {
        String soliloquy  = "To be or not to be, that is the question;"
                + "Whether 'tis nobler in the mind to suffer"
                + "the slings and arrows of outrageous fortune"
                +  "or to take arms against a sea of troubles"
                +  "and by opposing end them?";
        // Step 1: Extract words from the soliloquy
        String[] words = soliloquy.split("\\W+");

        // Step 2: Sort the words in alphabetical order
        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);

        // Step 3: Print the sorted words
        for (String word : words) {
            System.out.println(word);
        }
    }
}