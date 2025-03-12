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
        
        buttonsPanel.setLayout(new GridLayout(5,4)); //setting up grid layout for the buttons
        buttonsPanel.setBackground(customBlack); //background color of the buttons
        frame.add(buttonsPanel); //adding the buttons to the frame

        //setting up the buttons
        for (int i = 0; i < buttonValues.length; i++) {
            JButton button = new JButton();
            String buttonValue = buttonValues[i];
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue); //setting the inner text of the button
            button.setFocusable(false); //making it so that a focus box doesnt appear on the button text
            button.setBorder(new LineBorder(customBlack));
            //setting up different colors for different types of buttons
            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setBackground(customLightGray);
                button.setForeground(customBlack);
            }
            else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                button.setBackground(customOrange);
                button.setForeground(Color.white);
            }
            else {
                button.setBackground(customDarkGray);
                button.setForeground(Color.white);
            }

            buttonsPanel.add(button); //adding button to the frame

            button.addActionListener(new ActionListener() { //listening for action in the buttons
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource(); //getting the source of the action, i.e where the button was clicked
                    String buttonValue = button.getText(); //getting the text of the button clicked
                    if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                        
                    }
                    else if (Arrays.asList(topSymbols).contains(buttonValue)) {
                       
                    }
                    else { //for digits or decimal
                        if (buttonValue == ".") {
                            if(!displayLabel.getText().contains(buttonValue)) {
                                displayLabel.setText(displayLabel.getText() + buttonValue); 
                            }

                        }
                        else if ("0123456789".contains(buttonValue)) {
                            if (displayLabel.getText() == "0") { //if in initial stage i.e 0, we remove 0 and show the number that is clicked
                                displayLabel.setText(buttonValue);
                            }
                            else {
                                displayLabel.setText(displayLabel.getText() + buttonValue);
                            }
                        }
                    }

                }
            });
        }
    }
}
