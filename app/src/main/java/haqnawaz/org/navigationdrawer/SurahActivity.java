package haqnawaz.org.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SurahActivity extends AppCompatActivity {

    ListView listView;
    List<String> surahList= new ArrayList<>();
    QDH qdh = new QDH();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surah);

        listView = findViewById(R.id.listViewSurahName);

        surahList = Arrays.asList(qdh.urduSurahNames);

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                surahList);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int startPointer = qdh.SSP[position];
                int endPointer = qdh.SSP[position + 1];
                Intent intent = new Intent(SurahActivity.this,SurahDetailActivity.class);
                intent.putExtra("Start", startPointer);
                intent.putExtra("End", endPointer);
                startActivity( intent);
            }
        });

    }
}