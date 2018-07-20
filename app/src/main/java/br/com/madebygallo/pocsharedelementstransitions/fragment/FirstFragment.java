package br.com.madebygallo.pocsharedelementstransitions.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import br.com.madebygallo.pocsharedelementstransitions.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by RaqGallo on 20/07/2018
 */

public class FirstFragment extends Fragment {

    @BindView(R.id.cat_button)
    Button catButton;

    @BindView(R.id.cat_image)
    ImageView catImage;

    public FirstFragment() {
    }

    public static android.support.v4.app.Fragment newInstance() {
        return new FirstFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        catButton.setOnClickListener(onClickCatButton());
    }

    private View.OnClickListener onClickCatButton() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextFragment fragment = NextFragment.newInstance();
                getFragmentManager()
                        .beginTransaction()
                        .addSharedElement(catImage, ViewCompat.getTransitionName(catImage))
                        .addToBackStack("Back to FirstFragment")
                        .replace(R.id.content, fragment)
                        .commit();
            }
        };
    }
}
