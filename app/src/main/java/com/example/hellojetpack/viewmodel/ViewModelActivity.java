package com.example.hellojetpack.viewmodel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.TextView;

import com.example.hellojetpack.R;

public class ViewModelActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_view_model);
    initComponent();
  }

  private void initComponent() {
    final TextView textView = findViewById(R.id.tvTime);
    TimerViewModel timerViewModel = new ViewModelProvider(this).get(TimerViewModel.class);
    timerViewModel.setOnTimeChangesListener(new TimerViewModel.OnTimeChangListener() {
      @Override
      public void onTimeChanged(final int second) {
        runOnUiThread(new Runnable() {
          @Override
          public void run() {
            textView.setText("TIME:" + second);
          }
        });
      }
    });
    timerViewModel.startTiming();
  }
}