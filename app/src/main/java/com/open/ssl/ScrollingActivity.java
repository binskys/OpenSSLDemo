package com.open.ssl;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.alley.openssl.util.JniUtils;


public class ScrollingActivity extends AppCompatActivity {

    private String TAG="===";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
      final TextView tv_title = (TextView) findViewById(R.id.tv_title);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        final JniUtils jni=new JniUtils();
        String title=tv_title.getText().toString();
        byte[] encodeAES = jni.encodeByAES((JniUtils.KEY).getBytes(), title.getBytes());
        String aesPsw = Base64.encodeToString(encodeAES, Base64.NO_WRAP);
        Log.i(TAG, "AES加密编码->" + aesPsw);
        Log.i(TAG, "AES加密编码长度：->" + aesPsw.length());

        byte[] decodeAES = jni.decodeByAES((JniUtils.KEY).getBytes(), encodeAES);
        Log.i(TAG, "AES解密->" + new String(decodeAES));
        Log.i(TAG, "AES解密后数据长度->" + new String(decodeAES).length());

        tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title=tv_title.getText().toString();
                byte[] encodeAES = jni.encodeByAES((JniUtils.KEY).getBytes(), title.getBytes());
                String aesPsw = Base64.encodeToString(encodeAES, Base64.NO_WRAP);
                Log.i(TAG, "AES加密编码->" + aesPsw);
                Log.i(TAG, "AES加密编码长度：->" + aesPsw.length());

                byte[] decodeAES = jni.decodeByAES((JniUtils.KEY).getBytes(), encodeAES);
                Log.i(TAG, "AES解密->" + new String(decodeAES));
                Log.i(TAG, "AES解密后数据长度->" + new String(decodeAES).length());


            }
        });
    }

}
