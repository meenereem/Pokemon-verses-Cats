package com.example.meenereem.searchforfun;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetPokepun extends AppCompatActivity {
    private class BitmapMaker extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            String urlStr = params[0];
            try {
                URL url = new URL(urlStr);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream input = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(input);
                return myBitmap;
            } catch (IOException e) {
                // Log exception
                return null;
            }
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ImageView img = (ImageView) findViewById(R.id.Drawable);
            img.setImageBitmap(bitmap);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_pokepun);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);}



    public void onClickImage(View v) {
        ImageView obj = (ImageView) findViewById(R.id.Drawable);
        String nextUrl = MainActivity.getNextUrl();
        Glide.with(this).load(nextUrl).into(obj);
        TextView object = (TextView) findViewById(R.id.textView);
        object.setText(MainActivity.pointCounter());
        TextView objMax = (TextView) findViewById(R.id.textView4);
        objMax.setText(MainActivity.maxPointCounter());
    }

}
