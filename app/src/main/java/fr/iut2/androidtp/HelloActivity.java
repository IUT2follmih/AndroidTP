package fr.iut2.androidtp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HelloActivity extends AppCompatActivity{

    public static final String PRENOM_KEY = "prenom_key";
    TextView helloText;
    Button nameChange, choseExo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        String prenom = getIntent().getStringExtra(PRENOM_KEY);

        helloText = (TextView) findViewById(R.id.hello_hello);
        nameChange = (Button) findViewById(R.id.hello_change);
        choseExo = (Button) findViewById(R.id.hello_exo);


        if (prenom == "prenom_key") {
            helloText.setText("Aucun prenom enregistré !");
        } else {
            helloText.setText("Hello " + prenom);
        }

        nameChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra(Exercice4Activity.MESSAGE,"Nouveau Prénom !");
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        choseExo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HelloActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
    }
}