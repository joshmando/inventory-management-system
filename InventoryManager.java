import java.util.Scanner;
public class InventoryManager {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int option;
        String[] productNames = new String[10];
        double[] productPrices = new double[10];
        int[] productQuantities = new int[10];
        int productCount = 0;
        String searchName;
        Boolean found = false;
        double inventoryValue = 0;
        do{
        System.out.println("INVENTORY MANAGEMENT SYSTEM");
        System.out.println("1.Add product");
        System.out.println("2.Show products");
        System.out.println("3.Search products");
        System.out.println("4.Calculate inventory value");
        System.out.println("5.Exit");
        System.out.print("choose an option: ");
        option = sc.nextInt();
        switch (option){
            case 1:
                if (productCount >= productNames.length){
                    System.out.println("Inventory is full. Maximum capacity is reached.");
                    break;
                }
                sc.nextLine();
                System.out.print("Enter product name: ");
                productNames[productCount] = sc.nextLine();

                System.out.print("Enter product price: ");
                productPrices[productCount] = sc.nextDouble();

                System.out.print("Enter product quantity: ");
                productQuantities[productCount] = sc.nextInt(); 

                System.out.println("Product added: "+ productNames[productCount]);
                productCount++;
                break;
            case 2:
                if (productCount == 0){
                    System.out.println("No products in inventory.");
                }else{
                    System.out.println("== Product list ==");
                    for(int i = 0; i < productCount; i++){
                        System.out.println();
                        System.out.println("Product: " + productNames[i]);
                        System.out.println("Price: "+ productPrices[i]);
                        System.out.println("Quantity: " + productQuantities[i]);
                    }
                }
                
                break;
            case 3:
                if(productCount == 0){
                    System.out.println("No products in inventory.");
                    break;
                }
                sc.nextLine();
                System.out.print("Enter product name to search: ");
                searchName = sc.nextLine();
                found = false;
                for(int i = 0; i < productCount; i++){
                    if(searchName.equalsIgnoreCase( productNames[i])){
                        System.out.println();
                        System.out.println("Product found:");
                        System.out.println("Product: " + productNames[i]);
                        System.out.printf("Price: $%.2f%n" , productPrices[i]);
                        System.out.println("Quantity: " + productQuantities[i]);
                        found = true;
                        break;
                    }         
                }
                if(!found){
                    System.out.println("Product not found.");
                }
                break;
            case 4:
                inventoryValue = 0;

                for (int i = 0; i < productCount; i++){
                    inventoryValue += productPrices[i] * productQuantities[i];
                }
                System.out.println();
                System.out.println("Inventory Summary");
                System.out.println("Total products: " + productCount);
                System.out.printf("Total inventory value: $%.2f%n", inventoryValue);
                break;
            case 5:
                System.out.println("Exiting program ...");
                break;
            default:
                System.out.println("Invalid option");
        }
        }while(option != 5);
        sc.close();
    }
    
}
 