package fr.android.androidexercises;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Step1Fragment extends Fragment {

    private OnNextStep1Listener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (OnNextStep1Listener) context;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_step1, container, false);
        Button nextButton = (Button) view.findViewById(R.id.next1Button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onNext1();
            }
        });
        return view;
    }

    public interface OnNextStep1Listener {

        public void onNext1();

    }

}
