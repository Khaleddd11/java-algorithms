class RepeatInput {
    public static void main(String[] args) {
        // We need 2 arguments: The text (1) and the number (2)
        if (args.length >= 2) {
            
            String input = args[0]; // The text
            
            // CONVERSION: 
            int num = Integer.parseInt(args[1]); 

            for (int i = 0; i < num; i++) {
                System.out.println(input);
            }

        } else {
            System.out.println("Error: Please provide TEXT then a NUMBER.");
            System.out.println("Example: java RepeatInput Hello 5");
        }
    }
}