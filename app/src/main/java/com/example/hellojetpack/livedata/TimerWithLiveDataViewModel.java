package com.example.hellojetpack.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerWithLiveDataViewModel extends ViewModel {

  private Timer timer;

  //将 currentSecond 这个字段用 MutableLiveData 包装起来
  private MutableLiveData<Integer> currentSecond;
  public LiveData<Integer> getCurrentSecond() {
    if(currentSecond == null) {
       currentSecond = new MutableLiveData<>();
    }
    return currentSecond;
  }
  public int index = 0;

  /**
   * 开始计时
   */
  public void startTiming() {
    if (timer == null) {
      currentSecond.setValue(index);
      timer = new Timer();
      TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
          currentSecond.postValue(index++);
        }
      };
      timer.schedule(timerTask,1000,1000);
    }
  }

  /**
   * 清理资源
   */
  @Override
  protected void onCleared() {
    super.onCleared();
    timer.cancel();
  }
}
