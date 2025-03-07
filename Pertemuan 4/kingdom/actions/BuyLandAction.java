package kingdom.actions;

import kingdom.Kingdom;
import management.UserInterface;

public class BuyLandAction extends GameAction{

    public BuyLandAction(Kingdom kingdom, UserInterface ui){
        super(kingdom, ui);
    }   

    @Override
    public void execute(){
        int maxGold = kingdom.getGold();
        int goldSpent = ui.getNumberInput(0, maxGold/5, "How many accres? (0-" + kingdom.getGold()/5 + ")");
        kingdom.setGold(kingdom.getGold() - goldSpent*5);
        kingdom.setLand(kingdom.getLand() + goldSpent/5);
    }

    @Override
    public String getDisplayString() {
        return "Buy Acres (5 gold = 1 acre)";
    }

}
