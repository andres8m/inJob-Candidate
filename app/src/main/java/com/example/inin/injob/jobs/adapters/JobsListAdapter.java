package com.example.inin.injob.jobs.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.inin.injob.MainFragment;
import com.example.inin.injob.R;
import com.example.inin.injob.jobs.Jobs;
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
    Jobs fragment;

    public JobsListAdapter(Context context, List<DatumJobs> list, Jobs fragment) {
        inflater = LayoutInflater.from(context);
        this.list = list;
        this.fragment = fragment;

    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView offerName;
        private TextView offerDescription;
        private TextView offerDate;
        private Button button;



        private DatumJobs currentObject;
        public MyViewHolder (View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            offerName = (TextView) itemView.findViewById(R.id.offer_name);
            offerDescription = (TextView) itemView.findViewById(R.id.offer_detail);
            offerDate = (TextView) itemView.findViewById(R.id.offer_date);
            button = (Button) itemView.findViewById(R.id.applyButton);
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

        @Override
        public void onClick(View v) {
//            Toast.makeText(v.getContext(),currentObject.getTitle(),Toast.LENGTH_LONG).show();

                fragment.showM(currentObject);


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
