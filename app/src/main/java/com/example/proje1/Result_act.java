package com.example.proje1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;



public class Result_act extends AppCompatActivity {
    TextView textView_diease ;
    private String name,hastalık;
    private Boolean Nezle,Alerji,Grip,Another;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_act);
        setElement();
        printTextView();



    }


    public void printTextView(){

        getFirstScreen();

        if(Nezle == true){
            hastalık = "nezle";
        }
        else if(Alerji == true){
            hastalık = "alerji";
        }
        else if (Grip == true){
            hastalık = "grip";
        }
        else{
            hastalık = "soğuk algınlığı";
        }
        textView_diease.setText(name+" Ciddi bir rahatsızlığın görünmüyor sadece "+hastalık+" geçiriyorsun evinde kalmaya devam edip keyfine bak :)");

    }
    public void getFirstScreen(){
        Bundle first_screen_bundle = getIntent().getExtras();
        Nezle = first_screen_bundle.getBoolean("nezle");
        Alerji = first_screen_bundle.getBoolean("alerji");
        Grip = first_screen_bundle.getBoolean("grip");
        Another = first_screen_bundle.getBoolean("another");
        name = first_screen_bundle.getString("name");

    }
    public void setElement(){
        textView_diease = findViewById(R.id.diseas_state_textView);
    }


}
