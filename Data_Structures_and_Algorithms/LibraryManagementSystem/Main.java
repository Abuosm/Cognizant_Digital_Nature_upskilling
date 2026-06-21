package Data_Structures_and_Algorithms.LibraryManagementSystem;

import java.util.Arrays;

public class Main {

    public static void main(
            String[] args
    ) {

        Book[] books = {

                new Book(
                        1,
                        "Java",
                        "James"
                ),

                new Book(
                        2,
                        "Spring",
                        "Rod"
                ),

                new Book(
                        3,
                        "Python",
                        "Guido"
                ),

                new Book(
                        4,
                        "DSA",
                        "Mark"
                )
        };



        System.out.println(
                "Linear Search"
        );



        Book result1 =
                SearchService
                        .linearSearch(
                                books,
                                "Python"
                        );



        System.out.println(
                result1
        );



        Arrays.sort(
                books,
                (a,b)->
                        a.title
                                .compareToIgnoreCase(
                                        b.title
                                )
        );



        System.out.println(
                "\nBinary Search"
        );



        Book result2 =
                SearchService
                        .binarySearch(
                                books,
                                "Python"
                        );



        System.out.println(
                result2
        );
    }
}
