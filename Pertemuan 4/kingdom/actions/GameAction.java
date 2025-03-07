package kingdom.actions;
import kingdom.Kingdom;
import kingdom.interfaces.*;
import management.UserInterface;

public abstract class GameAction implements Actionable, Displayable {
    protected final Kingdom kingdom;
    protected final UserInterface ui;

    public GameAction(Kingdom kingdom, UserInterface ui) {
        this.kingdom = kingdom;
        this.ui = ui;
    }
}