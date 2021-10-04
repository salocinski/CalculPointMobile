package com.example.calculpoint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button quitter;
    private Button lancerPartie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("APPLICATION LOG - On lance l'application");

        //Suppression de la barre de titre de la vue
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        quitter = (Button) findViewById(R.id.quitter);
        quitter.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                finish();
            }
        });

        lancerPartie = (Button) findViewById(R.id.lancerPartie);
        lancerPartie.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                System.out.println("APPLICATION LOG - On lance la partie");
                Intent intent = new Intent(getApplicationContext(), CreerPartie.class);
                startActivity(intent);
            }
        });
    }


}