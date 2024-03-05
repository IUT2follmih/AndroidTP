package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Exercice5ActivityResult extends AppCompatActivity {

    public static String NB_ERROR = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercice5_result);

        TextView title = findViewById(R.id.e5_result);
        TextView subTitle = findViewById(R.id.e5_nbError);

        Button btn1 = findViewById(R.id.e5_btn1);
        Button btn2 = findViewById(R.id.e5_btn2);

        Integer errors = getIntent().getIntExtra(NB_ERROR, 0);

        if (errors > 0) {
            title.setText("ERREURS !");
            subTitle.setText("Nombre d'erreurs : " + errors);
            btn1.setText("Corriger mes erreurs");
            btn2.setText("Choisir une autre table");
        } else {
            title.setText("FELICITATION !");
            subTitle.setText("");
            btn1.setText("Choisir une autre tables");
            btn2.setText("Choisir un autre exercice");
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (errors > 0) {
                    finish();
                } else {
                    Intent intent = new Intent(Exercice5ActivityResult.this, Exercice5Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (errors > 0) {
                    Intent intent = new Intent(Exercice5ActivityResult.this, Exercice5Activity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(Exercice5ActivityResult.this, MainActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }
            }
        });
    }
}