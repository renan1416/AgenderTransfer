package renan.carvalho.agendertransfer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class TelaLogin extends AppCompatActivity {
Poo poo = new Poo();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_login);

    funClickCadastro();
    funClickSalvar();


    }


    public void funClickCadastro(){
        Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentbutton = new Intent(TelaLogin.this, cadastroPassageiro.class);
                startActivity(intentbutton);
            }
        });
    }

    public void funClickSalvar(){
        Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText = (EditText) (findViewById(R.id.edtEmailLogin));
                String email = editText.getText().toString();
                EditText editText1 = (EditText) (findViewById(R.id.edtSenhaLogin));
                String senha = editText1.getText().toString();

                if(email.length() <= 1){

                }




            }
        });

    }




}