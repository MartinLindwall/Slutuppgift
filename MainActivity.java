package com.example.slutuppgift;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button train;
    private Button bridge;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        train = (Button) findViewById(R.id.buttonTrain);
        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                opentrainActivity();
            }
        });

        bridge = (Button) findViewById(R.id.buttonBridge);
        bridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                openBridgeActivity();

            }
        });


    }
        public void opentrainActivity() {
            Intent intent = new Intent(this, trainActivity.class);
            startActivity(intent);
        }
        public void openBridgeActivity() {
            Intent intent = new Intent(this, BridgeActivity.class);
            startActivity(intent);
        }
}
