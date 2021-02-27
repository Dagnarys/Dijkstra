package com.example.dijkstra;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {






    public static String Begin,End;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.Vertex);
        ImageView iv = findViewById(R.id.Vertex);
        iv.setImageResource(R.drawable.vertex);
        Button btn;

        btn = findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Resultat.class);
                startActivity(intent);

                EditText Start = findViewById(R.id.Start);
                Begin=Start.getText().toString();
                EditText Finish =findViewById(R.id.Finish);
                End=Finish.getText().toString();

            }
        });

    }


}