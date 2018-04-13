package com.example.prem.easybill;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //overridePendingTransition(R.anim.move_left_in_activity, R.anim.move_right_out_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        final ImageButton home = (ImageButton)findViewById(R.id.home);
        final ImageButton stock = (ImageButton) findViewById(R.id.Transfer);
        final ImageButton menu = (ImageButton) findViewById(R.id.menu);
        final ImageButton inbox = (ImageButton) findViewById(R.id.inbox);
        final TextView txtHome = (TextView)findViewById(R.id.txtHome);
        final TextView txtAllBill = (TextView)findViewById(R.id.txtAllBill);
        final TextView txtMenu = (TextView)findViewById(R.id.txtMenu);
        //Home initial
        home.setImageResource(R.drawable.ic_home_black_48dp);
        stock.setImageResource(R.drawable.ic_view_list_white_48dp);
        menu.setImageResource(R.drawable.ic_dashboard_white_48dp);
        txtHome.setTextColor(Color.BLACK);
        txtAllBill.setTextColor(Color.WHITE);
        txtMenu.setTextColor(Color.WHITE);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayout, new Fragment_amount());
        ft.commit();

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                home.setImageResource(R.drawable.ic_home_black_48dp);
                stock.setImageResource(R.drawable.ic_view_list_white_48dp);
                menu.setImageResource(R.drawable.ic_dashboard_white_48dp);
                txtHome.setTextColor(Color.BLACK);
                txtAllBill.setTextColor(Color.WHITE);
                txtMenu.setTextColor(Color.WHITE);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new Fragment_amount());
                ft.commit();

            }
        });
        stock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                home.setImageResource(R.drawable.ic_home_white_48dp);
                stock.setImageResource(R.drawable.ic_view_list_black_48dp);
                menu.setImageResource(R.drawable.ic_dashboard_white_48dp);
                txtHome.setTextColor(Color.WHITE);
                txtAllBill.setTextColor(Color.BLACK);
                txtMenu.setTextColor(Color.WHITE);
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.frameLayout, new Fragment_stock());
                ft.commit();

            }
        });
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                home.setImageResource(R.drawable.ic_home_white_48dp);
                stock.setImageResource(R.drawable.ic_view_list_white_48dp);
                menu.setImageResource(R.drawable.ic_dashboard_black_48dp);
                txtHome.setTextColor(Color.WHITE);
                txtAllBill.setTextColor(Color.WHITE);
                txtMenu.setTextColor(Color.BLACK);
                MenuDialog menuDialog = new MenuDialog(MainActivity.this);
                menuDialog.show();
            }
        });
        inbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                startActivity(new Intent(MainActivity.this,Inbox.class));
            }
        });

    }
    TextView countTxt;
    int mCount= 10;
    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        final MenuItem menuNoti = menu.findItem(R.id.action_noti);
        final MenuItem menuSet = menu.findItem(R.id.action_setting);
        View actionViewNoti = MenuItemCompat.getActionView(menuNoti);
        View actionViewSet = MenuItemCompat.getActionView(menuSet);
        countTxt = (TextView) actionViewNoti.findViewById(R.id.count);
        setupNotiCount();
        actionViewNoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onOptionsItemSelected(menuNoti);
            }
        });
        actionViewSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                onOptionsItemSelected(menuSet);
            }
        });
        return super.onCreateOptionsMenu(menu);
    }
    private void setupNotiCount() {

        if (countTxt != null) {
            if (mCount == 0) {
                if (countTxt.getVisibility() != View.GONE) {
                    countTxt.setVisibility(View.GONE);
                }
            } else {
                countTxt.setText(String.valueOf(Math.min(mCount, 99)));
                if (countTxt.getVisibility() != View.VISIBLE) {
                    countTxt.setVisibility(View.VISIBLE);
                }
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_noti:
                startActivity(new Intent(MainActivity.this,Notification.class));
                overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
                return true;
            case R.id.action_setting:
                startActivity(new Intent(MainActivity.this,Me.class));
                overridePendingTransition(R.anim.move_right_in_activity, R.anim.move_left_out_activity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
