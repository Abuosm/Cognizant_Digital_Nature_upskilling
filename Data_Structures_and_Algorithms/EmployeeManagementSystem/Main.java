package Data_Structures_and_Algorithms.EmployeeManagementSystem;

public class Main {

    public static void main(
            String[] args
    ) {

        EmployeeService service =
                new EmployeeService(
                        5
                );



        service.addEmployee(
                new Employee(
                        101,
                        "Abubakar",
                        "Developer",
                        50000
                )
        );



        service.addEmployee(
                new Employee(
                        102,
                        "Ali",
                        "Tester",
                        45000
                )
        );



        System.out.println(
                "\nEmployees:"
        );

        service.display();



        System.out.println(
                "\nSearch:"
        );

        System.out.println(
                service.search(
                        101
                )
        );



        service.delete(
                102
        );



        System.out.println(
                "\nAfter Delete:"
        );

        service.display();
    }
}