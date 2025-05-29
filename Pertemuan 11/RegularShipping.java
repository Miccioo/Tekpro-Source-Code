public class RegularShipping implements ShippingStrategy {
    public void ship(String destination) {
        System.out.println("Dikirim Reguler ke " + destination);
    }
}