import java.util.List;

public class Reader {
    public void readAll(List<? extends Transaction> list) {
        for (Transaction t : list) {
            System.out.println("Reading: " + t.getSummary());
        }
    }
}