import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{

    Random random = new Random(); // To determine whos turn it is first
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    Boolean player1_turn;
    Integer panelWidth = 800;
    Integer turns = 0;

    TicTacToe(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(panelWidth,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(255, 181, 99));
        textfield.setForeground(new Color(248, 94, 0));   // Text color
        textfield.setFont(new Font("Courier New",Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        title_panel.setLayout((new BorderLayout()));
        title_panel.setBounds(0,0,panelWidth,100);

        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(255, 210, 157));

        for (int i=0; i<9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFocusable(false);
            buttons[i].setBackground(new Color(255, 210, 157));
            buttons[i].setFont(new Font("Tahoma", Font.BOLD,120));
            buttons[i].addActionListener(this);
        }


        title_panel.add(textfield);

        frame.add(title_panel, BorderLayout.NORTH); // BorderLayout.North makes the title panel stick to the top of our frame
        frame.add(button_panel);

        firstTurn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        for (int i = 0; i < 9; i++) {
            if (e.getSource() == buttons[i]) {
                if (player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(164, 22, 35));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        turns++;
                        check();
                    }
                } else {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(145, 132, 80));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        turns++;
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn(){

        try {
            Thread.sleep(2000);         // Show title text for a bit before showing who's turn it is
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2)==0){
            player1_turn=true;
            textfield.setText("X turn");
        } else {
            player1_turn=false;
            textfield.setText("O turn");
        }

    }

    public void check() {
        //check if it is a tie
        // if the ninth move is not a tie this will be overwritten, hehe
        if (turns == 9){
            tie();
        }

        //check if X wins
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[1].getText()=="X") &&
                        (buttons[2].getText()=="X")
        ) {
            xWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[5].getText()=="X")
        ) {
            xWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="X") &&
                        (buttons[7].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[3].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[7].getText()=="X")
        ) {
            xWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[5].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[8].getText()=="X")
        ) {
            xWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="X") &&
                        (buttons[4].getText()=="X") &&
                        (buttons[6].getText()=="X")
        ) {
            xWins(2,4,6);
        }
        //check if O wins
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[1].getText()=="O") &&
                        (buttons[2].getText()=="O")
        ) {
            oWins(0,1,2);
        }
        if(
                (buttons[3].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[5].getText()=="O")
        ) {
            oWins(3,4,5);
        }
        if(
                (buttons[6].getText()=="O") &&
                        (buttons[7].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(6,7,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[3].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(0,3,6);
        }
        if(
                (buttons[1].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[7].getText()=="O")
        ) {
            oWins(1,4,7);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[5].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(2,5,8);
        }
        if(
                (buttons[0].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[8].getText()=="O")
        ) {
            oWins(0,4,8);
        }
        if(
                (buttons[2].getText()=="O") &&
                        (buttons[4].getText()=="O") &&
                        (buttons[6].getText()=="O")
        ) {
            oWins(2,4,6);
        }

    }

    public void xWins( int a, int b, int c){
        buttons[a].setBackground(new Color(109, 191, 99));
        buttons[b].setBackground(new Color(109, 191, 99));
        buttons[c].setBackground(new Color(109, 191, 99));

        for (int i=0 ; i<9 ; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins!");
    }

    public void oWins( int a, int b, int c){
        buttons[a].setBackground(new Color(109, 191, 99));
        buttons[b].setBackground(new Color(109, 191, 99));
        buttons[c].setBackground(new Color(109, 191, 99));

        for (int i=0 ; i<9 ; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins!");

    }

    public void tie(){
        for (int i=0 ; i<9 ; i++) {
            buttons[i].setEnabled(false);
        }
        textfield.setText("It's a tie!");
    }

}