package br.com.local.buscacep_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {
    Button btnBuscarCep;
    EditText txtCep;
    TextView lblResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtCep = findViewById(R.id.txtCep);
        lblResposta = findViewById(R.id.lblResposta);
        btnBuscarCep = findViewById(R.id.btnBuscaCEP);

        btnBuscarCep.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Clicou em bucar!", Toast.LENGTH_LONG).show();
            try{
                CEP retorno = new HTTPService(txtCep.getText().toString()).execute().get();
                lblResposta.setText(retorno.toString());
            }catch (InterruptedException e){
                e.printStackTrace();
            }catch (ExecutionException e){
                e.printStackTrace();
            }
        });
    }
}