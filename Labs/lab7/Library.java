import java.util.ArrayList;



public class Library <T extends LibraryItem> {
    private ArrayList<T> items;
    private ArrayList<Client> clients;

    public Library() {
        this.items = new ArrayList<>();
        this.clients= new ArrayList<>();
    }

    public void addItem(T lib){
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
            System.out.println("the item id is: " + item.id +" "+ "AND the item's name is " +" " +item.title);
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
}
