package com.example.android_service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.Provider;

/**
 * Created by Mr.Chan
 * Time 2022-11-07
 * Blog https://www.cnblogs.com/Frank-dev-blog/
 */
public class MainService extends Service {
    private final String TAG = "TestService1";
    private Thread thread;

    //必须要实现的方法
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "onBind方法被调用!");
        return null;
    }

    //Service被创建时调用
    @Override
    public void onCreate() {
        Log.i(TAG, "thread have been init ed");
        thread=new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                //todo
                while (!thread.isInterrupted()){
                    workTime(1000);
                    Log.e("Service:", String.valueOf(++i));
                }
            }
        });
        super.onCreate();
    }

    //Service被启动时调用
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "thread started");
        thread.start();
        return super.onStartCommand(intent, flags, startId);
    }

    //Service被关闭之前回调
    @Override
    public void onDestroy() {
        thread.interrupt();
        Log.i(TAG, "thread stopped");
        super.onDestroy();
    }
    private static void workTime(long ms) {
        final long l = System.currentTimeMillis();
        while (System.currentTimeMillis() <= l + ms) {
        }
    }
}
