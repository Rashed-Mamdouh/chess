import main.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondPage extends JFrame implements ActionListener {
    RoundedButton whitebutton1;
    RoundedButton blackbutton1;
    RoundedButton whitebutton2;
    RoundedButton blackbutton2;
    RoundedButton startGame;
    SecondPage(){
        this.setSize(1280,1024);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Chess Game");

        ImageIcon background_image=new ImageIcon("New Project.png");
        JLabel background=new JLabel("",background_image,JLabel.CENTER);
        background.setBounds(0,0,1280,1024);



        JLabel player1=new JLabel("Player 1",JLabel.CENTER);
        player1.setFont(new Font("",Font.BOLD,40));
        player1.setForeground(Color.white);
        player1.setBounds(370,-470,500,1024);
        this.add(player1);


        JLabel name1=new JLabel("Name : ",JLabel.CENTER);
        name1.setFont(new Font("",Font.BOLD,40));
        name1.setForeground(Color.white);
        name1.setBounds(80,-390,500,1024);
        this.add(name1);

        JLabel playAs1=new JLabel("Play as : ",JLabel.CENTER);
        playAs1.setFont(new Font("",Font.BOLD,40));
        playAs1.setForeground(Color.white);
        playAs1.setBounds(80,-290,500,1024);
        this.add(playAs1);


        JLabel name2=new JLabel("Name : ",JLabel.CENTER);
        name2.setFont(new Font("",Font.BOLD,40));
        name2.setForeground(Color.white);
        name2.setBounds(80,-90,500,1024);
        this.add(name2);

        JLabel playAs2=new JLabel("Play as : ",JLabel.CENTER);
        playAs2.setFont(new Font("",Font.BOLD,40));
        playAs2.setForeground(Color.white);
        playAs2.setBounds(80,30,500,1024);
        this.add(playAs2);

        JLabel timer=new JLabel("Set timer : ",JLabel.CENTER);
        timer.setFont(new Font("",Font.BOLD,38));
        timer.setForeground(Color.white);
        timer.setBounds(80,138,500,1024);
        this.add(timer);




        ImageIcon white=new ImageIcon("whiteking2.png");
        ImageIcon black=new ImageIcon("blackKing.png");
        ImageIcon startgameimg=new ImageIcon("startgame.png");


        whitebutton1=new RoundedButton("",white.getImage());
        whitebutton1.setText("");
        whitebutton1.setBounds(620, 175, 132, 100);
        whitebutton1.addActionListener(this);
        this.add(whitebutton1);


        blackbutton1=new RoundedButton("",black.getImage());
        blackbutton1.setText("");
        blackbutton1.setBounds(480, 180, 213, 126);
        blackbutton1.addActionListener(this);
        this.add(blackbutton1);

        whitebutton2=new RoundedButton("",white.getImage());
        whitebutton2.setText("");
        whitebutton2.setBounds(620, 500, 135, 100);
        whitebutton2.addActionListener(this);
        this.add(whitebutton2);

        blackbutton2=new RoundedButton("",black.getImage());
        blackbutton2.setText("");
        blackbutton2.setBounds(480, 500, 213, 126);
        blackbutton2.addActionListener(this);
        this.add(blackbutton2);


        startGame=new RoundedButton("",startgameimg.getImage());
        startGame.setBounds(840, 76, 200, 91);
        startGame.addActionListener(this);
        this.add(startGame);

        RoundedTextField firstplayer=new RoundedTextField(1);
        firstplayer.setBounds(500,100,250,50);
        firstplayer.setFont(new Font("",Font.BOLD,20));
        firstplayer.setForeground(Color.black);
        firstplayer.setBackground(Color.white);
        firstplayer.setCaretColor(Color.black);
        this.add(firstplayer);

        RoundedTextField secondplayer=new RoundedTextField(1);
        secondplayer.setBounds(500,390,250,50);
        secondplayer.setFont(new Font("",Font.BOLD,20));
        secondplayer.setForeground(Color.black);
        secondplayer.setBackground(Color.white);
        secondplayer.setCaretColor(Color.black);

        this.add(secondplayer);

        RoundedTextField setTimer=new RoundedTextField(1);
        setTimer.setBounds(500,630,250,50);
        setTimer.setFont(new Font("",Font.BOLD,20));
        setTimer.setForeground(Color.black);
        setTimer.setBackground(Color.white);
        setTimer.setCaretColor(Color.black);

        this.add(setTimer);

        JLabel player2=new JLabel("Player 2",JLabel.CENTER);
        player2.setFont(new Font("",Font.BOLD,40));
        player2.setForeground(Color.white);
        player2.setBounds(370,-185,500,1024);
        this.add(player2);

        ImageIcon bottomimage= new ImageIcon("secondpage.png");
        JLabel bottom=new JLabel("",bottomimage,JLabel.CENTER);
        bottom.setBounds(330,660,500,300);
        this.add(bottom);

        this.add(background);
        this.setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==blackbutton1){

            System.out.println("first player is black");
            System.out.println("second player is white");

        }
         if(e.getSource()==whitebutton1){

            System.out.println("first player is white");
            System.out.println("second player is black");

        }
         if(e.getSource()==blackbutton2){

            System.out.println("first player is white");
            System.out.println("second player is black");

        }
         if(e.getSource()==whitebutton2){

            System.out.println("first player is black");
            System.out.println("second player is white");

        }
         if(e.getSource()==startGame){
             //add the game page here
            // new Board();
             //this.dispose();//this line will close the second page
             System.out.println("start game");
         }

    }
}
