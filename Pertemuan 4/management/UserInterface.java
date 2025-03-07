package management;
import kingdom.Kingdom;

public interface UserInterface {
    void showMessage(String message);
    void showStatus(Kingdom kingdom);
    int getNumberInput(int min, int max);
    int getNumberInput(int min, int max, String prompt);
    void displayActionMenu();
}