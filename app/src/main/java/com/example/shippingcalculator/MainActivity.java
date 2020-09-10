package com.example.shippingcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText weightET;
    ShipItem shipItem;
    TextView baseTV, addedTV, totalTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weightET = (EditText)findViewById(R.id.editText_weight);
        shipItem = new ShipItem();
        baseTV = (TextView)findViewById(R.id.base_cost_TextView);
        addedTV = (TextView)findViewById(R.id.added_cost_TextView);
        totalTV = (TextView)findViewById(R.id.total_cost_TextView);





        weightET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //leave empty
            }

            @Override
            public void onTextChanged(CharSequence sequence, int i, int i1, int i2) {
                try {
                     shipItem.setWeight(Double.parseDouble(sequence.toString()));
                } catch(NumberFormatException e) {
                     shipItem.setWeight(0.0);
                }
                displayShipping();
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //leave empty
            }
        });
    }
    public void displayShipping() {
        String base = String.format("$ %.2f", shipItem.getBaseCost());
        baseTV.setText(base);
        String added = String.format("$ %.2f", shipItem.getAddedCost());
        addedTV.setText(added);
        String total = String.format("$ %.2f", shipItem.getTotalCost());
        totalTV.setText(total);
    }



}
