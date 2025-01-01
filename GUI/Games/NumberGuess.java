//package src;
//-----Imports-----//
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.util.Random;
//-----Imports-----//

class NumberGuess implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private JTextField field;
    private JButton button, button_2, button_3;
    private JLabel label;

    Font font = new Font("Copperplate", Font.BOLD, 15);

    Random random = new Random();

    private int num;
    private int tries = 0;

    public NumberGuess(){

        frame = new JFrame();
        frame.setLayout(null);
        panel = new JPanel();

        panel.setLayout(new GridLayout(5, 1, 25, 25));
        panel.setBounds(25, 25, 350, 250);

        field = new JTextField(20);
        panel.add(field);

        button = new JButton("Guess");
        button.addActionListener(this);
        button.setFont(font);
        panel.add(button);

        button_2 = new JButton("Play");
        button_2.addActionListener(this);
        button_2.setFont(font);
        panel.add(button_2);

        button_3 = new JButton("Back");
        button_3.addActionListener(this);
        button_3.setFont(font);
        
        label = new JLabel("Press Play to generate a new game.");
        label.setFont(font);
        panel.add(label);
        panel.add(button_3);

        frame.setSize(410, 350);
        frame.setTitle("Guess the Number!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

        frame.add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button_2){
            num = random.nextInt(100) + 1;
            label.setText("A number from (0-100) is generated.");
        }

        if(e.getSource() == button_3){
            frame.dispose();
            new Launcher();
        }

        if(e.getSource() == button){
            String text = field.getText();


            if(text.isEmpty()){
                label.setText("Plese enter a number to guess.");
            }
            else{
                tries++;
                try{
                    int guess = Integer.parseInt(text);

                    if(guess < num){
                        label.setText("Your guess is lower!");
                    }
                    else if(guess > num){
                        label.setText("Your guess is higher!");
                    }
                    else if(guess == num){
                        label.setText("You have guessed the number! In tries: " + tries);
                    }

                }catch(NumberFormatException f){
                    tries--;
                    label.setText("Enter a number.");
                }
            }
        }
    }
}

