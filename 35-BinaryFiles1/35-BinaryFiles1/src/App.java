import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {
    public static void main(String[] args) {
        // Εγγραφή δυαδικού αρχείου.
        try (
                FileOutputStream fos = new FileOutputStream("a.bin");
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeInt(3);
            oos.writeInt(16);
            oos.writeInt(256);

            oos.writeDouble(1.0);

            oos.writeUTF("a");
            oos.writeUTF("abc");

            oos.writeUTF("αβγ");
        } catch (IOException e) {
            System.err.println(e);
        }

        // Ανάγνωση δυαδικού αρχείου.
        // Προφανώς διαβάζουμε αντίστοιχα στοιχεία με αυτά που έχουμε γράψει.
        try (
                ObjectInputStream ois = new ObjectInputStream(
                        new FileInputStream("a.bin"))) {
            int a = ois.readInt();
            int b = ois.readInt();
            int c = ois.readInt();
            double x = ois.readDouble();
            String q = ois.readUTF();
            String w = ois.readUTF();
            String e = ois.readUTF();

            System.out.printf("%d__%d__%d__%f__%s__%s__%s\n", a, b, c, x, q, w, e);

            // Ανάγνωση πέρα από το τέλος του αρχείου προκαλεί εξαίρεση.
            // int k = ois.readInt();

            // Δεν χρειάζεται να κλείσουμε το αρχείο καθώς χρησιμοποιύμε try-with-resources.
            // ois.close();
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}
