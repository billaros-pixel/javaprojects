import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) {
        // Δημιουργία δύο αντικειμένων τύπου Person.
        Person p1 = new Person("John", 67);
        Person p2 = new Person("Paul", 75);

        // Δημιουργία μίας ακόμα αναφοράς, που δείχνει σε υπάρχον αντικείμενο.
        Person p3 = p2;

        // Εγγραφή αντικειμένων σε δυαδικό αρχείο.
        try (
                ObjectOutputStream oos = new ObjectOutputStream(
                        new FileOutputStream("p.obj"))) {

            // Εγγραφή σε δυαδικό αρχείο απευθείας των τριών αναφορών.
            // Για την τρίτη αναφορά δεν γράφεται πάλι το ίδιο αντικείμενο,
            // αλλά κάτι ενδεικτικό του πού έδειχνε αυτή.
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);
        } catch (IOException e) {
            System.err.println(e);
        }

        // Ανάγνωση των αντικειμένων από δυαδικό αρχείο.
        try (
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("p.obj"))) {

            // Χρειάζεται αλλαγή τύπου στον πραγματικό τύπο των αντικειμένων
            // που διαβάζονται.
            // Αν ο τύπος δεν είναι ο σωστός, προκαλείται ClassNotFoundException.
            // Δεν χρειάζεται να δημιουργήσουμε εμείς τα αντικείμενα, τα δημιουργεί
            // (όταν χρειάζεται) η readObject().

            Person q1 = (Person) (ois.readObject());
            System.out.println(q1);

            Person q2 = (Person) (ois.readObject());
            System.out.println(q2);

            Person q3 = (Person) (ois.readObject());
            System.out.println(q3);

            // Η αναφορά qq θα δείχνει στο ίδιο αντικείμενο με την q1,
            // όπως ήταν η κατάσταση όταν τα αντικείμενα γράφτηκαν στο αρχείο.
            System.out.println(q3 == q2);

        } catch (IOException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }

}
