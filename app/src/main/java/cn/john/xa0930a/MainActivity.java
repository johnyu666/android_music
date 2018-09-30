package cn.john.xa0930a;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player=new MediaPlayer();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void requestPerm(View view) {
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE)!= PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},1);

        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    public void play(View view) throws  Exception{
        String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/mp3/";
        Log.i("john",path+"...........");
        player.reset();
        player.setDataSource(path+"fish.mp3");
        player.prepare();
        Log.i("john",player.getDuration()+"......."+player.getCurrentPosition());
        player.start();
    }

    public void stop(View view) throws  Exception{
        String path= Environment.getExternalStorageDirectory().getAbsolutePath()+"/mp3/";
        File mp3Dir=new File(path);
        if(mp3Dir.isDirectory()){
            File[] fs=mp3Dir.listFiles();
            for (File f:fs){
                Log.i("john",f.getAbsolutePath());
            }

        }
    }
}
