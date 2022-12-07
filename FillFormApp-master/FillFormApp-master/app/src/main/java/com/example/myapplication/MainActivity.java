package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked.
        switch (view.getId()) {
            case R.id.Male:
                if (checked) {
                    // Same day service
                    displayToast(getString(R.string.male));
                    Log.d("Message", getString(R.string.male));
                }
                break;
            case R.id.Female:
                if (checked)
                    // Next day delivery
                    displayToast(getString(R.string.female));
                break;
            default:
                // Do nothing.
                break;
        }
    }
    public void displayToast(String message) {
        Context context = getApplicationContext();
        CharSequence text = "Hello toast!";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context,text, duration);
        toast.show();
    }


}