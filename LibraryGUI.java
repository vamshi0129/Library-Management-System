import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LibraryGUI {
    Library lib = new Library();
    JFrame frame;
    JTextField idField, titleField, authorField, userField, nameField, dayField, searchField, transBookId, transUserId;
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
        
        idField = new JTextField();
        titleField = new JTextField();
        authorField = new JTextField();
        JButton addBookBtn = createBtn("Add");
        JButton removeBtn = createBtn("Remove");
        JButton updateBtn = createBtn("Update");

        bookPanel.add(new JLabel("Book ID")); bookPanel.add(new JLabel("Title")); 
        bookPanel.add(new JLabel("Author")); bookPanel.add(new JLabel(""));
        bookPanel.add(idField); bookPanel.add(titleField); 
        bookPanel.add(authorField); bookPanel.add(addBookBtn);
        bookPanel.add(removeBtn); bookPanel.add(updateBtn);
        bookPanel.add(new JLabel("")); bookPanel.add(new JLabel(""));

        JPanel userPanel = new JPanel(new GridLayout(2, 3, 5, 5));
        userPanel.setBackground(Color.WHITE);
        userPanel.setBorder(BorderFactory.createTitledBorder("User"));
        userField = new JTextField();
        nameField = new JTextField();
        JButton addUserBtn = createBtn("Add User");
        userPanel.add(new JLabel("User ID")); userPanel.add(new JLabel("Name")); userPanel.add(new JLabel(""));
        userPanel.add(userField); userPanel.add(nameField); userPanel.add(addUserBtn);

        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        searchPanel.setBackground(Color.WHITE);
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search"));
        searchField = new JTextField();
        searchField.setPreferredSize(new Dimension(350, 30));
        JButton searchTitleBtn = createBtn("By Title");
        JButton searchAuthorBtn = createBtn("By Author");
        searchPanel.add(searchField); searchPanel.add(searchTitleBtn); searchPanel.add(searchAuthorBtn);

        JPanel transPanel = new JPanel(new GridLayout(4, 2, 5, 5));
        transPanel.setBackground(Color.WHITE);
        transPanel.setBorder(BorderFactory.createTitledBorder("Transaction"));
        transBookId = new JTextField();
        transUserId = new JTextField();
        dayField = new JTextField();
        JButton issueBtn = createBtn("Issue");
        JButton returnBtn = createBtn("Return");
        transPanel.add(new JLabel("Book ID")); transPanel.add(transBookId);
        transPanel.add(new JLabel("User ID")); transPanel.add(transUserId);
        transPanel.add(new JLabel("Day")); transPanel.add(dayField);
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
            lib.addBook(Integer.parseInt(idField.getText()), titleField.getText(), authorField.getText());
            output.append("Book Added\n");
        });
        removeBtn.addActionListener(e -> {
            lib.removeBook(Integer.parseInt(idField.getText()));
            output.append("Book Removed\n");
        });
        updateBtn.addActionListener(e -> {
            lib.updateBook(Integer.parseInt(idField.getText()), titleField.getText(), authorField.getText());
            output.append("Book Updated\n");
        });
        addUserBtn.addActionListener(e -> {
            lib.addUser(Integer.parseInt(userField.getText()), nameField.getText());
            output.append("User Added\n");
        });
        searchTitleBtn.addActionListener(e -> output.setText(lib.searchByTitle(searchField.getText())));
        searchAuthorBtn.addActionListener(e -> output.setText(lib.searchByAuthor(searchField.getText())));
        issueBtn.addActionListener(e -> {
            lib.issueBook(Integer.parseInt(transBookId.getText()), Integer.parseInt(transUserId.getText()), Integer.parseInt(dayField.getText()));
            output.append("Book Issued\n");
        });
        returnBtn.addActionListener(e -> {
            lib.returnBook(Integer.parseInt(transBookId.getText()), Integer.parseInt(dayField.getText()));
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