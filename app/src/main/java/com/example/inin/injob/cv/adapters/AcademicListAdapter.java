package com.example.inin.injob.cv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inin.injob.R;
import com.example.inin.injob.models.cv4.DatumCv4;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Andres Canu on 7/11/2017.
 */

public class AcademicListAdapter extends RecyclerView.Adapter<AcademicListAdapter.MyViewHolder> {

    private List<DatumCv4> list;
    private LayoutInflater inflater;

    public AcademicListAdapter(Context context, List<DatumCv4> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView title;
        private TextView description;
        private TextView company;
        private TextView dates;
        private DatumCv4 currentObject;
        public MyViewHolder (View itemView)
        {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            description = (TextView) itemView.findViewById(R.id.description);
            company = (TextView) itemView.findViewById(R.id.company);
            dates = (TextView) itemView.findViewById(R.id.date);

        }

        public void setData(DatumCv4 current, int position) {
            this.title.setText(current.getTittle());
            String degree ="";
            if (current.getDegree()==1)
            {
                degree = "Doctorado";
            }
            else if(current.getDegree()==2)
            {
                degree="Maestría";
            }
            else if(current.getDegree()==3)
            {
                degree="Profesional";
            }
            else if(current.getDegree()==4)
            {
                degree="Técnico Superior";
            }
            else if(current.getDegree()==5)
            {
                degree ="Técnico";
            }
            else if(current.getDegree()==6)
            {
                degree ="Preparatoria";
            }
            else if(current.getDegree()==7)
            {
                degree= "Secundaria";
            }
            else if(current.getDegree()==8)
            {
                degree = "Primaria";
            }
            else {degree="Primaria inconclusa";}

            this.description.setText(degree);
            this.company.setText(current.getInstitution());

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
    public AcademicListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.academic_exp_card, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DatumCv4 current = list.get(position);
        holder.setData(current, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
