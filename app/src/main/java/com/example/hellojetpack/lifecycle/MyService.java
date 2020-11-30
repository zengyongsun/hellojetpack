package com.example.hellojetpack.lifecycle;

import android.content.Intent;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.lifecycle.LifecycleService;

public class MyService extends LifecycleService {

  private static final String TAG = MyService.class.getSimpleName();

  @Override
  public void onCreate() {
    super.onCreate();
    Log.d(TAG, "onCreate: ");

    MyServiceObserver observer = new MyServiceObserver();

    getLifecycle().addObserver(observer);
  }

  @Override
  public int onStartCommand(@Nullable Intent intent, int flags, int startId) {
    return super.onStartCommand(intent, flags, startId);

  }

  @Override
  public void onDestroy() {
    super.onDestroy();
    Log.d(TAG, "onDestroy: ");
  }
}
