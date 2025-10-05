package edu.upc.dsa.calculadora_dsa;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
private double n1,n2;
private double res;;
private int op;
private boolean isDegrees=true;
private boolean num=false;
private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onEquals(View v) {
        tvResultado = findViewById(R.id.tvResultado);
        EditText input = findViewById(R.id.IntroducirNumeros);

        try {
            n2 = Double.parseDouble(input.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Introduce un número válido", Toast.LENGTH_SHORT).show();
            return;
        }

        if (op == 1) {
            res = n1 + n2;
        } else if (op == 2) {
            res = n1 - n2;
        } else if (op == 3) {
            res = n1 * n2;
        } else if (op == 4) {
            if (n2 != 0) res = n1 / n2;
            else {
                Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                return;
            }
        } else if (op == 5) {
            res = isDegrees ? Math.sin(Math.toRadians(n1)) : Math.sin(n1);
        } else if (op == 6) {
            res = isDegrees ? Math.cos(Math.toRadians(n1)) : Math.cos(n1);
        } else if (op == 7) {
            res = isDegrees ? Math.tan(Math.toRadians(n1)) : Math.tan(n1);
        }

        tvResultado.setText(String.format(Locale.getDefault(), "%.2f", res));
        input.setText(""); 
    }

    public void onClear(View v)
    {
n1=0;
n2=0;
res=0;
        tvResultado=findViewById(R.id.tvResultado);
        tvResultado.setText("");
    }

    public void onAdd(View v) {
        tvResultado = findViewById(R.id.tvResultado);
        EditText input = findViewById(R.id.IntroducirNumeros);

        try {
            n1 = Double.parseDouble(input.getText().toString());
            op = 1;
            input.setText("");
            tvResultado.setText("+");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Introduce un número válido", Toast.LENGTH_SHORT).show();
        }
    }


    public void onSubstract(View v)
    {
        tvResultado = findViewById(R.id.tvResultado);
        EditText input = findViewById(R.id.IntroducirNumeros);

        try {
            n1 = Double.parseDouble(input.getText().toString());
            op = 2;
            input.setText("");
            tvResultado.setText("-");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Introduce un número válido", Toast.LENGTH_SHORT).show();
        }
    }

    public void onMultiply(View v)
    {
        tvResultado = findViewById(R.id.tvResultado);
        EditText input = findViewById(R.id.IntroducirNumeros);

        try {
            n1 = Double.parseDouble(input.getText().toString());
            op = 3;
            input.setText("");
            tvResultado.setText("*");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Introduce un número válido", Toast.LENGTH_SHORT).show();
        }
    }

    public void onDivision(View v)
    {
        tvResultado = findViewById(R.id.tvResultado);
        EditText input = findViewById(R.id.IntroducirNumeros);

        try {
            n1 = Double.parseDouble(input.getText().toString());
            op = 4;
            input.setText("");
            tvResultado.setText("/");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Introduce un número válido", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSin(View v)
    {
        EditText input = findViewById(R.id.IntroducirNumeros);
        tvResultado = findViewById(R.id.tvResultado);

        try {
            n1 = Double.parseDouble(input.getText().toString());
            res = isDegrees ? Math.sin(Math.toRadians(n1)) : Math.sin(n1);
            tvResultado.setText(String.format(Locale.getDefault(), "%.2f", res));
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Introduce un número válido", Toast.LENGTH_SHORT).show();
    }

    }

    public void onCos(View v) {
        EditText input = findViewById(R.id.IntroducirNumeros);
        tvResultado = findViewById(R.id.tvResultado);

        try {
            n1 = Double.parseDouble(input.getText().toString());
            res = isDegrees ? Math.cos(Math.toRadians(n1)) : Math.cos(n1);
            tvResultado.setText(String.format(Locale.getDefault(), "%.2f", res));
            input.setText("");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Introduce un número válido", Toast.LENGTH_SHORT).show();
        }
    }

        public void onTan(View v) {
        EditText input = findViewById(R.id.IntroducirNumeros);
        tvResultado = findViewById(R.id.tvResultado);

        try {
            n1 = Double.parseDouble(input.getText().toString());
            res = isDegrees ? Math.tan(Math.toRadians(n1)) : Math.tan(n1);
            tvResultado.setText(String.format(Locale.getDefault(), "%.2f", res));
            input.setText("");
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Introduce un número válido", Toast.LENGTH_SHORT).show();
        }
    }

    }

