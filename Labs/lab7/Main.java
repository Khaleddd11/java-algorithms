import java.util.Scanner;

public class Main {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Library<LibraryItem> library = new Library<LibraryItem>();
        
        // Main menu
        while(true){ 
            System.out.println("\n===========================");
            System.out.println("       MAIN MENU           ");
            System.out.println("===========================");
            System.out.println("1. Manage Library Items");
            System.out.println("2. Manage Clients");
            System.out.println("0. Exit System");
            System.out.print("Enter your choice: ");
            
            int mainChoice = sc.nextInt();

            // EXIT SYSTEM
            if (mainChoice == 0) {
                System.out.println("Exiting system. Goodbye!");
                break; 
            }

            // --> items menu
            if (mainChoice == 1) {
                while(true) { 
                    System.out.println("\n--- ITEM MANAGEMENT ---");
                    System.out.println("1. Add Item");
                    System.out.println("2. Retrieve Item by ID");
                    System.out.println("3. Display All Items");
                    System.out.println("4. Update Item");
                    System.out.println("5. Delete Item");
                    System.out.println("0. BACK to Main Menu");
                    System.out.print("Enter choice: ");
                    
                    int itemChoice = sc.nextInt();
                    
                    // GO BACK
                    if (itemChoice == 0) {
                        break; //  break Inner Loop only
                    }

                    switch(itemChoice) {
                        // ADD ITEM
                        case 1: 
                            System.out.println("--- Add New Item ---");
                            System.out.println("Press 1 for Book, 2 for Magazine:");
                            int typeChoice = sc.nextInt();
                            sc.nextLine(); // 
                            
                            if(typeChoice == 1){
                                System.out.print("Enter Title: ");
                                String title = sc.nextLine();
                                System.out.print("Enter ID: ");
                                int id = sc.nextInt();
                                sc.nextLine(); 
                                System.out.print("Enter Author Name: ");
                                String author = sc.nextLine();
                                
                                Book newBook = new Book(id, title, author);
                                library.addItem(newBook);
                                System.out.println("Successfully added Book.");
                            }
                            else if (typeChoice == 2){
                                System.out.print("Enter Title: ");
                                String title = sc.nextLine();
                                System.out.print("Enter ID: ");
                                int id = sc.nextInt();
                                System.out.print("Enter Issue Number: ");
                                int issue = sc.nextInt();
                                
                                Magazine newMagazine = new Magazine(id, title, issue);
                                library.addItem(newMagazine);
                                System.out.println("Successfully added Magazine.");
                            }        
                            break;

                        // RETRIEVE ITEM
                        case 2:
                            try {
                                System.out.print("Enter the item's ID: ");
                                int itemId = sc.nextInt();
                                LibraryItem foundItem = library.retrieveItem(itemId);
                                System.out.println("Item Found: " + foundItem.title + " (ID: " + foundItem.id + ")");
                            } catch(ItemNotFoundException e){
                                System.out.println(e.getMessage());
                            }
                            break;

                        // DISPLAY ALL
                        case 3:
                            library.displayItem();
                            break;
                        
                        // UPDATE ITEM
                        case 4: 
                            System.out.print("Enter the ID of the item to update: ");
                            int updateId = sc.nextInt();
                            sc.nextLine(); // Eat 'Enter' key
                            
                            try {
                                // 1. Retrieve the item
                                LibraryItem item = library.retrieveItem(updateId);
                                
                                // 2. Update Common Properties
                                System.out.println("Current Title: " + item.title); 
                                System.out.print("Enter NEW title: ");
                                String newTitle = sc.nextLine();
                                item.setTitle(newTitle); 

                                // 3. Update Specific Properties
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

                            } catch (ItemNotFoundException e){
                                System.out.println(e.getMessage());
                            }
                            break;

                            case 5: 
                            try{
                            System.out.println("here are all the items we have  ");
                            library.displayItem();
                            System.out.println("enter the id of the item that you want to delete  ");
                            int itemId= sc.nextInt();
                            library.deleteItem(itemId);
                            break;

                            }catch(Exception e){
                                System.out.println("error happened"+ e.getMessage());
                            }


                    }
                }
            }
            // --> client menu

            else if (mainChoice == 2) {
                while(true) { 
                    System.out.println("\n--- CLIENT MANAGEMENT ---");
                    System.out.println("1. Add Client");
                    System.out.println("2. Display Clients");
                     System.out.println("3. Update Clients");
                      System.out.println("4. Search For a Client");
                      System.out.println("5. Delete Clients");
                    System.out.println("0. BACK to Main Menu");
                    System.out.print("Enter choice: ");
                    
                    int clientChoice = sc.nextInt();

                    // GO BACK
                    if (clientChoice == 0) {
                        break; 
                    }

                    switch(clientChoice) {
                        case 1:
                             System.out.print("Enter Client ID: ");
                             int id = sc.nextInt();
                             sc.nextLine(); 
                             System.out.print("Enter Client Name: ");
                             String name = sc.nextLine();
                             if (name.isEmpty()){
                                System.out.println("Name cannot be empty.");
                                continue;
                             }
                              if (!name.matches("[a-zA-Z ]+")) {
                                System.out.println("Name must contain letters only!");
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
                             // 2. If null, stop right here. Don't ask for name/email.
                             System.out.println("Error: Client with ID " + updateId + " not found.");
                              }  
                            else{       
                            System.out.print("Enter NEW Name: ");
                            String newName = sc.nextLine();
                            System.out.print("Enter NEW Email: ");
                            String newEmail = sc.nextLine();
                            library.updateClient(updateId, newName, newEmail);
                            break;
                            }
                            case 4: 
                            System.out.println("enter the id of the client");
                            int clientId =sc.nextInt();
                            sc.nextLine();
                            Client foundClient =library.retrieveClient(clientId);

                            if(foundClient != null){
                                System.out.println("Client Found: ");
                                System.out.println("Name: " + foundClient.getName());
                                System.out.println("Email: " + foundClient.getEmail());
                            }
                            else{
                                System.out.println("Error: Client with ID " + clientId + " not found.");
                            }
                            break;

                            

                    }
                }
            }
        }
    }
}