public abstract class LibraryItem {
    protected int id;
    protected String title;
    protected boolean isBorrowed;

    public LibraryItem(int id, String title){
        this.id =id;
        this.title=title;
        this.isBorrowed=false;
    }

    public abstract String getItemDetails();

    
    public void setId(int id){
        this.id =id;
    }
    public int getId(){
        return this.id;
    }
    public void setIsBorrowed(boolean b){
        this.isBorrowed=b;

    }
    public boolean getIsBorrowed(){
        return this.isBorrowed;
    }
    public void setTitle(String title){
        this.title=title;
    }
    public String getTitle(){
        return this.title;
    }
}

