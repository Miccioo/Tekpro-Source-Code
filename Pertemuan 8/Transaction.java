public abstract class Transaction {
    protected String id;
    protected double amount;

    public Transaction(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public abstract String getSummary();

    @Override
    public String toString() {
        return getSummary(); // agar printList menampilkan isi transaksi, bukan hash
    }
}