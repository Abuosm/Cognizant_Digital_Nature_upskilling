package Data_Structures_and_Algorithms.InventoryManagementSystem;

public class Main {

    public static void main(String[] args) {

        Inventory inventory =
                new Inventory();

        inventory.addProduct(
                new Product(
                        101,
                        "Laptop",
                        50,
                        65000
                )
        );

        inventory.addProduct(
                new Product(
                        102,
                        "Mouse",
                        100,
                        800
                )
        );

        inventory.display();

        inventory.updateProduct(
                101,
                60,
                67000
        );

        inventory.deleteProduct(
                102
        );

        inventory.display();
    }
}