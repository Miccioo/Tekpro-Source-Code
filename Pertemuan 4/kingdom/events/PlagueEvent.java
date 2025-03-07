package kingdom.events;
import kingdom.Kingdom;

public class PlagueEvent extends Event {
    public PlagueEvent(Kingdom kingdom) {
        super(kingdom);
    }

    @Override
    public void execute() {
        int populationLoss = random.nextInt(100) + 50;
        kingdom.setPopulation(Math.max(0, kingdom.getPopulation() - populationLoss));
    }

    @Override
    public String getDisplayString() {
        return "A terrible plague has struck the kingdom!";
    }
}
