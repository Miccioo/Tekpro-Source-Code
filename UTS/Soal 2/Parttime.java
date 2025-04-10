import java.time.LocalDate;

// Parttime employee class
class Parttime extends Employee {
    private double baseSalary;
    private int completedProjects;
    
    public Parttime(String name, String position, Department department, LocalDate startDate, int completedProjects) {
        super(name, position, department, startDate);
        this.completedProjects = completedProjects;
        calculateBaseSalary();
    }
    
    private void calculateBaseSalary() {
        if (position.equals("Staf Manager")) {
            if (yearsOfService <= 2) {
                baseSalary = 5_000_000;
            } else if (yearsOfService <= 5) {
                baseSalary = 6_000_000;
            } else {
                baseSalary = 7_000_000;
            }
        } else if (position.equals("Staf Programmer")) {
            if (yearsOfService <= 2) {
                baseSalary = 3_000_000;
            } else if (yearsOfService <= 5) {
                baseSalary = 4_000_000;
            } else {
                baseSalary = 5_000_000;
            }
        } else if (position.equals("Staf Analis")) {
            if (yearsOfService <= 2) {
                baseSalary = 3_000_000;
            } else if (yearsOfService <= 5) {
                baseSalary = 3_500_000;
            } else {
                baseSalary = 4_500_000;
            }
        }
    }
    
    public double getProjectBonus() {
        return completedProjects * 200_000;
    }
    
    @Override
    public double getSalary() {
        // Gaji Parttime = gaji pokok + tunjangan lembur + bonus proyek
        return baseSalary + getOvertimeAllowance() + getProjectBonus();
    }
    
    public String getSalaryBreakdown() {
        StringBuilder breakdown = new StringBuilder();
        breakdown.append("Gaji Pokok: Rp. ").append(String.format("%,.2f", baseSalary)).append("\n");
        breakdown.append("Tunjangan Lembur: Rp. ").append(String.format("%,.2f", getOvertimeAllowance())).append("\n");
        breakdown.append("Bonus Proyek: Rp. ").append(String.format("%,.2f", getProjectBonus())).append("\n");
        return breakdown.toString();
    }
}