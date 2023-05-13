import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class FirstPage extends JFrame implements ActionListener {


    RoundedButton newgamebutton;

    FirstPage() {
        ImageIcon gameicon = new ImageIcon("602719ef-10b9-499d-9268-16a63e67ec8c-removebg-preview.png");
        this.setSize(1280, 1024);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chess Game");
        this.setIconImage(gameicon.getImage());


        ImageIcon background_image = new ImageIcon("background.jpg");
        Image image = background_image.getImage();
        Image temp = image.getScaledInstance(1280, 1024, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 1280, 1024);


        ImageIcon chessimage = new ImageIcon("cheسss.png");
        JLabel chessword = new JLabel("", chessimage, JLabel.CENTER);
        chessword.setBounds(10, -430, 1280, 1024);
        this.add(chessword);

        ImageIcon newgame = new ImageIcon("newgame.png");
        ImageIcon score = new ImageIcon("score.png");
        ImageIcon resume = new ImageIcon("resume.png");
        ImageIcon exit = new ImageIcon("Exit.png");

        RoundedButton Resumegame = new RoundedButton("", resume.getImage());
        Resumegame.setText("Resume Game");
        Resumegame.setBounds(700, 135, 404, 144);
        Resumegame.addActionListener(x -> System.out.println("Resumegame"));//add action


        RoundedButton Score = new RoundedButton("", score.getImage());
        Score.setText("Score");
        Score.setBounds(250, 300, 372, 170);
        Score.addActionListener(x -> System.out.println("Score"));//add action
        Score.doClick();

        RoundedButton Exit = new RoundedButton("", exit.getImage());
        Exit.setBounds(725, 300, 432, 151);

        Exit.addActionListener(x -> this.dispose());//add action

        newgamebutton = new RoundedButton("", newgame.getImage());
        newgamebutton.setText("New Game");
        newgamebutton.setBounds(250, 160, 366, 130);
        newgamebutton.addActionListener(this); //add action



        this.add(newgamebutton);
        this.add(Resumegame);
        this.add(Exit);
        this.add(Score);
        this.add(background);
        this.setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newgamebutton) {
            new SecondPage();
            this.dispose();
        }
    }
}
