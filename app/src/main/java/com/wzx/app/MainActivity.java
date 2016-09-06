package com.wzx.app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    private List<String> mDatas;
    private SimpleAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDatas();
        initResources();

    }

    private void initDatas() {
        mDatas = new ArrayList<>();
        for(int  i = 'A'; i <= 'z' ; i++){
            mDatas.add("" + (char)i);
        }
    }

    private void initResources() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        mAdapter = new SimpleAdapter(this,mDatas);

        recyclerView.setAdapter(mAdapter);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
    }

}
