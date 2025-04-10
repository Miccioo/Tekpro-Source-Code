public class Main {
    public static void main(String[] args) {
        // Create departments
        Department itDepartment = new Department("IT Department");

        // Create employees
        Fulltime asep = new Fulltime(
            "Asep", 
            "Staf Programmer", 
            itDepartment, 
            java.time.LocalDate.of(2021, 1, 1), 
            2, // Number of children
            500_000 // Loan amount
        );
        
        Parttime ujang = new Parttime(
            "Ujang", 
            "Staf Programmer", 
            itDepartment, 
            java.time.LocalDate.of(2024, 1, 1),
            1 // Completed projects (completed on March 25, 2025)
        );
        
        // Add overtime records for Asep
        asep.addOvertimeRecord(new OvertimeRecord(
            java.time.LocalDate.of(2025, 3, 15), // Saturday
            java.time.LocalTime.of(9, 0),
            java.time.LocalTime.of(12, 0)
        ));
        
        asep.addOvertimeRecord(new OvertimeRecord(
            java.time.LocalDate.of(2025, 3, 16), // Sunday
            java.time.LocalTime.of(20, 0),
            java.time.LocalTime.of(23, 0)
        ));
        
        // Add overtime records for Ujang
        ujang.addOvertimeRecord(new OvertimeRecord(
            java.time.LocalDate.of(2025, 3, 15), // Saturday
            java.time.LocalTime.of(13, 0),
            java.time.LocalTime.of(18, 0)
        ));

        ujang.addOvertimeRecord(new OvertimeRecord(
            java.time.LocalDate.of(2025, 3, 16), // Sunday
            java.time.LocalTime.of(10, 0),
            java.time.LocalTime.of(14, 0)
        ));
        
        // Print salary slips
        printSalarySlip(asep, 3, 2025);
        System.out.println("\n");
        printSalarySlip(ujang, 3, 2025);
    }
    
    public static void printSalarySlip(Employee employee, int month, int year) {
        java.time.LocalDate paymentDate = employee.getPaymentDate(month, year);
        
        System.out.println("==== Slip Gaji Bulan Maret ====");
        System.out.println("Tanggal Terbit: 1 April 2025");
        System.out.println("Tanggal Pembayaran: " + paymentDate.format(java.time.format.DateTimeFormatter.ofPattern("d MMMM yyyy")));
        System.out.println();
        System.out.println("Nama: " + employee.getName());
        System.out.println("Jabatan: " + employee.getPosition());
        System.out.println("Total Jam Kerja: " + employee.getTotalWorkHours() + " jam");
        System.out.println("Total Lembur: " + employee.getTotalOvertimeHours() + " jam (Akhir Pekan: " + employee.getWeekendOvertimeHours() + " jam)");
        
        // Different breakdowns based on employee type
        if (employee instanceof Fulltime) {
            System.out.println(((Fulltime) employee).getSalaryBreakdown());
        } else if (employee instanceof Parttime) {
            System.out.println(((Parttime) employee).getSalaryBreakdown());
        }
        
        System.out.println("Total Gaji: Rp. " + String.format("%,.2f", employee.getSalary()));
    }
}