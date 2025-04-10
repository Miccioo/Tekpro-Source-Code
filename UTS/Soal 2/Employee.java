import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

// Abstract Employee class
abstract class Employee {
    protected String name;
    protected String position;
    protected Department department;
    protected int yearsOfService;
    protected LocalDate startDate;
    protected int normalWorkHours;
    protected List<OvertimeRecord> overtimeRecords;
    
    public Employee(String name, String position, Department department, LocalDate startDate) {
        this.name = name;
        this.position = position;
        this.department = department;
        this.startDate = startDate;
        this.yearsOfService = calculateYearsOfService();
        this.overtimeRecords = new ArrayList<>();
        this.normalWorkHours = 160; // Standard working hours per month
    }
    
    private int calculateYearsOfService() {
        return Period.between(startDate, LocalDate.now()).getYears();
    }
    
    public void addOvertimeRecord(OvertimeRecord record) {
        overtimeRecords.add(record);
    }
    
    public int getTotalOvertimeHours() {
        return overtimeRecords.stream().mapToInt(OvertimeRecord::getHours).sum();
    }
    
    public int getWeekendOvertimeHours() {
        return overtimeRecords.stream()
                .filter(OvertimeRecord::isWeekend)
                .mapToInt(OvertimeRecord::getHours)
                .sum();
    }
    
    public int getRegularOvertimeHours() {
        return overtimeRecords.stream()
                .filter(record -> !record.isWeekend())
                .mapToInt(OvertimeRecord::getHours)
                .sum();
    }
    
    public double getOvertimeAllowance() {
        double weekendOvertimeAmount = getWeekendOvertimeHours() * 50000;
        double regularOvertimeAmount = getRegularOvertimeHours() * 30000;
        return weekendOvertimeAmount + regularOvertimeAmount;
    }
    
    public int getTotalWorkHours() {
        return normalWorkHours + getTotalOvertimeHours();
    }
    
    public String getName() {
        return name;
    }
    
    public String getPosition() {
        return position;
    }
    
    public Department getDepartment() {
        return department;
    }
    
    // Abstract method to be implemented by subclasses
    public abstract double getSalary();
    
    public LocalDate getPaymentDate(int month, int year) {
        // Get the first day of the next month
        LocalDate paymentDate = LocalDate.of(year, month, 1).plusMonths(1);
        
        // Check if the payment date falls on a weekend
        java.time.DayOfWeek dayOfWeek = paymentDate.getDayOfWeek();
        if (dayOfWeek == java.time.DayOfWeek.SATURDAY) {
            paymentDate = paymentDate.minusDays(1);
        } else if (dayOfWeek == java.time.DayOfWeek.SUNDAY) {
            paymentDate = paymentDate.minusDays(2);
        }
        
        return paymentDate;
    }
}