package Wordle;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Wordle extends WordleLogic implements ActionListener {
    JFrame frame;
    JButton enterButton, resetButton;
    JTextField textField;
    JLabel title, guessesLeft, answer;
    JLabel[][] guesses;
    int g_left, a;
    boolean Win = false;

    Wordle(){
        super();
        g_left=7;
        a=6;
        frame = new JFrame("Wordle");
        frame.setSize(800,700);
        frame.setLayout(null);

        frame.getContentPane().setBackground(Color.BLACK);

        enterButton = new JButton("ENTER");
        enterButton.setFont(new Font(Font.SANS_SERIF,Font.BOLD,40));
        enterButton.setBackground(Color.red);
        enterButton.setForeground(Color.white);
        enterButton.addActionListener(this);
        frame.add(enterButton);
        enterButton.setBounds(270,550,200,100);

        resetButton = new JButton("RESET");
        resetButton.setFont(new Font(Font.SANS_SERIF,Font.BOLD,40));
        resetButton.setBackground(Color.CYAN);
        resetButton.setForeground(Color.RED);
        resetButton.addActionListener(this);
        frame.add(resetButton);
        resetButton.setBounds(480,550,200,100);

        textField = new JTextField();
        textField.setFont(new Font(Font.MONOSPACED, Font.BOLD, 50));
        textField.setBackground(Color.BLACK);
        textField.setForeground(Color.white);
        textField.setBounds(100,550,160,100);
        frame.add(textField);

        title = new JLabel("Wordle");
        title.setFont(new Font(Font.MONOSPACED,Font.BOLD,60));
        title.setForeground(Color.green);
        title.setBounds(280,20,400,50);
        frame.add(title);

        guesses = new JLabel[7][5];
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 5; j++) {
                guesses[i][j] = new JLabel("_");
                guesses[i][j].setFont(new Font(Font.MONOSPACED,Font.BOLD,40));
                guesses[i][j].setForeground(Color.white);
                guesses[i][j].setBounds(295+(40*j),70+(55*i),70,80);
                frame.add(guesses[i][j]);
            }
        }

        guessesLeft = new JLabel("Guesses Left: 7");
        guessesLeft.setBounds(550,480,400,80);
        guessesLeft.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,30));
        guessesLeft.setForeground(Color.white);
        frame.add(guessesLeft);

        answer = new JLabel("");
        answer.setBounds(10,480,400,80);
        answer.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        answer.setForeground(Color.green);
        frame.add(answer);

        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Wordle();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==resetButton){
            answer.setForeground(Color.green);
            answer.setText("");
            textField.setText("");
            if(Win || g_left==0 || a==0) {
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 5; j++) {
                        guesses[i][j].setText("_");
                        guesses[i][j].setForeground(Color.white);
                    }
                }
                g_left = 7;
                a = 6;
                guessesLeft.setText("Guesses Left: "+g_left);
                Win = false;
                changeWord();
            }
        }
        if(e.getSource()==enterButton){
            if(textField.getText().length()<5){
                textField.setText("");
                return;
            }
            String guess = textField.getText().toUpperCase().substring(0,5);
            textField.setText("");

            if(guess.equals(getWord())){
                Win = true;
                answer.setText("Answer was "+getWord());
            }

            String result_from_method = enter(guess);
            String final_answer = getWord();

            for (int i = 0; i < 5; i++) {
                String letter1 = Character.toString(result_from_method.charAt(i));
                String letter_answer = Character.toString(final_answer.charAt(i));
                String guess1 = Character.toString(guess.charAt(i));

                if(letter1.equals("+")){
                    guesses[6-a][i].setText(guess1);
                    guesses[6-a][i].setForeground(Color.lightGray);
                }
                else if(guess1.equals(letter_answer)){
                    guesses[6-a][i].setText(guess1);
                    guesses[6-a][i].setForeground(Color.green);
                }
                else if( Character.isLowerCase(letter1.charAt(0)) ){
                    guesses[6-a][i].setText(guess1);
                    guesses[6-a][i].setForeground(new Color(255, 178, 0));
                }
            }
            a--;
            g_left--;
            guessesLeft.setText("Guesses Left: "+g_left);
            if(g_left==0 && !Win){
                answer.setText("Answer was:"+getWord());
                answer.setForeground(Color.red);
            }
        }
    }
}