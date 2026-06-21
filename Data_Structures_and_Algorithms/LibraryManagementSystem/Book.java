package Data_Structures_and_Algorithms.LibraryManagementSystem;
public class Book {

    int bookId;

    String title;

    String author;

    public Book(
            int bookId,
            String title,
            String author
    ){

        this.bookId =
                bookId;

        this.title =
                title;

        this.author =
                author;
    }

    @Override
    public String toString(){

        return bookId
                +" | "
                +title
                +" | "
                +author;
    }
}
