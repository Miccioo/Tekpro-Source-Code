package kingdom.actions;

import kingdom.Kingdom;
import management.UserInterface;

public class RecruitSoldiersAction extends  GameAction{
    public RecruitSoldiersAction(Kingdom kingdom, UserInterface ui){
        super(kingdom, ui);
    }

    @Override
    public void execute(){
        int maxGold = kingdom.getGold();
        int goldSpent = ui.getNumberInput(0, maxGold/5, "How many soldier? (0-" + kingdom.getGold()/10 + ")");
        kingdom.setGold(kingdom.getGold() - goldSpent*10);
        kingdom.setSoldiers(kingdom.getSoldiers() + goldSpent/10);
    }
    
    @Override
    public String getDisplayString() {
        return "Recruit Soldiers (10 gold = 1 soldier)";
    }

}
