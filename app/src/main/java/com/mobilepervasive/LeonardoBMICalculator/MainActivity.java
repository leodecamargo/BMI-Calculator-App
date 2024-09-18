package com.mobilepervasive.LeonardoBMICalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText heightEditText;
    private EditText weightEditText;
    private TextView resultTextView;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        heightEditText = findViewById(R.id.editHeight_038);
        weightEditText = findViewById(R.id.editWeight_038);
        resultTextView = findViewById(R.id.resultTextView_038);
        calculateButton = findViewById(R.id.button_038);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = heightEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            resultTextView.setText("Please enter both height and weight.");
            return;
        }

        double height = Double.parseDouble(heightStr) / 100;
        double weight = Double.parseDouble(weightStr);

        if (height <= 0 || weight <= 0) {
            resultTextView.setText("The values must be greater than zero.");
            return;
        }

        double bmi = weight / (height * height);

        resultTextView.setText(String.format("Your BMI is %.4f", bmi));
    }
}