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
        
        // Create a new Store object that contains the store's inventory and members.
        Store store = new Store();

        // Create lists that will hold the items a user adds to their order until those items are purchased and removed from store inventory.
        ArrayList<Product> cart = new ArrayList<Product>(5);

        // Main loop.
        while (programRunning) {

            // Main menu prompt.
            System.out.println("----- Welcome to the Bookstore Management System -----");
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
                    if (store.getInventory().size() > 0) {
                        
                    } else {
                        System.out.println("There are no products currently in stock.");
                    }
                    // END PURCHASE PROMPT

                    // BEGIN OLD PURCHASE PROMPT
                    // // See if there are any books in stock. If not, say so. If there are, ask the user if s/he wants to include any in his/her order.
                    // if (store.getBooks().size() > 0) {
                    //     System.out.println("Are any books included in your order? [y/n]");
                    //     strInput = sc.nextLine();

                    //     // Input validation.
                    //     while (!strInput.toLowerCase().equals("y") && !strInput.toLowerCase().equals("n")) {
                    //         System.out.println("Invalid response. Please enter y for yes or n for no.");
                    //         strInput = sc.nextLine();
                    //     }

                    //     // If the user wants book(s).
                    //     if (strInput.equals("y")) {
                    //         while (true) {
                    //             // Print the current books in stock, and let the user add them to his/her order.
                    //             store.printBookInventory();
                    //             System.out.println("--------------------");
                    //             System.out.println("Please enter the number for the book you want.");
                    //             intInput = sc.nextInt();
                    //             sc.nextLine();
                    //             booksInOrder.add(store.getBooks().get(intInput));
                    //             System.out.println("Book "+booksInOrder.get(booksInOrder.size()-1).getName()+" added to order.");
                                
                    //             // Ask if the user wants another book. If not, exit the book-adding loop.
                    //             System.out.println("Do you want to add another book?");
                    //             strInput = sc.nextLine();
                    //             if (strInput.toLowerCase().equals("n")) {
                    //                 break;
                    //             }
                    //         }
                    //     }
                    // } else {
                    //     System.out.println("There are currently no books in stock.");
                    // }
                    // // END BOOK PROMPT

                    // // BEGIN DVD PROMPT
                    // // See if there are any DVDs in stock. If not, say so. If there are, ask the user if s/he wants any.
                    // if (store.getDVDs().size() > 0) {
                    //     System.out.println("Are any DVDs included in your order? [y/n]");
                    //     strInput = sc.nextLine();

                    //     // Input validation.
                    //     while (!strInput.toLowerCase().equals("y") && !strInput.toLowerCase().equals("n")) {
                    //         System.out.println("Invalid response. Please enter y for yes or n for no.");
                    //         strInput = sc.nextLine();
                    //     }

                    //     // Print the DVDs that are currently in stock, and let the user add them to his/her order.
                    //     if (strInput.equals("y")) {
                    //         while (true) {
                    //             store.printDVDInventory();
                    //             System.out.println("--------------------");
                    //             System.out.println("Please enter the number for the DVD you want.");
                    //             intInput = sc.nextInt();
                    //             sc.nextLine();
                    //             dvdsInOrder.add(store.getDVDs().get(intInput));
                    //             System.out.println("DVD "+dvdsInOrder.get(dvdsInOrder.size()-1).getName()+" added to order.");
                                
                    //             // Ask the user if they want another DVD. If not, exit the DVD-adding loop.
                    //             System.out.println("Do you want to add another DVD?");
                    //             strInput = sc.nextLine();
                    //             if (strInput.toLowerCase().equals("n")) {
                    //                 break;
                    //             }
                    //         }
                    //     }
                    // } else {
                    //     System.out.println("There are currently no DVDs in stock.");
                    // }
                    // // END DVD PROMPT

                    // // BEGIN CD PROMPT
                    // // If there are no CDs in stock, say so. If there are, ask the user if s/he wants any.
                    // if (store.getCDs().size() > 0) {
                    //     System.out.println("Are any CDs included in your order? [y/n]");
                    //     strInput = sc.nextLine();

                    //     // Input validation
                    //     while (!strInput.toLowerCase().equals("y") && !strInput.toLowerCase().equals("n")) {
                    //         System.out.println("Invalid response. Please enter y for yes or n for no.");
                    //         strInput = sc.nextLine();
                    //     }

                    //     // Print the current inventory of CDs, and let the user add them to his/her order.
                    //     if (strInput.equals("y")) {
                    //         while (true) {
                    //             store.printCDInventory();
                    //             System.out.println("--------------------");
                    //             System.out.println("Please enter the number for the CD you want.");
                    //             intInput = sc.nextInt();
                    //             sc.nextLine();
                    //             cdsInOrder.add(store.getCDs().get(intInput));
                    //             System.out.println("CD "+cdsInOrder.get(cdsInOrder.size()-1).getName()+" added to order.");
                                
                    //             // Ask if the user wants any more CDs. If not, exit the CD-adding loop.
                    //             System.out.println("Do you want to add another CD?");
                    //             strInput = sc.nextLine();
                    //             if (strInput.toLowerCase().equals("n")) {
                    //                 break;
                    //             }
                    //         }
                    //     }
                    // } else {
                    //     System.out.println("There are currently no CDs in stock.");
                    // }
                    // // END CD PROMPT


                    // // Print out the items in cart, and sum their prices.
                    // double orderTotal = 0.0;
                    // System.out.println("--------------------");
                    // System.out.println("Your cart contains: ");
                    // System.out.println("--------------------");
                    // System.out.println("Books:");
                    // for (Book item : booksInOrder){
                    //     System.out.println(item.getName());
                    //     orderTotal += item.getPrice();
                    // }
                    // System.out.println("DVDs:");
                    // for (DVD item : dvdsInOrder) {
                    //     System.out.println(item.getName());
                    //     orderTotal += item.getPrice();
                    // }
                    // System.out.println("CDs:");
                    // for (CD item : cdsInOrder) {
                    //     System.out.println(item.getName());
                    //     orderTotal += item.getPrice();
                    // }
                    // System.out.println("--------------------");
                    // System.out.println("Your order total is: $"+((int)(orderTotal*100))/100.0);
                    // System.out.println("--------------------");

                    // // If there is nothing in the order, payment can be skipped.
                    // if (orderTotal == 0) {
                    //     break;
                    // }


                    // // Get the user's name, and see if they are a member.
                    // System.out.println("Please enter your name:");
                    // strInput = sc.nextLine();
                    
                    // // Find where the member with the given name is in the list of PremiumMembers.
                    // index = store.findPremiumMember(strInput); 
                    
                    // if (index == -1) {
                    //     // If they are not a Premium Member, see if they are a Member.
                    //     index = store.findMember(strInput);
                    //     if (index == -1) {
                    //         // The user is not a member at all, so ask for a card number and place the order.
                    //         System.out.println("Please enter a payment card number: ");
                    //         intInput = sc.nextInt();
                    //         sc.nextLine();
                    //         System.out.println(store.placeOrder(intInput, booksInOrder, dvdsInOrder, cdsInOrder));
                    //     } else {
                    //         // The user is a regular member, so update their money spent, ask for a card to pay with, and pay with that card.
                    //         store.getMembers().get(index).addMoneySpent(orderTotal);
                    //         System.out.println("Hello, "+strInput+"!");
                    //         System.out.println("Please enter a payment card number: ");
                    //         intInput = sc.nextInt();
                    //         sc.nextLine();
                    //         System.out.println(store.placeOrder(intInput, booksInOrder, dvdsInOrder, cdsInOrder));
                    //     }
                    // } else {
                    //     // The user is a PremiumMember, so update their total money spent and pay using the card on file.
                    //     store.getPremiumMembers().get(index).addMoneySpent(orderTotal);
                    //     System.out.println("Hello, "+strInput+"!");
                    //     System.out.println(store.placeOrder(store.getPremiumMembers().get(index).getPaymentCardNo(), booksInOrder, dvdsInOrder, cdsInOrder));
                    // }
                    

                    // booksInOrder.clear();
                    // dvdsInOrder.clear();
                    // cdsInOrder.clear();
                    // END OLD ORDERING SYSTEM

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
                            store.addPremiumMember(new PremiumMember(strInput, intInput));
                            System.out.println("Premium member "+strInput+" added.");
                            System.out.println("Card number for premium member "+strInput+" set to "+intInput+".");
                            break;
                        default:
                            System.out.println("Invalid option.");
                            break;
                    }
                    break;
                case 3: // Add items to the store inventory.
                    System.out.println("Please enter 1 to add a book, 2 for a DVD, and 3 for a CD:");
                    intInput = sc.nextInt();
                    sc.nextLine();
                    switch (intInput) {
                        case 1: // Adding a book.
                            System.out.println("Enter the book's name:");
                            tempString = sc.nextLine();
                            System.out.println("Enter the book's price:");
                            tempDouble = sc.nextDouble();
                            sc.nextLine();
                            System.out.println("Enter the name of the book's author:");
                            strInput = sc.nextLine();
                            store.addBook(new Book(tempString, tempDouble, strInput));
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
                            store.addDVD(new DVD(tempString, tempDouble, strInput));
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
                            store.addCD(new CD(tempString, tempDouble, strInput));
                            System.out.println("CD "+tempString+" added to inventory.");
                            break;
                    
                        default:
                            break;
                    }
                    break;

                case 4: // Show members and premium members
                    System.out.println("Premium members:");
                    for (PremiumMember member : store.getPremiumMembers()) {
                        System.out.println("\tName: "+member.getName()+"\t\tTotal spent: $"+member.getSpent()+"\t\tSubscription paid: "+member.isSubscriptionPaid()+"\t\tCard on file: "+member.getPaymentCardNo());
                    }
                    System.out.println();
                    System.out.println("Members:");
                    for (Member member : store.getMembers()) {
                        System.out.println("\tName: "+member.getName()+"\t\tTotal spent: $"+member.getSpent());
                    }
                    break;

                case 5: // Show current inventory.
                    System.out.println("Books:");
                    store.printBookInventory();
                    System.out.println();
                    System.out.println("DVDs:");
                    store.printDVDInventory();
                    System.out.println();
                    System.out.println("CDs:");
                    store.printCDInventory();
                    System.out.println();
                    break;
            }
        } // END MAIN LOOP

        sc.close();

    } // END MAIN METHOD
}
