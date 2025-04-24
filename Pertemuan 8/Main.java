public class Main {
    public static void main(String[] args) {
        // Generic Class
        DataStore<Transaction> store = new DataStore<>();
        store.add(new PaymentTransaction("TX001", 100.0));
        store.add(new RefundTransaction("TX002", 50.0));

        // Generic Method
        Utils.printList(store.getAll());

        // Wildcard Parameter
        Reader reader = new Reader();
        reader.readAll(store.getAll());

        // Multiple Type Parameters
        Pair<String, Transaction> pair = new Pair<>("TX003", new PaymentTransaction("TX003", 200.0));
        System.out.println(pair);

        // Interface & Generic Class
        TransactionProcessor<Transaction> processor = new TransactionProcessor<>();
        for (Transaction t : store.getAll()) {
            processor.process(t);
        }
    }
}