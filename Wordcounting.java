  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Wordcounting{

    // JFrame to hold all the components
    private JFrame frame;

    // Text area where user can input the paragraph
    private JTextArea textArea;

    // Label to display the word count
    private JLabel wordCountLabel;

    public Wordcounting() {
        // Create the frame
        frame = new JFrame("Word Count Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create the text area for input
        textArea = new JTextArea();
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        // Scroll pane to make the text area scrollable
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Panel to hold the button and word count label
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Button to trigger word count
        JButton countButton = new JButton("Count Words");
        panel.add(countButton);

        // Label to display the word count
        wordCountLabel = new JLabel("Word count: 0");
        panel.add(wordCountLabel);

        frame.add(panel, BorderLayout.SOUTH);

        // Action listener for the button
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textArea.getText();
                int wordCount = countWords(text);
                wordCountLabel.setText("Word count: " + wordCount);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    // Method to count words in a given text
    private int countWords(String text) {
        if (text == null || text.trim().isEmpty()) {
            return 0; // No words if the text is empty or null
        }
        // Split the text by spaces and count the number of elements
        String[] words = text.trim().split("\\s+");
        return words.length;
    }

    // Main method to launch the application
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Wordcounting();
            }
        });
    }
}

