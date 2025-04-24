public class PaymentTransaction extends Transaction {
    public PaymentTransaction(String id, double amount) {
        super(id, amount);
    }

    @Override
    public String getSummary() {
        return "Payment: " + id + " $" + amount;
    }
}