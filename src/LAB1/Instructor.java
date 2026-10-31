package LAB1;
public class Instructor extends Person{
    private double salary;
    public Instructor(int id,String name,String email, double salary) {
        super(id,name,email);
        this.salary=salary;
    }
    public double getSalary() {
        return salary;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "Instructor{" + "salary=" + salary + '}';
    }


}