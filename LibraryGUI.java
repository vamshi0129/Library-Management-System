import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LibraryGUI {
    Library lib = new Library();
    JFrame frame;
    JTextField id, title, author, user, name, day, search, transBookId, transUserId;
    JTextArea output;

    public LibraryGUI() {
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {}

        frame = new JFrame("Library Management System");
        frame.setSize(800, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));
        frame.getContentPane().setBackground(new Color(245, 247, 250));

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.setBackground(new Color(245, 247, 250));
        topPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel bookPanel = new JPanel(new GridLayout(3, 4, 5, 5));
        bookPanel.setBackground(Color.WHITE);
        bookPanel.setBorder(BorderFactory.createTitledBorder("Book"));
        
        id = new JTextField();
        title = new JTextField();
        author = new JTextField();
        JButton addBookBtn = createBtn("Add");
        JButton removeBtn = createBtn("Remove");
        JButton updateBtn = createBtn("Update");

        bookPanel.add(new JLabel("Book ID")); bookPanel.add(new JLabel("Title")); 
        bookPanel.add(new JLabel("Author")); bookPanel.add(new JLabel(""));
        bookPanel.add(id); bookPanel.add(title); 
        bookPanel.add(author); bookPanel.add(addBookBtn);
        bookPanel.add(removeBtn); bookPanel.add(updateBtn);
        bookPanel.add(new JLabel("")); bookPanel.add(new JLabel(""));

        JPanel userPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        userPanel.setBackground(Color.WHITE);
        userPanel.setBorder(BorderFactory.createTitledBorder("User"));
        user = new JTextField();
        name = new JTextField();
        JButton addUserBtn = createBtn("Add User");
        userPanel.add(new JLabel("User ID")); userPanel.add(new JLabel("Name")); userPanel.add(new JLabel(""));
        userPanel.add(user); userPanel.add(name); userPanel.add(addUserBtn);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        searchPanel.setBackground(Color.WHITE);
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search"));
        search = new JTextField();
        search.setPreferredSize(new Dimension(350, 30));
        JButton searchTitleBtn = createBtn("By Title");
        JButton searchAuthorBtn = createBtn("By Author");
        searchPanel.add(search); searchPanel.add(searchTitleBtn); searchPanel.add(searchAuthorBtn);

        JPanel transPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        transPanel.setBackground(Color.WHITE);
        transPanel.setBorder(BorderFactory.createTitledBorder("Transaction"));
        transBookId = new JTextField();
        transUserId = new JTextField();
        day = new JTextField();
        JButton issueBtn = createBtn("Issue");
        JButton returnBtn = createBtn("Return");
        transPanel.add(new JLabel("Book ID")); transPanel.add(transBookId);
        transPanel.add(new JLabel("User ID")); transPanel.add(transUserId);
        transPanel.add(new JLabel("Day")); transPanel.add(day);
        transPanel.add(issueBtn); transPanel.add(returnBtn);

        topPanel.add(bookPanel); topPanel.add(userPanel); 
        topPanel.add(searchPanel); topPanel.add(transPanel);

        output = new JTextArea();
        output.setFont(new Font("Consolas", Font.PLAIN, 14));
        output.setBackground(new Color(30, 30, 30));
        output.setForeground(Color.GREEN);
        JScrollPane scroll = new JScrollPane(output);
        scroll.setBorder(BorderFactory.createTitledBorder("Output"));

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scroll, BorderLayout.CENTER);

        addBookBtn.addActionListener(e -> {
            lib.addBook(Integer.parseInt(id.getText()), title.getText(), author.getText());
            output.append("Book Added\n");
        });
        removeBtn.addActionListener(e -> {
            lib.removeBook(Integer.parseInt(id.getText()));
            output.append("Book Removed\n");
        });
        updateBtn.addActionListener(e -> {
            lib.updateBook(Integer.parseInt(id.getText()), title.getText(), author.getText());
            output.append("Book Updated\n");
        });
        addUserBtn.addActionListener(e -> {
            lib.addUser(Integer.parseInt(user.getText()), name.getText());
            output.append("User Added\n");
        });
        searchTitleBtn.addActionListener(e -> output.setText(lib.searchByTitle(search.getText())));
        searchAuthorBtn.addActionListener(e -> output.setText(lib.searchByAuthor(search.getText())));
        issueBtn.addActionListener(e -> {
            lib.issueBook(Integer.parseInt(transBookId.getText()), Integer.parseInt(transUserId.getText()), Integer.parseInt(day.getText()));
            output.append("Book Issued\n");
        });
        returnBtn.addActionListener(e -> {
  
  
            lib.returnBook(Integer.parseInt(transBookId.getText()), Integer.parseInt(day.getText()));
            output.append("Book Returned\n");
        });

        frame.setVisible(true);
    }

    private JButton createBtn(String text) {
        JButton btn = new JButton(text);
        btn.setBackground(new Color(70, 130, 180));
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        return btn;
    }

    public static void main(String[] args) {
        new LibraryGUI();
    }
}