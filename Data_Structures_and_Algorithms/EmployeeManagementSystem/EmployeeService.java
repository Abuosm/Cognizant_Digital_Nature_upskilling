package Data_Structures_and_Algorithms.EmployeeManagementSystem;

public class EmployeeService {

    private Employee[] employees;

    private int count = 0;


    public EmployeeService(
            int size
    ){

        employees =
                new Employee[size];
    }



    // ADD

    public void addEmployee(
            Employee employee
    ){

        if(
                count <
                employees.length
        ){

            employees[count++] =
                    employee;

            System.out.println(
                    "Employee Added"
            );

        }

        else{

            System.out.println(
                    "Array Full"
            );
        }
    }



    // SEARCH

    public Employee search(
            int id
    ){

        for(
                int i=0;
                i<count;
                i++
        ){

            if(
                    employees[i]
                            .employeeId
                            ==
                            id
            ){

                return employees[i];
            }
        }

        return null;
    }



    // TRAVERSE

    public void display(){

        for(
                int i=0;
                i<count;
                i++
        ){

            System.out.println(
                    employees[i]
            );
        }
    }



    // DELETE

    public void delete(
            int id
    ){

        for(
                int i=0;
                i<count;
                i++
        ){

            if(
                    employees[i]
                            .employeeId
                            ==
                            id
            ){

                for(
                        int j=i;
                        j<count-1;
                        j++
                ){

                    employees[j] =
                            employees[j+1];
                }

                employees[count-1] =
                        null;

                count--;

                System.out.println(
                        "Employee Deleted"
                );

                return;
            }
        }

        System.out.println(
                "Employee Not Found"
        );
    }
}