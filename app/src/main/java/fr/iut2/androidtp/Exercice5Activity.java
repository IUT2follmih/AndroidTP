package fr.iut2.androidtp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;

import androidx.appcompat.app.AppCompatActivity;

public class Exercice5Activity extends AppCompatActivity {

    NumberPicker nbPicker;
    Button btnValider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice5);

        nbPicker = (NumberPicker) findViewById(R.id.nbPicker);
        nbPicker.setMaxValue(9);
        nbPicker.setMinValue(1);
        btnValider = (Button) findViewById(R.id.btnTable);

        btnValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Exercice5Activity.this, Exercice5ActvityAnswer.class);
                startActivity(intent);
            }
        });
    }
}
