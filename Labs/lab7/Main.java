import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Library<LibraryItem> library = new Library<>(); 
        

        // MAIN MENU
        while(true){ 
            System.out.println("\n===========================");
            System.out.println("       MAIN MENU           ");
            System.out.println("===========================");
            System.out.println("1. Manage Library Items (Add, Borrow, Return...)");
            System.out.println("2. Manage Clients");
            System.out.println("0. Exit System");
            System.out.print("Enter your choice: ");
            
            int mainChoice = sc.nextInt();
            sc.nextLine(); 

            // EXIT SYSTEM
            if (mainChoice == 0) {
                System.out.println("Exiting system. Goodbye!");
                break; 
            }


            // 1. ITEM MANAGEMENT
            else if (mainChoice == 1) {
                while(true) { 
                    System.out.println("\n--- ITEM MANAGEMENT ---");
                    System.out.println("1. Add Item");
                    System.out.println("2. Retrieve Item by ID");
                    System.out.println("3. Display All Items");
                    System.out.println("4. Update Item");
                    System.out.println("5. Delete Item");
                    System.out.println("6. Borrow Item"); 
                    System.out.println("7. Return Item"); 
                    System.out.println("0. BACK to Main Menu");
                    System.out.print("Enter choice: ");
                    
                    int itemChoice = sc.nextInt();
                    sc.nextLine(); 
                    
                    if (itemChoice == 0) break; 

                    try {
                        switch(itemChoice) {

                            case 1: 
                                System.out.println("--- Add New Item ---");
                                System.out.println("Press 1 for Book, 2 for Magazine:");
                                int typeChoice = sc.nextInt();
                                sc.nextLine();
                                
                                System.out.print("Enter Title: ");
                                String title = sc.nextLine();
                                System.out.print("Enter ID: ");
                                int id = sc.nextInt();
                                sc.nextLine(); 
                                
                                if(typeChoice == 1){
                                    System.out.print("Enter Author Name: ");
                                    String author = sc.nextLine();
                                    Book newBook = new Book(id, title, author);
                                    library.addItem(newBook);
                                    System.out.println("Successfully added Book.");
                                }
                                else if (typeChoice == 2){
                                    System.out.print("Enter Issue Number: ");
                                    int issue = sc.nextInt();
                                    Magazine newMagazine = new Magazine(id, title, issue);
                                    library.addItem(newMagazine);
                                    System.out.println("Successfully added Magazine.");
                                }        
                                break;


                            case 2:
                                System.out.print("Enter the item's ID: ");
                                int itemId = sc.nextInt();
                                LibraryItem foundItem = library.retrieveItem(itemId);
                                if(foundItem != null) {
                                    System.out.println("Item Found: " + foundItem.title);
                                }
                                break;

                            case 3:
                                library.displayItem();
                                break;

                            case 4: 
                                System.out.print("Enter the ID of the item to update: ");
                                int updateId = sc.nextInt();
                                sc.nextLine();
                                
                                LibraryItem item = library.retrieveItem(updateId);
                                System.out.println("Current Title: " + item.title); 
                                System.out.print("Enter NEW title: ");
                                String newTitle = sc.nextLine();
                                item.setTitle(newTitle); 

                                if(item instanceof Book){
                                     System.out.print("Enter NEW Author: ");
                                     String newAuthor = sc.nextLine();
                                    ((Book)item).setAuthor(newAuthor); 
                                } else if (item instanceof Magazine) {
                                    System.out.print("Enter NEW Issue Number: ");
                                    int newIssue = sc.nextInt();
                                    ((Magazine) item).setIssueNumber(newIssue);
                                }
                                System.out.println("Item updated successfully!");
                                break;


                            case 5: 
                                System.out.println("Enter the id of the item that you want to delete: ");
                                int deleteId = sc.nextInt();
                                library.deleteItem(deleteId);
                                break;


                            case 6:
                                System.out.println("--- BORROW PROCESS ---");
                                System.out.print("Enter Item ID to borrow: ");
                                int bItemId = sc.nextInt();
                                LibraryItem itemToBorrow = library.retrieveItem(bItemId);

                                System.out.print("Enter Client ID: ");
                                int bClientId = sc.nextInt();
                                Client borrower = library.retrieveClient(bClientId);

                                if (itemToBorrow != null && borrower != null) {
                                    library.borrowItem(itemToBorrow, borrower);
                                } else {
                                    System.out.println("Error: Invalid Item ID or Client ID.");
                                }
                                break;

                            case 7:
                                System.out.println("--- RETURN PROCESS ---");
                                System.out.print("Enter Item ID to return: ");
                                int rItemId = sc.nextInt();
                                LibraryItem itemToReturn = library.retrieveItem(rItemId);

                                System.out.print("Enter Client ID: ");
                                int rClientId = sc.nextInt();
                                Client returner = library.retrieveClient(rClientId);

                                if (itemToReturn != null && returner != null) {
                                    library.returnItem(itemToReturn, returner);
                                } else {
                                    System.out.println("Error: Invalid Item ID or Client ID.");
                                }
                                break;
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
            }


            // 2. CLIENT MANAGEMENT
            else if (mainChoice == 2) {
                while(true) { 
                    System.out.println("\n--- CLIENT MANAGEMENT ---");
                    System.out.println("1. Add Client");
                    System.out.println("2. Display Clients");
                    System.out.println("3. Update Clients");
                    System.out.println("4. Search For a Client");
                    System.out.println("5.Display Borrowed Items Of  A Client");
                    System.out.println("6. Delete Clients");
                    System.out.println("0. BACK to Main Menu");
                    System.out.print("Enter choice: ");
                    
                    int clientChoice = sc.nextInt();
                    sc.nextLine(); 

                    if (clientChoice == 0) break; 

                    switch(clientChoice) {
                        case 1:
                             System.out.print("Enter Client ID: ");
                             int id = sc.nextInt();
                             sc.nextLine(); 
                             System.out.print("Enter Client Name: ");
                             String name = sc.nextLine();
                             
                             if (name.isEmpty() || !name.matches("[a-zA-Z ]+")){
                                System.out.println("Invalid name.");
                                continue;
                             }
                             System.out.print("Enter Client Email: ");
                             String email = sc.nextLine();
                             
                             library.addClient(id, name, email);
                             System.out.println("Client added successfully.");
                             break;
                        case 2:
                            library.displayClients();
                            break;
                        case 3:
                            System.out.print("Enter Client ID to update: ");
                            int updateId = sc.nextInt();
                            sc.nextLine();
                            Client clientToUpdate = library.retrieveClient(updateId);  
                            if (clientToUpdate == null) {
                                System.out.println("Error: Client not found.");
                            } else {        
                                System.out.print("Enter NEW Name: ");
                                String newName = sc.nextLine();
                                System.out.print("Enter NEW Email: ");
                                String newEmail = sc.nextLine();
                                library.updateClient(updateId, newName, newEmail);
                            }
                            break;
                        case 4: 
                            System.out.print("Enter the id of the client: ");
                            int clientId = sc.nextInt();
                            sc.nextLine();
                            Client foundClient = library.retrieveClient(clientId);
                            if(foundClient != null){
                                System.out.println("Client Found: " + foundClient.getName() + " | " + foundClient.getEmail());
                            } else {
                                System.out.println("Error: Client not found.");
                            }
                            break;
                        case 5:
                            System.out.print("Enter the id of the client: ");
                            int cIdForItems = sc.nextInt();
                            sc.nextLine();
                            Client clientForItems = library.retrieveClient(cIdForItems);
                            if(clientForItems != null){
                                clientForItems.getBorrowedItems();
                            } else {
                                System.out.println("Error: Client not found.");
                            }
                            break;
                        case 6:
                            System.out.print("Enter the id of the client to delete: ");
                            int cId = sc.nextInt();
                            sc.nextLine();
                            library.deleteClient(cId);
                            break;
                    }
                }
            }
        }
    }
}