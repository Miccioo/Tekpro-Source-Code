public class Machine {
    private final String id;
    private final String type;
    private int durability;
    private final int processingSpeed; // 1 = slow, 2 = medium, 3 = fast
    private final int cost;

    public Machine(String id, String type, int durability, int processingSpeed, int cost) {
        this.id = id;
        this.type = type;
        this.durability = durability;
        this.processingSpeed = processingSpeed;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public int getDurability() {
        return durability;
    }

    public int getProcessingSpeed() {
        return processingSpeed;
    }

    public int getCost() {
        return cost;
    }

    public void use() {
        durability -= 10; // Durability decreases with use
        if (durability < 0) {
            durability = 0;
        }
    }

    public void repair() {
        durability = 100;
    }

    @Override
    public String toString() {
        return "Mesin " + id + " (" + type + "), Kecepatan: " + processingSpeed + ", Durability: " + durability + "%, Harga: $" + cost;
    }
}
