package com.example.astudiosqltest01;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    MainActivityViewModel viewModel;
    President president = new President();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnInsertPresident = findViewById(R.id.btnInsertPresident);
        TextView editInsertPresident = findViewById(R.id.editInsertPresident);
        TextView tvPresidents = findViewById(R.id.tvPresidents);

        viewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);

        viewModel.getPresidents().observe(this, new Observer<List<President>>() {
            @Override
            public void onChanged(@Nullable List<President> result) {
                String output="";
                for(President president : result) {
                    output+= president.getName() +"\n";
                }
                tvPresidents.setText(output);
            }
        });
    }
}