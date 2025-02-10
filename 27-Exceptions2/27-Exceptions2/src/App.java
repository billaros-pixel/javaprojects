import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static int divide(int a, int b) {
        // Διαίρεση με το μηδέν προκαλεί μία ArithmeticException.
        // Αν το b είναι μηδέν, η εξαίρεση που προκαλεί η διαίρεση
        // μεταφέρεται έξω από τη μέθοδο divide(), στο σημείο στο οποίο
        // αυτή έχει κληθεί.
        return a / b;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            int x = input.nextInt();
            int y = input.nextInt();

            int z = divide(x, y);
            System.out.println(z);
        }
        // Ένα try μπορεί να συνοδεύεται από πολλά catch, ώστε να πιάνονται
        // εξαιρέσεις διαφορετικών τύπων που μπορεί να προκύψουν από τον
        // κώδικα μέσα στο try.

        // Η εξαίρεση δεν είναι τίποτε άλλο από ένα αντικείμενο. Όταν πιάνουμε
        // μία εξαίρεση, πιάνουμε αυτό το αντικείμενο. Για να χρησιμοποιήσουμε
        // το αντικείμενο αυτό, του δίνουμε όνομα στο catch, εδώ "e".
        catch (ArithmeticException e) {
            System.out.println("Error");
            // Κάποιες εξαιρέσεις συνοδεύονται από ένα μήνυμα, και το μήνυμα
            // αυτό μας δίνεται με την μέθοδο getMessage().
            System.out.println(e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Wrong input");
            // Η InputMismatchException δεν έχει κάποιο μήνυμα, η επόμενη
            // γραμμή, αν εκτελεστεί, θα εμφανίσει "null".
            System.out.println(e.getMessage());
        }
        // Αν η ενέργεια πολλών catch είναι ακριβώς η ίδια, μπορεί να
        // χρησιμοποιηθεί η σύνταξη "multi-catch" όπως φαίνεται εδώ,
        // με "|" μεταξύ των τύπων εξαίρεσης που θέλουμε να πιάσουμε και να
        // χειριστούμε ενιαία.
        // catch (ArithmeticException | InputMismatchException e) {
        // System.out.println("Error");
        // System.out.println(e.getMessage());
        // }

        System.out.println("Bye");
    }

}
