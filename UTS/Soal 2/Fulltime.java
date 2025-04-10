import java.time.LocalDate;

// Fulltime employee class that implements Koperasi
class Fulltime extends Employee implements Koperasi {
    private double baseSalary;
    private double positionAllowance;
    private int numberOfChildren;
    private double loanAmount;
    
    public Fulltime(String name, String position, Department department, LocalDate startDate, 
                  int numberOfChildren, double loanAmount) {
        super(name, position, department, startDate);
        this.numberOfChildren = numberOfChildren;
        this.loanAmount = loanAmount;
        calculateBaseSalary();
        calculatePositionAllowance();
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
    
    private void calculatePositionAllowance() {
        if (yearsOfService >= 3) {
            if (position.equals("Staf Manager")) {
                positionAllowance = 5_000_000;
            } else if (position.equals("Staf Programmer")) {
                positionAllowance = 2_000_000;
            } else if (position.equals("Staf Analis")) {
                positionAllowance = 3_000_000;
            }
        } else {
            positionAllowance = 0;
        }
    }
    
    public double getCommunicationAllowance() {
        return 500_000;
    }
    
    public double getChildrenAllowance() {
        // Maximum 3 children, 500,000 per child
        int eligibleChildren = Math.min(numberOfChildren, 3);
        return eligibleChildren * 500_000;
    }
    
    public double getProductivityBonus() {
        // 10% bonus if working more than 200 hours in a month
        if (getTotalWorkHours() > 200) {
            return baseSalary * 0.1;
        }
        return 0;
    }
    
    @Override
    public double loanMonthly() {
        return loanAmount;
    }
    
    @Override
    public double getSalary() {
        // Gaji Fulltime = gaji pokok + tunjangan lembur + tunjangan jabatan + tunjangan anak + tunjangan komunikasi + bonus produktivitas – pinjaman koperasi
        return baseSalary + 
               getOvertimeAllowance() + 
               positionAllowance + 
               getChildrenAllowance() + 
               getCommunicationAllowance() + 
               getProductivityBonus() - 
               loanMonthly();
    }
    
    public String getSalaryBreakdown() {
        StringBuilder breakdown = new StringBuilder();
        breakdown.append("Gaji Pokok: Rp. ").append(String.format("%,.2f", baseSalary)).append("\n");
        breakdown.append("Tunjangan Jabatan: Rp. ").append(String.format("%,.2f", positionAllowance)).append("\n");
        breakdown.append("Tunjangan Anak: Rp. ").append(String.format("%,.2f", getChildrenAllowance())).append("\n");
        breakdown.append("Tunjangan Komunikasi: Rp. ").append(String.format("%,.2f", getCommunicationAllowance())).append("\n");
        breakdown.append("Tunjangan Lembur: Rp. ").append(String.format("%,.2f", getOvertimeAllowance())).append("\n");
        breakdown.append("Bonus Produktivitas: Rp. ").append(String.format("%,.2f", getProductivityBonus())).append("\n");
        breakdown.append("Total Pinjaman Koperasi: Rp. ").append(String.format("%,.2f", loanMonthly())).append("\n");
        return breakdown.toString();
    }
}