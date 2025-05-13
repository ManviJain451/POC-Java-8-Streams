import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Manvi", "JVM", 70000, Arrays.asList(new Project("ABC"), new Project("DEF"))),
                new Employee(2, "Ananya", "JS", 50000, Arrays.asList(new Project("DEF"))),
                new Employee(3, "Yash", "Devops", 80000, Arrays.asList(new Project("GHI"))),
                new Employee(4, "Rohit", "JVM", 60000, Arrays.asList(new Project("CRM"), new Project("KLM"))),
                new Employee(5, "Kunal", "JVM", 55000, new ArrayList<>())
        );

        List<Employee> jvmEmp = employees
                .stream()
                .filter(e -> "JVM".equals(e.getDepartment()))
                .collect(Collectors.toList());
        System.out.println("JVM Employees: " + jvmEmp);

        List<String> highSalaryEarners = employees
                .stream()
                .filter(e -> e.getSalary() > 60000)
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("High Earners: " + highSalaryEarners);


        List<Employee> sortedBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .collect(Collectors.toList());
        System.out.println("Sorted by Salary in descending order: " + sortedBySalary);


        Map<String, List<Employee>> groupedByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        System.out.println("Grouped by Department: " + groupedByDept);

        Set<String> allProjects = employees.stream()
                .flatMap(e -> e.getProjects().stream())
                .map(Project::getProjectName)
                .collect(Collectors.toSet());
        System.out.println("All Projects: " + allProjects);


        Map<Boolean, List<Employee>> partitioned = employees.stream()
                .collect(Collectors.partitioningBy(e -> e.getSalary() > 60000));
        System.out.println("High Salary Group: " + partitioned.get(true));
        System.out.println("Low Salary Group: " + partitioned.get(false));


        employees.stream()
                .reduce((e1, e2) -> e1.getSalary() > e2.getSalary() ? e1 : e2)
                .ifPresent(e -> System.out.println("Highest Paid: " + e));


        List<Employee> deptThenSalary = employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment)
                        .thenComparing(Employee::getSalary))
                .collect(Collectors.toList());
        System.out.println("Sorted by Department & Salary: " + deptThenSalary);


        List<String> debugged = employees.stream()
                .peek(e -> System.out.println("Processing: " + e.getName()))
                .map(Employee::getName)
                .collect(Collectors.toList());


        double totalSalary = employees.parallelStream()
                .mapToDouble(Employee::getSalary)
                .sum();
        System.out.println("Total Salary : " + totalSalary);



        Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0]+f[1]})
                .limit(10).map(f->f[0]).forEach(System.out::println);
    }



}