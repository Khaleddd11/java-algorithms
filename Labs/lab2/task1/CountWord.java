import java.util.Scanner;
public class CountWord{
     public int countOccurrences(String sentence,String wordToCount){
      
      

        String[] words=sentence.split(" ");

        int count=0;

        if(sentence.isEmpty()){
            System.out.println("The sentence cannot be empty.");
            return -1;
        }


        if (wordToCount.isEmpty()) {
            System.out.println("The word to count cannot be empty.");
            return -1;
        }
        if(wordToCount.contains(" ")){
            System.out.println("The word to count must be a single word without spaces.");
            return -1;
        }

        for(int i =0 ; i<words.length; i++){
            if(words[i].equals(wordToCount)){
                count++;
            }
        }
        return count;

    }
}