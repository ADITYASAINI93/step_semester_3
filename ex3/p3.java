package ex3;

    
class Employee {
    String empName;
    double salary;
    boolean permanent;
}

public class p3 {
    public static void main(String[] args) {
        Employee e = new Employee();

        System.out.println("Name: " + e.empName);
        System.out.println("Salary: " + e.salary);
        System.out.println("Permanent: " + e.permanent);
    }
}
