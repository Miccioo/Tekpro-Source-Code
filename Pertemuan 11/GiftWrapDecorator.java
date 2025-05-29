public class GiftWrapDecorator extends ProductDecorator {
    public GiftWrapDecorator(BasicProduct product) { super(product); }
    public String getDescription() { return product.getDescription() + ", dengan bungkus kado"; }
    public double getPrice() { return product.getPrice() + 5.0; }
}