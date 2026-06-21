package Data_Structures_and_Algorithms.OrderSortingSystem;

public class Main {

    public static void main(
            String[] args
    ) {

        Order[] orders = {

                new Order(
                        101,
                        "Abubakar",
                        5500
                ),

                new Order(
                        102,
                        "Ali",
                        1500
                ),

                new Order(
                        103,
                        "Sara",
                        9000
                ),

                new Order(
                        104,
                        "John",
                        3500
                )
        };



        System.out.println(
                "Original"
        );

        SortService.display(
                orders
        );



        SortService.bubbleSort(
                orders
        );



        System.out.println(
                "Bubble Sort"
        );

        SortService.display(
                orders
        );



        Order[] quickOrders = {

                new Order(
                        101,
                        "Abubakar",
                        5500
                ),

                new Order(
                        102,
                        "Ali",
                        1500
                ),

                new Order(
                        103,
                        "Sara",
                        9000
                ),

                new Order(
                        104,
                        "John",
                        3500
                )
        };



        SortService.quickSort(
                quickOrders,
                0,
                quickOrders.length-1
        );



        System.out.println(
                "Quick Sort"
        );

        SortService.display(
                quickOrders
        );
    }
}