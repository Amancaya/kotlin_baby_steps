package negron.kaya.kotlinbabysteps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.jetbrains.annotations.NotNull;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener, OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button = findViewById(R.id.btnPrueba);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void showOwner(@NotNull Owner nameOwner) {

    }

    @Override
    public void showHumanAge(@NotNull Pet pet) {

    }

    @Override
    public void clickCard() {

    }
}
