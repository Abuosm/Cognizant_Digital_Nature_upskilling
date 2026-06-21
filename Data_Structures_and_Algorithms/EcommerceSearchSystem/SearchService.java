package Data_Structures_and_Algorithms.EcommerceSearchSystem;

public class SearchService {

    // LINEAR SEARCH

    public static Product linearSearch(
            Product[] products,
            String target
    ) {

        for(Product p : products){

            if(p.productName
                    .equalsIgnoreCase(target)){

                return p;
            }
        }

        return null;
    }



    // BINARY SEARCH

    public static Product binarySearch(
            Product[] products,
            String target
    ) {

        int left = 0;

        int right =
                products.length - 1;

        while(left <= right){

            int mid =
                    (left + right) / 2;

            int compare =
                    products[mid]
                    .productName
                    .compareToIgnoreCase(
                            target
                    );

            if(compare == 0){

                return products[mid];
            }

            else if(compare < 0){

                left =
                        mid + 1;
            }

            else{

                right =
                        mid - 1;
            }
        }

        return null;
    }
}