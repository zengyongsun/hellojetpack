package com.example.hellojetpack.lifecycle;

import android.app.Activity;
import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLocationListener implements LifecycleObserver {


  private static final String TAG = MyLocationListener.class.getSimpleName();

  private OnLocationListener mOnLocationListener;

  public MyLocationListener(OnLocationListener onLocationListener) {
    this.mOnLocationListener = onLocationListener;
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
  private void initLocationManager() {
    Log.d(TAG, "initLocationManager: onCreate");
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
  private void startGetLocation() {
    Log.d(TAG, "startGetLocation: OnResume");
    if (mOnLocationListener != null) {
      mOnLocationListener.onChanged(100, 200);
    }
  }

  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  private void stopGetLocation() {
    Log.d(TAG, "stopGetLocation: onDestroy");
  }

  public interface OnLocationListener {
    void onChanged(double latitude, double longitude);
  }

}
