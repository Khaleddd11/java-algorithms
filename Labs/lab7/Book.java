public class Book extends LibraryItem{
private String author;

    public Book(int id, String title,String author) {
    super(id, title); // Passes the data up to the parent
    this.author=author;
}

public void setAuthor(String author){
    this.author=author;
}

    public String getItemDetails(){
        String result= "the Book id is: " + id + "and the title is: "
+ title ;
return result;
    }
    
}
