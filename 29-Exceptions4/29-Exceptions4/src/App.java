import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    // Αν μία μέθοδος μπορεί να προκαλέσει εξαίρεση, αυτή δηλώνεται με throws
    // στην επικεφαλίδα της μεθόδου,
    // προαιρετικά, εφόσον η εξαίρεση είναι μη ελεγχόμενη...
    public static double mySqrt1(double x) // throws MySqrtUncheckedException
    {
        if (x < 0) {
            throw new MySqrtUncheckedException("Negative Number");
        }
        return Math.sqrt(x);
    }

    // ή υποχρεωτικά, εφόσον η εξαίρεση είναι ελεγχόμενη (και δεν αντιμετωπίζεται
    // με try .. catch μέσα στη μέθοδο).
    public static double mySqrt2(double x) throws MySqrtCheckedException {
        if (x < 0) {
            throw new MySqrtCheckedException("Negative number");
        }
        return Math.sqrt(x);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double x = input.nextDouble();

        // Αυτή η κλήση επιτρέπεται και χωρίς try...catch γιατί η εξαίρεση
        // που προκαλεί είναι μη ελεγχόμενη.
        double z1 = mySqrt1(x);
        System.out.println(z1);

        // Αυτή η κλήση δεν επιτρέπεται χωρίς try...catch γιατί η εξαίρεση
        // που προκαλεί είναι ελεγχόμενη.
        // double z2 = mySqrt2(x);
        // System.out.println(z2);

        try {
            double y = input.nextDouble();

            // αλλά ασφαλώς μπορεί να γίνει μέσα σε try...catch ώστε να
            // χειριστούμε την εξαίρεση
            double w = mySqrt1(y);
            System.out.println(w);
        } catch (MySqrtUncheckedException e) {
            System.out.println(e.getMessage());
        }

        try {
            double y = input.nextDouble();

            // Αυτή η κλήση *δεν* επιτρέπεται χωρίς try...catch γιατί η εξαίρεση
            // που προκαλεί είναι ελεγχόμενη.
            double w = mySqrt2(y);
            System.out.println(w);
        } catch (MySqrtCheckedException e) {
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
        }
        // Λόγω πολυμορφισμού, το παρακάτω πιάνει όλες τις υπόλοιπες εξαιρέσεις
        // (αν και εδώ δεν υπάρχουν άλλες που μπορεί να συμβούν).
        catch (Exception e) {
            System.out.println(e);
        }
        // Αν υπάρχει block finally μετά από τα catch, θα περάσουμε από αυτό
        // είτε συμβεί εξαίρεση είτε όχι.
        finally {
            System.out.println("Finally...");
        }

        System.out.println("Bye");
    }

}
