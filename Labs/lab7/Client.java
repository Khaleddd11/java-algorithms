import java.util.ArrayList;

public class Client{
    private int id;
    private String name;
    private String email;
    private ArrayList<LibraryItem> borrowedItems;

    public Client(int id, String name, String email){
        this.id=id;
        this.name=name;
        this.email=email;
        this.borrowedItems= new ArrayList<>();
    }
    public void setId(int id){
        this.id=id;
    }
    public int getId(){
        return this.id; 
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return this.email;
    }
    public void addBorrowedItem(LibraryItem item){
        this.borrowedItems.add(item);
    }
     public void removeBorrowedItem(LibraryItem item){
        this.borrowedItems.remove(item);
    }
    public void getBorrowedItems(){
        for (LibraryItem item: borrowedItems){
            System.out.println("Borrowed Item ID: " + item.getId() + " Title: " + item.getTitle());
        }
    }
    public void getClientDetails(){
        System.out.println("Client id: " + id + " Name: " + name + " Email: " + email);
    }
    
 
    
}