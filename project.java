package project_work;
import java.util.*;
import java.io.Serializable;

class Product8 implements Serializable {

    // Optional but recommended
    private static final long serialVersionUID = 1L;

	private String name;
	private int id;
	private double price;
	private int stock;
	Product8(String name,int id,double price,int stock){
		this.name=name;
		this.id=id;
		this.price=price;
		this.stock=stock;
	}
	public String getname() {
		return name;
	}
	public int getid() {
		return id;
	}
	public double getprice() {
		return price;
	}
	public int getstock() {
		return stock;
	}
	  public void display() {

	        String status;

	        if (stock > 0)
	            status = "Available";
	        else
	            status = "Not Available";

	        System.out.println(id + "\t" + name + "\t₹" + price +
	                           "\tStock : " + stock + "\t" + status);
	    }
	
				// alag alag bhi print katr hakate hia
	}

class Cart {
    private ArrayList<Product8> cart = new ArrayList<>();

    public void addProduct(Product8 p) {
        cart.add(p);
        System.out.println(p.getname() + " added successfully.");
    }

    public void removeProduct(int id) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getid() == id) {
                System.out.println(cart.get(i).getname() + " removed.");
                cart.remove(i);
                return;
            }
        }
        System.out.println("Product not found in cart.");
    }
    
    public void viewCart() {
        if (cart.isEmpty()) {// Empty ka matlad-Cart me koi bhi product add nahi hua hai.
            System.out.println("Cart is Empty.");
            return;
        }

        double total = 0;
        System.out.println("\n----- Shopping Cart -----");
        

        for (Product8 p : cart) {// for inch loops
            System.out.println(p.getname() + "  ₹" + p.getprice());
            total += p.getprice();
        }

        System.out.println("-------------------------");
        System.out.println("Total = ₹" + total);
    }

    public double getTotal() {
        double total = 0;

        for (Product8 p : cart) {// for inch Loops
            total += p.getprice();
        }

        return total;
    }
}
class Customer {

    private String name;
    private String mobile;
    private String address;
    private int pin_Number;

    Customer(String name, String mobile, String address, int pin_number) {
        this.name = name;
        this.mobile = mobile;
        this.address = address;
        this.pin_Number = pin_number;
    }

    public void displayCustomer() {
        System.out.println("\n===== CUSTOMER DETAILS =====");
        System.out.println("Customer Name : " + name);
        System.out.println("Mobile Number : " + mobile);
        System.out.println("Address       : " + address);
        System.out.println("Pin_number:"+pin_Number);
    }

    public String getName() {
        return name;
    }
}
public class E_Cart_Commerce{

    private static final Product8[] products8 = null;

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product8 p1 = new Product8("Laptop", 1, 55000,5);
        Product8 p2 = new Product8("Mobile", 2, 18000,10);
        Product8 p3 = new Product8("Keyboard", 3, 1200,5);
        Product8 p4 = new Product8("Mouse", 4, 700,7);
        Product8 p5 = new Product8("Headphone",5,500,2);        

        Cart cart = new Cart();

        System.out.println("===== Welcome To E-Cart =====");

        System.out.print("Enter Username : ");
        String user = sc.next();

        System.out.print("Enter Password : ");
        String pass = sc.next();

        if (user.equals("Anurag") && pass.equals("1234")) {

            System.out.println("\nLogin Successful");

            int choice;
            sc.nextLine(); // Buffer clear

            System.out.println("\n===== CUSTOMER DETAILS =====");

            System.out.print("Enter Customer Name : ");
            String cname = sc.nextLine();

            System.out.print("Enter Mobile Number : ");
            String mobile = sc.nextLine();

            System.out.print("Enter Address : ");
            String address = sc.nextLine();
            
            System.out.println("Pin_Number");
            int pin_Number=sc.nextInt();

          Customer customer = new Customer(cname, mobile, address,pin_Number);
            do {

                System.out.println("\n===== MENU =====");
                System.out.println("1. View Products");
                System.out.println("2. Add Product");
                System.out.println("3. Remove Product");
                System.out.println("4. View Cart");
                System.out.println("5. Generate Bill");
                System.out.println("6. Exit");

                System.out.print("Enter Choice : ");
                choice = sc.nextInt();

                switch (choice) {

                case 1:

                    System.out.println("\nID\tProduct\tPrice");// product , price,id alag alag bhi print kae askte hai
                    p1.display();
                    p2.display();
                    p3.display();
                    p4.display();
                    p5.display();
                    break;
                    
                
                case 2:

                    System.out.print("Enter Product ID to Add: ");
                    int addId = sc.nextInt();

                    switch (addId) {

                        case 1:
                            cart.addProduct(p1);
                            break;

                        case 2:
                            cart.addProduct(p2);
                            break;

                        case 3:
                            cart.addProduct(p3);
                            break;

                        case 4:
                            cart.addProduct(p4);
                            break;

                        case 5:
                            cart.addProduct(p5);
                            break;

                        default:
                            System.out.println("Invalid Product ID.");
                    }
                    break;

               
        case 3:
            System.out.print("Enter Product ID to Remove: ");
            int removeId = sc.nextInt();
            cart.removeProduct(removeId);
            break;

        case 4:
            cart.viewCart();
            break;

        case 5:
            double total = cart.getTotal();

            if (total == 0) {
                System.out.println("Your cart is empty.");
                // Empty ka matlab hai ki koi bhi card me add nhi hai
                break;
            }

            System.out.println("\n========== BILL ==========");
            customer.displayCustomer();
            cart.viewCart();

            System.out.println("\nPayment Method");
            System.out.println("1. Cash");
            System.out.println("2. UPI");
            System.out.print("Choose Payment: ");

            int payment = sc.nextInt();

            if (payment == 1) {
                System.out.println("Cash Payment Successful.");
            } else if (payment == 2) {
                System.out.println("UPI Payment Successful.");
            } else {
                System.out.println("Invalid Payment Method.");
            }

            System.out.println("Thank You for Shopping!");
            break;

        case 6:
            System.out.println("Thank You! Visit Again.");
           sc.close();
           System.exit(0);
        default:
            System.out.println("Invalid Choice.");
          //---------- Product List ----------
            ArrayList<Product8> products = new ArrayList<>();

            products.add(p1);
            products.add(p2);
            products.add(p3);
            products.add(p4);
            products.add(p5);

            // ---------- Menu ----------
            System.out.println("\n===== E-CART MENU =====");
            System.out.println("1. View Products");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. View Cart");
            System.out.println("5. Generate Bill");
            System.out.println("6. Search Product");
            System.out.println("7. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();
                }
                // Userd switch case6 related to
            switch (choice) {
            case 6:

                System.out.print("Enter Product Name: ");
                sc.nextLine();
                String search = sc.nextLine();

                boolean found = false;

				for (Product8 p : products8) {// for inch loop used in print product

                    if (p.getname().equalsIgnoreCase(search)) {
                        System.out.println("\nProduct Found");
                        p.display();
                        found = true;
                        break;
                    }
                }

                if (!found) {
                    System.out.println("Product Not Found.");
                }

                break;

            case 5: //upar ke case5 se realted

                double Total = cart.getTotal();

                if (Total == 0) {
                    System.out.println("Cart is Empty.");
                    break;
                }

                double discount = 0;

                if (Total >= 50000) {
                    discount = Total * 0.10; // 10% Discount
                }

                double gst = (Total - discount) * 0.18;

                double finalAmount = (Total - discount) + gst;

                System.out.println("\n========= FINAL BILL =========");

                cart.viewCart();

                System.out.println("------------------------------");
                System.out.println("Total Amount : ₹" + Total);
                System.out.println("Discount     : ₹" + discount);
                System.out.println("GST (18%)    : ₹" + gst);
                System.out.println("Final Amount : ₹" + finalAmount);
                System.out.println("==============================");

                System.out.println("\nPayment Method");
                System.out.println("1. Cash");
                System.out.println("2. UPI");
                System.out.print("Choose Payment: ");

                int pay = sc.nextInt();

                if (pay == 1)
                    System.out.println("Cash Payment Successful.");
                else if (pay == 2)
                    System.out.println("UPI Payment Successful.");
                else
                    System.out.println("Invalid Payment Method.");

                System.out.println("Thank You For Shopping!");
                break;

            case 7:
 
                System.out.println("Thank You! Visit Again.");
                sc.close();
                System.exit(0);

            default:
                System.out.println("Invalid Choice.");

            }

        } while (true);

    } else {

        System.out.println("Invalid Username or Password.");
    }

    sc.close();
    }
    }