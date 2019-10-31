package com.sujanmaharjan008.dictionary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    public static final String words[] = {
            "grenadine", "thin syrup made from pomegranate juice; used in mixed drinks",
            "pomegranate", "shrub or small tree having large red many-seeded fruit",
            "hefty", "of considerable weight and size",
            "pelter", "a thrower of missiles",
            "concretize", "make something concrete",
            "manikin", "a life-size dummy used to display clothes",
            "canvass", "get opinions by asking specific questions",
            "lubberly", "clumsy and unskilled",
            "cordial", "politely warm and friendly",
            "jocular", "characterized by jokes and good humor",
            "Utopian", "of or pertaining to or resembling a utopia",
            "tamp", "press down tightly",
            "annulment", "an official or legal cancellation",
            "regime", "the governing authority of a political unit",
            "minimal", "the least possible"
    };
    private AutoCompleteTextView ACTxtWord;
    private ListView lsvWords;
    private TextView txtMeaning;
    private Map<String, String> WordAndMeaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ACTxtWord = findViewById(R.id.ACTxtword);
        lsvWords = findViewById(R.id.lsvWords);
        txtMeaning = findViewById(R.id.txtMeaning);

        WordAndMeaning = new HashMap<>();
        for (int i = 0; i < words.length; i += 2) {
            WordAndMeaning.put(words[i], words[i + 1]);
        }

        ArrayAdapter<String> wordAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(WordAndMeaning.keySet())
        );

        lsvWords.setAdapter(wordAdapter);
        ACTxtWord.setAdapter(wordAdapter);
        ACTxtWord.setThreshold(1);

        lsvWords.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String wordpos = parent.getItemAtPosition(position).toString();
                String meanin = WordAndMeaning.get(wordpos);

                txtMeaning.setText(meanin);
            }
        });

        ACTxtWord.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String wordpos = parent.getItemAtPosition(position).toString();
                String meanin = WordAndMeaning.get(wordpos);

                txtMeaning.setText(meanin);
            }
        });
    }
}
