package kingdom.events;

import kingdom.Kingdom;

public class GoodHarvestEvent extends Event {
    public GoodHarvestEvent(Kingdom kingdom){
        super(kingdom);
    }

    @Override
    public void execute() {
        int food = 300;
        kingdom.setFood(kingdom.getFood() + food);
    }

    @Override
    public String getDisplayString() {
        return "Bountiful harvest this year!";
    }

}
