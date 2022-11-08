package com.example.atividadesavaliativasunivesp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class DwQuestao2 extends AppCompatActivity {
    RadioButton a,b,c,d,e;
    Button bt_resposta, bt_continuar;
    RadioGroup radioGroup;
    TextView tv_resposta, tv_placar;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dw_questao2);
        i = getIntent();
        int Placar = Integer.parseInt(i.getExtras().getString("placar"));
        String placar = Integer.toString(Placar);



        bt_resposta = findViewById(R.id.bt_resp);
        bt_continuar = findViewById(R.id.bt_continuar);
        radioGroup = findViewById(R.id.rd_Group);
        tv_resposta = findViewById(R.id.tv_resp);
        tv_placar = findViewById(R.id.placar);
        tv_placar.setText(placar);

        a = findViewById(R.id.dw_a);
        b = findViewById(R.id.dw_b);
        c = findViewById(R.id.dw_c);
        d = findViewById(R.id.dw_d);
        e = findViewById(R.id.dw_e);


        bt_resposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int Placar = Integer.parseInt(i.getExtras().getString("placar"));

                String resposta = "";

                if (d.isChecked()) {
                    resposta = "Acertou!";
                    Placar +=1;
                }else{
                    resposta = "Errou !";
                    Placar +=0;
                }
                //Toast.makeText(DwQuestao1.this, "Selecionado"+resposta, Toast.LENGTH_SHORT).show();
                String placar = Integer.toString(Placar);
                a.setEnabled(false);
                b.setEnabled(false);
                c.setEnabled(false);
                d.setEnabled(false);
                d.setTextColor(Color.parseColor("#006400"));
                d.setText("d - Lula   RESPOSTA CORRETA!");
                e.setEnabled(false);
                tv_resposta.setText(resposta);
                tv_placar.setText(placar);
            }
        });
        bt_continuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cont = tv_placar.getText().toString();
                Intent i = new Intent(DwQuestao2.this, DwQuestao3.class);
                i.putExtra("placar", cont );
                startActivity(i);

            }
        });

    }
}