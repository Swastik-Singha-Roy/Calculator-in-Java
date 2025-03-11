import java.awt.*; //for graphics library
import java.awt.event.*; //for event handling
import java.util.Arrays; //for listing the buttons
import javax.swing.*;
import javax.swing.border.LineBorder; //for modifying the buttons border lines

public class Calculator {
    //dimensions of the window
    int boardWidth = 360;
    int boardHeight = 540;

    //setting the color objects
    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(80, 80, 80);
    Color customBlack = new Color(28, 28, 28);
    Color customOrange = new Color(255, 149, 0);
    
    String[] buttonValues = {
        "AC", "+/-", "%", "÷", 
        "7", "8", "9", "×", 
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };
    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    JFrame frame = new JFrame("Calculator"); //title of the frame
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel(); //We will place our text within the label -> label within panel -> panel within frame
    JPanel buttonsPanel = new JPanel(); //panel for the buttons
    Calculator() { //constructor
        frame.setVisible(true); //visibility set to true
        frame.setSize(boardWidth, boardHeight); //setting the dimension of the frame
        frame.setLocationRelativeTo(null); //window opens in the center
        frame.setResizable(false); //so user cannot resize the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //window closes on clicking the close button (program is terminated)
        frame.setLayout(new BorderLayout()); //so that we can set components N,S,E,W on the window
        
        displayLabel.setBackground(customBlack); //background color
        displayLabel.setForeground(Color.white); //text color
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80)); //setting fornt, <font size, font style, font size>
        displayLabel.setHorizontalAlignment(JLabel.RIGHT); //calculator shows result to the right of the screen
        displayLabel.setText("0"); //default text
        displayLabel.setOpaque(true); //setting opacity of the text
        
        displayPanel.setLayout(new BorderLayout()); //setting the layout of the panel
        displayPanel.add(displayLabel); //adding the label to the panel 
        frame.add(displayPanel, BorderLayout.NORTH); //adding the panel to the frame in the north (top of the frame)
        
    }
}
