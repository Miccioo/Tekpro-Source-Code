package management;
import java.util.Scanner;
import kingdom.Kingdom;

public class TextBasedUI implements UserInterface {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void showMessage(String message) {
        System.out.println("\n" + message);
    }

    @Override
    public void showStatus(Kingdom kingdom) {
        System.out.println("\n=== KINGDOM STATUS ===");
        System.out.println("Year: " + kingdom.getYear() + "/" + kingdom.getMAX_YEARS());
        System.out.println("Population: " + kingdom.getPopulation());
        System.out.println("Gold: " + kingdom.getGold());
        System.out.println("Food: " + kingdom.getFood());
        System.out.println("Land: " + kingdom.getLand());
        System.out.println("Soldiers: " + kingdom.getSoldiers());
        System.out.println("======================");
    }

    @Override
    public int getNumberInput(int min, int max) {
        return getNumberInput(min, max, "");
    }

    @Override
    public int getNumberInput(int min, int max, String prompt) {
        while(true) {
            try {
                if(!prompt.isEmpty()) System.out.println(prompt);
                System.out.print("> ");
                int input = Integer.parseInt(scanner.nextLine());
                if(input >= min && input <= max) return input;
                System.out.println("Please enter between " + min + "-" + max);
            } catch(NumberFormatException e) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    @Override
    public void displayActionMenu() {
        System.out.println("\nChoose an action:");
        System.out.println("1. Buy Food (1 gold = 2 food)");
        System.out.println("2. Buy Land (5 gold = 1 acre)");
        System.out.println("3. Recruit Soldiers (10 gold = 1 soldier)");
        System.out.println("4. Do Nothing");
    }

}