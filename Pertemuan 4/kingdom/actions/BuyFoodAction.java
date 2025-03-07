package kingdom.actions;
import kingdom.Kingdom;
import management.UserInterface;

public class BuyFoodAction extends GameAction {
    public BuyFoodAction(Kingdom kingdom, UserInterface ui) {
        super(kingdom, ui);
    }

    @Override
    public void execute() {
        int maxGold = kingdom.getGold();
        int goldSpent = ui.getNumberInput(0, maxGold, "How much gold to spend on food? (0-" + kingdom.getGold() + ")");
        kingdom.setGold(kingdom.getGold() - goldSpent);
        kingdom.setFood(kingdom.getFood() + goldSpent * 2);
    }

    @Override
    public String getDisplayString() {
        return "Buy Food (1 gold = 2 food)";
    }
}