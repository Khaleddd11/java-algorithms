package task5;

class StringChecker {
    
    // Method to check if string contains only alphabets
    public static boolean containsOnlyAlphabets(String str) {
        // Check if string is empty
        if (str == null || str.isEmpty()) {
            return false;
        }
        
        // Check each character using Character.isLetter()
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // Test cases
        String test1 = "Hello";
        String test2 = "Hello123";
        String test3 = "HelloWorld";
        String test4 = "Hello World";
        String test5 = "abc@xyz";
        String test6 = "";
        
        System.out.println(test1 + "' contains only alphabets: " + containsOnlyAlphabets(test1));
        System.out.println(test2 + "' contains only alphabets: " + containsOnlyAlphabets(test2));
        System.out.println(test3 + "' contains only alphabets: " + containsOnlyAlphabets(test3));
        System.out.println(test4 + "' contains only alphabets: " + containsOnlyAlphabets(test4));
        System.out.println(test5 + "' contains only alphabets: " + containsOnlyAlphabets(test5));
        System.out.println(test6 + "' contains only alphabets: " + containsOnlyAlphabets(test6));
    }
}


