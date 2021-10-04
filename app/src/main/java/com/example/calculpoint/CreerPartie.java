package com.example.calculpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Telephony;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import java.io.Serializable;

import Model.Partie;

public class CreerPartie extends AppCompatActivity {

    private Button quitter;
    private Button lancerPartie;
    private Button changerScoreLimite;
    private Button ajouterJoueur;
    private Partie partie = new Partie();
    private LinearLayout listeJoueur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("APPLICATION LOG - On lance l'accueil de la partie");

        //Suppression de la barre de titre de la vue
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_creer_partie);

        listeJoueur = (LinearLayout) findViewById(R.id.listeJoueur);

        //Définition des boutons et de leurs actions
        quitter = (Button) findViewById(R.id.quitter);
        /*
        quitter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });
        */
        lancerPartie = (Button) findViewById(R.id.lancerPartie);

        lancerPartie.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), Classement.class);
                intent.putExtra("partie", (Serializable) partie);
                startActivity(intent);
            }
        });

        changerScoreLimite = (Button) findViewById(R.id.changerScoreLimite);
        changerScoreLimite.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), ChangerScoreLimite.class);
                intent.putExtra("partie", (Parcelable) partie);
                startActivity(intent);
            }
        });

        ajouterJoueur = (Button) findViewById(R.id.ajouterJoueur);
        ajouterJoueur.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(), AjouterJoueur.class);
                intent.putExtra("partie", partie);
                startActivity(intent);
            }
        });


        //Mise sous condition de l'affichage du bouton 'lancer partie' si la liste de joueur est vide -> caché.
        if (partie.getListeJoueurs() != null) {
            lancerPartie.setVisibility(View.VISIBLE);
        }
    }
}