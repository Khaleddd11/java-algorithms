import java.util.function.BiPredicate;

class StringUtils {
    
    // Method that takes two strings and a lambda to determine which is "better"
    public static String betterString(String string1, String string2, BiPredicate<String, String> condition) {
        if (condition.test(string1, string2)) {
            return string1;
        } else {
            return string2;
        }
    }
    
    public static void main(String[] args) {
        String str1 = "Hello";
        String str2 = "World!";
        
        
        // Test 1: Return the longer string
        // Lambda explanation:
        // (s1, s2) -> s1.length() > s2.length()
        // - s1, s2 are the two strings passed in
        // - The expression returns true if s1 is longer than s2
        String longer = betterString(str1, str2, (s1, s2) -> s1.length() > s2.length());
        System.out.println("Longer string: " + longer);
        
         // Test 2: Always return the first string
        // Lambda: (s1, s2) -> true
        // - Ignores both parameters, always returns true
        String first = betterString(str1, str2, (s1, s2) -> true);
        System.out.println("First string: " + first);
        
       // Test 3: Return the string that comes first alphabetically
        // Lambda: (s1, s2) -> s1.compareTo(s2) < 0
        // - s1.compareTo(s2) < 0 means s1 comes before s2 in dictionary order
        String alphabetical = betterString(str1, str2, (s1, s2) -> s1.compareTo(s2) < 0);
        System.out.println("Alphabetically first: " + alphabetical);
        
    }
   
}