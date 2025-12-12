public class Magazine extends LibraryItem{
    private int issueNumber;

    public Magazine(int id,String title, int issueNumber){
        super(id,title);
        this.issueNumber = issueNumber;
    }
    public void setIssueNumber(int issueNumber){
        this.issueNumber=issueNumber;
    }   

     public int getIssueNumber(){
            return issueNumber;
        }
        
    public String getItemDetails(){
        String result= "the magazine id is: " + id + "and the title is: "
+ title ;
return result;
    }
    
}
