import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ask for sentence
        System.out.println("Enter a sentence:");
        String sentence = sc.nextLine();

        // Ask for delimiter word
        System.out.println("Enter a delimiter (a word):");
        String delimiterWord = sc.nextLine();

        // Replace the delimiter word with a single character (e.g., '|')
        //tring modifiedSentence = sentence.replace(delimiterWord, "|");

        // Create a StringTokenizer to split the sentence using '|' as the delimiter
        StringTokenizer st = new StringTokenizer(sentence, delimiterWord);

        System.out.println("Tokens are:");
        // Loop through all tokens in the StringTokenizer
        while (st.hasMoreTokens()) {
            // Get the next token, remove extra spaces from start and end, and print it
            System.out.println(st.nextToken().trim()); // remove extra spaces
        }
    }
}
