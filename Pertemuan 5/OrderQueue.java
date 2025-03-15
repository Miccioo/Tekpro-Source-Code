import java.util.Deque;
import java.util.Optional;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

public class OrderQueue {
    // 4. Kelas untuk mengelola antrean pesanan
    private final Queue<Order> orderQueue = new ConcurrentLinkedQueue<>();
    private final Deque<Order> priorityOrderDeque = new ConcurrentLinkedDeque<>(); // Deque for priority orders
    private final CopyOnWriteArrayList<Order> processedOrders = new CopyOnWriteArrayList<>();

    public void addOrder(Order order) {
        orderQueue.offer(order);
    }

    public void addPriorityOrder(Order order) {
        priorityOrderDeque.addFirst(order); // Add to the front of the deque for priority
    }

    public Optional<Order> processNextOrder() {
        // Process priority orders first (from the front of the deque)
        Order order = priorityOrderDeque.poll();
        if (order == null) {
            // If no priority orders, process regular orders from the queue
            order = orderQueue.poll();
        }
        if (order != null) {
            processedOrders.add(order);
        }
        return Optional.ofNullable(order);
    }

    public void displayProcessedOrders() {
        System.out.println("\nPesanan yang Telah Diproses:");
        processedOrders.forEach(System.out::println);
    }

    public boolean hasOrders() {
        return !orderQueue.isEmpty() || !priorityOrderDeque.isEmpty();
    }
}
