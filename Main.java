import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n1.Add Book 2.Add User 3.Search 4.Issue 5.Return 6.Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter id, title, author: ");
                    int id = sc.nextInt();
                    String title = sc.next();
                    String author = sc.next();
                    lib.addBook(id, title, author);
                    break;

                case 2:
                    System.out.print("Enter user id and name: ");
                    int uid = sc.nextInt();
                    String name = sc.next();
                    lib.addUser(uid, name);
                    break;

                case 3:
                    System.out.print("Enter keyword: ");
                    String key = sc.next();
                    lib.searchBook(key);
                    break;

                case 4:
                    System.out.print("Enter bookId userId day: ");
                    lib.issueBook(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;

                case 5:
                    System.out.print("Enter bookId and return day: ");
                    lib.returnBook(sc.nextInt(), sc.nextInt());
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}