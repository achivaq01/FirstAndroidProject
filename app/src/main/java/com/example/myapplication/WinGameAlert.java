package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class WinGameAlert extends DialogFragment {
    private final int _attempts;

    public WinGameAlert(int attempts) {
        super();
        this._attempts = attempts;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final EditText inputEditText = new EditText(getActivity());

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Number guessed!")
                .setMessage("You guessed the number in " + _attempts + " guesses!")
                .setView(inputEditText)
                .setNegativeButton(R.string.cancel_score, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                })
                .setPositiveButton(R.string.save_score, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String userInput = inputEditText.getText().toString();
                    }
                });


        setCancelable(false);

        return builder.create();
    }
}
