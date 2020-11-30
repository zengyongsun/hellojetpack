package com.example.hellojetpack.lifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.hellojetpack.R;


/**
 * Lifecycle的基础使用
 */
public class LifeDemoActivity extends AppCompatActivity implements View.OnClickListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_life_demo);
    findViewById(R.id.btStart).setOnClickListener(this);
    findViewById(R.id.btStop).setOnClickListener(this);

    MyLocationListener mListener = new MyLocationListener(new MyLocationListener.OnLocationListener() {
      @Override
      public void onChanged(double latitude, double longitude) {
        Log.d("MyLocationListener", "onChanged: " + latitude + " : " + longitude);
      }
    });

    //将观察这与被观察者绑定
    getLifecycle().addObserver(mListener);
  }

  @Override
  public void onClick(View v) {
    int id = v.getId();
    switch (id) {
      case R.id.btStart:
        startService(new Intent(this, MyService.class));
        break;
      case R.id.btStop:
        stopService(new Intent(this, MyService.class));
        break;
    }
  }
}