package com.example.calculpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class Classement extends AppCompatActivity {

    Button ajouterScore;
    Button quitter;
    LinearLayout listeJoueur;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("APPLICATION LOG - On affiche le classement de la partie");

        //Suppression de la barre de titre de la vue
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_classement);

        listeJoueur = (LinearLayout) findViewById(R.id.listeJoueur);
        ajouterScore = (Button) findViewById(R.id.ajouterScore);
        quitter = (Button) findViewById(R.id.quitter);
    }
}