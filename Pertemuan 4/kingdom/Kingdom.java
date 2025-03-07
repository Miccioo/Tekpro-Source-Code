package kingdom;
import kingdom.interfaces.Displayable;

public class Kingdom implements Displayable {
    private int year = 1;
    private int population = 500;
    private int gold = 1000;
    private int food = 500;
    private int land = 1000;
    private int soldiers = 50;
    private int MAX_YEARS = 10;
    
    @Override
    public String getDisplayString() {
        return String.format(
            "Year %d/%d | Pop: %d | Gold: %d | Food: %d | Land: %d | Soldiers: %d",
            year, MAX_YEARS, population, gold, food, land, soldiers
        );
    }

    public void incrementYear() {
        setYear(getYear() + 1);
    }
    
    // Getters and setters
    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getGold() {
        return this.gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getFood() {
        return this.food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getLand() {
        return this.land;
    }

    public void setLand(int land) {
        this.land = land;
    }

    public int getSoldiers() {
        return this.soldiers;
    }

    public void setSoldiers(int soldiers) {
        this.soldiers = soldiers;
    }

    public int getMAX_YEARS() {
        return this.MAX_YEARS;
    }

    public void setMAX_YEARS(int MAX_YEARS) {
        this.MAX_YEARS = MAX_YEARS;
    }


    

}