package com.example.utilisateur.hangman;

import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView tvWord;
    private EditText inputWord;
    private Button buttonValidate;
    private Button buttonRandom;

    private ImageView imageHangman;
    private TextView tvCryptedWord;
    private TextView tvTriedLetters;
    private TableLayout tableLayoutKeyboard;

    private String word;
    private int count;
    private ArrayList<String> cryptedLetters;
    private ArrayList<String> wordLetters;
    private ArrayList<String> triedLetters;
    private ArrayList<String> validLettres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        this.tvWord = (TextView) findViewById(R.id.textViewSelectYourWord);
        this.inputWord = (EditText) findViewById(R.id.inputWord);
        this.inputWord.getBackground().clearColorFilter();
        this.inputWord.getBackground().mutate().setColorFilter(getResources().getColor(R.color.black), PorterDuff.Mode.SRC_ATOP);
        this.buttonValidate = (Button) findViewById(R.id.buttonValidate);
        this.buttonValidate.setOnClickListener(clickValidate);
        this.buttonRandom = (Button) findViewById(R.id.buttonRandom);
        this.buttonRandom.setOnClickListener(clickRandom);

        this.word = "";
        this.count = 0;
        this.cryptedLetters = new ArrayList<>();
        this.wordLetters = new ArrayList<>();
        this.triedLetters = new ArrayList<>();
        this.validLettres = new ArrayList<>();

        this.imageHangman = (ImageView) findViewById(R.id.imageView);
        this.tvCryptedWord = (TextView) findViewById(R.id.textViewCryptedWord);
        this.tvTriedLetters = (TextView) findViewById(R.id.textViewTriedLetters);
        this.tableLayoutKeyboard = (TableLayout) findViewById(R.id.tableLayoutKeybord);
    }

    View.OnClickListener clickValidate = new View.OnClickListener() {
        public void onClick(View v) {
            word = inputWord.getText().toString();
            //IF WORD CONTAINS SYMBOLE/NUMBERS/CAPITAL LETTER
            initGame();
        }
    };

    View.OnClickListener clickRandom = new View.OnClickListener() {
        public void onClick(View v) {
            word = "romain";
            initGame();
        }
    };

    private void initGame(){
        if(this.word.equals("")){
            Toast.makeText(this, "You need to enter a word",Toast.LENGTH_SHORT).show();
        }
        else{
            this.tvWord.setVisibility(View.INVISIBLE);
            this.inputWord.setVisibility(View.INVISIBLE);
            this.buttonValidate.setVisibility(View.INVISIBLE);
            this.buttonRandom.setVisibility(View.INVISIBLE);
            this.tvWord.setText(word);
            this.imageHangman.setVisibility(View.VISIBLE);
            this.tvCryptedWord.setVisibility(View.VISIBLE);
            this.tvTriedLetters.setVisibility(View.VISIBLE);
            this.tableLayoutKeyboard.setVisibility(View.VISIBLE);

            for (char c : this.word.toCharArray()) {
                this.cryptedLetters.add("_");
            }

            for (char c : this.word.toCharArray()) {
                this.wordLetters.add(c +"");
            }

            this.tvCryptedWord.setText("");
            for(int i=0; i<this.cryptedLetters.size(); i++){
                this.tvCryptedWord.append(this.cryptedLetters.get(i) + " ");
            }

            this.tvTriedLetters.setText("");
            for(int i=0; i<this.triedLetters.size(); i++){
                this.tvTriedLetters.append(this.triedLetters.get(i) + " ");
            }
        }
    }
}
