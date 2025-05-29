public class CheckoutFacade {
    private Inventory inventory = new Inventory();
    private PaymentGateway payment = new PaymentGateway();
    private ShippingService shipping = new ShippingService();

    public void completeOrder(String product, double amount, String address) {
        inventory.checkStock(product);
        payment.pay(amount);
        shipping.ship(address);
    }
}
