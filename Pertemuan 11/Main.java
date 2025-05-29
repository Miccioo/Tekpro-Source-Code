public class Main {
    public static void main(String[] args) {
        // BUILDER PATTERN
        Product p1 = new Product.Builder()
                .setName("Laptop")
                .setPrice(15000000)
                .setDiscount(true)
                .build();
        p1.display();

        // PROTOTYPE PATTERN
        FlashSaleProduct original = new FlashSaleProduct("Smartphone", 5000000);
        FlashSaleProduct cloned = (FlashSaleProduct) original.clone();
        cloned.display();

        // FACADE PATTERN
        CheckoutFacade checkout = new CheckoutFacade();
        checkout.completeOrder("Keyboard", 250000, "Jl. Dipatiukur No. 80");

        // DECORATOR PATTERN
        BasicProduct basic = new ConcreteProduct();
        BasicProduct wrapped = new GiftWrapDecorator(basic);
        System.out.println(wrapped.getDescription());
        System.out.println("Harga total: " + wrapped.getPrice());

        // STRATEGY PATTERN
        ShippingContext shipCtx = new ShippingContext();
        shipCtx.setStrategy(new RegularShipping());
        shipCtx.executeStrategy("Bandung");

        shipCtx.setStrategy(new ExpressShipping());
        shipCtx.executeStrategy("Jakarta");

        // STATE PATTERN
        Order order = new Order();
        order.setState(new NewOrderState());
        order.process();

        order.setState(new ProcessingState());
        order.process();

        order.setState(new ShippedState());
        order.process();
    }
}
