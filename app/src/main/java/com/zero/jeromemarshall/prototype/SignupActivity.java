package com.zero.jeromemarshall.prototype;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class SignupActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner spinnerState, spinnerCity, spinnerChapter;
    ImageButton signup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        spinnerState = (Spinner) findViewById(R.id.StateSpinner);
        spinnerCity = (Spinner) findViewById(R.id.CitySpinner);
        spinnerChapter = (Spinner) findViewById(R.id.ChapterSpinner);

        ArrayAdapter adapterChapter = ArrayAdapter.createFromResource(this, R.array.chapter, android.R.layout.simple_list_item_1);
        spinnerChapter.setAdapter(adapterChapter);

        ArrayAdapter adapterState = ArrayAdapter.createFromResource(this, R.array.states, android.R.layout.simple_list_item_1);
        spinnerState.setAdapter(adapterState);
        spinnerState.setOnItemSelectedListener(this);

        signup = (ImageButton) findViewById(R.id.SignupButton);
        signup.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String stateName = spinnerState.getSelectedItem().toString();
        switch (stateName) {
            case "Karnataka": {
                ArrayAdapter adapterCity = ArrayAdapter.createFromResource(this, R.array.karnataka, android.R.layout.simple_list_item_1);
                spinnerCity.setAdapter(adapterCity);
                break;
            }
            case "Kerala": {
                ArrayAdapter adapterCity = ArrayAdapter.createFromResource(this, R.array.kerala, android.R.layout.simple_list_item_1);
                spinnerCity.setAdapter(adapterCity);
                break;
            }
            case "Tamil Nadu": {
                ArrayAdapter adapterCity = ArrayAdapter.createFromResource(this, R.array.tamilnadu, android.R.layout.simple_list_item_1);
                spinnerCity.setAdapter(adapterCity);
                break;
            }
            case "Choose a State": {
                ArrayAdapter adapterCity = ArrayAdapter.createFromResource(this, R.array.valid, android.R.layout.simple_list_item_1);
                spinnerCity.setAdapter(adapterCity);
                break;
            }
        }
    }



    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.SignupButton: {
                Intent signupintent = new Intent(this, SignupCompletedActivity.class);
                startActivity(signupintent);
                break;
            }
        }
    }
}
