public class RepeatInput {
    public static void main(String[] args) {
        
        if (args.length < 2) {
            System.out.println("Error: Please provide TEXT then a NUMBER.");
            return; 
        }

        String firstArg = args[0];
        String secondArg = args[1];

        // check 1: Ensure first arg is TEXT (not a number) ---
        try {
            // Try to treat it as a number )
            Double.parseDouble(firstArg);
            
            // If the line above didn't crash, it means the input WAS a number. 
            System.out.println("Error: First argument must be text, not a number!");
            return; 
        } catch (NumberFormatException e) {
            // If we caught an error here, it means it wasn't a number. 
            // Tso we procees
        }

        // CHECK 2: Ensure second arg is an INT
        try {
            // Try to turn the second string into an integer
            int num = Integer.parseInt(secondArg);

            // if we reach here, it succeded !
            for (int i = 0; i < num; i++) {
                System.out.println(firstArg);
            }

        } catch (NumberFormatException e) {
            // If the code crashes here, it means secondArg was not a valid integer
            System.out.println("Error: Second argument must be a valid integer");
        }
    }
}