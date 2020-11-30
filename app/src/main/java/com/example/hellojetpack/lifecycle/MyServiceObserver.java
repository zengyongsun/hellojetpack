package com.example.hellojetpack.lifecycle;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyServiceObserver implements LifecycleObserver {


  private static final String TAG = MyServiceObserver.class.getSimpleName();


  public MyServiceObserver() {
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  private void initLocationManager() {
    Log.d(TAG, "initLocationManager: onCreate");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  private void startGetLocation() {
    Log.d(TAG, "startGetLocation: OnResume");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  private void stopGetLocation() {
    Log.d(TAG, "stopGetLocation: onDestroy");
  }


}
