import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Library {
   static HashMap<String, Book> library = new HashMap<String, Book>();
   static List<Book> cart = new ArrayList<Book>();
   static Set<String> uniqueGenres = new HashSet<String>();
   static Scanner scanner = new Scanner(System.in);
   static String userInput;

    public static void addBook(){
        while (true){
            System.out.println("If you would like to add a book to your cart; type add. If not, type the title of the book to lookup the book. Type DONE is you are finished!");
            userInput = scanner.next();
            System.out.println(userInput);
            if (!(userInput.equals("add"))){
                lookUp(userInput);
            } else if (userInput.equals("DONE")){
                break;
            }
            else {
                checkGenre();
                System.out.println("What is the title?");
                String title = scanner.next();
                System.out.println("How many pages does it have?");
                int pageCount = scanner.nextInt();
                System.out.println("What is the genre?");
                String genre = scanner.next();
                Book book = new Book(title, genre, pageCount);
                //add book to library
                library.put(title, book);
                //add genre to set
                uniqueGenres.add(book.genre);
                //add book to cart
                cart.add(book);
                System.out.println(cart);
                System.out.println(library);
               }
             }   
             System.out.println("Your cart:");
             System.out.println(cart);
             scanner.close();
        }

    @Override
    public String toString() {
        return "Library []";
    }
    static public void lookUp(String title){
        if(library.containsKey(title)){
            System.out.println("Looks like we have that book:");
            System.out.println(library.get(title));
        }
        else {
            System.out.println("Sorry looks like we dont have that book.");
        }
    }
    static public void checkGenre(){
        System.out.println("Can I help you find a genre? Type 1 for yes and 0 for no.");
        int yesOrNO = scanner.nextInt();
        if (yesOrNO == 1){
            System.out.println("Type that genre youd like me to look for.");
            String genre = scanner.next();
            System.out.println(uniqueGenres.contains(genre) ? "We have that genre" : "Sorry we dont have that genre, but you can add it by adding a book of that genre.");
        }
    }
}
