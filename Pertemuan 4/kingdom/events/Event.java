package kingdom.events;
import java.util.Random;
import kingdom.Kingdom;
import kingdom.interfaces.*;

public abstract class Event implements Actionable, Displayable {
    protected final Kingdom kingdom;
    protected final Random random = new Random();

    public Event(Kingdom kingdom) {
        this.kingdom = kingdom;
    }

    @Override
    public abstract void execute();

    @Override
    public abstract String getDisplayString();
}