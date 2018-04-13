package com.example.prem.easybill;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;

public class MenuDialog extends Dialog {
    public Context mContext;
    public MenuDialog(@NonNull final Context context) {
        super(context);
        this.mContext = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_dialog);
        Button trans = (Button) findViewById(R.id.Transfer);
        trans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                //mContext.startActivity(new Intent(getContext(),AllBill.class));

            }
        });
    }
}
