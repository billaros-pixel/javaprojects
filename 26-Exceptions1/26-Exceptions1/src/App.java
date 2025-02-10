import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        try {
            // Η μέθοδος nextInt() μπορεί να προκαλέσει εξαίρεση τύπου
            // InputMismatchException αν η είσοδος δεν είναι τύπου double.
            // Μπορούμε να «πιάσουμε» αυτή την εξαίρεση ώστε να μην τερματιστεί
            // το πρόγραμμα, βάζοντας τον κώδικα μέσα σε try .. catch.

            System.out.println("Before");
            int x = input.nextInt();
            System.out.println(x);
            System.out.println("After");
        } catch (InputMismatchException e) {
            // Αν συμβεί εξαίρεση, διακόπτεται η ροή του προγράμματος στο σημείο
            // εκείνο και πηγαίνουμε στο catch που μπορεί να πιάσει αυτό τον τύπο
            // εξαίρεσης.
            System.out.println("Wrong input");
        }

        // Κατόπιν η ροή του προγράμματος συνεχίζει μετά το catch.
        System.out.println("Bye");

        // Αν θέλουμε να ζητούμε επαναληπτικά τον αριθμό μέχρι να μην υπάρχει
        // σφάλμα εισαγωγής, πρέπει να το κάνουμε μέσα σε ένα while, με κώδικα
        // της μορφής που φαίνεται παρακάτω:
        // (Το try .. catch δεν επιστρέφει τη ροή του προγράμματος προς τα πίσω.)
        while (true) {
            try {
                int y = input.nextInt();
                System.out.println(y);
                break;
            } catch (InputMismatchException e) {
                System.out.println("Wrong input");
                // Απαραίτητος ο καθαρισμός της εισόδου
                input.nextLine();
            }
        }
    }

}
