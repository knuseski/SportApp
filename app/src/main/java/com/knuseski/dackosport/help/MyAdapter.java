package com.knuseski.dackosport.help;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.knuseski.dackosport.R;
import com.knuseski.dackosport.app.MyApplication;
import com.knuseski.dackosport.model.Data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private LayoutInflater inflater;
    private List<Data> items = new ArrayList<>();

    private int colorBlue;
    private int colorBlack;
    private int colorGray;

    public MyAdapter(List<Data> items) {
        inflater = LayoutInflater.from(MyApplication.getAppContext());
        this.items = items;
        colorBlue = ContextCompat.getColor(MyApplication.getAppContext(), R.color.blue);
        colorBlack = ContextCompat.getColor(MyApplication.getAppContext(), R.color.black);
        colorGray = ContextCompat.getColor(MyApplication.getAppContext(), R.color.gray);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.one_data, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        Data data = items.get(position);

        holder.tvDayNum.setText(String.valueOf(data.getDay()));

        holder.tvHeader.setText(data.getHeader());

        if (data.isNew())
            holder.tvNew.setVisibility(View.VISIBLE);
        else
            holder.tvNew.setVisibility(View.INVISIBLE);

        holder.tvBodyBig.setText(data.getBodyBig());
        holder.tvBodySmall.setText(data.getBodySmall());

        //////////////////////////////////////////////////////

        configureColors(holder, data);
    }

    private void configureColors(MyViewHolder holder, Data data) {
        Calendar calendar = new GregorianCalendar();
        if (data.getDay() == 1)
            holder.lineGore.setVisibility(View.INVISIBLE);
        else
            holder.lineGore.setVisibility(View.VISIBLE);

        if (data.getDay() == calendar.getMaximum(Calendar.DAY_OF_MONTH))
            holder.lineDole.setVisibility(View.INVISIBLE);
        else
            holder.lineDole.setVisibility(View.VISIBLE);

        if (data.getDay() <= calendar.get(Calendar.DAY_OF_MONTH)) {
            holder.tvDay.setTextColor(colorBlue);
            holder.tvDayNum.setSolidColor(R.color.blue);
            holder.tvDayNum.setStrokeColor(R.color.blue);

            holder.tvHeader.setTextColor(colorBlack);

            holder.tvNew.setTextColor(colorBlue);
            holder.tvBodyBig.setTextColor(colorBlack);
            holder.tvBodySmall.setTextColor(colorBlack);

            holder.lineGore.setBackgroundColor(colorBlue);
        } else {
            holder.tvDay.setTextColor(colorGray);
            holder.tvDayNum.setSolidColor(R.color.gray);
            holder.tvDayNum.setStrokeColor(R.color.gray);

            holder.tvHeader.setTextColor(colorGray);

            holder.tvNew.setTextColor(colorGray);
            holder.tvBodyBig.setTextColor(colorGray);
            holder.tvBodySmall.setTextColor(colorGray);

            holder.lineGore.setBackgroundColor(colorGray);
        }

        if (data.getDay() < new GregorianCalendar().get(Calendar.DAY_OF_MONTH))
            holder.lineDole.setBackgroundColor(colorBlue);
        else
            holder.lineDole.setBackgroundColor(colorGray);
    }


    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        holder.itemView.clearAnimation();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDay;
        private CircularTextView tvDayNum;

        private TextView tvHeader;

        private TextView tvNew;
        private TextView tvBodyBig;
        private TextView tvBodySmall;

        private LinearLayout lineGore;
        private LinearLayout lineDole;

        MyViewHolder(View itemView) {
            super(itemView);

            tvDay = (TextView) itemView.findViewById(R.id.tvDay);
            tvDayNum = (CircularTextView) itemView.findViewById(R.id.tvDayNum);
            tvDayNum.setSolidColor(R.color.gray);
            tvDayNum.setStrokeColor(R.color.gray);
            tvDayNum.setTextColor(ContextCompat.getColor(MyApplication.getAppContext(), R.color.white));

            tvHeader = (TextView) itemView.findViewById(R.id.tvHeader);

            tvNew = (TextView) itemView.findViewById(R.id.tvNew);
            tvBodyBig = (TextView) itemView.findViewById(R.id.tvBodyBig);
            tvBodySmall = (TextView) itemView.findViewById(R.id.tvBodySmall);

            lineDole = (LinearLayout) itemView.findViewById(R.id.lineGore);
            lineGore = (LinearLayout) itemView.findViewById(R.id.lineDole);
        }
    }

}


