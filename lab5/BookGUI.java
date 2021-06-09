import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class BookGUI extends JFrame implements ActionListener{
    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;

    private JTextArea outputArea;
    private JTextField titleField;
    private JTextField authorField;
    private JTextField isbnField;
    private JTextField yearField;
    private JTextField priceField;
    private JTextField subjectField;
    private JTextField workField;
    private JTextField probField;

    private BookStore store;

    public BookGUI(){
        super();
        setSize(WIDTH, HEIGHT);
        setTitle("Bookstore GUI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));

        store = new BookStore();

        outputArea = new JTextArea(100, 50);
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        //Convert all this into another class
        JMenu bookMenu = new JMenu("Options");

        JMenuItem saveOp = new JMenuItem("Save As...");
        saveOp.addActionListener(this);
        bookMenu.add(saveOp);

        JMenuItem loadOp = new JMenuItem("Load File...");
        loadOp.addActionListener(this);
        bookMenu.add(loadOp);

        JMenuItem quitOp = new JMenuItem("Quit");
        quitOp.addActionListener(this);
        bookMenu.add(quitOp);

        JMenuBar bar = new JMenuBar();
        bar.add(bookMenu);
        setJMenuBar(bar);

        JPanel operationsPanel = new JPanel();
        operationsPanel.setLayout(new GridLayout(2, 2, 10, 10));
        JPanel addingPanel = new JPanel();
        addingPanel.setLayout(new GridLayout(3, 1, 10, 10));
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(8, 1, 5, 5));

        JButton showBooks = new JButton("Show Books");
        showBooks.addActionListener(new BookListener());
        JButton showAuthors = new JButton("Show Authors");
        showAuthors.addActionListener(new AuthorListener());
        JButton showAverage = new JButton("Average Price");
        showAverage.addActionListener(new AverageListener());
        JButton showMatching = new JButton("Textbook - Workbook Pairs");
        showMatching.addActionListener(new MatchingListener());

        JButton addBook = new JButton("Add Book");
        addBook.addActionListener(new AddBookListener());
        JButton addTextBook = new JButton("Add Textbook");
        addTextBook.addActionListener(new AddBookListener());
        JButton addWorkBook = new JButton("Add Workbook");
        addWorkBook.addActionListener(new AddBookListener());

        JLabel titleLabel = new JLabel("Title");
        JLabel authorLabel = new JLabel("Author");
        JLabel isbnLabel = new JLabel("ISBN");
        JLabel yearLabel = new JLabel("Year");
        JLabel priceLabel = new JLabel("Price");
        JLabel subjectLabel = new JLabel("Subject");
        JLabel workLabel = new JLabel("Workbook ISBN");
        JLabel probLabel = new JLabel("Number of Problems");

        titleField = new JTextField();
        authorField = new JTextField();
        isbnField = new JTextField();
        yearField = new JTextField();
        priceField = new JTextField();
        subjectField = new JTextField();
        workField = new JTextField();
        probField = new JTextField();

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new GridLayout(1, 2, 5, 5));
        titlePanel.add(titleLabel);
        titlePanel.add(titleField);

        JPanel authorPanel = new JPanel();
        authorPanel.setLayout(new GridLayout(1, 2, 5, 5));
        authorPanel.add(authorLabel);
        authorPanel.add(authorField);

        JPanel isbnPanel = new JPanel();
        isbnPanel.setLayout(new GridLayout(1, 2, 5, 5));
        isbnPanel.add(isbnLabel);
        isbnPanel.add(isbnField);

        JPanel yearPanel = new JPanel();
        yearPanel.setLayout(new GridLayout(1, 2, 5, 5));
        yearPanel.add(yearLabel);
        yearPanel.add(yearField);

        JPanel pricePanel = new JPanel();
        pricePanel.setLayout(new GridLayout(1, 2, 5, 5));
        pricePanel.add(priceLabel);
        pricePanel.add(priceField);

        JPanel subjectPanel = new JPanel();
        subjectPanel.setLayout(new GridLayout(1, 2, 5, 5));
        subjectPanel.add(subjectLabel);
        subjectPanel.add(subjectField);

        JPanel workPanel = new JPanel();
        workPanel.setLayout(new GridLayout(1, 2, 5, 5));
        workPanel.add(workLabel);
        workPanel.add(workField);

        JPanel probPanel = new JPanel();
        probPanel.setLayout(new GridLayout(1, 2, 5, 5));
        probPanel.add(probLabel);
        probPanel.add(probField);

        operationsPanel.add(showBooks);
        operationsPanel.add(showAuthors);
        operationsPanel.add(showAverage);
        operationsPanel.add(showMatching);

        addingPanel.add(addBook);
        addingPanel.add(addTextBook);
        addingPanel.add(addWorkBook);

        inputPanel.add(titlePanel);
        inputPanel.add(authorPanel);
        inputPanel.add(isbnPanel);
        inputPanel.add(yearPanel);
        inputPanel.add(pricePanel);
        inputPanel.add(subjectPanel);
        inputPanel.add(workPanel);
        inputPanel.add(probPanel);


        add(operationsPanel);
        add(addingPanel);
        add(scrollPane);
        add(inputPanel);
    }


    public void actionPerformed(ActionEvent e){
        String actionName = e.getActionCommand();

        if(actionName.contains("Save")){
            String fileName = JOptionPane.showInputDialog(this, "Enter the file name:");
            String message = null;
            if(store.saveBooks(fileName)){
                message = "Books have been saved to " + fileName;
            }else{
                message = "Could not save the books to " + fileName;
            }

            JOptionPane.showMessageDialog(this, message);

        }else if(actionName.contains("Load")){
            String fileName = JOptionPane.showInputDialog(this, "Enter the file name:");
            String message = null;

            if(store.loadBooks(fileName)){
                message = "Loaded books from " + fileName;
            }else{
                message = "Could not load from " + fileName;
            }

            JOptionPane.showMessageDialog(this, message);

        }else if(actionName.equals("Quit")){
            System.exit(0);
        }
    }


    private class BookListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ArrayList<String> books = store.getBooks();
            outputArea.setText("Books:\n");
            for(String s : books){
                outputArea.append(s + "\n");
            }
        }
    }


    private class AuthorListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ArrayList<String> authors = store.getAuthors();
            outputArea.setText("Authors:\n");
            for(String s : authors){
                outputArea.append(s + "\n");
            }
        }
    }


    private class MatchingListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ArrayList<String> matchingList = store.getMatching();
            outputArea.setText("Matching Pairs:\n");
            for(String s : matchingList){
                outputArea.append(s + "\n");
            }
        }
    }

    private class AverageListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            ArrayList<String> avgList = store.getAverage();
            outputArea.setText("Store Details\n");
            for(String s : avgList){
                outputArea.append(s + "\n");
            }
        }
    }

    private class AddBookListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            String command = e.getActionCommand();
            outputArea.setText("");
            boolean formValid = true;
            String title = titleField.getText();
            String author = authorField.getText();
            String isbn = isbnField.getText();
            int year = 0;
            try{
                year = Integer.parseInt(yearField.getText());
            }catch(NumberFormatException ex){
                outputArea.append("Year is invalid.\n");
                formValid = false;
            }
            double price = 0.0;
            try{
                price = Double.parseDouble(priceField.getText());
            }catch(NumberFormatException ex){
                outputArea.append("Price is invalid.\n");
                formValid = false;
            }

            ArrayList<String> messages = new ArrayList<>();

            if(formValid && command.equals("Add Book")){
                messages = store.addBook(title, author, isbn, year, price);
            }else if(formValid && command.equals("Add Textbook")){
                String subject = subjectField.getText();
                String workISBN = workField.getText();
                messages = store.addTextBook(title, author, isbn, year, price, subject, workISBN);
            }else if (formValid && command.equals("Add Workbook")){
                try{
                    int numProbs = Integer.parseInt(probField.getText());
                    messages = store.addWorkBook(title, author, isbn, year, price, numProbs);
                }catch(NumberFormatException ex){
                    outputArea.append("Number of problems is invalid.");
                }
            }

            for(String s : messages){
                outputArea.append(s + "\n");
            }

            titleField.setText("");
            authorField.setText("");
            isbnField.setText("");
            yearField.setText("");
            probField.setText("");
            workField.setText("");
            priceField.setText("");
            subjectField.setText("");

        }
    }

}