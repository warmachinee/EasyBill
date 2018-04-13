package com.example.prem.easybill;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class InboxAdapter extends RecyclerView.Adapter<InboxAdapter.ViewHolder> {
    ArrayList<String> mBillFrom;
    ArrayList<String> mTrans;
    ArrayList<String> mCompany;
    ArrayList<String> mDate;
    ArrayList<Integer> mTotal;

    public InboxAdapter(final ArrayList<String> BillFrom
            ,ArrayList<String> Transaction
            ,ArrayList<String> CompanyName
            ,ArrayList<String> Date
            ,ArrayList<Integer> Total) {

        this.mBillFrom = BillFrom;
        this.mTrans = Transaction;
        this.mCompany = CompanyName;
        this.mDate = Date;
        this.mTotal = Total;
    }
    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inbox_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.txtBillFrom.setText(mBillFrom.get(position));
        holder.txtTrans.setText(mTrans.get(position));
        holder.txtCom.setText(mCompany.get(position));
        holder.txtDate.setText(mDate.get(position));
        holder.txtTotal.setText(String.valueOf(mTotal.get(position)));
    }

    @Override
    public int getItemCount() {
        return mTrans.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtBillFrom;
        public TextView txtTrans;
        public TextView txtCom;
        public TextView txtDate;
        public TextView txtTotal;
        public ViewHolder(final View itemView) {
            super(itemView);
            txtBillFrom = (TextView) itemView.findViewById(R.id.txtBillFrom);
            txtTrans = (TextView) itemView.findViewById(R.id.txtTrans);
            txtCom = (TextView) itemView.findViewById(R.id.txtCom);
            txtDate = (TextView) itemView.findViewById(R.id.txtD);
            txtTotal = (TextView) itemView.findViewById(R.id.txtT);
        }
    }
}
