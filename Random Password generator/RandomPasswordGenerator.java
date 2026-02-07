import java.util.*;

public class RandomPasswordGenerator {

    // Method to generate a random password
    public static String generatePassword(int length, boolean includeLowercase, boolean includeUppercase,
                                           boolean includeNumbers, boolean includeSpecialChars) {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String numbers = "0123456789";
        String specialChars = "!@#$%^&*()-_=+<>?/";

        StringBuilder characterPool = new StringBuilder();

        // Append character sets based on user preferences
        if (includeLowercase) {
            characterPool.append(lowercase);
        }
        if (includeUppercase) {
            characterPool.append(uppercase);
        }
        if (includeNumbers) {
            characterPool.append(numbers);
        }
        if (includeSpecialChars) {
            characterPool.append(specialChars);
        }

        // If no character set is selected
        if (characterPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type must be selected.");
        }

        // Generate password
        Random random = new Random();
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        return password.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input for password preferences
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();
        System.out.print("Include lowercase letters? (true/false): ");
        boolean includeLowercase = scanner.nextBoolean();
        System.out.print("Include uppercase letters? (true/false): ");
        boolean includeUppercase = scanner.nextBoolean();
        System.out.print("Include numbers? (true/false): ");
        boolean includeNumbers = scanner.nextBoolean();
        System.out.print("Include special characters? (true/false): ");
        boolean includeSpecialChars = scanner.nextBoolean();

        try {
            // Generate and display the password
            String password = generatePassword(length, includeLowercase, includeUppercase, includeNumbers, includeSpecialChars);
            System.out.println("Generated Password: " + password);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
