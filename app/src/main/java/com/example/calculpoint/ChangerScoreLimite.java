package com.example.calculpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import Model.Partie;

public class ChangerScoreLimite extends AppCompatActivity {

    private Button validerScoreLimite;
    private Button annulerScoreLimite;
    private EditText saisieScoreLimite;
    private Partie partie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        partie = getIntent().getParcelableExtra("partie");
        System.out.println("APPLICATION LOG - Modification du score limite");

        //Suppression de la barre de titre de la vue
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        saisieScoreLimite = (EditText) findViewById(R.id.saisieScoreLimite);

        validerScoreLimite = (Button) findViewById(R.id.changerScoreLimite);
        validerScoreLimite.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String valeurSaisie = saisieScoreLimite.getText().toString();
                System.out.println("APPLICATION LOG - Score limite modifié : " + valeurSaisie);
                partie.setScoreLimite(Integer.parseInt(valeurSaisie));
                Intent intent = new Intent(getApplicationContext(), CreerPartie.class);
                intent.putExtra("partie", partie);
                startActivity(intent);
            }
        });
        annulerScoreLimite = (Button) findViewById(R.id.annulerScoreLimite);
        annulerScoreLimite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), CreerPartie.class);
                System.out.println("APPLICATION LOG - Annulation modification du score limite");
                intent.putExtra("partie", (Parcelable) partie);
                startActivity(intent);
            }
        });
    }
}