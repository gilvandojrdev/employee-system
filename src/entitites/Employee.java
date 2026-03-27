public class Employee {

    private Integer id;
    private String name;
    private Double salary;

    public Employee(){
    }

    public Employee(String name, Integer id, Double salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }

    public void increaseSalary(double percentage){
        salary += salary * percentage / 100.0;
    }

    @Override
    public String toString() {
        return id + ", " + name  + ", " + String.format("%.2f", salary);
    }

}
