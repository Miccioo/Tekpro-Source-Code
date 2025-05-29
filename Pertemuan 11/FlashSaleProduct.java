public class FlashSaleProduct implements CloneableProduct {
    private String name;
    private double salePrice;

    public FlashSaleProduct(String name, double salePrice) {
        this.name = name;
        this.salePrice = salePrice;
    }

    public CloneableProduct clone() {
        return new FlashSaleProduct(this.name, this.salePrice);
    }

    public void display() {
        System.out.println("Flash Sale - " + name + ": " + salePrice);
    }
}
