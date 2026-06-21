package Data_Structures_and_Algorithms.LibraryManagementSystem;

public class SearchService {



    // LINEAR SEARCH

    public static Book linearSearch(
            Book[] books,
            String target
    ){

        for(Book book : books){

            if(
                    book.title
                            .equalsIgnoreCase(
                                    target
                            )
            ){

                return book;
            }
        }

        return null;
    }



    // BINARY SEARCH

    public static Book binarySearch(
            Book[] books,
            String target
    ){

        int left = 0;

        int right =
                books.length-1;



        while(
                left <= right
        ){

            int mid =
                    (left+right)/2;



            int compare =
                    books[mid]
                            .title
                            .compareToIgnoreCase(
                                    target
                            );



            if(compare == 0){

                return books[mid];
            }

            else if(compare < 0){

                left =
                        mid+1;
            }

            else{

                right =
                        mid-1;
            }
        }

        return null;
    }
}
