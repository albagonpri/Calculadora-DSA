package edu.upc.dsa.calculadora_dsa;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private double n1 = 0, n2 = 0, res = 0;
    private int op = 0;
    private boolean newNumber = true;
    private boolean isDegrees = false;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tvResultado = findViewById(R.id.tvResultado);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void onNumberClick(View v) {
        Button b = (Button) v;
        String value = b.getText().toString();

        if (newNumber) {
            tvResultado.setText(value);
            newNumber = false;
        } else {
            tvResultado.append(value);
        }
    }

    public void onAdd(View v) {
        try {
            n1 = Double.parseDouble(tvResultado.getText().toString());
            op = 1;
            newNumber = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        }
    }

    public void onSubstract(View v) {
        try {
            n1 = Double.parseDouble(tvResultado.getText().toString());
            op = 2;
            newNumber = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        }
    }

    public void onMultiply(View v) {
        try {
            n1 = Double.parseDouble(tvResultado.getText().toString());
            op = 3;
            newNumber = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        }
    }

    public void onDivision(View v) {
        try {
            n1 = Double.parseDouble(tvResultado.getText().toString());
            op = 4;
            newNumber = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        }
    }

    public void onEquals(View v) {
        try {
            n2 = Double.parseDouble(tvResultado.getText().toString());
            switch (op) {
                case 1:
                    res = n1 + n2;
                    break;
                case 2:
                    res = n1 - n2;
                    break;
                case 3:
                    res = n1 * n2;
                    break;
                case 4:
                    if (n2 != 0) res = n1 / n2;
                    else {
                        Toast.makeText(this, "No se puede dividir entre 0", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    break;
                default:
                    res = n2;
            }
            tvResultado.setText(String.format(Locale.getDefault(), "%.2f", res));
            newNumber = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClear(View v) {
        n1 = 0;
        n2 = 0;
        res = 0;
        op = 0;
        newNumber = true;
        tvResultado.setText("");
    }

    public void onSin(View v) {
        try {
            n1 = Double.parseDouble(tvResultado.getText().toString());
            res = isDegrees ? Math.sin(Math.toRadians(n1)) : Math.sin(n1);
            tvResultado.setText(String.format(Locale.getDefault(), "%.2f", res));
            newNumber = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        }
    }

    public void onCos(View v) {
        try {
            n1 = Double.parseDouble(tvResultado.getText().toString());
            res = isDegrees ? Math.cos(Math.toRadians(n1)) : Math.cos(n1);
            tvResultado.setText(String.format(Locale.getDefault(), "%.2f", res));
            newNumber = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        }
    }

    public void onTan(View v) {
        try {
            n1 = Double.parseDouble(tvResultado.getText().toString());
            res = isDegrees ? Math.tan(Math.toRadians(n1)) : Math.tan(n1);
            tvResultado.setText(String.format(Locale.getDefault(), "%.2f", res));
            newNumber = true;
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Número inválido", Toast.LENGTH_SHORT).show();
        }
    }
}


