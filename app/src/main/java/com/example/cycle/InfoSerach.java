package com.example.cycle;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cycle.Model.METAR.Datum;

import java.util.List;

public class InfoSerach extends RecyclerView.Adapter<InfoSerach.ViewHolder>{

    private static final String TAG = "SearchAutorAdapter";
    List<Datum> listeAut;
    Context context;
    String lon ;
    String lat ;
    String oaci ;




    public InfoSerach(List<Datum> listeAut, Context context) {
        this.listeAut = listeAut;
        this.context =  context;
    }

    public void setData(List<Datum> listeAut) {
        this.listeAut = listeAut;
        //notifyDataSetChanged();
    }

    @NonNull
    @Override
    public InfoSerach.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.autor, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull InfoSerach.ViewHolder holder, int position) {
        final List<Datum> data = listeAut;
        final Datum aero = listeAut.get(position);
        holder.temperature.setText( aero.getTemperature().getCelsius() +" °C");
        holder.rawtext.setText( aero.getRawText());
        holder.name.setText( aero.getStation().getName());
        oaci = aero.getIcao();
        holder.winds11.setText( aero.getWind()==null?"missing":aero.getWind().getSpeedKph() + " Km/h ");
        holder.winds.setText( aero.getWind()==null?"missing":aero.getWind().getDegrees()+ " °");
        holder.pressure.setText( aero.getBarometer().getHg()+ " hg "+ aero.getBarometer().getMb()+" mb");
        holder.ceiling.setText( aero.getCeiling()==null?"missing":aero.getCeiling().getBaseFeetAgl()+"");

        holder.visibility.setText( aero.getVisibility().getMiles() +"  miles");
        holder.dewpoint.setText( aero.getDewpoint().getCelsius() +" °C ");

        holder.clouds1.setText( aero.getClouds().get(0).getText() );
        holder.clouds11.setText(aero.getClouds().get(0).getFeet()+"" );

        lon = +aero.getStation().getGeometry().getCoordinates().get(0)+"";
        lat = aero.getStation().getGeometry().getCoordinates().get(1)+"";


    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView temperature;
        private final TextView rawtext;
        private final TextView dewpoint;
        private final TextView visibility;
        private final TextView winds;
        private final TextView winds11;

        private final TextView clouds1;
        private final TextView clouds11;

        private final TextView pressure;
        private final TextView ceiling11;


        private final TextView name;
        private final TextView ceiling;
        private final Button bpmaps;

        public ViewHolder(View view) {
            super(view);
            temperature = view.findViewById(R.id.temperature1);
            rawtext = view.findViewById(R.id.rawtext);
            ceiling = view.findViewById(R.id.ceiling1);
            ceiling11 = view.findViewById(R.id.ceiling11);
            visibility = view.findViewById(R.id.visibility);
            winds = view.findViewById(R.id.windsmetar1);
            winds11 = view.findViewById(R.id.windsmetar11);
            pressure = view.findViewById(R.id.pressure);

            clouds1 = view.findViewById(R.id.clouds1);
            clouds11 = view.findViewById(R.id.clouds11);

            name = view.findViewById(R.id.name1);
            dewpoint = view.findViewById(R.id.dewpoint);
            bpmaps = view.findViewById(R.id.maps);


            bpmaps.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Log.d(TAG, "onClick: ");
                    Intent INT=new Intent(context, TafsActivity.class);
                    INT.putExtra("lon",lon);
                    INT.putExtra("lat",lat);
                    INT.putExtra("name",oaci);
                    context.startActivity(INT);

                }
            });

        }
    }

}
