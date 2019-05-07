package com.example.csc300yelpapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static List<String> listVals;
    public static ArrayAdapter<String> aa;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listVals = new ArrayList<>();
        aa = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listVals);
        ListView lv = findViewById(R.id.lV);
        lv.setAdapter(aa);
        YelpAPI yelp = new YelpAPI();
        yelp.start();
    }

    public void onClickGrabItems(View v)
    {
        aa.notifyDataSetChanged();
    }
}
