import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main (String []args){

        int [] numbers =  new int [1000];
         for ( int i =0 ; i< numbers.length; i++){
            numbers [i]= (int)(Math.random()*10000);
         }
         Arrays.sort(numbers);

        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a target number: ");
        System.out.println("the maximum number in the arrays is " + numbers[numbers.length-1]);

        System.out.println("the minimum number in the arrays is " + numbers[0]);
        int target = scanner.nextInt();

        
 


         
         BinarySearch binarysearch = new BinarySearch();
          long start = System.nanoTime();

        int index=  binarysearch.search(numbers,target);

          long end = System.nanoTime();

       long timeTaken = end - start;

 
         if (index == -1) {
            System.out.println("Target not found!");
        } else {
            System.out.println("Target found at index = " + index);
        }

        System.out.println("Time taken (ns): " + timeTaken);


    }
}