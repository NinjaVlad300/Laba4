package com.company;

import com.company.bdclass.DBBuilder;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws IOException {

        JFrame frame = new JFrame();
        frame.setContentPane(new NewGUI().getJPanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(300,150,500,550);
        frame.setVisible(true);
    }
}

