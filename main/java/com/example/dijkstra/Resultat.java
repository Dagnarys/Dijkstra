package com.example.dijkstra;



import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultat extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultat);


        findViewById(R.id.Vertex);
        ImageView iv = findViewById(R.id.Vertex);
        iv.setImageResource(R.drawable.vertex);

        Button btn;
        String S = Main.main();
        TextView Result =(TextView)findViewById(R.id.Result) ;
        Result.setText(S);

        btn = (Button) findViewById(R.id.Back);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Resultat.this,MainActivity.class);
                startActivity(intent);

            }
        });
    }
}