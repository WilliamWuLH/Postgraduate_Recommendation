package com.example.postgraduaterecommendation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvmain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRvmain = findViewById(R.id.rv_main);
        mRvmain.setLayoutManager(new LinearLayoutManager(this));
        mRvmain.setAdapter(new LinearAdapter(this));
    }
}
