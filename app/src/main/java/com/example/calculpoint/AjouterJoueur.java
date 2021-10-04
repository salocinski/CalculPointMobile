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

import Model.Joueur;
import Model.Partie;

public class AjouterJoueur extends AppCompatActivity {

    Partie partie;
    Button valider;
    Button annuler;
    EditText saisie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("APPLICATION LOG - On lance la création d'un nouveau joueur");

        Intent intent = getIntent();
        partie = (Partie) intent.getSerializableExtra("partie");
        //Suppression de la barre de titre de la vue
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_ajouter_joueur);

        valider = (Button) findViewById(R.id.validerAjouterJoueur);
        valider.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                System.out.println("APPLICATION LOG - On valide l'ajout d'un joueur");
                String nomSaisie = saisie.getText().toString();
                Joueur joueur = new Joueur(nomSaisie);
                partie.ajouterJoueur(joueur);
                System.out.println("APPLICATION LOG - Nom du joueur ajouté : " + nomSaisie);

                Intent intent = new Intent(getApplicationContext(), CreerPartie.class);
                intent.putExtra("partie", partie);
                startActivity(intent);
            }
        });
        annuler = (Button) findViewById(R.id.annulerAjouterJoueur);
        annuler.setOnClickListener(new View.OnClickListener()
        {
           @Override
           public void onClick(View view)
           {
               Intent intent = new Intent(getApplicationContext(), CreerPartie.class);
               startActivity(intent);
           }
        });
        saisie = (EditText) findViewById(R.id.saisie);
        saisie.setHint("Saisir le nom du joueur");
    }
}