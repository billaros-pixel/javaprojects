// Μία κλάση μη ελεγχόμενη εξαίρεσης, κληρονομεί την RuntimeException.
public class MySqrtUncheckedException extends RuntimeException {
    public MySqrtUncheckedException() {
        // super();
    }

    public MySqrtUncheckedException(String msg) {
        super(msg);
    }
}
