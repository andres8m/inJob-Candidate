package com.example.inin.injob.jobs.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inin.injob.R;
import com.example.inin.injob.models.jobs.DatumJobs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Andres Canu on 12/11/2017.
 */

public class JobsListAdapter extends RecyclerView.Adapter<JobsListAdapter.MyViewHolder>  {

    private List<DatumJobs> list;
    private LayoutInflater inflater;

    public JobsListAdapter(Context context, List<DatumJobs> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView offerName;
        private TextView offerDescription;
        private TextView offerDate;

        private DatumJobs currentObject;
        public MyViewHolder (View itemView)
        {
            super(itemView);
            offerName = (TextView) itemView.findViewById(R.id.offer_name);
            offerDescription = (TextView) itemView.findViewById(R.id.offer_detail);
            offerDate = (TextView) itemView.findViewById(R.id.offer_date);
        }

        public void setData(DatumJobs current, int position) {

            offerName.setText(current.getTitle());
            offerDescription.setText(current.getDescription());
            if(current.getSubmitDate()!=null)
            {
                Date date = new Date(current.getSubmitDate());
                SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yy");
                String dateText = df2.format(date);
                offerDate.setText(dateText);
            }

            this.currentObject = current;
        }
    }

    @Override
    public JobsListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.job_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DatumJobs current = list.get(position);
        holder.setData(current, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }







}
