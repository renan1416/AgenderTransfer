package renan.carvalho.agendertransfer;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    int tempoDeEspera = 1000 * 10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
    trocarTela();

    }

    private void trocarTela(){

        new Handler().postDelayed(() -> {
            Intent trocarDeTela = new Intent(this, TelaLogin.class);

            startActivity(trocarDeTela);
            finish();
        }, tempoDeEspera);



    }


}