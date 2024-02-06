package fr.iut2.androidtp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class Exercice3Activity extends AppCompatActivity {

    ImageView pcPaper, pcRock, pcSicor, myPaper, myRock, mySicor;
    TextView result, nbWin, nbLose, nbNul;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice3);

        // PC
        pcPaper = (ImageView) findViewById(R.id.pcPaper);
        pcRock = (ImageView) findViewById(R.id.pcRock);
        pcSicor = (ImageView) findViewById(R.id.pcSicor);

        // PLayer
        myPaper = (ImageView) findViewById(R.id.myPaper);
        myRock = (ImageView) findViewById(R.id.myRock);
        mySicor = (ImageView) findViewById(R.id.mySicor);

        // text
        result = (TextView) findViewById(R.id.result);
        nbWin = (TextView) findViewById(R.id.nbWin);
        nbLose = (TextView) findViewById(R.id.nbLose);
        nbNul = (TextView) findViewById(R.id.nbNul);


    }

}
