package br.com.madebygallo.pocsharedelementstransitions.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import br.com.madebygallo.pocsharedelementstransitions.R;
import br.com.madebygallo.pocsharedelementstransitions.fragment.FirstFragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.activity_button)
    Button activityButton;

    @BindView(R.id.fragment_button)
    Button fragmentButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        activityButton.setOnClickListener(onClickActivityButton());
        fragmentButton.setOnClickListener(onClickFragmentButton());
    }

    private View.OnClickListener onClickActivityButton() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(MainActivity.this, FirstActivity.class);
            }
        };
    }

    private View.OnClickListener onClickFragmentButton() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewActivity(MainActivity.this, FirstFragmentActivity.class);
            }
        };
    }

    private void startNewActivity(MainActivity currentClass, Class nextClass) {
        Intent intent = new Intent(currentClass, nextClass);
        startActivity(intent);
    }
}
