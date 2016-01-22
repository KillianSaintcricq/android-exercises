package fr.android.androidexercises;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class LibraryActivity extends AppCompatActivity implements Step0Fragment.OnNextStep0Listener,
        Step1Fragment.OnNextStep1Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        boolean landscape = getResources().getBoolean(R.bool.landscape);

        View fragment1 = findViewById(R.id.containerFrameLayout2);

        if (landscape) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout, new Step0Fragment(), Step0Fragment.class.getSimpleName())
                    .commit();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout2, new Step1Fragment(), Step1Fragment.class.getSimpleName())
                    .commit();
            fragment1.setVisibility(View.VISIBLE);
        } else {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFrameLayout, new Step0Fragment(), Step0Fragment.class.getSimpleName())
                    .commit();
            fragment1.setVisibility(View.GONE);
        }

    }

    @Override
    public void onNext() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, new Step1Fragment(), Step1Fragment.class.getSimpleName())
                .addToBackStack(Step0Fragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void onNext1() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, new Step2Fragment(), Step2Fragment.class.getSimpleName())
                .addToBackStack(Step1Fragment.class.getSimpleName())
                .commit();
    }

}
