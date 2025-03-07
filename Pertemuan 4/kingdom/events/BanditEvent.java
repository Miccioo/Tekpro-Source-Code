package kingdom.events;
import kingdom.Kingdom;

public class BanditEvent extends Event {
    public BanditEvent(Kingdom kingdom) {
        super(kingdom);
    }

    @Override
    public void execute() {
        if(kingdom.getSoldiers() > 30) {
            kingdom.setSoldiers(kingdom.getSoldiers() - 5);
        } else {
            kingdom.setGold(Math.max(0, kingdom.getGold() - 200));
            kingdom.setFood(Math.max(0, kingdom.getFood() - 100));
        }
    }

    @Override
    public String getDisplayString() {
        return "Bandits are raiding the countryside!";
    }
}