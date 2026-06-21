package Data_Structures_and_Algorithms.TaskManagementSystem;

public class TaskLinkedList {

    private Task head;



    // ADD

    public void addTask(
            int id,
            String name,
            String status
    ){

        Task newTask =
                new Task(
                        id,
                        name,
                        status
                );



        if(head == null){

            head =
                    newTask;

            return;
        }



        Task temp =
                head;

        while(
                temp.next
                !=
                null
        ){

            temp =
                    temp.next;
        }



        temp.next =
                newTask;
    }



    // SEARCH

    public Task search(
            int id
    ){

        Task temp =
                head;



        while(
                temp
                !=
                null
        ){

            if(
                    temp.taskId
                    ==
                    id
            ){

                return temp;
            }



            temp =
                    temp.next;
        }



        return null;
    }



    // TRAVERSE

    public void display(){

        Task temp =
                head;



        while(
                temp
                !=
                null
        ){

            System.out.println(
                    temp
            );



            temp =
                    temp.next;
        }
    }



    // DELETE

    public void delete(
            int id
    ){

        if(
                head
                ==
                null
        ){

            return;
        }



        if(
                head.taskId
                ==
                id
        ){

            head =
                    head.next;

            return;
        }



        Task current =
                head;



        while(
                current.next
                !=
                null
        ){

            if(
                    current.next.taskId
                    ==
                    id
            ){

                current.next =
                        current.next.next;

                return;
            }



            current =
                    current.next;
        }



        System.out.println(
                "Task Not Found"
        );
    }
}