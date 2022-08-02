package tictactoe;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TicTacToe implements ActionListener{
    
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    int count = 0;
    boolean player1_turn;
    
    TicTacToe()
    {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25, 255, 0));
        textfield.setFont(new Font("Ink Free", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);
        
//        frame.add(textfield);
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,800);
        
        button_panel.setLayout(new GridLayout(3,3));
        button_panel.setBackground(new Color(150, 150, 150));
        
        for(int i = 0; i < 9; i++)
        {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(true);
            buttons[i].addActionListener(this);
        }
        
        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        
        firstTurn();
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        for(int i = 0; i < 9; i++)
        {
            if(e.getSource() == buttons[i])
            {
                count++;
                if(player1_turn)
                {
                    if(buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(255, 0, 0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        check('x');
                    }
                }
                else
                {
                    if(buttons[i].getText() == "")
                    {
                        buttons[i].setForeground(new Color(0, 0, 255));
                        buttons[i].setText("O");
                        player1_turn = true;
                        textfield.setText("X turn");
                        check('y');
                    }
                }
                if(count == 9)
                {
                    textfield.setText("Match Tied!!");
                    for(int j = 0; j < 9; j++)
                    {
                        buttons[j].setEnabled(false);
                    }
                }
                return;
            }
        }
    }
    
    public void firstTurn()
    {
        try
        {
            Thread.sleep(2000);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        if(random.nextInt(2) == 0)
        {
            player1_turn = true;
            textfield.setText("X Turn");
        }
        else
        {
            player1_turn = false;
            textfield.setText("O Turn");
        }
    }
    
    public void checkWin(int a, int b, int c, String str)
    {
        if(buttons[a].getText() == str && buttons[b].getText() == str && buttons[c].getText() == str)
        {
            buttons[a].setBackground(Color.GREEN);
            buttons[b].setBackground(Color.GREEN);
            buttons[c].setBackground(Color.GREEN);
        
            for(int i = 0; i < 9; i++)
            {
                buttons[i].setEnabled(false);
            }
                
            if(str == "X")
            {
                textfield.setText("X wins");
            }
            else
            {
                textfield.setText("O wins");
            }
        }
    }
    
    public void check(char ch)
    {
        if(count < 5)
        {
            return;
        }
        if(ch == 'x')
        {
            checkWin(0,1,2,"X");
            checkWin(3,4,5,"X");
            checkWin(6,7,8,"X");
            checkWin(0,3,6,"X");
            checkWin(1,4,7,"X");
            checkWin(2,5,8,"X");
            checkWin(0,4,8,"X");
            checkWin(2,4,6,"X");
        }
        else
        {
            checkWin(0,1,2,"O");
            checkWin(3,4,5,"O");
            checkWin(6,7,8,"O");
            checkWin(0,3,6,"O");
            checkWin(1,4,7,"O");
            checkWin(2,5,8,"O");
            checkWin(0,4,8,"O");
            checkWin(2,4,6,"O");
        }
    }
    
}
