package fr.iut2.androidtp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

public class Exercice4Activity extends AppCompatActivity implements View.OnClickListener {

    Button btnValider;
    EditText prenom;
    public static final String MESSAGE = "msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // On charge le XML pour créer l'arbre graphique
        setContentView(R.layout.activity_exercice4);

        prenom = (EditText) findViewById(R.id.exercice4_prenom);
        btnValider = (Button) findViewById(R.id.exercice4_button);
        btnValider.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(Exercice4Activity.this, HelloActivity.class);
        intent.putExtra(HelloActivity.PRENOM_KEY, prenom.getText().toString());
        activityResultLauncher.launch(intent);
    }

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent intent = result.getData();
                        String msg = intent.getStringExtra(Exercice4Activity.MESSAGE);
                        prenom.setText("");
                        Toast.makeText(Exercice4Activity.this, msg, Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(Exercice4Activity.this, "Boutton back", Toast.LENGTH_SHORT).show();
                    }
                }
            }
    );
}
