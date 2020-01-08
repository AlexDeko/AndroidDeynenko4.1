package com.homework1_3.androiddeynenko41;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ListView list = findViewById(R.id.list);

        List<Map<String, String>> values = prepareContent();

        BaseAdapter listContentAdapter = createAdapter(values);

        list.setAdapter(listContentAdapter);
    }

    @NonNull
    private BaseAdapter createAdapter(List<Map<String, String>> values) {
        List<String> keyList = new ArrayList<>();
        for (Iterator<Map<String, String>> it = values.iterator(); it.hasNext(); ) {
            Map<String, String> maps = it.next();
            for(String key :maps.keySet()){
                keyList.add(key);
            }
        }

        String[] keys = new String[keyList.toArray().length];
        for(int i = 0; i < keys.length; i++){
            keys[i] = keyList.get(i);
        }
            keyList.listIterator();

        return new SimpleAdapter(this, values, R.layout.lists,
                keys,new int[]{R.id.textItem1, R.id.textItem2});
    }

    @NonNull
    private List<Map<String, String>> prepareContent() {
        List<Map<String, String>> content = new ArrayList<>();
        Map<String, String> firstMap = new HashMap<>();
        String[] arrayContent = getString(R.string.large_text).split("\n\n");
        for (int i = 0; i <  arrayContent.length; i++ ){
            String number = getString(arrayContent[i].length());
            firstMap.put(arrayContent[i],number);
        }
        content.add(firstMap);
        return content;
    }

    @Override
    public String toString() {
        return "MainActivity{}";
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(@Nullable Object obj) {
        return super.equals(obj);
    }
}