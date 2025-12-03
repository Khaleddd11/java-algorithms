class Input {
    public static void main(String[] args) {
        // Check if the user provided at least one argument
        if (args.length > 0) {
            String input = args[0]; 
            System.out.println("You typed: " + input);
        } else {
            System.out.println("Please provide an argument when running the program.");
        }
    }
}