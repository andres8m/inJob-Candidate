package com.example.inin.injob.cv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.inin.injob.R;
import com.example.inin.injob.models.cv5.DatumCv5;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Andres Canu on 11/11/2017.
 */

public class LanguageListAdapter extends RecyclerView.Adapter<LanguageListAdapter.MyViewHolder> {
    private List<DatumCv5> list;
    private LayoutInflater inflater;

    public LanguageListAdapter(Context context, List<DatumCv5> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private RatingBar ratingBar1;
        private RatingBar ratingBar2;
        private RatingBar ratingBar3;
        private RatingBar ratingBar4;
        private RatingBar ratingBar5;
        private TextView textViewTitle;

        private DatumCv5 currentObject;
        public MyViewHolder (View itemView)
        {
            super(itemView);
            ratingBar1 = (RatingBar) itemView.findViewById(R.id.ratingBar1);
            ratingBar2 = (RatingBar) itemView.findViewById(R.id.ratingBar2);
            ratingBar3 = (RatingBar) itemView.findViewById(R.id.ratingBar3);
            ratingBar4 = (RatingBar) itemView.findViewById(R.id.ratingBar4);
            ratingBar5 = (RatingBar) itemView.findViewById(R.id.ratingBar5);
            textViewTitle = (TextView) itemView.findViewById(R.id.title);
        }

        public void setData(DatumCv5 current, int position) {
            float rt1 = current.getComprensionAuditiva()/2;
            rt1 = rt1 /10;
            float rt2 = current.getInteraccionOral()/2;
            rt2 = rt2 /10;
            float rt3 = current.getExpresionOral()/2;
            rt3 = rt3 /10;
            float rt4 = current.getComprensionLectora()/2;
            rt4 = rt4 /10;
            float rt5 = current.getExpresionEscrita()/2;
            rt5 = rt5 /10;

            textViewTitle.setText(current.getLanguaje().getName());
            ratingBar1.setRating(rt1);
            ratingBar2.setRating(rt2);
            ratingBar3.setRating(rt3);
            ratingBar4.setRating(rt4);
            ratingBar5.setRating(rt5);
            this.currentObject = current;
        }
    }

    @Override
    public LanguageListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_language, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DatumCv5 current = list.get(position);
        holder.setData(current, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
