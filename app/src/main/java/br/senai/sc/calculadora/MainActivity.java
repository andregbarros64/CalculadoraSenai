package br.senai.sc.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    public String primeiroNumero = "";
    public String segundoNumero = "";
    public String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Minha Calculadora");
        display = findViewById(R.id.tv_display);
    }

    public void onClickBtn_1(View v) {
        atualizarNumeroDigitado("1");
        atualizarDisplay("1");
    }

    public void onClickBtn_2(View v) {
        atualizarNumeroDigitado("2");
        atualizarDisplay("2");
    }

    public void onClickBtn_3(View v) {
        atualizarNumeroDigitado("3");
        atualizarDisplay("3");
    }

    public void onClickBtn_4(View v) {
        atualizarNumeroDigitado("4");
        atualizarDisplay("4");
    }

    public void onClickBtn_5(View v) {
        atualizarNumeroDigitado("5");
        atualizarDisplay("5");
    }

    public void onClickBtn_6(View v) {
        atualizarNumeroDigitado("6");
        atualizarDisplay("6");
    }

    public void onClickBtn_7(View v) {
        atualizarNumeroDigitado("7");
        atualizarDisplay("7");
    }

    public void onClickBtn_8(View v) {
        atualizarNumeroDigitado("8");
        atualizarDisplay("8");
    }

    public void onClickBtn_9(View v) {
        atualizarNumeroDigitado("9");
        atualizarDisplay("9");
    }

    public void onClickBtn_0(View v) {
        atualizarNumeroDigitado("0");
        atualizarDisplay("0");
    }

    public void onClickAdicao(View v) {
        if(!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()){
            operacao = "+";
            atualizarDisplay("+");
        }else{ Toast.makeText(MainActivity.this, "Informe o número para a operação", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickSubtracao(View v) {
        if(!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()){
            operacao = "-";
            atualizarDisplay("-");
        }else{ Toast.makeText(MainActivity.this, "Informe o número para a operação", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickMultiplicacao(View v) {
        if(!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()){
            operacao = "X";
            atualizarDisplay("X");
        }else{ Toast.makeText(MainActivity.this, "Informe o número para a operação", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickDivisao(View v) {
        if (segundoNumero.equals(0)){
            Toast.makeText(MainActivity.this, "Divisão por zero não permitida", Toast.LENGTH_LONG).show();
        }
        else if(!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()){
            operacao = "/";
            atualizarDisplay("/");
        }else{ Toast.makeText(MainActivity.this, "Informe o número para a operação", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickLimpa(View v) {
        if(!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()){
            operacao = "L";
            atualizarDisplay("");
        }else{ Toast.makeText(MainActivity.this, "Informe o número para a operação", Toast.LENGTH_LONG).show();
        }
    }

    public void onClickIgual(View v) {
        int numero1 = Integer.parseInt(primeiroNumero);
        int numero2 = Integer.parseInt(segundoNumero);
        atualizarDisplay("=");
        if (operacao.equals("+")){
            int resultado = numero1 + numero2;
            display.setText(String.valueOf(resultado));
        }if(operacao.equals("-")){
            int resultado = numero1 - numero2;
            display.setText(String.valueOf(resultado));
        }if(operacao.equals("X")){
            int resultado = numero1 * numero2;
            display.setText(String.valueOf(resultado));
        }if(operacao.equals("/")){
            int resultado = numero1 / numero2;
            display.setText(String.valueOf(resultado));
        }if(operacao.equals("L")){
            display.setText(String.valueOf(""));
        };
    }

    private void atualizarDisplay (String texto){
        if (operacao.equals("L")){
            String textoDisplay = display.getText().toString();
            textoDisplay = "";
            display.setText(textoDisplay);
        }else if (!primeiroNumero.isEmpty() && !segundoNumero.isEmpty()) {
            String textoDisplay = display.getText().toString();
            textoDisplay = textoDisplay + texto;
            display.setText(textoDisplay);
        }else { Toast.makeText(MainActivity.this,"Informe uma operação", Toast.LENGTH_LONG).show();
        }
    }

    private void  atualizarNumeroDigitado (String numero){
        if (operacao.isEmpty()){
            primeiroNumero = primeiroNumero + numero;
        }else segundoNumero = segundoNumero + numero;
    }
}