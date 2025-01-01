//package src;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.util.Random;

class RPS implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private JButton button_1, button_2, button_3, button_4;
    private JLabel playerLabel, compLabel, result;
   
    Font font = new Font("Copperplate", Font.BOLD, 15);

    private Random random = new Random();
    private String User = "";
    private String Comp = "";
    private String resText = "";

    RPS(){

        frame = new JFrame();
        frame.setSize(415, 350);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Rock, Paper, Scissors!");

        panel = new JPanel();
        panel.setBounds(0, 0, 415, 350);
        panel.setLayout(null);

        button_1 = new JButton("Rock");
        button_1.setFont(font);
        button_1.setFocusable(false);
        button_1.setBounds(25, 25, 100, 50);
        button_1.addActionListener(this);
        panel.add(button_1);

        button_2 = new JButton("Paper");
        button_2.setFont(font);
        button_2.setFocusable(false);
        button_2.setBounds(150, 25, 100, 50);
        button_2.addActionListener(this);
        panel.add(button_2);

        button_3 = new JButton("Scissors");
        button_3.setFont(font);
        button_3.setFocusable(false);
        button_3.setBounds(275, 25, 100, 50);
        button_3.addActionListener(this);
        panel.add(button_3);

        playerLabel = new JLabel("User's choice: ");
        playerLabel.setBounds(25, 100, 350, 25);
        playerLabel.setFont(font);
        panel.add(playerLabel);

        compLabel = new JLabel("Comp's choice: ");
        compLabel.setBounds(25, 150, 350, 25);
        compLabel.setFont(font);
        panel.add(compLabel);

        result = new JLabel("Result: ");
        result.setBounds(25, 200, 350, 25);
        result.setFont(font);
        panel.add(result);

        button_4 = new JButton("Back");
        button_4.setFont(font);
        button_4.setFocusable(false);
        button_4.setBounds(25, 250, 100, 50);
        button_4.addActionListener(this);
        panel.add(button_4);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String[] options = {"Rock", "Paper", "Scissors"};

        if(e.getSource() == button_1){
            User = "Rock";
            Comp = options[random.nextInt(3)];
            playerLabel.setText("User's choice: " +  User);
            compLabel.setText("Comp's choice: " +  Comp);
            result.setText("Result: " + Getresult(User, Comp));
        }

        if(e.getSource() == button_2){
            User = "Paper";
            Comp = options[random.nextInt(3)];
            playerLabel.setText("User's choice: " +  User);
            compLabel.setText("Comp's choice: " +  Comp);
            result.setText("Result: " + Getresult(User, Comp));
        }

        if(e.getSource() == button_3){
            User = "Scissors";
            Comp = options[random.nextInt(3)];
            playerLabel.setText("User's choice: " +  User);
            compLabel.setText("Comp's choice: " +  Comp);
            result.setText("Result: " + Getresult(User, Comp));
        }

        if(e.getSource() == button_4){
            frame.dispose();
            new Launcher();
        }
    }

    String Getresult(String user, String comp){
        if(user.equals(comp)){
            resText = "It's a Draw!";
        }
        else if(user.equals("Rock") && comp.equals("Paper")){
            resText = "Comp wins!";
        }
        else if(user.equals("Rock") && comp.equals("Scissors")){
            resText = "User wins!";
        }
        else if(user.equals("Paper") && comp.equals("Rock")){
            resText = "User wins!";
        }
        else if(user.equals("Paper") && comp.equals("Scissors")){
            resText = "Comp wins!";
        }
        else if(user.equals("Scissors") && comp.equals("Rock")){
            resText = "Comp wins!";
        }
        else if(user.equals("Scissors") && comp.equals("Paper")){
            resText = "User wins!";
        }

        return resText;
    }
}
