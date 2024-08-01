import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI implements ActionListener {

    private JLabel passLabel, passLength, passText;
    private PassGen generator;
    private JFrame frame;
    private JPanel panel;
    private JButton generate, plus, minus, copy;
    private JRadioButton lowercase, uppercase, spChar;

    int SCREEN_HEIGHT;
    int SCREEN_WIDTH;
    public GUI() {

        frame = new JFrame();
        generator = new PassGen();

        SCREEN_HEIGHT = 700;
        SCREEN_WIDTH = 800;
        frame.setSize(SCREEN_WIDTH, SCREEN_HEIGHT);


        plus = new JButton("+");
        plus.setActionCommand("plus");
        plus.addActionListener(this);
        minus = new JButton("-");
        minus.setActionCommand("minus");
        minus.addActionListener(this);
        copy = new JButton("Copy");
        copy.setActionCommand("copy");
        copy.addActionListener(this);
        generate = new JButton("Generate password");
        generate.setActionCommand("generate");
        lowercase = new JRadioButton("Locwercase Chars");
        uppercase = new JRadioButton("Uppercase Chars");
        spChar = new JRadioButton("Special Chars");
        generate.addActionListener(this);

        passLabel = new JLabel("");
        passLength = new JLabel(Integer.toString(generator.watchwordLength));

        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 30, 100));
        panel.setLayout(new GridLayout(7, 2));
        panel.add(new JLabel("Password length"));
        panel.add(plus);
        panel.add(passLength);
        panel.add(minus);
        panel.add(lowercase);
        panel.add(new JLabel("abcd..."));
        panel.add(uppercase);
        panel.add(new JLabel("ABCD..."));
        panel.add(spChar);
        panel.add(new JLabel("+-!%^..."));
        panel.add(generate);
        panel.add(new JLabel("Password:"));
        panel.add(copy);
        panel.add(passLabel);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("PassWord Generator");
        //frame.pack();

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("generate")) {
            String strPool = generator.stringGen(lowercase, uppercase, spChar);
            passLabel.setText(generator.passGen(strPool));
        }
        else if(e.getActionCommand().equals("plus")) {
            passLength.setText(generator.increase());
        }
        else if(e.getActionCommand().equals("minus")) {
            passLength.setText(generator.decrease());
        }
        else if(e.getActionCommand().equals("copy")) {
            StringSelection stringSelection = new StringSelection(passLabel.getText());
            Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
            clpbrd.setContents(stringSelection, null);
        }
    }
}
