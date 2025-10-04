package edu.upc.dsa.calculadora_dsa;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
int n1;
int n2;
int op;
int res;
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
    public void onEquals(View v)
    {
        if (op == 1) {
            res=n1+n2;
        } else if (op==2) {
           res=n1-n2;
        }
        else if (op==3) {
            res=n1*n2;
        }  else if (op==4) {
            res=n1/n2;
        }
        }

    public void onClear(View v)
    {
n1=0;
n2=0;
res=0;
    }

    public void onAdd(View v){
        op=1;
    }

    public void onSubstract(View v)
    {
        op=2;
    }

    public void onMultiply(View v)
    {
        op=3;
    }

    public void onDivision(View v)
    {
        op=4;
    }

    public void onSin(View v)
    {

    }

    public void onCos(View v)
    {

    }

    public void onTan(View v)
    {

    }
}
    }