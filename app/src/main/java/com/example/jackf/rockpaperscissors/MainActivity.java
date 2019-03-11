package com.example.jackf.rockpaperscissors;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_rock, b_scissors, b_paper;
    TextView tv_score;
    ImageView iv_ComputerChoice, iv_HumanChoice;
    int HumanScore, ComputerScore= 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_paper = (Button) findViewById(R.id.b_paper);
        b_rock = (Button) findViewById(R.id.b_rock);
        b_scissors = (Button) findViewById(R.id.b_scissors);

        iv_ComputerChoice = (ImageView) findViewById(R.id.iv_ComputerCHoice);
        iv_HumanChoice = (ImageView) findViewById(R.id.iv_HumanChoice);

        tv_score = (TextView) findViewById(R.id.tv_score);

        b_rock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.rocktransparent);
                String message = play_turn("rock");
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });
        b_paper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.handtransparent);
                String message = play_turn("paper");
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });
        b_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.scissorstransparent);
                String message = play_turn("scissors");
                Toast.makeText(MainActivity.this,message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: " + Integer.toString(HumanScore) + " Computer: " + Integer.toString(ComputerScore));
            }
        });

    }

    public String play_turn(String player_Choice){
        String computer_Choice ="";
        Random r = new Random();
        int computer_ChoiceRandom = r.nextInt(3)+1;  //choose 1,2,or 3
        if(computer_ChoiceRandom ==1){
            computer_Choice = "rock";
        }
        else if(computer_ChoiceRandom ==2){
            computer_Choice = "paper";
        }
        else if(computer_ChoiceRandom ==3){
            computer_Choice = "scissors";
        }
        //set the computer image based on random number
        if(computer_Choice == "rock"){
            iv_ComputerChoice.setImageResource(R.drawable.rocktransparent);
        }
        else if(computer_Choice == "paper"){
            iv_ComputerChoice.setImageResource(R.drawable.handtransparent);
        }
        else if(computer_Choice == "scissors") {
            iv_ComputerChoice.setImageResource(R.drawable.scissorstransparent);
        }
        //compare human and computer choices
        if(computer_Choice == player_Choice){
            return "Draw. Nobody won";
        }
        else if(player_Choice == "rock" && computer_Choice == "scissors"){
            HumanScore++;
            return "Rock crushes scissors. You win!";
        }
        else if(player_Choice == "rock" && computer_Choice == "paper"){
            ComputerScore++;
            return "Paper covers rock. Computer wins!";
        }
        else if(player_Choice == "paper" && computer_Choice == "rock"){
            HumanScore++;
            return "Paper covers rock. You win!";
        }
        else if(player_Choice == "paper" && computer_Choice == "scissors"){
            ComputerScore++;
            return "Scissors cut paper. Computer wins!";
        }
        else if(player_Choice == "scissors" && computer_Choice == "paper"){
            HumanScore++;
            return "Scissors cut paper. You win!";
        }
        else if(player_Choice == "scissors" && computer_Choice == "rock"){
            ComputerScore++;
            return "Rock crushes scissors. Computer wins!";
        }
        else return "Not sure...";
    }

}
