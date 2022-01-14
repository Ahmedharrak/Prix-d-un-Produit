package com.example.prixdunproduit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText1;
    private EditText mEditText2;
    private EditText mEditText3;
    private TextView mTextViewResultat1;
    private TextView mTextViewResultat2;
    private TextView mTextViewResultat3;
    private Button mButtonPrix;
    private Button mButtonAnnuler;
    private static final String KEY_PRIXHT= "prixht_key";
    private static final String KEY_PRIXTTC = "prixttc_key";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEditText1 = findViewById(R.id.editTextNumberDecimal2);
        mEditText2 = findViewById(R.id.editTextNumber);
        mEditText3 = findViewById(R.id.editTextNumberDecimal);
        mTextViewResultat1 = findViewById(R.id.textView4);
        mTextViewResultat2 = findViewById(R.id.textView7);
        mButtonPrix = findViewById(R.id.button3);
        mButtonAnnuler = findViewById(R.id.button2);
        mEditText3.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "100")});
        mEditText1.setFilters(new InputFilter[]{ new InputFilterMinMax("0", "999999999")});
        mEditText2.setFilters(new InputFilter[]{ new InputFilterMinMax("1", "9999")});


        mButtonPrix.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (mEditText1.getText().toString().isEmpty()  ){
                    Toast.makeText(getApplicationContext(), "Entrer votre prix", Toast.LENGTH_SHORT).show();
                } else {

                if(mEditText2.getText().toString().length() == 0){
                    mEditText2.setText("1");
                }
                if(mEditText3.getText().toString().length() == 0){
                    mEditText3.setText("18");
                }

                int num1 = Integer.parseInt(mEditText1.getText().toString());
                int num2 = Integer.parseInt(mEditText2.getText().toString());
                float num3 = Float.parseFloat(mEditText3.getText().toString());


                int prixHT = num1 * num2 ;
                float prixTTC = prixHT * (1 + (num3 / 100));
                    mTextViewResultat1.setText(String.valueOf(prixHT));
                    mTextViewResultat2.setText(String.valueOf(prixTTC));


            }}
        });

        mButtonAnnuler.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(mEditText1.getText().toString().trim());
                int num2 = Integer.parseInt(mEditText2.getText().toString().trim());
                float num3 = Float.parseFloat(mEditText3.getText().toString().trim());


                mEditText1.setText(String.valueOf(0));
                mEditText2.setText(String.valueOf(1));
                mEditText3.setText(String.valueOf(0));
                mTextViewResultat1.setText(String.valueOf(0));
                mTextViewResultat2.setText(String.valueOf(0));


            }
        });
        if (savedInstanceState != null) {
            String savedPrixHT = savedInstanceState.getString(KEY_PRIXHT);
            mTextViewResultat1.setText(savedPrixHT);

            String savedPrixTTC = savedInstanceState.getString(KEY_PRIXTTC);
            mTextViewResultat2.setText(savedPrixTTC);



        }else{
            Toast.makeText(this, "Nouvelle Page", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {

        savedInstanceState.putString(KEY_PRIXHT, mTextViewResultat1.getText().toString());
        savedInstanceState.putString(KEY_PRIXTTC, mTextViewResultat2.getText().toString());


        super.onSaveInstanceState(savedInstanceState);
    }


}