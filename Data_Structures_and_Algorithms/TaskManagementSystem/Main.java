package Data_Structures_and_Algorithms.TaskManagementSystem;

public class Main {

    public static void main(
            String[] args
    ) {

        TaskLinkedList tasks =
                new TaskLinkedList();



        tasks.addTask(
                101,
                "Design UI",
                "Pending"
        );



        tasks.addTask(
                102,
                "Build Backend",
                "In Progress"
        );



        tasks.addTask(
                103,
                "Testing",
                "Pending"
        );



        System.out.println(
                "All Tasks:"
        );

        tasks.display();



        System.out.println(
                "\nSearch:"
        );

        System.out.println(
                tasks.search(
                        102
                )
        );



        tasks.delete(
                102
        );



        System.out.println(
                "\nAfter Delete:"
        );

        tasks.display();
    }
}