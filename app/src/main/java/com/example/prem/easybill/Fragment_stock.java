package com.example.prem.easybill;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class Fragment_stock extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_stock,container,false);

        ListView listView =(ListView)rootView.findViewById(R.id.Transfer);
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
        StockList stockList = new StockList(getContext(),cname,trans,amount,dayleft);
        listView.setAdapter(stockList);
        return rootView;

    }
}
