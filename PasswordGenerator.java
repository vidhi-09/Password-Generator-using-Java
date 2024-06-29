import java.security.SecureRandom;
import java.util.Scanner;

public class PasswordGenerator {

    // Characters to be included in the password
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    // SecureRandom instance for generating random values
    private static final SecureRandom random = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for password length
        System.out.print("Enter the desired password length: ");
        int length = scanner.nextInt();

        // Prompt user for character inclusion
        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUppercase = scanner.next().toLowerCase().charAt(0) == 'y';

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLowercase = scanner.next().toLowerCase().charAt(0) == 'y';

        System.out.print("Include digits? (y/n): ");
        boolean includeDigits = scanner.next().toLowerCase().charAt(0) == 'y';

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = scanner.next().toLowerCase().charAt(0) == 'y';

        // Generate and print the password
        String password = generatePassword(length, includeUppercase, includeLowercase, includeDigits, includeSpecial);
        System.out.println("Generated Password: " + password);
    }

    private static String generatePassword(int length, boolean includeUppercase, boolean includeLowercase,
                                           boolean includeDigits, boolean includeSpecial) {
        if (length <= 0) {
            throw new IllegalArgumentException("Password length must be greater than 0");
        }

        StringBuilder password = new StringBuilder(length);
        String charPool = "";

        if (includeUppercase) {
            charPool += UPPERCASE;
        }
        if (includeLowercase) {
            charPool += LOWERCASE;
        }
        if (includeDigits) {
            charPool += DIGITS;
        }
        if (includeSpecial) {
            charPool += SPECIAL_CHARACTERS;
        }

        if (charPool.isEmpty()) {
            throw new IllegalArgumentException("At least one character set must be included");
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(charPool.length());
            password.append(charPool.charAt(randomIndex));
        }

        return password.toString();
    }
}