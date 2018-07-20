package br.com.madebygallo.pocsharedelementstransitions.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import br.com.madebygallo.pocsharedelementstransitions.R;
import br.com.madebygallo.pocsharedelementstransitions.fragment.FirstFragment;

/**
 * Created by RaqGallo on 20/07/2018
 */

public class FirstFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_fragment);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.content, FirstFragment.newInstance())
                .commit();
    }
}
