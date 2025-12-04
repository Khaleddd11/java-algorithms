import java.util.Scanner;
public class Main{
    public static void main (String []args){
        
        Scanner scanner= new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String sentence=scanner.nextLine();

        System.out.println("Enter a word to count:");
        String wordToCount=scanner.nextLine();  

        CountWord cw = new CountWord();

        int result = cw.countOccurrences(sentence, wordToCount);
        System.out.println("The word occurs " + result + " times.");
        
    }
    
}