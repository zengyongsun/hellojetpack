package com.example.hellojetpack.livedata;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.hellojetpack.R;

public class LiveDataActivity extends AppCompatActivity {

  private static final String TAG = LiveDataActivity.class.getSimpleName();

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_live_data);
    initComponent();
  }

  private void initComponent() {
    final TextView textView = findViewById(R.id.tvTime);
    //通过 ViewModelProvider得到ViewModel
    TimerWithLiveDataViewModel timerViewModel = new ViewModelProvider(this)
            .get(TimerWithLiveDataViewModel.class);

    //得到 ViewModel 中的 LiveData
    final MutableLiveData<Integer> liveData =
            (MutableLiveData<Integer>) timerViewModel.getCurrentSecond();

    //通过 LiveData.observe() 观察ViewModel中数据的变化
    liveData.observe(this, new Observer<Integer>() {
      @Override
      public void onChanged(Integer integer) {
        //收到回调后，更新UI界面
        textView.setText("time:" + integer);
      }
    });

    //重置计时
    findViewById(R.id.btnResetTime).setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Log.d(TAG, "onClick:"+liveData.getValue());
        //通过LiveData.setValue() UI线程中
        // LiveData.postValue() 非UI线程
        // 完成对ViewModel中数据的更新
        liveData.setValue(0);
      }
    });

    timerViewModel.startTiming();
  }
}
