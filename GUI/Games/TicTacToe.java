package src;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


class TicTacToe implements ActionListener{

    private JFrame frame;
    private JPanel panel;
    private JTextField[] fields = new JTextField[9];
    private JButton button, button_1;
    private JLabel label;

    Font font = new Font("Copperplate", Font.BOLD, 15);

    private int count = 2;
    private boolean turn = false;

    TicTacToe(){
        frame = new JFrame();
        frame.setSize(400, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setTitle("Tic-Tac-Toe!");

        panel = new JPanel();
        panel.setBounds(25, 25, 300, 300);
        panel.setLayout(new GridLayout(3, 3, 10, 10));

        for(int i  = 0; i < 9; i++){
            fields[i] = new JTextField();
            fields[i].setFont(font);
        }

        panel.add(fields[0]);
        panel.add(fields[1]);
        panel.add(fields[2]);

        panel.add(fields[3]);
        panel.add(fields[4]);
        panel.add(fields[5]);

        panel.add(fields[6]);
        panel.add(fields[7]);
        panel.add(fields[8]);

        label = new JLabel("Player 1(X)");
        label.setBounds(25, 350, 300, 25);
        label.setFont(font);
        frame.add(label);

        button = new JButton("Add");
        button.setBounds(125, 400, 100, 50);
        button.setFont(font);
        button.addActionListener(this);
        frame.add(button);

        button_1 = new JButton("Back");
        button_1.setBounds(125, 500, 100, 50);
        button_1.setFont(font);
        button_1.addActionListener(this);
        frame.add(button_1);

        JLabel label_1 = new JLabel("Please press the add button only once, only after entering a letter.");
        label_1.setBounds(0, 575, 400, 25);
        frame.add(label_1);

        frame.add(panel);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == button_1){
            frame.dispose();
            new Launcher();
        }

        if(e.getSource() == button){
            count++;
            for(int i = 0; i < 9; i++){
                if(fields[i].getText().equals("X")){
                    if(turn == false){
                        fields[i].setText("X");
                        fields[i].setEditable(false);   
                    }       
                }
                else if(fields[i].getText().equals("O")){
                    if(turn == true){
                        fields[i].setText("O");
                        fields[i].setEditable(false);
                    } 
                }
            }

            if(count > 0){
                if(count % 2 != 0){
                    label.setText("Player 2(O)");
                    turn = true;
                }
                else if(count % 2 == 0){
                    label.setText("Player 1(X)");
                    turn = false;
                }
            }
            

            if(CheckWin("X") == true){
                label.setText("Player with X wins!");
                for(int a = 0; a < 9; a++){
                    fields[a].setEditable(false);
                }
            }
            else if(CheckWin("O") == true){
                label.setText("Player with O wins!");
                for(int b = 0; b < 9; b++){
                    fields[b].setEditable(false);
                }
                
            }
            else if(CheckWin("X") == false && CheckWin("O") == false && getEmpty() == 1){
                label.setText("It's a Draw!");
                for(int c = 0; c < 9; c++){
                    fields[c].setEditable(false);
                }
            }
        }
    }

    boolean CheckWin(String mark){
        boolean isTrue = false;


        if((fields[0].getText().equals(mark) && fields[1].getText().equals(mark) && fields[2].getText().equals(mark)) || (fields[3].getText().equals(mark) && fields[4].getText().equals(mark) && fields[5].getText().equals(mark)) || (fields[6].getText().equals(mark) && fields[7].getText().equals(mark) && fields[8].getText().equals(mark)) || (fields[0].getText().equals(mark) && fields[3].getText().equals(mark) && fields[6].getText().equals(mark)) || (fields[1].getText().equals(mark) && fields[4].getText().equals(mark) && fields[7].getText().equals(mark)) || (fields[2].getText().equals(mark) && fields[5].getText().equals(mark) && fields[8].getText().equals(mark)) || (fields[0].getText().equals(mark) && fields[4].getText().equals(mark) && fields[8].getText().equals(mark)) || (fields[2].getText().equals(mark) && fields[4].getText().equals(mark) && fields[6].getText().equals(mark))){
            isTrue = true;
        }

        return isTrue;
    }

    int getEmpty(){
        int empty = 0;

        for(int x = 0; x < 9; x++){
            if(fields[x].getText().equals("")){
                empty++;
            }
        }

        return empty;
    }
}
