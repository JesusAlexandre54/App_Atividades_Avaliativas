package com.example.atividadesavaliativasunivesp;

import static com.example.atividadesavaliativasunivesp.R.color.purple_700;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DwQuestao1 extends AppCompatActivity {
    RadioButton a,b,c,d,e;
    Button bt_resposta, bt_continuar;
    RadioGroup radioGroup;
    TextView tv_resposta, tv_placar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw_questao1);

        bt_resposta = findViewById(R.id.bt_resp);
        bt_continuar = findViewById(R.id.bt_continuar);
        radioGroup = findViewById(R.id.rd_Group);
        tv_resposta = findViewById(R.id.tv_resp);
        tv_placar = findViewById(R.id.placar);

        a = findViewById(R.id.dw_a);
        b = findViewById(R.id.dw_b);
        c = findViewById(R.id.dw_c);
        d = findViewById(R.id.dw_d);
        e = findViewById(R.id.dw_e);


       bt_resposta.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String resposta = "";
               int Placar = 0;
               if (a.isChecked()) {
                   resposta = "Acertou !";
                   Placar +=1;
               }else{
                   resposta = "Errou !";
                   Placar +=0;
               }
               //Toast.makeText(DwQuestao1.this, "Selecionado"+resposta, Toast.LENGTH_SHORT).show();
               String placar = Integer.toString(Placar);

               a.setEnabled(false);
               a.setTextColor(Color.parseColor("#006400"));
               a.setText("a - O Rato   RESPOSTA CORRETA!");
               b.setEnabled(false);
               c.setEnabled(false);
               d.setEnabled(false);
               e.setEnabled(false);
               tv_resposta.setText(resposta);
               tv_placar.setText(placar);


           }
       });
       bt_continuar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String placar = tv_placar.getText().toString();

               Intent i = new Intent(DwQuestao1.this, DwQuestao2.class);
               i.putExtra("placar", placar );
               startActivity(i);





           }
       });

    }
}