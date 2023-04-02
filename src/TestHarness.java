import java.util.ArrayList;
import java.util.Scanner;

public class TestHarness {
    public static void main(String[] args) {
        // Setup scanner and other global program variables.
        Scanner sc = new Scanner(System.in);
        boolean programRunning = true;
        int intInput = 0;
        String strInput = "";
        int index = 0;
        String tempString = "";
        double tempDouble = 0.0;
        int tempInt = 0;
        
        // Create a new Store object that contains the store's inventory and members.
        Store store = new Store();

        // Create lists that will hold the items a user adds to their order until those items are purchased and removed from store inventory.
        ArrayList<Product> cart = new ArrayList<Product>(5);

        // Main loop.
        while (programRunning) {

            // Main menu prompt.
            System.out.println("----- Welcome to the Bookstore Management System -----");
            System.out.println("GRADER PLEASE NOTE THAT INVENTORY VALUE ACCESSIBLE FROM OPTION 5 AND RESTOCK PRODUCT FROM OPTION 3");
            System.out.println("Please choose an option below:");
            System.out.println();
            System.out.println("1\tCreate a new order.");
            System.out.println("2\tAdd a new member.");
            System.out.println("3\tAdd items to store inventory.");
            System.out.println("4\tList members and premium members.");
            System.out.println("5\tList store inventory.");
            System.out.println("6\tQuit");
            System.out.println();
            System.out.println("Please enter your choice:");

            // Take the users choice.
            intInput = sc.nextInt();
            // Make sure the choice is not out of bounds.
            while (intInput < 1 || intInput > 6) {
                System.out.println("Invalid option; please enter a number from 1 to 4.");
                intInput = sc.nextInt();
            }
            sc.nextLine(); // Catches the \n after the user enters an integer.

            // Switch case for each menu option.
            switch (intInput) {
                case 6: // Quit the program.
                    programRunning = false;
                    break;
                case 1: // Start a new order.

                    // BEGIN PURCHASE PROMPT
                    // Determine if there is anything in stock
                    if (store.getInventory().size() > 0) {
                        while (true) {
                            // Allow users to add items to their cart
                            System.out.println("Here are the items currently in stock:");
                            store.printInventory();
                            System.out.println("Please enter the number of the product you want to add to your cart:");
                            intInput = sc.nextInt();
                            sc.nextLine();
                            cart.add(store.getInventory().get(intInput));
                            System.out.println("Would you like to add another? [y/n]");
                            strInput = sc.nextLine();
                            if (strInput.toLowerCase().equals("n")) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("There are no products currently in stock.");
                    }

                    // Print out the contents of the cart while adding the price of each item to the total, then print the total
                    System.out.println("Your cart currently contains:");
                    double orderTotal = 0.0;
                    for (Product item : cart) {
                        System.out.println("--------------------");
                        orderTotal += item.getPrice();
                        item.print();
                    }
                    System.out.println("--------------------");
                    System.out.println("Order total: $"+(((int)(orderTotal*100))/100.0));
                    System.out.println("--------------------");

                    if (orderTotal == 0) {
                        break;
                    }

                    // Prompt the user for their name, and determine if they are a member
                    System.out.println("What is your name?");
                    strInput = sc.nextLine();

                    index = store.findMember(strInput);
                    if (index == -1) {
                        // User is not a member
                        System.out.println("Welcome, "+strInput+"!");
                        System.out.println("Please enter your credit card number:");
                        intInput = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Please enter the expiration date:");
                        tempString = sc.nextLine();
                        System.out.println(store.placeOrder(new CreditCard(intInput, tempString), cart));
                    } else {
                        if (store.getMembers().get(index) instanceof PremiumMember) {
                            // User is a premium member, so place an order with the card they have on file
                            System.out.println("Welcome, "+store.getMembers().get(index).getName()+"!");
                            System.out.println(store.placeOrder(((PremiumMember)store.getMembers().get(index)).getCardOnFile(), cart));
                            store.getMembers().get(index).addMoneySpent(orderTotal);
                        } else {
                            // User is a regular member
                            System.out.println("Welcome, "+store.getMembers().get(index).getName()+"!");
                            System.out.println("Please enter your credit card number:");
                            intInput = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Please enter the expiration date in the format mm/dd/yyyy:");
                            strInput = sc.nextLine();
                            System.out.println(store.placeOrder(new CreditCard(intInput, strInput), cart));
                            store.getMembers().get(index).addMoneySpent(orderTotal);
                        }
                    }

                    

                    cart.clear();
                    // END PURCHASE PROMPT

                    System.out.println("end of ordering system");
                    break;
                case 2: // Add a new member.
                    System.out.println("Enter 1 to add a regular member or 2 for a premium member.");
                    intInput = sc.nextInt();
                    sc.nextLine();
                    switch (intInput) {
                        case 1: // If adding a regular member, ask for his/her name and create the member.
                            System.out.println("Please enter the name of the new member: ");
                            strInput = sc.nextLine();
                            store.addMember(new Member(strInput));
                            System.out.println("Member "+strInput+" added.");
                            break;
                        
                        case 2: // If adding a premium member, ask for his/her name and create the member, then ask for a card number and set his/her card number.
                            System.out.println("Please enter the name of the new premium member: ");
                            strInput = sc.nextLine();
                            System.out.println("Please enter the card number for the new premium member: ");
                            intInput = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Please enter the expiration date for that card:");
                            tempString = sc.nextLine();
                            store.addMember(new PremiumMember(strInput, new CreditCard(intInput, tempString)));
                            System.out.println("Premium member "+strInput+" added.");
                            System.out.println("Card number for premium member "+strInput+" set to "+intInput+".");
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;
                case 3: // Add items to the store inventory.
                    System.out.println("Please enter 1 to add a new item, or 2 to add more of an existing item.");
                    intInput = sc.nextInt();
                    sc.nextLine();
                    switch (intInput) { // begin existing vs new switch
                        case 1: // Adding a new item
                            System.out.println("Please enter 1 to add a book, 2 for a DVD, and 3 for a CD:");
                            intInput = sc.nextInt();
                            sc.nextLine();
                            switch (intInput) { // begin product type switch
                                case 1: // Adding a book.
                                    System.out.println("Enter the book's name:");
                                    tempString = sc.nextLine();
                                    System.out.println("Enter the book's price:");
                                    tempDouble = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Enter the name of the book's author:");
                                    strInput = sc.nextLine();
                                    store.addProduct(new Book(tempString, tempDouble, strInput));
                                    System.out.println("Book "+tempString+" added to inventory.");
                                    break;

                                case 2: // Adding a DVD.
                                    System.out.println("Enter the DVD's name:");
                                    tempString = sc.nextLine();
                                    System.out.println("Enter the DVD's price:");
                                    tempDouble = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Enter the name the studio that released the DVD:");
                                    strInput = sc.nextLine();
                                    store.addProduct(new DVD(tempString, tempDouble, strInput));
                                    System.out.println("DVD "+tempString+" added to inventory.");
                                    break;

                                case 3: // Adding a CD.
                                    System.out.println("Enter the album name:");
                                    tempString = sc.nextLine();
                                    System.out.println("Enter the CD's price:");
                                    tempDouble = sc.nextDouble();
                                    sc.nextLine();
                                    System.out.println("Enter the name of the artist:");
                                    strInput = sc.nextLine();
                                    store.addProduct(new CD(tempString, tempDouble, strInput));
                                    System.out.println("CD "+tempString+" added to inventory.");
                                    break;
                            
                                default:
                                    break;
                            }
                            break;
                        case 2: // Adding more of an existing item
                            System.out.println("Current inventory:");
                            store.printInventory();
                            System.out.println("Please enter the number of the item you want to add more of:");
                            intInput = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Please enter the quantity you wish to add:");
                            tempInt = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Quanitity now in stock:"+store.restockProduct(intInput, tempInt));
                            
                            break;

                    }// end existing vs new switch   
                    break;

                case 4: // Show members and premium members
                    System.out.println("Premium members:");
                    for (Member member : store.getMembers()) {
                        if (member instanceof PremiumMember)
                            System.out.println("\tName: "+member.getName()+"\t\tTotal spent: $"+member.getSpent()+"\t\tSubscription paid: "+((PremiumMember)member).isSubscriptionPaid()+"\t\tCard on file: "+((PremiumMember)member).getCardOnFile().getCardNo());
                    }
                    System.out.println();
                    System.out.println("Members:");
                    for (Member member : store.getMembers()) {
                        if (member instanceof Member)
                            System.out.println("\tName: "+member.getName()+"\t\tTotal spent: $"+member.getSpent());
                    }
                    break;

                case 5: // Show current inventory.
                    System.out.println("\nCurrent inventory:");
                    store.printInventory();
                    System.out.println("Value of current inventory: $"+store.inventoryValue());
                    break;
            }
        } // END MAIN LOOP

        sc.close();

    } // END MAIN METHOD
}
