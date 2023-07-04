package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SurahDetailActivity extends AppCompatActivity {
    ListView listView ;
    ArrayList<String> dataList = new ArrayList<>();
    QuranArabicText quranArabicText = new QuranArabicText();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah_detail);

        Intent intent = getIntent();

        listView = findViewById(R.id.listViewSurahDtail);
        int start = intent.getIntExtra("Start",0);
        int end = intent.getIntExtra("End", 0);

       // String[] list  = quranArabicText.GetData(start, end);

        for (int i = start; i < end ; i++) {
            dataList.add((quranArabicText.QuranArabicText[i]).toString());
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,dataList);

        listView.setAdapter(arrayAdapter);




    }
}