import kingdom.Kingdom;
import management.*;

public class Main {
    public static void main(String[] args) {
        // Initialize game components
        Kingdom kingdom = new Kingdom();
        UserInterface ui = new TextBasedUI();
        GameManager gameManager = new GameManager(kingdom, ui);
        
        // Start the game
        gameManager.startGame();
    }
}