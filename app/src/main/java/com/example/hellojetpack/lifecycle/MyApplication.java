package com.example.hellojetpack.lifecycle;

import android.app.Application;

import androidx.lifecycle.ProcessLifecycleOwner;

public class MyApplication  extends Application {


  @Override
  public void onCreate() {
    super.onCreate();

    ApplicationObserver observer = new ApplicationObserver();

    ProcessLifecycleOwner.get().getLifecycle().addObserver(observer);
  }
}
