// Μία κλάση ελεγχόμενης εξαίρεσης, κληρονομεί την Exception.
public class MySqrtCheckedException extends Exception {
    // Οι κλάσεις εξαίρεσης πρέπει τουλάχιστον να έχουν 2 constructors,
    // έναν χωρίς παραμέτρους και έναν με παράμετρο String, το μήνυμα της εξαίρεσης.
    // Και οι δύο αυτοί constructors αρκεί να καλούν τους αντίστοιχους της Exception
    // (με χρήση της super()).
    public MySqrtCheckedException() {
        // Η ακόλουθη κλήση εννοείται ακόμα και αν δεν γραφτεί.
        // super();
    }

    public MySqrtCheckedException(String msg) {
        super(msg);
    }
}
