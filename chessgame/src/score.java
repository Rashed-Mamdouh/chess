import javax.swing.*;
import java.awt.*;

public class score {

    JFrame frame = new JFrame();
    JLabel player1 = new JLabel("MCarlsen");
    JLabel player2 = new JLabel("GKasparov");
    JLabel player3 = new JLabel("BFischer");
    JLabel player4 = new JLabel("BethHarmon");
    JLabel score1 = new JLabel("1433");
    JLabel score2 = new JLabel("1380");
    JLabel score3 = new JLabel("1130");
    JLabel score4 = new JLabel("900");

    JButton backButton = new JButton("Back");
    public score(){


        frame.setTitle("Chess game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(700,550);
        frame.setVisible(true);
        ImageIcon icon = new ImageIcon("logo.jpg");
        frame.setIconImage(icon.getImage());

        player1.setBounds(295,275,170,100);
        player1.setForeground(Color.white);
        player1.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player1);

        score1.setBounds(303,305,170,100);
        score1.setForeground(Color.white);
        score1.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score1);

        player2.setBounds(140,255,170,100);
        player2.setForeground(Color.white);
        player2.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player2);

        score2.setBounds(160,285,170,100);
        score2.setForeground(Color.white);
        score2.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score2);

        player3.setBounds(445,255,170,100);
        player3.setForeground(Color.white);
        player3.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player3);

        score3.setBounds(455,285,170,100);
        score3.setForeground(Color.white);
        score3.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score3);

        player4.setBounds(110,345,170,100);
        player4.setForeground(Color.white);
        player4.setFont(new Font("Comic Sans US",Font.BOLD,20));
        frame.add(player4);

        score4.setBounds(140,370,170,100);
        score4.setForeground(Color.white);
        score4.setFont(new Font("Comic Sans US",Font.BOLD,25));
        frame.add(score4);

        backButton.setBounds(300,460,75,25);
        backButton.setFont(new Font("Comic sans",Font.BOLD,12));
        backButton.setForeground(Color.white);
        backButton.setBackground(new Color(72,133,174));
        frame.add(backButton);

        ImageIcon background = new ImageIcon("score.png");
        background.setImage(background.getImage().getScaledInstance(700, 550, Image.SCALE_SMOOTH));
        JLabel back = new JLabel(background);
        back.setBounds(0, 0, 700, 550);
        frame.add(back);
        frame.setVisible(true);
    }

}
