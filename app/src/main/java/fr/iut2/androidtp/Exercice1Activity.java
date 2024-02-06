package fr.iut2.androidtp;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice1Activity extends AppCompatActivity implements View.OnClickListener {

    Button exo1Button;
    TextView exo1Hello;
    EditText exo1Prenom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice1);

        exo1Button = (Button) findViewById(R.id.exercice1_button);
        exo1Button.setOnClickListener(this);


    }

//    public void exerciceValider(View view) {
//        exo1Hello = (TextView) findViewById(R.id.exercice1_hello);
//        exo1Prenom = (EditText) findViewById(R.id.exercice1_prenom);
//
//        if (!TextUtils.isEmpty(exo1Prenom.getText())){
//            exo1Hello.setText("Hello " + exo1Prenom.getText() + " !");
//        }
//    }

    @Override
    public void onClick(View view) {
        exo1Hello = (TextView) findViewById(R.id.exercice1_hello);
        exo1Prenom = (EditText) findViewById(R.id.exercice1_prenom);

        if (!TextUtils.isEmpty(exo1Prenom.getText())) {
            exo1Hello.setText("Hello " + exo1Prenom.getText() + " !");
        }
    }
}
