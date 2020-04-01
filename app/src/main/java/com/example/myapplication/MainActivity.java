package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtNumber;
    private Button btnValidate;
    private TextView txtResult;
    private ProgressBar prgBarEssai;
    private TextView txtHistory;
    private int searchedValue;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber = (EditText) findViewById(R.id.txtNumber);
        btnValidate = (Button) findViewById(R.id.btnValidate);
        txtResult = (TextView) findViewById(R.id.txtResult);
        prgBarEssai = (ProgressBar) findViewById(R.id.prgBarEssai);
        txtHistory = (TextView) findViewById(R.id.txtHistory);

        btnValidate.setOnClickListener(btnValideListenner);
        init();
    }

    private void init(){
        score=0;
        searchedValue = 1+ (int)(Math.random()*100);
        Log.i(" DEBUG ","Valeur cherchée : "+searchedValue);
        prgBarEssai.setProgress(score);
        txtHistory.setText("");
        txtResult.setText("");
        txtNumber.setText("");
        txtNumber.requestFocus();

    }

    private void congratulation(){
        txtResult.setText(R.string.str_congrat);
        AlertDialog retryAlert = new AlertDialog.Builder( this ).create();
        retryAlert.setTitle(R.string.app_name);
        retryAlert.setMessage(getString(R.string.str_message, score));
        retryAlert.setButton(AlertDialog.BUTTON_POSITIVE, getString(R.string.str_Oui), new AlertDialog.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                init();
            }
        });
        retryAlert.setButton(AlertDialog.BUTTON_NEGATIVE, getString(R.string.str_Non), new AlertDialog.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        retryAlert.show();
    }

    private View.OnClickListener btnValideListenner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.i(" DEBUG ","Bouton cliqué");

            String txtNumberG = txtNumber.getText().toString();
            if (txtNumberG.equals("")) return;

            txtHistory.append(txtNumber.getText().toString()+"\r\n");
            prgBarEssai.incrementProgressBy(1);
            score++;

            int enteredValue = Integer.parseInt(txtNumberG);
            if (enteredValue == searchedValue) {
                congratulation();
            }else if (enteredValue<searchedValue){
                txtResult.setText(R.string.str_plusG);
            }
            else{
                txtResult.setText(R.string.str_plusP);
            }
            txtNumber.setText("");
            txtNumber.requestFocus();
        }
    };
}
