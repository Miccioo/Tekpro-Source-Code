package management;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import kingdom.Kingdom;
import kingdom.actions.*;
import kingdom.events.*;

public class GameManager {
    private final Kingdom kingdom;
    private final UserInterface ui;
    private final List<GameAction> actions;
    private final List<Event> events;

    public GameManager(Kingdom kingdom, UserInterface ui) {
        this.kingdom = kingdom;
        this.ui = ui;
        
        // Initialize actions
        this.actions = Arrays.asList(
            new BuyFoodAction(kingdom, ui),
            new BuyLandAction(kingdom, ui),
            new RecruitSoldiersAction(kingdom, ui)
        );
        
        // Initialize events
        this.events = Arrays.asList(
            new PlagueEvent(kingdom),
            new BanditEvent(kingdom),
            new GoodHarvestEvent(kingdom)
        );
    }

    public void startGame() {
        ui.showMessage("Welcome to Kingdom Simulator!");
        
        while (kingdom.getYear() <= kingdom.getMAX_YEARS()) {
            ui.showStatus(kingdom);
            handleYear();
            if (kingdom.getPopulation() <= 0) {
                ui.showMessage("Your kingdom has fallen!");
                return;
            }
            kingdom.incrementYear();
        }
        endGame();
    }

    public void handleYear() {
        // Polymorphic action handling
        for(int i = 0; i < actions.size(); i++) {
            ui.showMessage((i + 1) + ". " + actions.get(i).getDisplayString());
        }
        
        int choice = ui.getNumberInput(1, actions.size());
        actions.get(choice - 1).execute(); // Polymorphic execution
        
        // Handle random event
        if(new Random().nextInt(5) == 0) {
            Event event = events.get(new Random().nextInt(events.size()));
            ui.showMessage(event.getDisplayString());
            event.execute(); // Polymorphic execution
        }
    }

    private void endGame() {
        ui.showMessage("=== Game Over ===");
        ui.showStatus(kingdom);
    }
}