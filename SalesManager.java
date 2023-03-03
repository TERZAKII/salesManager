import java.util.Scanner;

abstract class Employee implements Manager {
    protected String name;
    protected double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    protected abstract void hireEmployee(String name, double salary);
}

interface Manager {
    void hireEmployee(Employee employee);
}

interface SalesPerson {
    void sell();
}

public class SalesManager extends Employee implements SalesPerson {
    protected String department;

    public SalesManager(String name, double salary, String department) {
        super(name, salary);
        this.department = department;
    }

    @Override
    public void work() {
        System.out.println("Managing sales team");
    }

    @Override
    protected void hireEmployee(String name, double salary) {
        System.out.println(name + "'s salary is: " + salary);
    }

    @Override
    public void hireEmployee(Employee employee) {
        System.out.println("Hiring employee for sales team");
    }

    @Override
    public void sell() {
        System.out.println("Selling products");
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        double salary = in.nextDouble();
        String department = in.next();
        if(salary==0){
            System.out.println("Salary can not be zero");
        }
        else if(salary<0){
            System.out.println("Salary can not be less than ZERO");
        }
        else{
            SalesManager salesManager = new SalesManager(name,salary,department);
            salesManager.hireEmployee(name,salary);
            salesManager.work();
            salesManager.sell();
            System.out.println(salesManager.department);
        }

    }
}
