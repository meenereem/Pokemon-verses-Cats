package com.example.meenereem.searchforfun;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static int points = 0 ;
    private static int maxPoints = 0;
    private static Card[] Rng = {
            new Card("https://images.encyclopediadramatica.se/b/bd/Halp.jpg", 1),
            new Card("https://i.kinja-img.com/gawker-media/image/upload/juk9ovwejflnhhmbgiql.png", 1),
            new Card("http://cdn.bulbagarden.net/upload/thumb/3/3b/460Abomasnow.png/250px-460Abomasnow.png", -1),
            new Card("https://s-media-cache-ak0.pinimg.com/736x/cb/fc/ac/cbfcac6e455f1d0d57b6a23ce82b8593.jpg", 0),
            new Card("http://www.funny-animalpictures.com/media/content/items/images/funnydogs0028_O.jpg", 0),
            new Card("https://i.ytimg.com/vi/Ea8rOZyawIs/hqdefault.jpg", 0),
            new Card("http://images1.fanpop.com/images/image_uploads/Funny-Cat-Pictures-cats-935656_500_375.jpg", 1),
            new Card("https://i.ytimg.com/vi/tntOCGkgt98/maxresdefault.jpg", 1),
            new Card("https://i.ytimg.com/vi/icqDxNab3Do/maxresdefault.jpg", 1),
            new Card("http://beforeitsnews.com/contributor/upload/486248/images/11-10-12-caturday-funny-cat-photos3.jpg_pagespeed_ce__IIaUv8H4OOpSp5X-7Rkr.jpg",1),
            new Card("http://www.funny-animalpictures.com/media/content/items/images/funnycats0011_O.jpg", 1),
            new Card("http://www.funcatpictures.com/wp-content/uploads/2014/08/funny-cat-pictures-not-obese.jpg",1),
            new Card("https://mydoggys.files.wordpress.com/2012/04/funny-dog-lovers.png",0),
            new Card("http://cdn.bulbagarden.net/upload/thumb/6/62/063Abra.png/250px-063Abra.png",-1),
            new Card("http://cdn.bulbagarden.net/upload/thumb/c/ce/Alomomola_anime.png/250px-Alomomola_anime.png",-1),
            new Card("http://img15.deviantart.net/fc0d/i/2015/204/7/3/mega_amoonguss_by_deeler88-d92h3jq.jpg",-1),
            new Card("http://orig06.deviantart.net/8141/f/2013/276/9/e/aromatisse_by_windflite-d6p3gnm.png",-1),
            new Card("http://cdn.bulbagarden.net/upload/thumb/3/3a/Bronzor-bronzong.png/200px-Bronzor-bronzong.png",-1),
            new Card("http://pre08.deviantart.net/e56b/th/pre/i/2012/268/c/f/50_pokemon__18_buizel_by_megbeth-d5fv298.png",-1),
            new Card( "http://img10.deviantart.net/384f/i/2012/084/0/3/butterfree_by_saito_800-d4tunn1.png",-1),
            new Card("http://cdn.bulbagarden.net/upload/thumb/a/a7/420Cherubi.png/250px-420Cherubi.png",-1),
            new Card("http://cdn.bulbagarden.net/upload/thumb/b/bf/152Chikorita.png/250px-152Chikorita.png",-1),
            new Card("http://orig05.deviantart.net/90ab/f/2011/162/6/b/darkrai_v_3_by_xous54-d3inty9.png",-1),
            new Card("http://cdn.bulbagarden.net/upload/thumb/c/c6/094Gengar.png/250px-094Gengar.png", -1),
            new Card("http://cdn.bulbagarden.net/upload/thumb/1/1b/146Moltres.png/250px-146Moltres.png", -1),
            new Card("http://www.writeups.org/img/fiche/1254.jpg", -1),
            new Card("http://static.pokemonpets.com/images/monsters-images-300-300/143-Snorlax.png", -1),
            new Card("http://cdn.bulbagarden.net/upload/thumb/8/8c/Tierno_Squirtle.png/250px-Tierno_Squirtle.png", -1),
            new Card("http://www.silver-islands.com/media/pokemon-art/cyndaquil.png", -1),
            new Card("http://webclasses.qrsd.org/~mfrekey/hitmonlee.png", -1),
            new Card("http://picsportray.com/wp-content/uploads/2015/06/funny-dog-i-dunno-lol.jpg", 0),
            new Card("http://webclasses.qrsd.org/~mfrekey/hitmonlee.png", -1),
            new Card("https://s-media-cache-ak0.pinimg.com/236x/b0/30/cf/b030cf085c09104d8c07a9402e2f6dc5.jpg", 0),
            new Card("http://petsfans.com/wp-content/uploads/2014/11/edfsaf.jpg", 1),
            new Card("http://www.top13.net/wp-content/uploads/2015/10/perfectly-timed-funny-cat-pictures-5.jpg", 1),
            new Card("http://images.dailydawdle.com/11-9-13-caturday-hilarious-funny-cat-photos2.jpg", 1)

    };
    public static int ranIndex = 0;

    public static String getNextUrl() {
        String url = Rng[ranIndex].getString();
        points += Rng[ranIndex].getPointVal();
        if(points > maxPoints){
            points = maxPoints;
        }
        ranIndex = (ranIndex + 1) % Rng.length;
        if(ranIndex% 5 == 0){
            shuffleArray(Rng);
        }
        return url;
    }
    public static String pointCounter(){
        return Integer.toString(points);
    }

    public static String maxPointCounter(){
        return Integer.toString(maxPoints);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    static void shuffleArray(Card[] ar)
    {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            Card a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        shuffleArray(Rng);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonOnClick(View v) {
        Button button = (Button) v;
        startActivity(new Intent(getApplicationContext(), GetPokepun.class));
    }

}
