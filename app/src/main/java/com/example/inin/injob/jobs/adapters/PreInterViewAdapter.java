package com.example.inin.injob.jobs.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.inin.injob.R;
import com.example.inin.injob.models.jobs.preinterview.PreInterviewQuestion;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Andres Canu on 3/12/2017.
 */

public class PreInterViewAdapter extends RecyclerView.Adapter<PreInterViewAdapter.MyViewHolder>  {


    private List<PreInterviewQuestion> list;
    private LayoutInflater inflater;

    public PreInterViewAdapter(Context context, List<PreInterviewQuestion> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private EditText editTextQuestion;

        private PreInterviewQuestion currentObject;
        public MyViewHolder (View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);
            editTextQuestion = (EditText) itemView.findViewById(R.id.editTextQuestion);
        }


        public void setData(PreInterviewQuestion current, int position) {

            editTextQuestion.setHint(current.getText());
            this.currentObject = current;
        }

        @Override
        public void onClick(View v) {
//            Toast.makeText(v.getContext(),currentObject.getTitle(),Toast.LENGTH_LONG).show();

//            fragment.showM(currentObject);


        }
    }

    @Override
    public PreInterViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.layout_questions, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        PreInterviewQuestion current = list.get(position);
        holder.setData(current, position);
    }
    @Override
    public int getItemCount() {
        return list.size();
    }

    public void addItems(List<PreInterviewQuestion> borrowModelList) {
        this.list = borrowModelList;
        notifyDataSetChanged();
    }

}
