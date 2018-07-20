package br.com.madebygallo.pocsharedelementstransitions;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.dog_button)
    Button dogButton;

    @BindView(R.id.dog_image)
    ImageView dogImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        dogButton.setOnClickListener(onClickDogButton());
    }

    private View.OnClickListener onClickDogButton() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NextActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(
                                MainActivity.this,
                                dogImage,
                                ViewCompat.getTransitionName(dogImage));
                startActivity(intent, optionsCompat.toBundle());
            }
        };
    }
}
