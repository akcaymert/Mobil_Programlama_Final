package com.example.proje1;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Diseas_ extends AppCompatActivity {


    private String name;
    TextView disease_textView,disease_info_textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diseas_);
        setElement();
        setText();
    }


    private void setElement() {
        disease_textView = findViewById(R.id.disease_state_textView);
        disease_info_textView = findViewById(R.id.evde_kal_diseaseInfo_textView);
    }


    private void setText() {
        getName();
        disease_textView.setText(name + " Covid-19 belirtileri ile belirtlileriniz eşleşiyor lütfen 14 gün içinde görüştüğünüz kişilerle sağlık kuruluşunu arayınız.");
        disease_textView.setOnClickListener(new View.OnClickListener() {

            final int emerg = 112;

            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                Intent call = new Intent(Intent.ACTION_CALL);
                call.setData(Uri.parse("tel: " +emerg));
                if (checkSelfPermission(Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                    Toast mes = Toast.makeText(getApplication(),"Lütfen Arama Izni Verin",Toast.LENGTH_LONG);
                    View layout = getLayoutInflater().inflate(R.layout.custom_toast,(ViewGroup) findViewById(R.id.custom_toast_container));
                    mes.setView(layout);
                    mes.show();


                    return;
                }
                startActivity(call);

            }
        });

    }


    private void getName(){
        Bundle disease_screen_bundle = getIntent().getExtras();
        name = disease_screen_bundle.getString("name");

    }
}
