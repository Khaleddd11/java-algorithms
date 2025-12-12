import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;



public class Library <T extends LibraryItem> {
    private ArrayList<T> items;
    private ArrayList<Client> clients;

    public Library() {
        this.items = new ArrayList<>();
        this.clients= new ArrayList<>();
    }

    public void addItem(T lib){
        if (lib == null) {
        System.out.println("Error: Cannot add a null item.");
        return;
    }
        for(int i = 0; i < items.size(); i++){
            if(items.get(i).id == lib.id){
                System.out.println("item already is here!");
                return;
            }
        }
        items.add(lib);
    }

    public T retrieveItem(int id)throws ItemNotFoundException{
        for (T item : items) {
            if (item.id == id) {
                return item;
            }
        }
        System.out.println("Id not found");
        throw new ItemNotFoundException("Id not found error thrown");
    }

    public void displayItem(){
        if (items.isEmpty()) {
            System.out.println("No items found.");}
        System.out.println("The list of all items in the librray: ");
        System.out.println("-------------------------------");
        for(LibraryItem item :items){
            System.out.println("the item id is: " + item.id +" "+ "AND the item's name is " +" " +item.title +
             " " + "And The item Borrowed Status is: " + item.isBorrowed);
        }
       
        
    }
   
    public void deleteItem(int id){
        for (T item : items){
            if(item.id == id){
                items.remove(item);
                return;
            }
        }
    }

    public Client retrieveClient(int id) {
    for (Client client : clients) {
        if (client.getId() == id) {
            return client;
        }
    }
    return null; // Return null if not found (or throw exception)
}

    public void addClient(int id, String name, String email){
        for (Client client: clients){
            if (client.getId()== id){
                System.out.println("A Student With This Id is Already Registered");
                return;

            }

        }
        //email check
        for (Client client: clients){
        if (client.getEmail().equalsIgnoreCase(email)){
            System.out.println("Error: This email is already registered.");
            return;
        }
    }
        clients.add(new Client(id,name,email));
        return ;
    }
    public void displayClients(){
        if (clients.isEmpty()){
            System.out.println("No clients found.");
            return;
        }
        for(Client client : clients){
            System.out.println("Client ID: " + client.getId() + " Name: " + client.getName());
        }

    }
    public void updateClient(int id ,String name, String email){
     for(Client client :clients){
       if (client.getId() == id){
           client.setName(name);
           client.setEmail(email);
           System.out.println("Client information updated successfully.");
           return;
       }
       }
       System.out.println("Client with ID " + id + " not found.");
       return;


    }
    public void deleteClient( int id){
        for (Client client: clients){
            if(client.getId() == id){
                clients.remove(client);
                System.out.println("Client with ID " + id + " has been deleted.");
                return;
            }
        }
        System.out.println("Client with ID " + id + " not found.");
        
    }
    public void borrowItem(LibraryItem itemToBorrow, Client clientBorrowing) {
    if (itemToBorrow.isBorrowed) {
        System.out.println("Item is already borrowed.");
        return;
    }
    clientBorrowing.addBorrowedItem(itemToBorrow);
    itemToBorrow.isBorrowed = true;
    System.out.println("Item borrowed successfully.");
}

    public void returnItem(LibraryItem itemToReturn,Client clientReturning){
        if (!itemToReturn.isBorrowed) {
        System.out.println("Error: Item '" + itemToReturn.title + "' was not borrowed.");
        return;
    }
        clientReturning.removeBorrowedItem(itemToReturn);
        itemToReturn.isBorrowed=false;
        System.out.println("Item returned successfully.");
    }

    //STREAM METHODS:
    public T findItemStream(int id) throws ItemNotFoundException {
        //  Filter by ID then Find first result then Or Throw Exception
        return items.stream()
                .filter(item -> item.id == id)
                .findFirst()
                .orElseThrow(() -> new ItemNotFoundException("Id not found error thrown (Stream version)"));
    }

    // Client Management (Stream) 
    public Client findClientByIdStream(int id) {
        return clients.stream()
                .filter(client -> client.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //Filter library items
    public List<T> filterItemsByTitleStream(String titleKeyword) {
        return items.stream()
                .filter(item -> item.title.toLowerCase().contains(titleKeyword.toLowerCase()))
                .collect(Collectors.toList());
    }
    //Filtering items to see only available ones
    public List<T> getAvailableItemsStream() {
        return items.stream()
                .filter(item -> !item.isBorrowed)
                .collect(Collectors.toList());
    }
}
