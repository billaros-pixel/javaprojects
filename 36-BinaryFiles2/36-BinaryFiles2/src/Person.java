import java.io.Serializable;

// Για να γραφτούν σε ένα δυαδικό αρχείο απευθείας αντικείμενα μίας κλάσης,
// πρέπει αυτή η κλάση να υλοποιεί τη διεπαφή Serializable.
// (Επίσης αν έχει πεδία τύπου άλλων κλάσεων, πρέπει και εκείνες οι κλάσεις
// να υλοποιούν τη διεπαφή Serializable).
public class Person implements Serializable {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String toString() {
        return name + " " + age;
    }
}
