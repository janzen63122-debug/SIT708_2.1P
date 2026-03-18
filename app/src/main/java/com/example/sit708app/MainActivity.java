package com.example.sit708app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText inputValue;
    private Spinner spinnerSource;
    private Spinner spinnerDest;
    private TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputValue = findViewById(R.id.inputValue);
        spinnerSource = findViewById(R.id.spinnerSource);
        spinnerDest = findViewById(R.id.spinnerDestination);
        Button btnConvert = findViewById(R.id.btnConvert);
        textResult = findViewById(R.id.textResult);


        btnConvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputStr = inputValue.getText().toString();
                if (inputStr.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                    return;
                }

                double value;
                try {
                    value = Double.parseDouble(inputStr);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid number format", Toast.LENGTH_SHORT).show();
                    return;
                }

                String sourceUnit = spinnerSource.getSelectedItem().toString();
                String destUnit = spinnerDest.getSelectedItem().toString();

                if (sourceUnit.equals(destUnit)) {
                    textResult.setText("Result: " + value + " " + destUnit);
                    Toast.makeText(MainActivity.this, "Identity conversion detected", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (value < 0 && (sourceUnit.equals("mpg") || sourceUnit.equals("Gallon") || sourceUnit.equals("Nautical Mile"))) {
                    Toast.makeText(MainActivity.this, "This value cannot be negative!", Toast.LENGTH_LONG).show();
                    return;
                }

                Double result = calculateConversion(sourceUnit, destUnit, value);
                if (result != null) {
                    if (sourceUnit.equals("mpg") || sourceUnit.equals("km/L") ||
                            sourceUnit.equals("Gallon") || sourceUnit.equals("Liters") ||
                            sourceUnit.equals("Nautical Mile") || sourceUnit.equals("Kilometers")) {
                        textResult.setText(String.format("Result: %.3f %s", result, destUnit));
                    } else {
                        textResult.setText(String.format("Result: %.2f %s", result, destUnit));
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Invalid conversion pair", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private Double calculateConversion(String source, String dest, double value) {
        if (source.equals("USD") && dest.equals("AUD")) return value * 1.55;
        if (source.equals("USD") && dest.equals("EUR")) return value * 0.92;
        if (source.equals("USD") && dest.equals("JPY")) return value * 148.50;
        if (source.equals("USD") && dest.equals("GBP")) return value * 0.78;
        if (source.equals("mpg") && dest.equals("km/L")) return value * 0.425;
        if (source.equals("Gallon") && dest.equals("Liters")) return value * 3.785;
        if (source.equals("Nautical Mile") && dest.equals("Kilometers")) return value * 1.852;
        if (source.equals("Celsius") && dest.equals("Fahrenheit")) return (value * 1.8) + 32;
        if (source.equals("Fahrenheit") && dest.equals("Celsius")) return (value - 32) / 1.8;
        if (source.equals("Celsius") && dest.equals("Kelvin")) return value + 273.15;
        return null;
    }
}