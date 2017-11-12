package com.example.inin.injob.cv.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.inin.injob.R;
import com.example.inin.injob.models.cv7.DatumCv7;

import java.util.List;

/**
 * Created by Andres Canu on 11/11/2017.
 */

public class ReferencesListAdapter extends RecyclerView.Adapter<ReferencesListAdapter.MyViewHolder> {

    private List<DatumCv7> list;
    private LayoutInflater inflater;

    public ReferencesListAdapter(Context context, List<DatumCv7> list) {
        inflater = LayoutInflater.from(context);
        this.list = list;

    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView typeReference;
        private TextView nameReference;
        private TextView phoneReference;
        private TextView emailReference;


        private DatumCv7 currentObject;
        public MyViewHolder (View itemView)
        {
            super(itemView);
            typeReference = (TextView) itemView.findViewById(R.id.title);
            nameReference = (TextView) itemView.findViewById(R.id.name);
            phoneReference = (TextView) itemView.findViewById(R.id.phone);
            emailReference = (TextView) itemView.findViewById(R.id.email);

        }

        public void setData(DatumCv7 current, int position) {

            typeReference.setText(getReferenceType(current.getTipoReferencia()));
            nameReference.setText(current.getNombre()+" "+current.getApellido());
            phoneReference.setText(current.getTelefono());
            emailReference.setText(current.getCorreo());
            this.currentObject = current;
        }
    }

    @Override
    public ReferencesListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.card_references, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        DatumCv7 current = list.get(position);
        holder.setData(current, position);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public String getReferenceType(Long type)
    {
        if(type==1)
        {
            return "Referencia Personal";
        }
        else {
            return "Referencia Profesional";
        }
    }

}
