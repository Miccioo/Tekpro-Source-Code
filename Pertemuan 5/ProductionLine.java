import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class ProductionLine {
    // 3. Kelas untuk mengelola mesin produksi
    private final ConcurrentHashMap<String, String> machineStatus = new ConcurrentHashMap<>();
    private final ConcurrentSkipListSet<String> activeMachines = new ConcurrentSkipListSet<>();

    public void updateMachineStatus(String machineId, String status) {
        machineStatus.put(machineId, status);
        if (status.equals("Operational")) {
            activeMachines.add(machineId);
        } else {
            activeMachines.remove(machineId);
        }
    }

    public void displayMachineStatus() {
        System.out.println("\nStatus Mesin Produksi:");
        machineStatus.forEach((machine, status) -> 
            System.out.println("Mesin " + machine + " status: " + status));
    }

    public boolean isMachineOperational(String machineId) {
        return "Operational".equals(machineStatus.get(machineId));
    }
}
