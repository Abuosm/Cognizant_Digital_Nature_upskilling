package Data_Structures_and_Algorithms.InventoryManagementSystem;

import java.util.HashMap;

public class Inventory {

    private HashMap<Integer, Product> products =
            new HashMap<>();

    // Add Product
    public void addProduct(Product product) {

        products.put(
                product.getProductId(),
                product
        );

        System.out.println("Product Added");
    }

    // Update Product
    public void updateProduct(
            int id,
            int quantity,
            double price) {

        Product product =
                products.get(id);

        if(product != null){

            product.setQuantity(quantity);
            product.setPrice(price);

            System.out.println(
                    "Product Updated"
            );

        } else {
            System.out.println(
                    "Product Not Found"
            );
        }
    }

    // Delete Product
    public void deleteProduct(int id){

        products.remove(id);

        System.out.println(
                "Product Deleted"
        );
    }

    // Display
    public void display(){

        for(Product p:
                products.values()){

            System.out.println(p);
        }
    }
}