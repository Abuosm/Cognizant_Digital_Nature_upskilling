package Data_Structures_and_Algorithms.EcommerceSearchSystem;

import java.util.Arrays;

public class Main {

    public static void main(
            String[] args
    ) {

        Product[] products = {

                new Product(
                        1,
                        "Laptop",
                        "Electronics"
                ),

                new Product(
                        2,
                        "Mobile",
                        "Electronics"
                ),

                new Product(
                        3,
                        "Mouse",
                        "Accessories"
                ),

                new Product(
                        4,
                        "Watch",
                        "Fashion"
                )
        };



        Product result1 =
                SearchService.linearSearch(
                        products,
                        "Mouse"
                );

        System.out.println(
                "Linear Search: "
                        + result1
        );



        Arrays.sort(
                products,
                (a,b)->a.productName
                        .compareToIgnoreCase(
                                b.productName
                        )
        );



        Product result2 =
                SearchService.binarySearch(
                        products,
                        "Mouse"
                );

        System.out.println(
                "Binary Search: "
                        + result2
        );
    }
}