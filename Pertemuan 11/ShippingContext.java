public class ShippingContext {
    private ShippingStrategy strategy;
    public void setStrategy(ShippingStrategy strategy) {
         this.strategy = strategy; 
    }
    
    public void executeStrategy(String destination) {
        strategy.ship(destination); 
    }
}
