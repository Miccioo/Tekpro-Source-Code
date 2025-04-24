public class RefundTransaction extends Transaction {
    public RefundTransaction(String id, double amount) {
        super(id, amount);
    }

    @Override
    public String getSummary() {
        return "Refund: " + id + " $" + amount;
    }
}