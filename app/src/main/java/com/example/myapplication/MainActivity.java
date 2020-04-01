package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNumber = (EditText) findViewById(R.id.txtNumber);
        btnValidate = (Button) findViewById(R.id.btnValidate);
        txtResult = (TextView) findViewById(R.id.txtResult);
        prgBarEssai = (ProgressBar) findViewById(R.id.prgBarEssai);
        txtHistory = (TextView) findViewById(R.id.txtHistory);

        init();
    }

    private void init(){

    }

    private View.OnClickListener btnValideListenner = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };
}
