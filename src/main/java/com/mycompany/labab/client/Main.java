package com.mycompany.labab.client;

import javax.swing.*;
import java.awt.*;
import java.util.Locale;

public class Main extends JFrame {

    private JFrame frame = new JFrame();
    private JLabel digits = new JLabel("Numbers");
    private JLabel operation = new JLabel("Operation");
    private JComboBox operations = new JComboBox(new String[]{"Add", "Subtract", "Multiply", "Divide", "Power", "Sqrt"});
    private JTextField digit1 = new JTextField();
    private JLabel value = new JLabel();
    private JLabel valueLabel = new JLabel("Result: ");
    private JButton count = new JButton("Count");
    private JTextField digit2 = new JTextField();

    public enum Operations {
        add, subtract, multiply, divide, power, sqrt
    }

    Main() {
        frame.setSize(360, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setTitle("Calculator");
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation((Toolkit.getDefaultToolkit().getScreenSize().width - 320) / 2, (Toolkit.getDefaultToolkit().getScreenSize().height - 340) / 2);

        digits.setSize(100, 20);
        digits.setLocation(20, 20);
        digits.setVisible(true);
        frame.add(digits);

        digit1.setSize(50, 20);
        digit1.setLocation(130, 20);
        digit1.setVisible(true);
        frame.add(digit1);

        digit2.setSize(50, 20);
        digit2.setLocation(190, 20);
        digit2.setVisible(true);
        frame.add(digit2);

        operation.setSize(100, 20);
        operation.setLocation(20, 50);
        operation.setVisible(true);
        frame.add(operation);

        operations.setSize(80, 20);
        operations.setLocation(150, 50);
        operations.setVisible(true);
        frame.add(operations);

        value.setSize(100, 20);
        value.setLocation(130, 80);
        value.setVisible(true);
        frame.add(value);

        valueLabel.setSize(100, 20);
        valueLabel.setLocation(20, 80);
        valueLabel.setVisible(true);
        frame.add(valueLabel);

        count.setSize(200, 40);
        count.setLocation(60, 120);
        count.setVisible(true);
        count.addActionListener(e -> count());
        frame.add(count);
    }

    private void count() {
        try {
            String line = operations.getSelectedItem().toString();
            line = line.toLowerCase();
            Double d1 = Double.parseDouble(digit1.getText());
            Double d2 = Double.parseDouble(digit2.getText());

            String result = HttpService.getResult(d1,d2,Operations.valueOf(line));

            value.setText(result);

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }


    public static void main(String[] args) throws Exception {
        Main main = new Main();
    }
}
