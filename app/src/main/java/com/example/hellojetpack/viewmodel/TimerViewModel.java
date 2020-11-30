package com.example.hellojetpack.viewmodel;

import androidx.lifecycle.ViewModel;

import java.util.Timer;
import java.util.TimerTask;

public class TimerViewModel extends ViewModel {

  private Timer timer;
  private int currentSecond;

  /**
   * 开始计时
   */
  public void startTiming() {
    if (timer == null) {
      currentSecond = 0;
      timer = new Timer();
      TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
          currentSecond++;
          if (onTimeChangesListener != null) {
            onTimeChangesListener.onTimeChanged(currentSecond);
          }
        }
      };
      timer.schedule(timerTask,1000,1000);
    }
  }

  /**
   * 通过接口的方式，完成对调用者的通知
   * 实际上这种方式不是很好，更好的方式是通过LiveData组件来实现
   */
  public interface OnTimeChangListener {
    void onTimeChanged(int second);
  }

  private OnTimeChangListener onTimeChangesListener;

  public void setOnTimeChangesListener(OnTimeChangListener onTimeChangesListener) {
    this.onTimeChangesListener = onTimeChangesListener;
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
