package br.com.madebygallo.pocsharedelementstransitions.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import br.com.madebygallo.pocsharedelementstransitions.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RaqGallo on 20/07/2018
 */

public class FirstActivity extends AppCompatActivity {

    @BindView(R.id.dog_button)
    Button dogButton;

    @BindView(R.id.dog_image)
    ImageView dogImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        ButterKnife.bind(this);

        dogButton.setOnClickListener(onClickDogButton());
    }

    private View.OnClickListener onClickDogButton() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstActivity.this, NextActivity.class);
                ActivityOptionsCompat optionsCompat = ActivityOptionsCompat
                        .makeSceneTransitionAnimation(
                                FirstActivity.this,
                                dogImage,
                                ViewCompat.getTransitionName(dogImage));
                startActivity(intent, optionsCompat.toBundle());
            }
        };
    }
}
