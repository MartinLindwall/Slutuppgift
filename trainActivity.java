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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import java.util.Random;

public class trainActivity extends AppCompatActivity {

    ImageView imageView;
    Drawable drawable;
    Bitmap bitmap;
    int number;

    private Button nr14;
    private Button nr28;
    private Button nr42;

    public void generate(View view) {
        Random random = new Random();
        number = random.nextInt(3) + 1;
        TextView myText = (TextView)findViewById(R.id.textView);
        String myString = String.valueOf(number);
        myText.setText(myString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        imageView = (ImageView) findViewById(R.id.train);

        drawable = ContextCompat.getDrawable(this, R.drawable.train);
        bitmap = ((BitmapDrawable) drawable).getBitmap();
        Bitmap newBitmap = convertImage(bitmap);
        imageView.setImageBitmap(newBitmap);

        nr14 = (Button) findViewById(R.id.buttonAns1);
        nr14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number == 1)
                    openshowTrain();
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Seriously? You failed math, didn't you?", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        nr28 = (Button) findViewById(R.id.buttonAns2);
        nr28.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number == 2)
                    openshowTrain();
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Seriously? You failed in math, didn't you?", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
        nr42 = (Button) findViewById(R.id.buttonAns3);
        nr42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (number == 3)
                    openshowTrain();
                else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Seriously? You failed in math, didn't you?", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });
    }


    public static Bitmap convertImage(Bitmap original) {
        Bitmap finalImage = Bitmap.createBitmap(original.getWidth(), original.getHeight(), original.getConfig());

        int A, R, G, B;
        int colorPixel;
        int width = original.getWidth();
        int height = original.getHeight();

        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                colorPixel = original.getPixel(x, y);
                A = Color.alpha(colorPixel);
                R = Color.red(colorPixel);
                G = Color.green(colorPixel);
                B = Color.blue(colorPixel);

                R = (R + G + B) / 3;

                finalImage.setPixel(x, y, Color.argb(A, R, G, B));
            }
        }


        return finalImage;
    }


    public void openshowTrain() {
        Intent intent = new Intent(this, showTrain.class);
        startActivity(intent);
    }
}
