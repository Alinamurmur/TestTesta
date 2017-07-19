package com.example.alina.testtesta;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends AppCompatActivity {

    String url = "https://pp.userapi.com/c837522/v837522759/4976d/d29djluWTiE.jpg";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imf = (ImageView)findViewById(R.id.Img);
      //  new DownloadImageTask(imf).execute("https://cs7064.userapi.com/c540100/v540100555/2f850/c-IcE9427A4.jpg");
//
     //  imf.setImageURI(Uri.parse(url));

     //   Uri imgUri=Uri.parse("file:///data/data/MYFOLDER/myimage.png");

       // imf.setImageURI(imgUri);

        //Bitmap bitmap = BitmapFactory.decodeStream((InputStream)new URL("https://pp.userapi.com/c837522/v837522759/4976d/d29djluWTiE.jpg").getContent());
      //  imf.setImageBitmap(bitmap);


        //Работаем с Picasso
        Picasso.with(this)
                //Загружаем изображение через его адрес URL:
                .load("https://pp.userapi.com/c840222/v840222710/17fb1/lCXP7ih2IYU.jpg")
                //Настраиваем изображение, которое отобразится в случае ошибки при загрузке:
                .error(R.drawable.akvapark)
                //Через команду placeholder мы задаем изображение, которое будет
                //отображаться до тех пор, пока не загрузятся необходимые изображения:
                .placeholder(R.drawable.backend)
                //Показываем его в объекте ImageView:
                .into(imf);


    }
     Bitmap getImageBitmap(String url) {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
           // Log.e(TAG, "Error getting bitmap", e);
        }
        return bm;
    }

    public void onClick(View view) {
        Context context = getApplicationContext();

        Intent intent = new Intent(this,Test.class);
        startActivity(intent);

    }

    public void onClick2(View view) {
        Intent intent = new Intent(this, ActivityTab.class);
        startActivity(intent);

    }

    public void onClick3(View view) {
        Intent intent = new Intent(this, Contacts.class);
        startActivity(intent);

    }

    }