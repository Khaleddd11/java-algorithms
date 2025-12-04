import java.util.regex.Pattern;

public class IpValidatorAndSplitor {
    public static void main(String[] args) {
        
        // 1. Basic check for arguments
        if (args.length == 0) {
            System.out.println("Please provide an IP address.");
            return;
        }
        String ipAddress = args[0];

        // 2. Define the Strict Regex
        // This ensures every number is between 0 and 255
        String zeroTo255 = "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";
        // ^: This anchors the start. It says "The string must start right here
        // $: This anchors the end. It says "The string must end right here." (This ensures you don't accept
        String regex = "^" + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "\\." + zeroTo255 + "$";

        // 3. Check Validity
        if (ipAddress.matches(regex)) {
            System.out.println("Valid IP! Splitting now...");
            
            // Split by literal dot
            String[] parts = ipAddress.split("\\.");
            
            for (String part : parts) {
                System.out.println(part);
            }
        } else {
            System.out.println("Invalid IP Address. Numbers must be 0-255.");
        }
    }
}