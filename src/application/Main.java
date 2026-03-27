import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {

        List<Employee> list = new ArrayList<>();

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("How many employees will be registred? ");

        int quantity = sc.nextInt();

        for (int i = 0; i < quantity; i++) {
            System.out.println("Emplyooe " + "#" +(i + 1) + ":");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            while (hasId(list, id)) {
                System.out.println("Id already taken! Try again: ");
                id = sc.nextInt();
            }

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();

            Employee emp = new Employee(name, id, salary);

            list.add(emp);
        }

        System.out.println("Enter the employee id that will have salary increase: ");
        int id = sc.nextInt();

        //Integer pos = idPosition(list, id);

        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        // if (pos == null) {
        if(emp == null){
            System.out.println("This id does not exist!");
        } else {
            System.out.println("Enther the percetange: ");
            double percetange = sc.nextDouble();
            //list.get(pos).increaseSalary(percetange);
            emp.increaseSalary(percetange);
        }

        System.out.println();
        System.out.println("List of employees: ");

        for (Employee e : list){
            System.out.println(e);
        }

    }

    public static Integer idPosition(List<Employee> list, int id) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }

}
