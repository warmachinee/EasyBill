package com.example.prem.easybill;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by PREM on 3/31/2018.
 */

public class AmountList extends BaseAdapter {
    ArrayList<String> cname;
    ArrayList<String> trans;
    ArrayList<Integer> amount;
    ArrayList<Integer> day;
    Context mContext;
    public AmountList(Context context,
                     ArrayList<String> CompanyName,
                     ArrayList<String> Transaction,
                     ArrayList<Integer> Amount,
                     ArrayList<Integer> DayLeft){
        this.mContext=context;
        this.trans=Transaction;
        this.amount=Amount;
        this.day=DayLeft;
        this.cname=CompanyName;
    }
    @Override
    public int getCount() {
        return trans.size();
    }

    @Override
    public Object getItem(final int i) {
        return null;
    }

    @Override
    public long getItemId(final int i) {
        return 0;
    }

    @Override
    public View getView(final int i, View view, final ViewGroup viewGroup) {
        LayoutInflater mInflater =
                (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if(view == null)
            view = mInflater.inflate(R.layout.stock_bloack, viewGroup, false);
        try {
            LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
            TextView textCName = (TextView) view.findViewById(R.id.cname);
            textCName.setText(cname.get(i));
            TextView textTrans = (TextView) view.findViewById(R.id.transaction);
            textTrans.setText(trans.get(i));
            TextView textAmount = (TextView) view.findViewById(R.id.amount);
            textAmount.setText(String.valueOf(amount.get(i))+" baht");
            TextView textDay = (TextView) view.findViewById(R.id.dayleft);
            textDay.setText(String.valueOf(day.get(i))+" Day");
            if(day.get(i)<3 && day.get(i)>0){
                linearLayout.setBackgroundColor(Color.rgb(255,214,0));
                textDay.setTextColor(Color.rgb(245,127,23));
            }else if(day.get(i)<=0){
                linearLayout.setBackgroundColor(Color.RED);
                textDay.setTextColor(Color.RED);
            }
            else {
                linearLayout.setBackgroundColor(Color.rgb(55,71,79));
                textDay.setTextColor(Color.rgb(38,50,56));
            }
        }catch (IndexOutOfBoundsException e){

        }

        return view;
    }
}
