package com.example.cycle;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cycle.Model.METAR.Datum;

import java.util.List;

public class AllDataSearch extends RecyclerView.Adapter<AllDataSearch.ViewHolder>{

    private static final String TAG = "SearchAutorAdapter";
    List<Datum> listeAut;
    Context context;

    public AllDataSearch(List<Datum> listeAut, Context context) {
        this.listeAut = listeAut;
        this.context =  context;
    }

    public void setData(List<Datum> listeAut) {
        this.listeAut = listeAut;
        //notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AllDataSearch.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.airportselection, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull AllDataSearch.ViewHolder holder, int position) {
        final List<Datum> data = listeAut;
        final Datum aero = listeAut.get(position);
        holder.textViewFullText.setText( aero.getIcao());
        holder.airportName.setText( aero.getStation().getName());
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textViewFullText;
        private final TextView airportName;

        public ViewHolder(View view) {
            super(view);
            textViewFullText = view.findViewById(R.id.textViewFullText);
            airportName = view.findViewById(R.id.airportName);


            textViewFullText.setClickable(true);
            airportName.setClickable(true);
            textViewFullText.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Log.d(TAG, "onClick: ");
                    Intent INT=new Intent(context,AirportSelection.class);
                    String name = textViewFullText.getText().toString();
                    INT.putExtra("name",name);
                    context.startActivity(INT);

                }
            });
            airportName.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Log.d(TAG, "onClick: ");
                    Intent INT=new Intent(context,AirportSelection.class);
                    String name = textViewFullText.getText().toString();
                    INT.putExtra("name",name);
                    context.startActivity(INT);

                }
            });
        }
    }

}
