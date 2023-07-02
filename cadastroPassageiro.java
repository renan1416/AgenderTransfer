package renan.carvalho.agendertransfer;

import static renan.carvalho.agendertransfer.IntegracaoDbJava.getConnection;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class cadastroPassageiro extends AppCompatActivity {
    Poo poo = new Poo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_passageiro);
        funVerificar();
        IntegracaoDbJava integracaoDbJava = new IntegracaoDbJava();

    }

    public void  funVerificar() {

        Button buttonSalvar = findViewById(R.id.btnSlv);
        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText edtTextSenha = findViewById(R.id.edtSenha1);
                String senha = edtTextSenha.getText().toString();
                EditText edtTextSenhaConfirmacao = findViewById(R.id.edtSenha2);
                String senha2 = edtTextSenhaConfirmacao.getText().toString();
                Log.d("debug", "Senha digitada: " + senha);


                EditText editNome = (findViewById(R.id.edtNome));
                String nome = (editNome.getText().toString());
                EditText editEmail = findViewById(R.id.edtEmail);
                String email = (editEmail.getText().toString());
                EditText editTelefone = findViewById(R.id.edtTelefone);
                String telefone = editTelefone.getText().toString();
                EditText editEndCasa = findViewById(R.id.edtEnderecoC);
                String endCasa = editEndCasa.getText().toString();
                EditText editEndTrab = findViewById(R.id.edtEnderecoT);
                String endTrab = editEndTrab.getText().toString();


                RadioButton radioGF = findViewById(R.id.rdbFeminino);
                String radioF = radioGF.getText().toString();
                RadioButton radioGM = findViewById(R.id.rdbMasculino);
                String radioM = radioGM.getText().toString();

                boolean radio;
                radio = radioGF.isSelected();
                radioGF.setSelected(radio);


                boolean radio1;
                radio1 = radioGM.isSelected();
                radioGM.setSelected(radio1);


                String com = "@";
                String com2 = ".com";

                if ((senha.length() >= 8 && senha.length() == senha2.length())) {


                    if(nome.isEmpty() || senha.isEmpty() || senha2.isEmpty() || email.isEmpty() || telefone.isEmpty() || endCasa.isEmpty()   ){
                        Snackbar snackbarVerifica = Snackbar.make(view, "Verificar se não tem algum campo obrigatorio em branco ", 1000);
                        snackbarVerifica.show();



                    }else if(!(email.toLowerCase().contains(com.toLowerCase())) || !(email.toLowerCase().contains(com2.toLowerCase()))){
                        Snackbar snackbarVerificar = Snackbar.make(view, "Verificar se o email tem @ e o .com ", 1000);
                        snackbarVerificar.show();
                    }

                    else {

                            AlertDialog.Builder confirma = new AlertDialog.Builder(cadastroPassageiro.this);

                            if(radioGF.isChecked()) {
                                confirma.setTitle("Atenção");
                                confirma.setMessage("Favor verificar os campos " + "\n" + nome + "\n" + email + "\n" + radioF + "\n" + telefone + "\n" + endCasa + "\n");

                            }else if(radioGM.isChecked()) {
                                confirma.setTitle("Atenção");
                                confirma.setMessage("Favor verificar os campos " + "\n" + nome + "\n" + email + "\n" + radioM + "\n" + telefone + "\n" + endCasa + "\n");

                            }


                            confirma.setNegativeButton("Cancelar cadastro", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    String vazio = "";
                                    editNome.setText(vazio);
                                    editEmail.setText(vazio);
                                    editEndTrab.setText(vazio);
                                    editEndCasa.setText(vazio);
                                    editTelefone.setText(vazio);
                                    edtTextSenha.setText(vazio);
                                    edtTextSenhaConfirmacao.setText(vazio);




                                }
                            });


                            confirma.setPositiveButton("Confirmar Cadastro", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent intentbutton = new Intent(cadastroPassageiro.this, SolicitarTransporte.class);
                                    startActivity(intentbutton);
                                }
                            });
                            confirma.create().show();
                            executeQuery();
                        }




                }else if(senha.length() >=8 && senha.length() !=senha2.length()){
                    Snackbar snackbarVerifica = Snackbar.make(view, "Senha não corresponde a confirmação de senha ", 1000);
                    snackbarVerifica.show();
                }


                 if (senha.length() < 8 || senha2.length() < 8) {

                    if(nome.isEmpty() || senha.isEmpty() || senha2.isEmpty() || email.isEmpty() || telefone.isEmpty() || endCasa.isEmpty()){
                        Snackbar snackbarVerifica = Snackbar.make(view, "Verificar se não tem algum campo obrigatorio em branco ", 1000);
                        snackbarVerifica.show();


                    }else{

                                Snackbar snackbar = Snackbar.make(view, "Senha e confirmação não está igual ou Não esta completa a senha ", 1000);
                                snackbar.show();

                    }



                }





            }
        });
        RadioGroup radioGroup = findViewById(R.id.rdgMF);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId) {
                    case R.id.rdbMasculino:

                        break;

                    case R.id.rdbFeminino:

                        break;

                }

            }
        });


        EditText editTextTel = findViewById(R.id.edtTelefone);
        editTextTel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {



            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(charSequence.length() == 1){
                    editTextTel.setText("("+ charSequence.toString());
                    editTextTel.setSelection(editTextTel.getText().length());
                }else if(charSequence.length() == 3){
                    editTextTel.setText(charSequence.toString()+ ")");
                    editTextTel.setSelection(editTextTel.getText().length());
                }


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }

    //Conexão ao banco de dados.
    public static void executeQuery(){
        Connection connection = null;

        try {
            connection = getConnection();

            String query = "Insert into cadastropax(idCpf, nome, email, telefone, sexo, enderecoCasa, enderecoTrabalho, senha, foto) Values (?, ?, ?, ?, ?, ?, ?, ?,?) )";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){

                    String nome = resultSet.getString("nome");
                    String email = resultSet.getString("email");
                    String telefone = resultSet.getString("telefone");
                   // String sexo = resultSet.getString("")


            }

            resultSet.close();
            statement.close();
            connection.close();

        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }finally {
            if (connection != null){
                try{
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }


    }


}