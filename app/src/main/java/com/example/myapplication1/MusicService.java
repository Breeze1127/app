package com.example.myapplication1;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaParser;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

public class MusicService extends Service {

    private MediaPlayer mediaPlayer;
    Context context;

    public MusicService() {
        context=this;
        Log.d("wxw","MusicServece...");
//        mediaPlayer= MediaPlayer.create(this,R.raw.music1);
//        mediaPlayer.start();
//        //mediaPlayer.stop();
    }

    @Override
    public void onCreate(){
        super.onCreate();
        //加载音乐文件
        mediaPlayer=MediaPlayer.create(this,R.raw.music3);
        mediaPlayer.setLooping(true);//设置循环播放
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // 服务启动时调用
        // 初始化 mediaPlayer 对象
//        Log.d("wxw","MusicServece:onStartCommand......");
//        mediaPlayer = MediaPlayer.create(this,R.raw.music1);
//        mediaPlayer.start();
//        return super.onStartCommand(intent, flags, startId);
        if(!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            Log.d("wxw","MusicServece:onStartCommand......");
        }
        return START_STICKY;

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("wxw","MusicServece:onDestroy...");
        mediaPlayer.stop();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        // throw new UnsupportedOperationException("Not yet implemented");
        Log.d("wxw","MusicOnbind...");
        Mybinder binder=new Mybinder();
        return binder ;
    }

    public class Mybinder extends Binder{
        public Mybinder() {

        }

        public void todo() {
            Log.d("wxw", "MusicServece:todo()...");
            mediaPlayer = MediaPlayer.create(context, R.raw.music3);
            mediaPlayer.start();
        }
    }

}
