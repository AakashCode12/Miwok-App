package com.example.miwokapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("father", "әpә", R.drawable.family_father));
        words.add(new Word("mother", "әṭa", R.drawable.family_mother));
        words.add(new Word("son", "angsi", R.drawable.family_son));
        words.add(new Word("daughter", "tune", R.drawable.family_daughter));
        words.add(new Word("older brother", "taachi", R.drawable.family_older_brother));
        words.add(new Word("younger brother", "chalitti", R.drawable.family_younger_brother));
        words.add(new Word("older sister", "teṭe", R.drawable.family_older_sister));
        words.add(new Word("younger sister", "kolliti", R.drawable.family_younger_sister));
        words.add(new Word("grandmother", "ama", R.drawable.family_grandmother));
        words.add(new Word("grandfather", "paapa", R.drawable.family_grandfather));

        //Array Adapter Displaying the ArrayList Contents
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_family);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        final ArrayList<Integer> audios = new ArrayList<>();
        audios.add(R.raw.family_father);
        audios.add(R.raw.family_mother);
        audios.add(R.raw.family_son);
        audios.add(R.raw.family_daughter);
        audios.add(R.raw.family_older_brother);
        audios.add(R.raw.family_younger_brother);
        audios.add(R.raw.family_older_sister);
        audios.add(R.raw.family_younger_sister);
        audios.add(R.raw.family_grandmother);
        audios.add(R.raw.family_grandmother);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {

                mediaPlayer = MediaPlayer.create(FamilyActivity.this, audios.get(position));
                mediaPlayer.start();
            }
        });
    }
}