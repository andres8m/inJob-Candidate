package com.example.inin.injob.cv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inin.injob.R;
import com.example.inin.injob.models.cv3.DatumCv3;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Andres Canu on 6/11/2017.
 */

public class ExperienceListAdapter extends RecyclerView.Adapter<ExperienceListAdapter.MyViewHolder> {

    private List<DatumCv3> list;
    private LayoutInflater inflater;

    public ExperienceListAdapter(Context context,List<DatumCv3> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView description;
        private TextView company;
        private TextView dates;
        private DatumCv3 currentObject;
        public MyViewHolder (View itemView)
        {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            company = (TextView) itemView.findViewById(R.id.company);
            dates = (TextView) itemView.findViewById(R.id.date);


        }

        public void setData(DatumCv3 current, int position) {
            this.title.setText(current.getJob());
            this.description.setText(current.getDescription());
            this.company.setText(current.getCompany());

            String finalTxt = "";
            if(current.getStart()!=null)
            {
                Date date = new Date(current.getStart());
                SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
                String dateText = df2.format(date);
                finalTxt = "Desde "+dateText;

                if(current.getEnd()!=null)
                {
                    date = new Date(current.getEnd());
                    finalTxt = finalTxt + " hasta "+ df2.format(date);
                }
            }
            this.dates.setText(finalTxt);


            this.currentObject = current;
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_professional_exp, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DatumCv3 current = list.get(position);
        holder.setData(current, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
