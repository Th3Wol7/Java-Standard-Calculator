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
    private JLabel  titleLabel;
    private JTextField  displayArea, equationArea;
    private JButton oneBtn, twoBtn, threeBtn, fourBtn;
    private JButton fiveBtn, sixBtn, sevenBtn, eightBtn;
    private JButton nineBtn, zeroBtn, plusBtn, minusBtn;
    private JButton multiplyBtn, divideBtn, pointBtn;
    private JButton plusOrMinusBtn, equalBtn, squareBtn, squareRootBtn;
    private JButton clearEntryBtn, clearBtn, percentageBtn, memoryClearBtn;
    private JButton memoryAddBtn, memoryRemoveBtn, memoryBtn, reciprocalBtn, deleteBtn;
    private JPanel mainPanel, memoryPanel;
    private JFrame mainFrame;
    private double results, num, prev;
    private int calculation;

    public MainScreen() {
        initializeComponents();
        addComponentsToPanel();
        setWindowProperties();
        registerListeners();
    }

    //This method initializes all the component of the calculator and
    //add them to the panel which gets added to the frame.
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

        equationArea = new JTextField();
        equationArea.setFont(labelFont);
        equationArea.setBorder(null);
        equationArea.setOpaque(true);
        equationArea.setBackground(null);
        equationArea.setBounds(0, 40, 320, 35);
        equationArea.setHorizontalAlignment(SwingConstants.RIGHT);

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
                oneBtn, twoBtn, threeBtn, fourBtn, fiveBtn, sixBtn, sevenBtn,
                eightBtn, nineBtn, zeroBtn, plusBtn, minusBtn, multiplyBtn,
                divideBtn, pointBtn, plusOrMinusBtn, equalBtn, squareBtn, squareRootBtn,
                clearEntryBtn, clearBtn, percentageBtn, memoryClearBtn, memoryAddBtn,
                memoryRemoveBtn, memoryBtn, reciprocalBtn, deleteBtn
        };
        JButton[] memoryButtons = {
                memoryClearBtn, memoryAddBtn,
                memoryRemoveBtn, memoryBtn
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

    //This method determines which operation should take place
    private void operation(){
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
                results = num / Double.parseDouble(displayArea.getText());
                equationArea.setText(num + " ÷ " + displayArea.getText() + " = ");
                displayArea.setText(Double.toString(results));
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String value, equation = "";
        boolean check1 = false;

        if (e.getSource() == oneBtn) {
            if (displayArea.getText().length() <= 28) {
                value = displayArea.getText() + "1";
                displayArea.setText(value);
            }
        }
        if (e.getSource() == twoBtn) {
            if (displayArea.getText().length() <= 28) {
                value = displayArea.getText() + "2";
                displayArea.setText(value);
            }
        }
        if (e.getSource() == threeBtn) {
            if (displayArea.getText().length() <= 28) {
                value = displayArea.getText() + "3";
                displayArea.setText(value);
            }
        }
        if (e.getSource() == fourBtn) {
            if (displayArea.getText().length() <= 28) {
                value = displayArea.getText() + "4";
                displayArea.setText(value);
            }
        }
        if (e.getSource() == fiveBtn) {
            if (displayArea.getText().length() <= 28) {
                value = displayArea.getText() + "5";
                displayArea.setText(value);
            }
        }
        if (e.getSource() == sixBtn) {
            if (displayArea.getText().length() <= 28) {
                value = displayArea.getText() + "6";
                displayArea.setText(value);
            }
        }
        if (e.getSource() == sevenBtn) {
            if (displayArea.getText().length() <= 28) {
                value = displayArea.getText() + "7";
                displayArea.setText(value);
            }
        }
        if (e.getSource() == eightBtn) {
            if (displayArea.getText().length() <= 28) {
                value = displayArea.getText() + "8";
                displayArea.setText(value);
            }
        }
        if (e.getSource() == nineBtn) {
            if (displayArea.getText().length() <= 28) {
                value = displayArea.getText() + "9";
                displayArea.setText(value);
            }
        }
        if (e.getSource() == zeroBtn) {
            if (displayArea.getText().length() <= 28) {
                value = displayArea.getText() + "0";
                displayArea.setText(value);
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
            if(equationArea.getText().contains("=")){
                equationArea.setText(Double.toString(results));
            }
            if(equationArea.getText().equals("")) {
                equation = displayArea.getText() + " - ";
            }else{
                equation += displayArea.getText() + " - ";
            }
            num = Double.parseDouble(displayArea.getText());
            calculation = 2;
            equationArea.setText(equation);
        }
        if (e.getSource() == multiplyBtn) {
            if(equationArea.getText().contains("=")){
                equationArea.setText(Double.toString(results));
            }
            if(equationArea.getText().equals("")) {
                equation = displayArea.getText() + " x ";
            }else{
                equation += displayArea.getText() + " x ";
            }
            num = Double.parseDouble(displayArea.getText());
            calculation = 3;
            equationArea.setText(equation);
        }
        if (e.getSource() == plusBtn) {
            if(equationArea.getText().contains("=")){
                equationArea.setText(Double.toString(results));
            }
            if(equationArea.getText().equals("")) {
                equation = displayArea.getText() + " + ";
            }else{
                equation += displayArea.getText() + " + ";
            }
            num = Double.parseDouble(displayArea.getText());
            calculation = 1;
            equationArea.setText(equation);
        }
        if (e.getSource() == divideBtn) {
            if(equationArea.getText().contains("=")){
                equationArea.setText(Double.toString(results));
            }
            if(equationArea.getText().equals("")) {
                equation = displayArea.getText() + " ÷ ";
            }else{
                equation += displayArea.getText() + " ÷ ";
            }
            num = Double.parseDouble(displayArea.getText());
            calculation = 4;
            equationArea.setText(equation);
        }
        if (e.getSource() == pointBtn) {
            value = displayArea.getText();
            if (!value.contains(".")) {
                if (value.equals("")) {
                    value += "0";
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
            if (!value.equals("") && !value.equals(".")) {
                equationArea.setText("1/(" + Float.valueOf(value) + ")");
                displayArea.setText(String.valueOf(1 / Double.parseDouble(value)));
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
            if(equationArea.getText().contains("+") || equationArea.getText().contains("-")
            ||equationArea.getText().contains("÷") || equationArea.getText().contains("x") ) {
                displayArea.setText(Double.toString(num*(num/100)));
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

/*
 private void initializeComponents() {
        mainFrame = new JFrame("Calculator");
        gbc = new GridBagConstraints();
        mainPanel = new JPanel();
        mainPanel.setSize(340, 540);

        Font labelFont = new Font("Oswald", Font.PLAIN, 13);
        Color btnColour = new Color(255, 255, 255);
        Dimension btnDimension = new Dimension(75, 50);

        titleLabel = new JLabel("Standard", SwingConstants.CENTER);
        titleLabel.setBounds(20, 20, 30, 40);

        displayArea = new JTextArea();
        displayArea.setFont(labelFont);
        displayArea.setBackground(btnColour);

        oneBtn = new JButton("1");
        oneBtn.setFont(labelFont);
        oneBtn.setFocusPainted(false);
        oneBtn.setBackground(btnColour);
        oneBtn.setBorder(null);
        oneBtn.setPreferredSize(btnDimension);
        titleLabel.setBounds(20, 20, 30, 40);




        twoBtn = new JButton("2");
        twoBtn.setFont(labelFont);
        twoBtn.setFocusPainted(false);
        twoBtn.setBackground(btnColour);
        twoBtn.setBorder(null);
        twoBtn.setPreferredSize(btnDimension);

        threeBtn = new JButton("3");
        threeBtn.setFont(labelFont);
        threeBtn.setFocusPainted(false);
        threeBtn.setBackground(btnColour);
        threeBtn.setBorder(null);
        threeBtn.setPreferredSize(btnDimension);


        fourBtn = new JButton("4");
        fourBtn.setFont(labelFont);
        fourBtn.setFocusPainted(false);
        fourBtn.setBackground(btnColour);
        fourBtn.setBorder(null);
        fourBtn.setPreferredSize(btnDimension);


        fiveBtn = new JButton("5");
        fiveBtn.setFont(labelFont);
        fiveBtn.setFocusPainted(false);
        fiveBtn.setBackground(btnColour);
        fiveBtn.setBorder(null);
        fiveBtn.setPreferredSize(btnDimension);


        sixBtn = new JButton("6");
        sixBtn.setFont(labelFont);
        sixBtn.setFocusPainted(false);
        sixBtn.setBackground(btnColour);
        sixBtn.setBorder(null);
        sixBtn.setPreferredSize(btnDimension);


        sevenBtn = new JButton("7");
        sevenBtn.setFont(labelFont);
        sevenBtn.setFocusPainted(false);
        sevenBtn.setBackground(btnColour);
        sevenBtn.setBorder(null);
        sevenBtn.setPreferredSize(btnDimension);

        eightBtn = new JButton("8");
        eightBtn.setFont(labelFont);
        eightBtn.setFocusPainted(false);
        eightBtn.setBackground(btnColour);
        eightBtn.setBorder(null);
        eightBtn.setPreferredSize(btnDimension);


        nineBtn = new JButton("9");
        nineBtn.setFont(labelFont);
        nineBtn.setFocusPainted(false);
        nineBtn.setBackground(btnColour);
        nineBtn.setBorder(null);
        nineBtn.setPreferredSize(btnDimension);

        zeroBtn = new JButton("0");
        zeroBtn.setFont(labelFont);
        zeroBtn.setFocusPainted(false);
        zeroBtn.setBackground(btnColour);
        zeroBtn.setBorder(null);
        zeroBtn.setPreferredSize(btnDimension);


        squareBtn = new JButton("x²");
        squareBtn.setFont(labelFont);
        squareBtn.setFocusPainted(false);
        squareBtn.setBackground(btnColour);
        squareBtn.setBorder(null);
        squareBtn.setPreferredSize(btnDimension);


        squareRootBtn = new JButton("²√x");
        squareRootBtn.setFont(labelFont);
        squareRootBtn.setFocusPainted(false);
        squareRootBtn.setBackground(btnColour);
        squareRootBtn.setBorder(null);
        squareRootBtn.setPreferredSize(btnDimension);

        reciprocalBtn = new JButton("1/x");
        reciprocalBtn.setFont(labelFont);
        reciprocalBtn.setFocusPainted(false);
        reciprocalBtn.setBackground(btnColour);
        reciprocalBtn.setBorder(null);
        reciprocalBtn.setPreferredSize(btnDimension);

        plusOrMinusBtn = new JButton("+/-");
        plusOrMinusBtn.setFont(labelFont);
        plusOrMinusBtn.setFocusPainted(false);
        plusOrMinusBtn.setBackground(btnColour);
        plusOrMinusBtn.setBorder(null);
        plusOrMinusBtn.setPreferredSize(btnDimension);

        pointBtn = new JButton(".");
        pointBtn.setFont(labelFont);
        pointBtn.setFocusPainted(false);
        pointBtn.setBackground(btnColour);
        pointBtn.setBorder(null);
        pointBtn.setPreferredSize(btnDimension);

        equalBtn = new JButton("=");
        equalBtn.setFont(labelFont);
        equalBtn.setFocusPainted(false);
        equalBtn.setBackground(new Color(232, 126, 12));
        equalBtn.setBorder(null);
        equalBtn.setPreferredSize(btnDimension);


        plusBtn = new JButton("+");
        plusBtn.setFont(labelFont);
        plusBtn.setFocusPainted(false);
        plusBtn.setBackground(btnColour);
        plusBtn.setBorder(null);
        plusBtn.setPreferredSize(btnDimension);


        minusBtn = new JButton("-");
        minusBtn.setFont(labelFont);
        minusBtn.setFocusPainted(false);
        minusBtn.setBackground(btnColour);
        minusBtn.setBorder(null);
        minusBtn.setPreferredSize(btnDimension);


        multiplyBtn = new JButton("x");
        multiplyBtn.setFont(labelFont);
        multiplyBtn.setFocusPainted(false);
        multiplyBtn.setBackground(btnColour);
        multiplyBtn.setBorder(null);
        multiplyBtn.setPreferredSize(btnDimension);


        divideBtn = new JButton("÷");
        divideBtn.setFont(labelFont);
        divideBtn.setFocusPainted(false);
        divideBtn.setBackground(btnColour);
        divideBtn.setBorder(null);
        displayArea.setPreferredSize(btnDimension);


        deleteBtn = new JButton("del");
        deleteBtn.setFont(labelFont);
        deleteBtn.setFocusPainted(false);
        deleteBtn.setBackground(btnColour);
        deleteBtn.setBorder(null);
        deleteBtn.setPreferredSize(btnDimension);


        clearBtn = new JButton("C");
        clearBtn.setFont(labelFont);
        clearBtn.setFocusPainted(false);
        clearBtn.setBackground(btnColour);
        clearBtn.setBorder(null);
        clearBtn.setPreferredSize(btnDimension);


        clearEntryBtn = new JButton("CE");
        clearEntryBtn.setFont(labelFont);
        clearEntryBtn.setFocusPainted(false);
        clearEntryBtn.setBackground(btnColour);
        clearEntryBtn.setBorder(null);
        clearEntryBtn.setPreferredSize(btnDimension);

        percentageBtn = new JButton("%");
        percentageBtn.setFont(labelFont);
        percentageBtn.setFocusPainted(false);
        percentageBtn.setBackground(btnColour);
        percentageBtn.setBorder(null);
        percentageBtn.setPreferredSize(btnDimension);

        memoryClearBtn = new JButton("MC");
        memoryClearBtn.setFont(labelFont);
        memoryClearBtn.setFocusPainted(false);
        memoryClearBtn.setBackground(btnColour);
        memoryClearBtn.setBorder(null);
        memoryClearBtn.setPreferredSize(btnDimension);

        memoryAddBtn = new JButton("M+");
        memoryAddBtn.setFont(labelFont);
        memoryAddBtn.setFocusPainted(false);
        memoryAddBtn.setBackground(btnColour);
        memoryAddBtn.setBorder(null);
        memoryAddBtn.setPreferredSize(btnDimension);

        memoryRemoveBtn = new JButton("M-");
        memoryRemoveBtn.setFont(labelFont);
        memoryRemoveBtn.setFocusPainted(false);
        memoryRemoveBtn.setBackground(btnColour);
        memoryRemoveBtn.setBorder(null);
        memoryRemoveBtn.setPreferredSize(btnDimension);

        memoryBtn = new JButton("M↓");
        memoryBtn.setFont(labelFont);
        memoryBtn.setFocusPainted(false);
        memoryBtn.setBackground(btnColour);
        memoryBtn.setBorder(null);
        memoryBtn.setPreferredSize(btnDimension);
    }

 */