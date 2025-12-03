import java.util.Scanner;

class RepeatInput {
    public static void main(String[]args){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a text: ");

    
        String input = scanner.nextLine();

        System.out.println("enter a number: ");
        int num = scanner.nextInt();
        for ( int i =0 ; i< num ; i++){
            System.out.println(input);
        }
          
    

      
         scanner.close();

    }

}