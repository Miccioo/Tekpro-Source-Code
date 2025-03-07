package kingdom.events;

import kingdom.Kingdom;

public class GoldMineEvent extends Event {
    public GoldMineEvent(Kingdom kingdom){
        super(kingdom);
    }

    @Override
    public void execute() {
        int gold = 300;
        kingdom.setGold(kingdom.getGold() + gold);
    }

    @Override
    public String getDisplayString() {
        return "Discovered a new gold mine!";
    }
}
