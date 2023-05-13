package main;

import main.Board;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
JFrame frame =new JFrame();
frame.getContentPane().setBackground(Color.BLACK);
frame.setLayout(new GridBagLayout());
frame.setMinimumSize(new Dimension(1000,1000));
frame.setLocationRelativeTo(null);
frame.setVisible(true);
Board board =new Board();
frame.add(board);

    }
}
