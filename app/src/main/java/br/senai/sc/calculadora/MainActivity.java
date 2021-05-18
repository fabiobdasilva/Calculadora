package br.senai.sc.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private String primeiroNumero = "";
    private String segundoNumero = "";
    private String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Minha Calculadora");
        display = findViewById(R.id.tv_display);
    }

    public void onClickBotao1(View v) {
        atualizarNumeroDigitado("1");
        atualizarDisplay("1");

    }

    public void onClickBotao2(View v) {
        atualizarNumeroDigitado("2");
        atualizarDisplay("2");
    }

    public void onClickAdicao(View v) {
        if (!primeiroNumero.isEmpty()) {
            operacao = "+";
            atualizarDisplay("+");
        } else {
            Toast.makeText(MainActivity.this, "É preciso informar um número antes", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickIgual(View v) {
        if (!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()) {
            int numero1 = Integer.parseInt(primeiroNumero);
            int numero2 = Integer.parseInt(segundoNumero);
            if (operacao.equals("+")) {
                int resultado = numero1 + numero2;
                display.setText(String.valueOf(resultado));
            }
        } else {
            Toast.makeText(MainActivity.this, "Nenhuma operação foi solicitada", Toast.LENGTH_LONG).show();
        }
    }

    private void atualizarDisplay(String texto) {
        String textoDisplay = display.getText().toString();
        textoDisplay = textoDisplay + texto;
        display.setText(textoDisplay);
    }

    private void atualizarNumeroDigitado(String numero) {
        if (operacao.isEmpty()) {
            primeiroNumero = primeiroNumero + numero;
        } else {
            segundoNumero = segundoNumero + numero;
        }
    }
}