package app;

import services.PasswordHasher;

public class Main {
    public static void main(String[] args) {
        // Krijo një salt dhe password të salted
        String salt = PasswordHasher.generateSalt();
        String saltedPassword = PasswordHasher.generateSaltedHash("medimedi", salt);

        // Testo verifikimin
        boolean isValid = PasswordHasher.compareSaltedHash("medimedi", salt, saltedPassword);

        System.out.println("Salti: " + salt);
        System.out.println("Passwordi i kriposur: " + saltedPassword);
        // Printo rezultatin
        if (isValid) {
            System.out.println("Fjalekalimi eshte i sakte.");
        } else {
            System.out.println("Fjalekalimi eshte gabim.");
        }

        // (Opsional: Mund të shtosh kodin për JavaFX, nëse duhen interfejsa)
        // launch(args); // Kjo mund të lëshohet vetëm nëse po krijoni GUI me JavaFX
    }
}
