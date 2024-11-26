package com.example.hw_7;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_2);
        int data = getIntent().getIntExtra("result", 0) ;
        TextView textView = findViewById(R.id.text_ex);
        textView.setText(String.valueOf(data));

        Spinner spinner = findViewById(R.id.dropdown_menu);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.choice_color, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        Button buttonHeart = findViewById(R.id.heart_button);
        buttonHeart.setOnClickListener(v -> {
            if (buttonHeart.getBackground().getConstantState().equals(getResources().getDrawable(R.drawable.ic_heart).getConstantState())) {
                buttonHeart.setBackgroundResource(R.drawable.ic_heart_2);
            } else {
                buttonHeart.setBackgroundResource(R.drawable.ic_heart);
            }
        });
    }
}