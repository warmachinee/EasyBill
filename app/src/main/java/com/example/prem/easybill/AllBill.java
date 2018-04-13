package com.example.prem.easybill;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class AllBill extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_bill);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AllBill.this, MainActivity.class));
                overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
            }
        });
        ListView listView =(ListView)findViewById(R.id.Transfer);
        ArrayList<String> cname = new ArrayList<>();
        ArrayList<String> trans = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();
        ArrayList<Integer> dayleft = new ArrayList<>();
        for(int i=0;i<=10;i++){
            cname.add("Krungsri Bank");
            trans.add("Electric & Gas");
            amount.add(i*100);
            dayleft.add(i);
        }
        StockList stockList = new StockList(getApplicationContext(),cname,trans,amount,dayleft);
        listView.setAdapter(stockList);
    }

}
