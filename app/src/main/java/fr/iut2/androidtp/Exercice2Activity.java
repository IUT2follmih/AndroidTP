package fr.iut2.androidtp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Exercice2Activity extends AppCompatActivity implements View.OnClickListener {

    TextView exo2Hello;
    RadioGroup exo2RadioG;
    Button exo2Button;
    String bonneReponse;
    String mauvaiseReponse1;
    String mauvaiseReponse2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice2);

        exo2Hello = (TextView) findViewById(R.id.exercice2_hello);
        exo2RadioG = (RadioGroup) findViewById(R.id.exercice2_radioGroup);
        exo2Button = (Button) findViewById(R.id.exercice2_button);
        exo2Button.setOnClickListener(this);

        bonneReponse = "+10 pour les enseignants";
        mauvaiseReponse1 = "0 match nul";
        mauvaiseReponse2 = "+1 pour les étudiants";

        ArrayList<String> reponses = new ArrayList<>();
        reponses.add(bonneReponse);
        reponses.add(mauvaiseReponse1);
        reponses.add(mauvaiseReponse2);

        Collections.shuffle(reponses);

        for (int i = 0; i < reponses.size(); i++) {
            RadioButton button = (RadioButton) exo2RadioG.getChildAt(i);
            button.setText(reponses.get(i));
        }
    }

    @Override
    public void onClick(View view) {

        if (exo2RadioG.getCheckedRadioButtonId() == -1) {
            exo2Hello.setText("Veuillez selectionner une réponse !");
        } else {
            RadioButton selectedButton = (RadioButton) findViewById(exo2RadioG.getCheckedRadioButtonId());
            if (selectedButton.getText().equals(bonneReponse)) {
                exo2Hello.setText("Bonne réponse !");
            } else {
                exo2Hello.setText("Mauvaise réponse !");
            }
        }
    }
}
