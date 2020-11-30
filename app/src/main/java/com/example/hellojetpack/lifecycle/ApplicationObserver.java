package com.example.hellojetpack.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class ApplicationObserver implements LifecycleObserver {


  private static final String TAG = ApplicationObserver.class.getSimpleName();


  public ApplicationObserver() {
  }

  /**
   * 启动时调用，只调用一起
   */
  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  private void initLocationManager() {
    Log.d(TAG, "initLocationManager: onCreate");
  }

  /**
   * 进入前台调用
   */
  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  private void startGetLocation() {
    Log.d(TAG, "startGetLocation: OnResume");
  }


  /**
   * 应用进入后台调用
   */
  @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
  private void onPause() {
    //延迟，为了区分是不是配置改变，比如横竖屏切换
    Log.d(TAG, "onPause: onPause");
  }


  /**
   * 应用进入后台调用
   */
  @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
  private void onStop() {
    Log.d(TAG, "onStop: onStop");
  }

  /**
   * 这个永远不会调用
   */
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  private void stopGetLocation() {
    Log.d(TAG, "stopGetLocation: onDestroy");
  }


}
