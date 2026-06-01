import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class KYC {
    
    private static final Map<String, Pattern> validationRules = new HashMap<>();
    
    static {
        validationRules.put("name", Pattern.compile("^[A-Za-z ]{3,}$"));
        validationRules.put("password", Pattern.compile("^(?=.*[@#$!_])[A-Za-z0-9@#$!_]{8,}$"));
        validationRules.put("aadhaar", Pattern.compile("^[0-9]{12}$"));
        validationRules.put("pan", Pattern.compile("^[A-Z]{5}[0-9]{4}[A-Z]{1}$"));
    }

    public static boolean isValid(String documentType, String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return false;
        }
        
        String key = documentType.toLowerCase();
        
        if (!validationRules.containsKey(key)) {
            System.out.println("Invalid document type: " + documentType);
            return false;
        }
        
        Pattern expectedPattern = validationRules.get(key);
        return expectedPattern.matcher(userInput).matches();
    }

    public static void main(String[] args) {
        System.out.println(isValid("name", "RAZAK MOHAMMAD"));
        System.out.println(isValid("name", "Jo")); 
        
        System.out.println(isValid("password", "Secure_123"));
        System.out.println(isValid("password", "weakpw")); 
        
        System.out.println(isValid("aadhaar", "123456789012"));
        System.out.println(isValid("aadhaar", "12345ABCD")); 
        
        System.out.println(isValid("pan", "ABCDE1234F"));
        System.out.println(isValid("pan", "12345ABCDE")); 
    }
}