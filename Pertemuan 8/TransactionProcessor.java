public class TransactionProcessor<T extends Transaction> implements Processor<T> {
    @Override
    public void process(T data) {
        System.out.println("Processed: " + data.getSummary());
    }
}