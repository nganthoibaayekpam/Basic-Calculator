import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    static JFrame jframe;
    static JTextField jTextField;
    static JPanel jPanel;

    static JButton[] numberButtons= new JButton[10];
    static JButton[] functionButtons= new JButton[7];
    static JButton addButton, subButton, divButton, multiButton, clrButton, delButton, equButton;
    static JButton button1, button2, button3, button4, button5, button6, button7, button8, button9, button0;

    static char operation;
    static double num1;
    static double num2;

    public static void main(String[] args){
        jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.setSize(420, 550);

        jTextField = new JTextField();
        jTextField.setBounds(50, 25, 300, 50);
        jTextField.setEditable(false);

        addButton = new JButton("+");
        subButton = new JButton("-");
        divButton = new JButton("/");
        multiButton = new JButton("x");
        equButton = new JButton("=");
        clrButton = new JButton("AC");
        delButton = new JButton("del");

        functionButtons[0] = addButton;
        addButton.addActionListener(new Calculator());
        functionButtons[1] = subButton;
        subButton.addActionListener(new Calculator());
        functionButtons[2] = multiButton;
        multiButton.addActionListener(new Calculator());
        functionButtons[3] = divButton;
        divButton.addActionListener(new Calculator());
        functionButtons[4] = equButton;
        equButton.addActionListener(new Calculator());
        functionButtons[5] = clrButton;
        clrButton.addActionListener(new Calculator());
        functionButtons[6] = delButton;
        delButton.addActionListener(new Calculator());

        button1 = new JButton("1");
        button1.addActionListener(new Calculator());
        numberButtons[1] = button1;

        button2 = new JButton("2");
        button2.addActionListener(new Calculator());
        numberButtons[2] = button2;

        button3 = new JButton("3");
        button3.addActionListener(new Calculator());
        numberButtons[3] = button3;

        button4 = new JButton("4");
        button4.addActionListener(new Calculator());
        numberButtons[4] = button4;

        button5 = new JButton("5");
        button1.addActionListener(new Calculator());
        numberButtons[5] = button5;

        button6 = new JButton("6");
        button6.addActionListener(new Calculator());
        numberButtons[6] = button6;

        button7 = new JButton("7");
        button7.addActionListener(new Calculator());
        numberButtons[7] = button7;

        button8 = new JButton("8");
        button8.addActionListener(new Calculator());
        numberButtons[8] = button8;

        button9 = new JButton("9");
        button9.addActionListener(new Calculator());
        numberButtons[9] = button9;

        button0 = new JButton("0");
        button0.addActionListener(new Calculator());
        numberButtons[0] = button0;

        delButton.setBounds(50, 430, 145, 50);
        clrButton.setBounds(205, 430, 145, 50);


        jPanel = new JPanel();
        jPanel.setBounds(50, 100, 300, 300);
        jPanel.setLayout(new GridLayout(4, 4, 10, 10));

        for(int i = 1; i<=3; i++){
            jPanel.add(numberButtons[i]);

        }
        jPanel.add(addButton);

        for(int i = 4; i<=6; i++){
            jPanel.add(numberButtons[i]);
        }
        jPanel.add(subButton);

        for(int i = 7; i<=9; i++){
            jPanel.add(numberButtons[i]);
        }
        jPanel.add(multiButton);
        jPanel.add(new JButton());
        jPanel.add(numberButtons[0]);
        jPanel.add(equButton);
        jPanel.add(divButton);

        jframe.add(delButton);
        jframe.add(clrButton);
        jframe.add(jTextField);
        jframe.add(jPanel);
        jframe.setLayout(null);
        jframe.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){

        if(e.getSource()==addButton){
            num1 = Double.parseDouble(jTextField.getText());
            jTextField.setText("");
            operation = '+';
        }
        else if(e.getSource()==subButton){
            num1 = Double.parseDouble(jTextField.getText());
            jTextField.setText("");
            operation = '-';
        }
        else if(e.getSource()==multiButton){
            num1 = Double.parseDouble(jTextField.getText());
            jTextField.setText("");
            operation = '*';
        }
        else if(e.getSource()==divButton){
            jTextField.setText("");
            operation = '/';
        }
        else if(e.getSource()==clrButton){
            jTextField.setText("");
        }
        else if(e.getSource()==delButton){
            String currentText = jTextField.getText();
            jTextField.setText("");
            for(int i = 0; i<currentText.length()-1; i++){
                String currentInnerText = jTextField.getText();
                jTextField.setText(currentInnerText+currentText.charAt(i));
            }
        }
        else if(e.getSource()==equButton){
            num2 = Double.parseDouble(jTextField.getText());

            switch(operation){
                case '+':
                    jTextField.setText(Integer.toString((int)(num1+num2)));
                    break;
                case '-':
                    jTextField.setText(Integer.toString((int)(num1-num2)));
                    break;
                case '*':
                    jTextField.setText(Integer.toString((int)(num1*num2)));
                    break;
                case '/':
                    jTextField.setText(Integer.toString((int)(num1/num2)));
                    break;
                default:
                    break;
            }
        }
        else{
            for(int i = 0; i<10; i++){
                if(e.getSource()==numberButtons[i]){
                    String currentText = jTextField.getText();
                    jTextField.setText(currentText+i);
                }
            }
        }
    }

}