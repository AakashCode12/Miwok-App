package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("Where are you going?", "minto wuksus"));
        words.add(new Word("What is your name?", "tinnә oyaase'nә"));
        words.add(new Word("My name is...", "oyaaset..."));
        words.add(new Word("How are you feeling?", "michәksәs?"));
        words.add(new Word("I’m feeling good.", "kuchi achit"));
        words.add(new Word("Are you coming?", "әәnәs'aa?"));
        words.add(new Word("Yes, I’m coming.", "hәә’ әәnәm"));
        words.add(new Word("I’m coming.", "әәnәm"));
        words.add(new Word("Let’s go.", "yoowutis"));
        words.add(new Word("Come here.", "әnni'nem"));

        //Array Adapter Displaying the ArrayList Contents
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_phrases);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        final ArrayList<Integer> audios = new ArrayList<>();
        audios.add(R.raw.phrase_where_are_you_going);
        audios.add(R.raw.phrase_what_is_your_name);
        audios.add(R.raw.phrase_my_name_is);
        audios.add(R.raw.phrase_how_are_you_feeling);
        audios.add(R.raw.phrase_im_feeling_good);
        audios.add(R.raw.phrase_are_you_coming);
        audios.add(R.raw.phrase_im_coming);
        audios.add(R.raw.phrase_lets_go);
        audios.add(R.raw.phrase_come_here);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                mediaPlayer = MediaPlayer.create(PhrasesActivity.this, audios.get(position));
                mediaPlayer.start();
            }
        });
    }
}