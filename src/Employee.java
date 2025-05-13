import java.util.List;

public class Employee {
    private int id;
    private String name;
    private String department;
    private double salary;
    private List<Project> projects;

    public Employee(int id, String name, String department, double salary, List<Project> projects) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.projects = projects;
    }

    public String getName() { return name; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
    public List<Project> getProjects() { return projects; }

    @Override
    public String toString() {
        return name + " (" + department + ", $" + salary + ")";
    }
}


