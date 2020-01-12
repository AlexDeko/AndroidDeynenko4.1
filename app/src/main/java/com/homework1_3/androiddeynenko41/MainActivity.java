package com.homework1_3.androiddeynenko41;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private final static String TITLE = "title";
    private final static String SUBTITLE = "subtitle";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        String[] content = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(content);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(String[] values) {
        List<Map<String, String>> simpleAdapterContent = new ArrayList<>();

        for (String value : values) {
            Map<String, String> row = new HashMap<>();
            row.put(TITLE, value);
            row.put(SUBTITLE, String.valueOf(value.length()));
            simpleAdapterContent.add(row);
        }
        return new SimpleAdapter(
                this,
                simpleAdapterContent,
                R.layout.lists,
                new String[]{TITLE, SUBTITLE},
                new int[]{R.id.textItem1, R.id.textItem2}
        );
    }

    @NonNull
    private String[] prepareContent() {
        return getString(R.string.large_text).split("\n\n");
    }
}