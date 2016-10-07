package com.inarts.inarts_user.data_network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class DataNetworkActivity extends AppCompatActivity {

    private TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_network);
        data = (TextView)findViewById(R.id.info_data);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                dataNetwork();
            }
        });
    }
    private void dataNetwork(){
        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = manager.getActiveNetworkInfo();
        if (info != null && info.isConnected()==true){
            data.setText("Network is Connected");
        }else{
            data.setText("Network is Disconnected");
        }
    }
}
