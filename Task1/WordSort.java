import java.util.Arrays;

public class WordSort {
    public static void main(String[] args) {
        String soliloquy  = "To be or not to be, that is the question;"
                + "Whether 'tis nobler in the mind to suffer"
                + "the slings and arrows of outrageous fortune"
                +  "or to take arms against a sea of troubles"
                +  "and by opposing end them?";

        String[] words = soliloquy.split("\\W+");

        Arrays.sort(words, String.CASE_INSENSITIVE_ORDER);

        for (String word : words) {
            System.out.println(word);
        }
    }
}
