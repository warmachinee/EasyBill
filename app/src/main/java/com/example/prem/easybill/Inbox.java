package com.example.prem.easybill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

public class Inbox extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inbox);
        overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Inbox.this, MainActivity.class));
                overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
            }
        });
        ArrayList<String> mBillFrom = new ArrayList<>();
        ArrayList<String> mTrans = new ArrayList<>();
        ArrayList<String> mCompany = new ArrayList<>();
        ArrayList<String> mDate = new ArrayList<>();
        ArrayList<Integer> mTotal = new ArrayList<>();
        for(int i =0;i<=4;i++){
            mBillFrom.add("A"+String.valueOf(i));
            mTrans.add("Elec"+String.valueOf(i));
            mCompany.add("Bank"+String.valueOf(i));
            mDate.add(String.valueOf(i+1)+" Mar 2018");
            mTotal.add(i*200);
        }

        LinearLayoutManager layoutManager
                = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new InboxAdapter(mBillFrom,mTrans,mCompany,mDate,mTotal);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(layoutManager);

    }
}
