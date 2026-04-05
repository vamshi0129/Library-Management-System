import java.util.ArrayList;

public class Library {
    
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<user> users = new ArrayList<>();
    ArrayList<Transaction> transactions = new ArrayList<>();

    void addBook(int id , String title , String author){
        books.add(new Book(id, title, author, false));
    }

    void removeBook(int id){
        books.removeIf(book -> book.id == id);
    }
    String searchByTitle(String title) {
        StringBuilder res = new StringBuilder();
        for (Book b : books) {
            if (b.title.toLowerCase().contains(title.toLowerCase())) {
                res.append(b.id + " - " + b.title + " by " + b.author + "\n");
            }
        }
        return res.toString();
    }

    String searchByAuthor(String author) {
        StringBuilder res = new StringBuilder();
        for (Book b : books) {
            if (b.author.toLowerCase().contains(author.toLowerCase())) {
                res.append(b.id + " - " + b.title + " by " + b.author + "\n");
            }
        }
        return res.toString();
    }
    void updateBook(int id, String newTitle, String newAuthor) {
        for (Book b : books) {
            if (b.id == id) {
                b.title = newTitle;
                b.author = newAuthor;
                return;
            }
        }
    }

    void addUser(int id , String name){
        users.add(new user(id, name));
    }

    void searchBook(String title){
        for(Book book : books){
            if(book.title.equals(title)){
                System.out.println("Book found: " + book.title + ", author : " + book.author);
                return;
            }
        }
        System.out.println("Book not found");
    }
    void issueBook(int bookId , int userId , int day){
        for(Book b : books){
            if(b.id == bookId && !b.isIssued){
                b.isIssued = true;
                transactions.add(new Transaction(bookId, userId, day, -1));
                System.out.println("Book issued successfully");
                return;
            }
        }
        System.out.println("Book not available");
    }
    void returnBook(int bookId , int userId , int day){
        for(Transaction t : transactions){
            if(t.bookId == bookId && t.userId == userId && t.returnDate == -1){
                t.returnDate = day;
                for(Book b : books){
                    if(b.id == bookId){
                        b.isIssued = false;
                        System.out.println("Book returned successfully");
                        return;
                    }
                }
            }
        }
        System.out.println("Invalid return");
    }

    void returnBook( int bookId ,int day){
        for(Transaction t : transactions){
            if(t.bookId == bookId && t.returnDate == -1){
                t.returnDate = day;
                for(Book b : books){
                    if(b.id == bookId){
                        b.isIssued = false;
                        System.out.println("Book returned .");
                        return;
                    }

                    int fine = calculateFine(t.issueDate , t.returnDate);
                    System.out.println("Book returned  , fine : "+fine);
                    return;
                }
            }
        }
        System.out.println("Invalid return");
    }

    int calculateFine(int issueDay, int returnDay) {
        int days = returnDay - issueDay;
        if (days > 7) {
            return (days - 7) * 10;
        }
        return 0;
    }
}
