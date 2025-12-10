import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Collections;

class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        
        List<String> wordsA = new ArrayList<>();
        wordsA.add("apple");
        wordsA.add("ant");


        List<String> wordsB = new ArrayList<>();
        wordsB.add("ball");
        
        HashMap<Character, List<String>> dictionnary = new HashMap<>();
        dictionnary.put('a', wordsA);
        dictionnary.put('b', wordsB);
        while(true){
        
        System.out.println("Press 1 to search for words:");
        System.out.println("Press 2 to add a word:");
        System.out.println("Press 3: Exit");
               System.out.println("Press 4 to display all dictionnary");


        int choice = sc.nextInt(); 

        switch (choice) {
            case 1:
                System.out.println("Enter a letter to see words starting with it:");
                char letter = sc.next().charAt(0);
                printWords(dictionnary, letter);
                break;

                case 2:
                    System.out.println("Enter a word that you want to enter");
                    String word = sc.next();
                    addWord(dictionnary,word);
                    break;
                case 3:
                    System.out.println("Exit !!!!!");
                    return;
                    case 4:
                        printAll(dictionnary);
                        break;
            default:
                System.out.println("Invalid choice");
        }
    }
    }

    public static void printWords(HashMap<Character, List<String>> dictionnary, Character letter) {
        if (dictionnary == null) {
            System.out.println("Error: Dictionary is missing.");
            return;
        }

        List<String> words = dictionnary.get(letter);

        if (words != null) {
            System.out.println(words);
        } else {
            System.out.println("No words found for this letter");
        }
    }
    public static void addWord(HashMap<Character, List<String>> dictionnary,String word){
        String lowerWord= word.toLowerCase();
        char letter = lowerWord.charAt(0);
        if(dictionnary.containsKey(letter)){
            List<String> currentWords = dictionnary.get(letter);
            currentWords.add(word);
            Collections.sort(currentWords);
             System.out.println("The words for this letter ater you added are: ");
             System.out.println(currentWords);
        }

        else{
            System.out.println("there are no other words starting with: " + letter + "I will create a new section for this word");
            List<String>newWords=new ArrayList<>();
            dictionnary.put(letter,newWords);
            newWords.add(word);
             Collections.sort(newWords);
             System.out.println("The words for this letter afer you added are: ");
            System.out.println(newWords);
        }
    }
    public static void printAll(HashMap<Character, List<String>> dictionnary) {
    if (dictionnary.isEmpty()) {
        System.out.println("Dictionary is empty.");
        return;
    }
    for (Character key : dictionnary.keySet()) {
        System.out.println(key + ": " + dictionnary.get(key));
    }

    
}

}