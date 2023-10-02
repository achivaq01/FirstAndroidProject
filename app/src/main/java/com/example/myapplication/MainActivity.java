package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static int _randomNumber;
    private static int _attempts;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        set_randomNumber();

        TextView textView = findViewById(R.id.text);
        textView.setMovementMethod(new ScrollingMovementMethod());

        // Toast creation

        CharSequence text = "You pressed the button!";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(this /* MyActivity */, text, duration);

        // EditText creation

        EditText editText = (EditText) findViewById(R.id.plain_text_input);

        // Button creation

        Button button = (Button) findViewById(R.id.supabutton);

        // Button onCLick events
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String guess = String.valueOf(editText.getText());
                try{
                    int validGuess = Integer.parseInt(guess);

                    if (validGuess == _randomNumber){
                        CharSequence correctGuess = "Your guess is correct!";
                        WinGameAlert dialog = new WinGameAlert(_attempts);
                        dialog.show(getSupportFragmentManager(), "test");
                        updateText(textView, validGuess, correctGuess);
                        set_randomNumber();

                        toast.setText(correctGuess);
                    } else {
                        String tip = _getTip(validGuess);
                        updateText(textView, validGuess, tip);
                        toast.setText(tip);
                        MainActivity._attempts++;
                    }


                } catch (NumberFormatException e) {
                    CharSequence errorText = "Invalid Guess";
                    toast.setText(errorText);

                    //throw new RuntimeException(e);
                }

                toast.show();
            }
        });
        
    }

    private String _getTip(int guess){
        if(guess > _randomNumber){
            return "The number is smaller";
        }
        return "The number is bigger";
    }

    @SuppressLint("SetTextI18n")
    private void updateText(TextView view, int guess, CharSequence tip){
        if (guess == _randomNumber){
            view.setText("");
            return;
        }
        CharSequence text = view.getText();
        view.setText(text + "\n" + guess + ": " + tip);
    }

    private void set_randomNumber(){
        _randomNumber = (int) (Math.random() * 100);
    }
}

