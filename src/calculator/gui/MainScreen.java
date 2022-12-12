package calculator.gui;
/* version: 1
   @author: Tyrien Gilpin
   @Date: December 2022
   Icon Credit: https://www.flaticon.com/free-icons/history- History icons created by joalfa
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainScreen implements ActionListener {
    private JLabel titleLabel;
    private JTextField displayArea, equationArea;
    private JButton oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn;
    private JButton sixBtn, sevenBtn, eightBtn, nineBtn, zeroBtn;
    private JButton plusBtn, minusBtn, multiplyBtn, divideBtn, pointBtn;
    private JButton plusOrMinusBtn, equalBtn, squareBtn, squareRootBtn;
    private JButton clearEntryBtn, clearBtn, percentageBtn, memoryClearBtn;
    private JButton memoryAddBtn, memoryRemoveBtn, memoryBtn, reciprocalBtn, deleteBtn;
    private JPanel mainPanel, memoryPanel;
    private JFrame mainFrame;
    private double results, num;
    private int calculation;

    public MainScreen() {
        initializeComponents();
        addComponentsToPanel();
        setWindowProperties();
        registerListeners();
    }

    //This method initializes all the component of the calculator.
    private void initializeComponents() {
        mainFrame = new JFrame("Calculator");
        mainPanel = new JPanel();
        mainPanel.setSize(340, 540);
        mainPanel.setLayout(null);

        Font labelFont = new Font("Oswald", Font.PLAIN, 16);
        Color btnColour = new Color(255, 255, 255);

        titleLabel = new JLabel("Standard", SwingConstants.LEFT);
        titleLabel.setBounds(25, 0, 120, 40);
        titleLabel.setFont(new Font("Segue", Font.PLAIN, 22));

        displayArea = new JTextField();
        displayArea.setFont(new Font("Oswald", Font.PLAIN, 20));
        displayArea.setBorder(null);
        displayArea.setOpaque(true);
        displayArea.setBackground(null);
        displayArea.setBounds(0, 76, 320, 55);
        displayArea.setHorizontalAlignment(SwingConstants.RIGHT);
        //displayArea.setEnabled(false);

        equationArea = new JTextField();
        equationArea.setFont(labelFont);
        equationArea.setBorder(null);
        equationArea.setOpaque(true);
        equationArea.setBackground(null);
        equationArea.setBounds(0, 40, 320, 35);
        equationArea.setHorizontalAlignment(SwingConstants.RIGHT);
        //equationArea.setEnabled(false);

        oneBtn = new JButton("1");
        oneBtn.setBounds(8, 400, 70, 45);

        twoBtn = new JButton("2");
        twoBtn.setBounds(86, 400, 70, 45);

        threeBtn = new JButton("3");
        threeBtn.setBounds(164, 400, 70, 45);

        fourBtn = new JButton("4");
        fourBtn.setBounds(8, 346, 70, 45);

        fiveBtn = new JButton("5");
        fiveBtn.setBounds(86, 346, 70, 45);

        sixBtn = new JButton("6");
        sixBtn.setBounds(164, 346, 70, 45);

        sevenBtn = new JButton("7");
        sevenBtn.setBounds(8, 292, 70, 45);

        eightBtn = new JButton("8");
        eightBtn.setBounds(86, 292, 70, 45);

        nineBtn = new JButton("9");
        nineBtn.setBounds(164, 292, 70, 45);

        zeroBtn = new JButton("0");
        zeroBtn.setBounds(86, 452, 70, 45);

        squareBtn = new JButton("x²");
        squareBtn.setBounds(86, 240, 70, 45);

        squareRootBtn = new JButton("²√x");
        squareRootBtn.setBounds(164, 240, 70, 45);

        reciprocalBtn = new JButton("1/x");
        reciprocalBtn.setBounds(8, 240, 70, 45);

        plusOrMinusBtn = new JButton("+/-");
        plusOrMinusBtn.setBounds(8, 452, 70, 45);

        pointBtn = new JButton(".");
        pointBtn.setBounds(164, 452, 70, 45);

        equalBtn = new JButton("=");
        equalBtn.setBounds(242, 452, 70, 45);

        plusBtn = new JButton("+");
        plusBtn.setBounds(242, 400, 70, 45);

        minusBtn = new JButton("-");
        minusBtn.setBounds(242, 346, 70, 45);

        multiplyBtn = new JButton("x");
        multiplyBtn.setBounds(242, 292, 70, 45);

        divideBtn = new JButton("÷");
        divideBtn.setBounds(242, 240, 70, 45);

        deleteBtn = new JButton("del");
        deleteBtn.setBounds(242, 188, 70, 45);

        clearBtn = new JButton("C");
        clearBtn.setBounds(164, 188, 70, 45);

        clearEntryBtn = new JButton("CE");
        clearEntryBtn.setBounds(86, 188, 70, 45);

        percentageBtn = new JButton("%");
        percentageBtn.setBounds(8, 188, 70, 45);

        memoryClearBtn = new JButton("MC");
        memoryClearBtn.setBounds(8, 140, 70, 45);

        memoryAddBtn = new JButton("M+");
        memoryAddBtn.setBounds(86, 140, 70, 45);

        memoryRemoveBtn = new JButton("M-");
        memoryRemoveBtn.setBounds(164, 140, 70, 45);

        memoryBtn = new JButton("M↓");
        memoryBtn.setBounds(242, 140, 70, 45);

        JButton[] allButtons = {
                oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn, eightBtn,
                nineBtn, zeroBtn, plusBtn, minusBtn, multiplyBtn, divideBtn, pointBtn,
                plusOrMinusBtn, equalBtn, squareBtn, squareRootBtn, clearEntryBtn, clearBtn,
                percentageBtn, memoryClearBtn, memoryAddBtn, memoryRemoveBtn, memoryBtn,
                reciprocalBtn, deleteBtn
        };
        JButton[] memoryButtons = {
                memoryClearBtn, memoryAddBtn, memoryRemoveBtn, memoryBtn
        };
        for (JButton button : allButtons) {
            button.setFont(labelFont);
            button.setFocusPainted(false);
            button.setBackground(btnColour);
            button.setBorder(null);
        }
        for (JButton button : memoryButtons) {
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);
        }
        equalBtn.setBackground(new Color(232, 126, 12));
    }

    //This method adds each component to a desired position on the  main panel which gets added to the frame.
    private void addComponentsToPanel() {
        mainPanel.add(titleLabel);
        mainPanel.add(equationArea);
        mainPanel.add(displayArea);
        mainPanel.add(oneBtn);
        mainPanel.add(twoBtn);
        mainPanel.add(threeBtn);
        mainPanel.add(fourBtn);
        mainPanel.add(fiveBtn);
        mainPanel.add(sixBtn);
        mainPanel.add(sevenBtn);
        mainPanel.add(eightBtn);
        mainPanel.add(nineBtn);
        mainPanel.add(zeroBtn);
        mainPanel.add(squareRootBtn);
        mainPanel.add(reciprocalBtn);
        mainPanel.add(squareBtn);
        mainPanel.add(pointBtn);
        mainPanel.add(plusBtn);
        mainPanel.add(minusBtn);
        mainPanel.add(plusOrMinusBtn);
        mainPanel.add(multiplyBtn);
        mainPanel.add(divideBtn);
        mainPanel.add(equalBtn);
        mainPanel.add(clearBtn);
        mainPanel.add(clearEntryBtn);
        mainPanel.add(percentageBtn);
        mainPanel.add(deleteBtn);
        mainPanel.add(memoryAddBtn);
        mainPanel.add(memoryClearBtn);
        mainPanel.add(memoryRemoveBtn);
        mainPanel.add(memoryBtn);

    }

    //Setting properties of JFrame window
    private void setWindowProperties() {
        mainFrame.add(mainPanel);
        mainFrame.setLayout(null);
        mainFrame.setSize(new Dimension(340, 540));
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Registering action listeners to each button
    private void registerListeners() {
        oneBtn.addActionListener(this);
        twoBtn.addActionListener(this);
        threeBtn.addActionListener(this);
        fourBtn.addActionListener(this);
        fiveBtn.addActionListener(this);
        sixBtn.addActionListener(this);
        sevenBtn.addActionListener(this);
        eightBtn.addActionListener(this);
        nineBtn.addActionListener(this);
        zeroBtn.addActionListener(this);
        plusBtn.addActionListener(this);
        minusBtn.addActionListener(this);
        multiplyBtn.addActionListener(this);
        divideBtn.addActionListener(this);
        pointBtn.addActionListener(this);
        plusOrMinusBtn.addActionListener(this);
        equalBtn.addActionListener(this);
        squareBtn.addActionListener(this);
        squareRootBtn.addActionListener(this);
        clearEntryBtn.addActionListener(this);
        clearBtn.addActionListener(this);
        percentageBtn.addActionListener(this);
        memoryClearBtn.addActionListener(this);
        memoryAddBtn.addActionListener(this);
        memoryRemoveBtn.addActionListener(this);
        memoryBtn.addActionListener(this);
        reciprocalBtn.addActionListener(this);
        deleteBtn.addActionListener(this);
    }

    //This method determines which operation should take place and computes the equation it
    private void operation() {
        switch (calculation) {
            case 1 -> {//Addition
                results = num + Double.parseDouble(displayArea.getText());
                equationArea.setText(num + " + " + displayArea.getText() + " = ");
                displayArea.setText(Double.toString(results));
            }
            case 2 -> {//Subtraction
                results = num - Double.parseDouble(displayArea.getText());
                equationArea.setText(num + " - " + displayArea.getText() + " = ");
                displayArea.setText(Double.toString(results));
            }
            case 3 -> { //Multiplication
                results = num * Double.parseDouble(displayArea.getText());
                equationArea.setText(num + " x " + displayArea.getText() + " = ");
                displayArea.setText(Double.toString(results));
            }
            case 4 -> { //Division
                equationArea.setText(num + " ÷ " + displayArea.getText() + " = ");
                if (Double.parseDouble(displayArea.getText()) == 0 || Double.parseDouble(displayArea.getText()) == 0.0) {
                    displayArea.setText("Cannot divide by zero");
                    results = 0;
                    num = 0;
                    errorDisable();
                } else {
                    results = num / Double.parseDouble(displayArea.getText());
                    displayArea.setText(Double.toString(results));
                }
            }
        }
    }

    //This method disables certain buttons when a math error occurs
    private void errorDisable() {
        plusBtn.setEnabled(false);
        minusBtn.setEnabled(false);
        multiplyBtn.setEnabled(false);
        divideBtn.setEnabled(false);
        pointBtn.setEnabled(false);
        plusOrMinusBtn.setEnabled(false);
        equalBtn.setEnabled(false);
        squareBtn.setEnabled(false);
        squareRootBtn.setEnabled(false);
        percentageBtn.setEnabled(false);
        memoryClearBtn.setEnabled(false);
        memoryAddBtn.setEnabled(false);
        memoryRemoveBtn.setEnabled(false);
        memoryBtn.setEnabled(false);
        reciprocalBtn.setEnabled(false);
    }

    //This method enables certain buttons when a math error occurs
    private void errorEnable() {
        plusBtn.setEnabled(true);
        minusBtn.setEnabled(true);
        multiplyBtn.setEnabled(true);
        divideBtn.setEnabled(true);
        pointBtn.setEnabled(true);
        plusOrMinusBtn.setEnabled(true);
        equalBtn.setEnabled(true);
        squareBtn.setEnabled(true);
        squareRootBtn.setEnabled(true);
        percentageBtn.setEnabled(true);
        memoryClearBtn.setEnabled(true);
        memoryAddBtn.setEnabled(true);
        memoryRemoveBtn.setEnabled(true);
        memoryBtn.setEnabled(true);
        reciprocalBtn.setEnabled(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value, equation = "";
        if (e.getSource() == oneBtn) {
            if (displayArea.getText().length() <= 28) {//this ensures the values stay within the bounds of the display
                value = "1";
                try {
                    if (!displayArea.getText().equals("") && num != Double.parseDouble(displayArea.getText())) {
                        value = displayArea.getText() + "1";
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Bad read due to division by zero or other math error");
                    equationArea.setText("");
                }
                displayArea.setText(value);
                errorEnable();
            }
        }
        if (e.getSource() == twoBtn) {
            if (displayArea.getText().length() <= 28) {//this ensures the values stay within the bounds of the display
                value = "2";
                try {
                    if (!displayArea.getText().equals("") && num != Double.parseDouble(displayArea.getText())) {
                        value = displayArea.getText() + "2";
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Bad read due to division by zero or other math error");
                    equationArea.setText("");
                }
                displayArea.setText(value);
                errorEnable();
            }
        }
        if (e.getSource() == threeBtn) {
            if (displayArea.getText().length() <= 28) {//this ensures the values stay within the bounds of the display
                value = "3";
                try {
                    if (!displayArea.getText().equals("") && num != Double.parseDouble(displayArea.getText())) {
                        value = displayArea.getText() + "3";
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Bad read due to division by zero or other math error");
                    equationArea.setText("");
                }
                displayArea.setText(value);
                errorEnable();
            }
        }
        if (e.getSource() == fourBtn) {
            if (displayArea.getText().length() <= 28) {//this ensures the values stay within the bounds of the display
                value = "4";
                try {
                    if (!displayArea.getText().equals("") && num != Double.parseDouble(displayArea.getText())) {
                        value = displayArea.getText() + "4";
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Bad read due to division by zero or other math error");
                    equationArea.setText("");
                }
                displayArea.setText(value);
                errorEnable();
            }
        }
        if (e.getSource() == fiveBtn) {
            if (displayArea.getText().length() <= 28) {//this ensures the values stay within the bounds of the display
                value = "5";
                try {
                    if (!displayArea.getText().equals("") && num != Double.parseDouble(displayArea.getText())) {
                        value = displayArea.getText() + "5";
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Bad read due to division by zero or other math error");
                    equationArea.setText("");
                }
                displayArea.setText(value);
                errorEnable();
            }
        }
        if (e.getSource() == sixBtn) {
            if (displayArea.getText().length() <= 28) {//this ensures the values stay within the bounds of the display
                value = "6";
                try {
                    if (!displayArea.getText().equals("") && num != Double.parseDouble(displayArea.getText())) {
                        value = displayArea.getText() + "6";
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Bad read due to division by zero or other math error");
                    equationArea.setText("");
                }
                displayArea.setText(value);
                errorEnable();
            }
        }
        if (e.getSource() == sevenBtn) {
            if (displayArea.getText().length() <= 28) {//this ensures the values stay within the bounds of the display
                value = "7";
                try {
                    if (!displayArea.getText().equals("") && num != Double.parseDouble(displayArea.getText())) {
                        value = displayArea.getText() + "7";
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Bad read due to division by zero or other math error");
                    equationArea.setText("");
                }
                displayArea.setText(value);
                errorEnable();
            }
        }
        if (e.getSource() == eightBtn) {
            if (displayArea.getText().length() <= 28) {//this ensures the values stay within the bounds of the display
                value = "8";
                try {
                    if (!displayArea.getText().equals("") && num != Double.parseDouble(displayArea.getText())) {
                        value = displayArea.getText() + "8";
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Bad read due to division by zero or other math error");
                    equationArea.setText("");
                }
                displayArea.setText(value);
                errorEnable();
            }
        }
        if (e.getSource() == nineBtn) {
            if (displayArea.getText().length() <= 28) {//this ensures the values stay within the bounds of the display
                value = "9";
                try {
                    if (!displayArea.getText().equals("") && num != Double.parseDouble(displayArea.getText())) {
                        value = displayArea.getText() + "9";
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Bad read due to division by zero or other math error");
                    equationArea.setText("");
                }
                displayArea.setText(value);
                errorEnable();
            }
        }
        if (e.getSource() == zeroBtn) {
            if (displayArea.getText().length() <= 28) {//this ensures the values stay within the bounds of the display
                value = "0";
                try {
                    if (!displayArea.getText().equals("") && num != Double.parseDouble(displayArea.getText())) {
                        value = displayArea.getText() + "0";
                    }
                } catch (NumberFormatException ex) {
                    System.out.println("Bad read due to division by zero or other math error");
                    equationArea.setText("");
                }
                displayArea.setText(value);
                errorEnable();
            }
        }
        if (e.getSource() == plusOrMinusBtn) {
            value = displayArea.getText();
            if (value.charAt(0) != '-') {
                value = "-" + value;
            } else {
                value = value.substring(1);
            }
            displayArea.setText(value);
        }
        if (e.getSource() == minusBtn) {
            if (equationArea.getText().contains("=")) {//if a calculation was already done
                equationArea.setText(Double.toString(results));
            }
            if (equationArea.getText().equals("")) {//if the equation display is clear
                equation = displayArea.getText() + " - ";
            } else {
                equation += displayArea.getText() + " - ";
            }
            num = Double.parseDouble(displayArea.getText());
            calculation = 2;
            equationArea.setText(equation);
        }
        if (e.getSource() == multiplyBtn) {
            if (equationArea.getText().contains("=")) {
                equationArea.setText(Double.toString(results));
            }
            if (equationArea.getText().equals("")) {
                equation = displayArea.getText() + " x ";
            } else {
                equation += displayArea.getText() + " x ";
            }
            num = Double.parseDouble(displayArea.getText());
            calculation = 3;
            equationArea.setText(equation);
        }
        if (e.getSource() == plusBtn) {
            if (equationArea.getText().contains("=")) {
                equationArea.setText(Double.toString(results));
            }
            if (equationArea.getText().equals("")) {
                equation = displayArea.getText() + " + ";
            } else {
                equation += displayArea.getText() + " + ";
            }
            num = Double.parseDouble(displayArea.getText());
            calculation = 1;
            equationArea.setText(equation);
        }
        if (e.getSource() == divideBtn) {
            if (equationArea.getText().contains("=")) {
                equationArea.setText(Double.toString(results));
            }
            if (equationArea.getText().equals("")) {
                equation = displayArea.getText() + " ÷ ";
            } else {
                equation += displayArea.getText() + " ÷ ";
            }
            num = Double.parseDouble(displayArea.getText());
            calculation = 4;
            equationArea.setText(equation);
        }
        if (e.getSource() == pointBtn) {
            value = displayArea.getText();
            if (!value.contains(".")) {
                if (value.equals("")) {//if display area is empty and a decimal point is added
                    value += "0";//insert a zero in front of decimal point
                }
                value += ".";
                displayArea.setText(value);
            }
        }
        if (e.getSource() == equalBtn) {
            operation();
        }
        if (e.getSource() == clearBtn) {
            displayArea.setText("");
            equationArea.setText("");
        }
        if (e.getSource() == clearEntryBtn) {
            displayArea.setText("");
        }
        if (e.getSource() == reciprocalBtn) {
            value = displayArea.getText();
            try {
                if (!value.equals("") && !value.equals(".") && Double.parseDouble(displayArea.getText()) != 0) {
                    equationArea.setText("1/(" + Float.valueOf(value) + ")");
                    displayArea.setText(String.valueOf(1 / Double.parseDouble(value)));
                }
            } catch (NumberFormatException ex) {
                System.out.println("Bad read due to division by zero or other math error");
                equationArea.setText("");
                displayArea.setText("cannot divide by zero");
                errorDisable();
            }
        }
        if (e.getSource() == squareBtn) {
            value = displayArea.getText();
            if (!value.equals("") && !value.equals(".")) {
                equationArea.setText("sqr(" + value + ")");
                displayArea.setText(String.valueOf(Math.pow(Float.parseFloat(value), 2)));
            }
        }
        if (e.getSource() == squareRootBtn) {
            value = displayArea.getText();
            if (!value.equals("") && !value.equals(".")) {
                equationArea.setText("√(" + value + ")");
                displayArea.setText(String.valueOf(Math.sqrt(Float.parseFloat(value))));
            }
        }
        if (e.getSource() == deleteBtn) {
            value = displayArea.getText();
            if (value.length() >= 1) {
                value = value.substring(0, value.length() - 1);
            }
            displayArea.setText(value);
        }
        if (e.getSource() == percentageBtn) {
            if (equationArea.getText().contains("+") || equationArea.getText().contains("-")
                    || equationArea.getText().contains("÷") || equationArea.getText().contains("x")) {
                displayArea.setText(Double.toString(num * (num / 100)));
            }
        }
        if (e.getSource() == memoryAddBtn) {

        }
        if (e.getSource() == memoryRemoveBtn) {

        }
        if (e.getSource() == memoryClearBtn) {

        }
    }
}
