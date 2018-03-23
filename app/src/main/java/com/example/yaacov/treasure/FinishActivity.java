package com.example.yaacov.treasure;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.TextView;

import com.example.yaacov.treasure.R;

public class FinishActivity extends AppCompatActivity {
    private TextView title;
    private int cityId=1;
    private final String MY_PREFS_NAME="prfes";
    private SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finish);
        prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        cityId = prefs.getInt("CityId" , 1);
        title = findViewById(R.id.txtFinish);
        title.setText("ברוכים הבאים ל" + getCityName(cityId) + " נקודת הסיום של המירוץ למיליון");
    }

    private String getCityName(int cityId){
        Resources res = getResources();
        String[] cities = res.getStringArray(R.array.cities_array);
        return cities[cityId-1];
    }

    public boolean onKeyDown(int keyCode, KeyEvent event)  {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            Intent intent = new Intent(this, StartActivity.class);
            startActivity(intent);
            return true;
        }

        return super.onKeyDown(keyCode, event);

    }
}
