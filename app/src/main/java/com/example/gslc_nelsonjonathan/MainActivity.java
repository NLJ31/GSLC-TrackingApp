package com.example.gslc_nelsonjonathan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ListView listView;
    private Button addBtn;
    private TextView totalCaloriesView;
    private ArrayList<Entry> enteries;
    private ArrayAdapter<Entry> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enteries = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, enteries);

        listView = findViewById(R.id.listView);
        totalCaloriesView = findViewById(R.id.totalCaloriesTextView);
        addBtn = findViewById(R.id.addBtn);

        listView.setAdapter(adapter);
        addBtn.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

    private void updateCalorieDisplay() {
        double totalCal = 0.0;

        for(Entry ent : enteries) {
            totalCal += ent.getCalories();
        }
        totalCaloriesView.setText("Total Calories" + totalCal);
    }

    public void add(Entry entry) {
        enteries.add(entry);
        adapter.notifyDataSetChanged();
        updateCalorieDisplay();
    }

    private void openAddEntryDialog() {
        DialogUtils.openAddEntryDialog(this, new DialogUtils.AddEntryListener() {
            @Override
            public void onAddEntry(String name, int amount, double calories) {
                FoodEntry newEntry = new FoodEntry(name, amount, calories);
                add(newEntry);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if(v == addBtn) {
            openAddEntryDialog();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if(view == listView){
            Entry entry = enteries.get(position);
            Toast.makeText(MainActivity.this, "Selected: " + entry.getDetails(), Toast.LENGTH_SHORT).show();
        }
    }
}