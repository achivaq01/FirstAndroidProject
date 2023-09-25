package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        int randomNumber = (int) (Math.random() * 10);

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

                    if (validGuess == randomNumber){
                        CharSequence correctGuess = "Your guess is correct!";

                        toast.setText(correctGuess);
                    } else {
                        CharSequence incorrectGuess = "Your guess is not correct";

                        toast.setText(incorrectGuess);
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
}