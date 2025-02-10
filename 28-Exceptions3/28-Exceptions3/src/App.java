import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    // Πρόκληση εξαίρεσης από δικό μας κώδικα.
    public static double mySqrt(double x) {
        // Η μέθοδος Math.sqrt() λειτουργεί ακόμα και για αρνητικό αριθμό, επιστρέφοντας
        // "NaN" ("not a number"). Εδώ θέλουμε σε αυτή την περίπτωση να προκαλέσουμε
        // («να πετάξουμε») μία εξαίρεση
        if (x < 0) {
            // Δημιουργούμε το αντικείμενο της εξαίρεσης. Χρησιμοποιούμε τον τύπο
            // ArithmeticException που υπάρχει ήδη στην Java.
            // Κάθε κλάση εξαίρεσης έχει έναν constructor που δέχεται ως παράμετρο
            // το «μήνυμα» της εξαίρεσης.
            ArithmeticException exc = new ArithmeticException("Negative number for sqrt");

            // «Πετάμε» την εξαίρεση.
            throw exc;

            // ή πιο σύντομα:
            // throw new ArithmeticException("Negative number for sqrt");
        }
        // Αν δεν πεταχτεί εξαίρεση, η ροή συνεχίζεται εδώ.
        return Math.sqrt(x);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            double x = input.nextDouble();
            double z = mySqrt(x);
            System.out.println(z);
        } catch (ArithmeticException e) {
            // Εκτύπωση του μηνύματος της εξαίρεσης.
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
        }

        System.out.println("Bye");
    }

}
