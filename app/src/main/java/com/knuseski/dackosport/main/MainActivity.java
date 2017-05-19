package com.knuseski.dackosport.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.knuseski.dackosport.model.Data;
import com.knuseski.dackosport.help.MyAdapter;
import com.knuseski.dackosport.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new MyAdapter(getData()));
    }

    private List<Data> getData() {
        List<Data> dataList = new ArrayList<>();
        String[] header = new String[]{"10 MOUNTAIN CLIMBERS", "10M BURPEE FROGS", "1/3 HADES"};
        String[] bodyBig = new String[]{"ENDURANCE", "3/5 NEMESIS", "200M SPRINT"};
        String[] bodySmall = new String[]{"Endurance", "Standard", "Interval: Full Body"};

        Random R = new Random();
        Calendar cal = new GregorianCalendar();
        int days = cal.getMaximum(Calendar.DAY_OF_MONTH);
        for (int i = 1; i <= days; i++) {
            dataList.add(new Data(i,
                    header[R.nextInt(header.length)],
                    R.nextInt(2) == 0,
                    bodyBig[R.nextInt(bodyBig.length)],
                    bodySmall[R.nextInt(bodySmall.length)]
            ));
        }

        return dataList;
    }
}
