import java.util.ArrayList;



public class Library <T extends LibraryItem> {
    private ArrayList<T> items;

    public Library() {
        this.items = new ArrayList<>();
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
    
}
