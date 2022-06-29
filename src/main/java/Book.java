public class Book {
    public String title;
    public String genre = "fiction";
    public int NumberofPages = 300;
 
    public Book(String title, String genre, int numberofPages) {
         this.title = title;
         this.genre = genre;
         NumberofPages = numberofPages;
     }
 
     @Override
     public String toString() {
         return "Book [NumberofPages=" + NumberofPages + ", genre=" + genre + ", title=" + title + "]";
     }
 }
 