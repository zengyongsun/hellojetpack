package com.example.hellojetpack;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.hellojetpack.lifecycle.LifeDemoActivity;
import com.example.hellojetpack.livedata.LiveDataActivity;
import com.example.hellojetpack.navigation.NavigationActivity;
import com.example.hellojetpack.viewmodel.ViewModelActivity;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    findViewById(R.id.openActivity).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, LiveDataActivity.class));
      }
    });
  }

}