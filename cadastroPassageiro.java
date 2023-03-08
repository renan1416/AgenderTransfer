package renan.carvalho.agendertransfer;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class cadastroPassageiro extends AppCompatActivity {
    Poo poo = new Poo();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_passageiro);
            funVerificar();



    }

    public void funVerificar(){

        Button buttonSalvar = (Button) findViewById(R.id.btnSlv);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edtTextSenha = (EditText) findViewById(R.id.edtSenha1);
                String senha = edtTextSenha.getText().toString();
                EditText edtTextSenhaConfirmacao = (EditText) findViewById(R.id.edtSenha2);
                String senha2 = edtTextSenhaConfirmacao.getText().toString();
                Log.d("debug", "Senha digitada: " + senha);

                if (senha.length() >= 8 && senha.length() == senha2.length() ) {

                    Snackbar snackbar1 = Snackbar.make(view, "Senha e confirmação de senha igual", 1000);
                    snackbar1.show();









                }else if(senha.length() != senha2.length()&& senha.length() < 8 || senha2.length() < 8) {
                    Snackbar snackbar = Snackbar.make(view, "Senha e confirmação não está igual ou Não esta completa a senha ", 1000);
                    snackbar.show();
                }










            }
        });

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.rdgMF);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.rdbMasculino:

                        break;

                    case R.id.rdbFeminino:

                        break;

                }

            }
        });

        Button btnLimpar = (Button) findViewById(R.id.btnLimpar);
        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               /* EditText editText = (EditText) findViewById(R.id.edtSenha1);
                editText.setText(poo.getSenha());
                EditText editText1 = (EditText) findViewById(R.id.edtSenha2);
                editText1.setText(poo.getSenhaConfirmacao());

*/
            }
        });



    }



}