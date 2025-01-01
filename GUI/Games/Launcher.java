//package src;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


class Launcher implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private JButton button_1,  button_2, button_3;

    Font font = new  Font("Copperplate", Font.BOLD, 15);

    Launcher(){

        frame = new JFrame();
        frame.setTitle("Launcher!");
        frame.setSize(415, 415);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1, 50, 50));
        panel.setBounds(50, 50, 300, 300);

        button_1 = new JButton("NumberGuesser");
        button_1.setFont(font);
        button_1.addActionListener(this);
        button_1.setFocusable(false);
        panel.add(button_1);

        button_2 = new JButton("Rock, Paper, Scissors");
        button_2.setFont(font);
        button_2.addActionListener(this);
        button_2.setFocusable(false);
        panel.add(button_2);

        button_3 = new JButton("Tic-Tac-Toe");
        button_3.setFont(font);
        button_3.addActionListener(this);
        button_3.setFocusable(false);
        panel.add(button_3);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == button_1){
            frame.dispose();
            new NumberGuess();
        }
        else if(e.getSource() == button_2){
            frame.dispose();
            new RPS();
        }
        else if(e.getSource() == button_3){
            frame.dispose();
            new TicTacToe();
        }    
    }
}
