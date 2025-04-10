class Department {
    private String departmentName;

    public Department(String name) {
        this.departmentName = name;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}

class Employee {
    private Department department;

    public Employee(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }
}
