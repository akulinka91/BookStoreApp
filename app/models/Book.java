package models;

import java.util.HashSet;
import java.util.Set;
import com.avaje.ebean.Model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book extends Model{

    @Id
    public Integer id;
    public String title;
    public Integer price;
    public String author;

    public static Finder<Integer, Book> finder = new Finder<>(Book.class);

    /*public Book() {
    }

    public Book(Integer id, String title, Integer price, String author) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.author = author;
    }

    private static Set<Book> bookSet;

    static {
        bookSet = new HashSet<>();
        bookSet.add(new Book(1, "C++", 23, "abc"));
        bookSet.add(new Book(2, "JAVA", 1, "dfg"));
        bookSet.add(new Book(3, "React", 4, "dgf"));
    }

    public static Set<Book> allBooks(){
        return bookSet;
    }

    public static Book findById(Integer id){
        for (Book book: bookSet) {
            if (id.equals(book.id)){
                return book;
            }
        }
        return null;
    }

    public static void add(Book book){
        bookSet.add(book);
    }

    public static boolean remove(Book book){
        return bookSet.remove(book);
    }*/
}
