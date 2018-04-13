package com.example.prem.easybill;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment_amount extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_amount,container,false);
        ListView listView =(ListView)rootView.findViewById(R.id.list_item);
        ArrayList<String> cname = new ArrayList<>();
        ArrayList<String> trans = new ArrayList<>();
        ArrayList<Integer> amount = new ArrayList<>();
        ArrayList<Integer> dayleft = new ArrayList<>();
        for(int i=0;i<2;i++){
            cname.add("Krungsri Bank");
            trans.add("Electric & Gas");
            amount.add(i*100);
            dayleft.add(-i);
        }
        for(int j=2;j<=4;j++){
            cname.add("Krungsri Bank");
            trans.add("Electric & Gas");
            amount.add(j*100);
            dayleft.add(j);
        }
        AmountList amountList = new AmountList(getContext(),cname,trans,amount,dayleft);
        listView.setAdapter(amountList);
        return rootView;

    }
}
