public abstract class LibraryItem {
    protected int id;
    protected String title;

    public LibraryItem(int id, String title){
        this.id =id;
        this.title=title;
    }

    public abstract String getItemDetails();

    
    public void setId(int id){
        this.id =id;
    }
    public int getId(){
        return this.id;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return this.title;
    }
}


/*1. Design a class hierarchy for a simple Library Management System:
   - Create an abstract class `LibraryItem` with properties like `id` and `title`.
   - Extend `LibraryItem` to create subclasses `Book` and `Magazine`.
   - Add a method `getItemDetails()` to return item details.
*/