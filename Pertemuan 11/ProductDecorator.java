abstract class ProductDecorator implements BasicProduct {
    protected BasicProduct product;
    public ProductDecorator(BasicProduct product) { this.product = product; }
}
