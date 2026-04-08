import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            int ch = sc.nextInt();

            switch (ch) {

                case 1:
                    int id = sc.nextInt();
                    String title = sc.next();
                    String author = sc.next();
                    lib.addBook(id, title, author);
                    break;

                case 2:
                    int uid = sc.nextInt();
                    String name = sc.next();
                    lib.addUser(uid, name);
                    break;

                case 3:
                    String key = sc.next();
                    lib.searchBook(key);
                    break;

                case 4:
                    int b_id = sc.nextInt();
                    int u_id = sc.nextInt();
                    int days = sc.nextInt();
                    lib.issueBook(b_id, u_id, days);
                    break;

                case 5:
                    int B_id = sc.nextInt();
                    int f = sc.nextInt();
                    lib.returnBook(B_id, f);
                    break;

                case 6:
                    System.exit(0);
            }
        }
    }
}