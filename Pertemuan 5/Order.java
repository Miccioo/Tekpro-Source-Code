public record Order(String id, String product, int quantity, String status, int reward) {
    public Order {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
    }

    @Override
    public String toString() {
        return "Order ID: " + id + ", Product: " + product + ", Quantity: " + quantity + ", Status: " + status + ", Reward: $" + reward + ", Deadline: Hari ";
    }
}