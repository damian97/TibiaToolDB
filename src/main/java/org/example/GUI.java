package org.example;

import javax.swing.*;

public class GUI extends JFrame {

    private final int WIDTH = 400;
    private final int HEIGHT = 300;






    public GUI() {
        super("My Gui");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);


        JTextField item = new JTextField();
        item.setBounds(100, 100, 150, 30);
        add(item);

        JButton button = new JButton("Sprawdz");
        button.setBounds(100, 180, 110, 40);
        add(button);




        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);

    }


}
