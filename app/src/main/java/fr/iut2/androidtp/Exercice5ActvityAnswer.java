package fr.iut2.androidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import fr.iut2.androidtp.exercice5Data.Multiplication;
import fr.iut2.androidtp.exercice5Data.TableDeMultiplication;

public class Exercice5ActvityAnswer extends AppCompatActivity {

    public static String TABLE_KEY = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice5_actvity_answer);

        LinearLayout linear = findViewById(R.id.e5_table_centeredLayout);
        Button valider = findViewById(R.id.e5_table_valider);

        ArrayList<EditText> resList = new ArrayList<>();

        int key = getIntent().getIntExtra(TABLE_KEY, 1);
        //Toast.makeText(TableMultiplicationActivity.this,TABLE_KEY, Toast.LENGTH_SHORT).show();
        TableDeMultiplication tableMult = new TableDeMultiplication(key);

        //linear.removeAllViews();


        for (Multiplication mult : tableMult.getMultiplications()) {
            LinearLayout linearTMP = (LinearLayout) getLayoutInflater().inflate(R.layout.template_calcul, null);

            TextView calcul = (TextView) linearTMP.findViewById(R.id.template_calcul);
            calcul.setText(mult.getA() + "x" + mult.getB() + "=");

            EditText resultat = (EditText) linearTMP.findViewById(R.id.template_resultat);
            //resultat.setText(Integer.toString(mult.getA() * mult.getB()));
            resList.add(resultat);
            linear.addView(linearTMP);
        }

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int i = 0; i < 9; i++) {
                    tableMult.getMultiplications().get(i).setRES(Integer.parseInt(resList.get(i).getText().toString()));
                }
                Integer res = tableMult.getNbErreurs();
                if (res == 0) {
                    Toast.makeText(Exercice5ActvityAnswer.this, "Bon!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Exercice5ActvityAnswer.this, res.toString(), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}