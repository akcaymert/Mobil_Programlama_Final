package com.example.proje1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText isim_soyisim_editText,tc_no_editText;
    Button login_button_first;
    CheckBox burun_akintisi,hapşırık,hırıltı,gözlerde_kızarlıklık,baş_agrisi,boğaz_agrisi,nefes_darligi,ani_ates,halsizlik,kuru_öksürük;
    Boolean burun_akintisi_result,hapşırık_result,hırıltı_result,gözlerde_kızarlıklık_result,bas_agrisi_result,boğaz_agrisi_result,nefes_darligi_result,ani_ates_result,halsizlik_result,kuru_öksürük_result;
    Boolean Nezle,Alerji,Grip,Covid,Another;
    String isim_soyisim_text;
    String tc;
    String name[];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defElement();

    }

    @Override
    protected void onResume() {
        super.onResume();
        loginButton();
    }

    public void loginButton(){
        login_button_first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kontrol();
                name = isim_soyisim_text.split(" ");
                if(Covid == true){
                    Intent disease_screen = new Intent(getApplicationContext(),Diseas_.class);

                    disease_screen.putExtra("name",name[0]);
                    startActivity(disease_screen);
                }
                else{
                    Intent result_screen = new  Intent(getApplicationContext(),Result_act.class);
                    result_screen.putExtra("nezle",Nezle);
                    result_screen.putExtra("alerji",Alerji);
                    result_screen.putExtra("grip",Grip);
                    result_screen.putExtra("another",Another);
                    result_screen.putExtra("name",name[0]);
                    startActivity(result_screen);
                }


            }
        });
    }





    public void defElement(){



        isim_soyisim_editText = findViewById(R.id.isim_soyisim);
        tc_no_editText = findViewById(R.id.tc_no);
        burun_akintisi = findViewById(R.id.checkbox_burun_akintisi);
        hapşırık = findViewById(R.id.checkbox_hapşirik);
        hırıltı = findViewById(R.id.checkbox_hirilti);
        gözlerde_kızarlıklık = findViewById(R.id.checkbox_gözlerde_kizarliklik);
        baş_agrisi = findViewById(R.id.checkbox_bas_agrisi);
        boğaz_agrisi = findViewById(R.id.checkbox_bogaz_agrisi);
        nefes_darligi = findViewById(R.id.checkbox_nefes_darligi);
        ani_ates = findViewById(R.id.checkbox_ani_ates);
        halsizlik = findViewById(R.id.checkbox_halsizlik);
        kuru_öksürük = findViewById(R.id.checkbox_kuru_öksürük);
        login_button_first = findViewById(R.id.login_first_screen);
    }
    public void check(){

        burun_akintisi_result = hapşırık_result = hırıltı_result = gözlerde_kızarlıklık_result = bas_agrisi_result = nefes_darligi_result = ani_ates_result = halsizlik_result = kuru_öksürük_result = false;


         isim_soyisim_text = String.valueOf(isim_soyisim_editText.getText());
         tc = String.valueOf(tc_no_editText.getText());
         burun_akintisi_result = burun_akintisi.isChecked();
         hapşırık_result = hapşırık.isChecked();
         hırıltı_result = hırıltı.isChecked();
         gözlerde_kızarlıklık_result = gözlerde_kızarlıklık.isChecked();
         bas_agrisi_result = baş_agrisi.isChecked();
         boğaz_agrisi_result = boğaz_agrisi.isChecked();
         nefes_darligi_result = nefes_darligi.isChecked();
         ani_ates_result = ani_ates.isChecked();
         halsizlik_result = halsizlik.isChecked();
         kuru_öksürük_result = kuru_öksürük.isChecked();
    }
    public void kontrol(){
        check();
        Nezle=Alerji=Grip=Covid=Another=false;

        if(burun_akintisi_result && hapşırık_result && hırıltı_result && gözlerde_kızarlıklık_result && bas_agrisi_result && boğaz_agrisi_result){
            Nezle = true;
        }
        else if(hapşırık_result && hırıltı_result && gözlerde_kızarlıklık_result ){
            Alerji = true;
        }
        else if( bas_agrisi_result && boğaz_agrisi_result&& ani_ates_result && halsizlik_result && kuru_öksürük_result ){
            Grip = true;
        }
        else if(nefes_darligi_result&&ani_ates_result&&halsizlik_result&&kuru_öksürük_result){
            Covid = true;
        }
        else{
            Another = true;
        }
    }
}
