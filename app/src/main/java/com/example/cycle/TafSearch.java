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

import com.example.cycle.Model.TAF.Forecast;
import com.example.cycle.Model.TAF.TafDatum;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TafSearch extends RecyclerView.Adapter<TafSearch.ViewHolder>{

    private static final String TAG = "SearchAutorAdapter";
    List<TafDatum> listeAut;
    Context context;
    String lon ;
    String lat ;
    String oaci ;
    Forecast f1;




    public TafSearch(List<TafDatum> listeAut, Context context) {
        this.listeAut = listeAut;
        this.context =  context;
    }

    public void setData(List<TafDatum> listeAut) {
        this.listeAut = listeAut;
        //notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TafSearch.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.taf_layout, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    private static String splitToNChar(String text, int debut, String fin) {

        String[] splitString = text.split(fin);

        for (String s : splitString) {
            System.out.println(s);
        }
       return splitString[0];
    }

    public String getDate(String mDate) {
        try {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
            Date date = dateFormat.parse(mDate);
            dateFormat = new SimpleDateFormat("EEEE, dd MMMM yyyy, hh:mm a");
            return dateFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final List<TafDatum> data = listeAut;
        final TafDatum aero = listeAut.get(position);


        /*for (int i=0; i< aero.getForecast().size(); i++) {
           Forecast f1= aero.getForecast().get(0);
            Log.d(TAG,  "f1 :" + f1.getCeiling().getText()+ f1.getCeiling().getMeters());
        }*/

        Forecast f1= aero.getForecast().get(1);
        Forecast f2= aero.getForecast().get(2);
        Forecast f3= aero.getForecast().get(3);
        Forecast f4= aero.getForecast().get(4);
       // Forecast f5= aero.getForecast().get(5);

        //Log.d(TAG,  "f1 :" + f1.getCeiling().getText()+ f1.getCeiling().getMeters());
       // Log.d(TAG,  "name :" + aero.getIcao() + aero.getStation().getLocation() + aero.getStation().getName());



        holder.name.setText( aero.getIcao() + aero.getStation().getLocation() + aero.getStation().getName());
        oaci = aero.getIcao();
        lon = aero.getStation().getGeometry().getCoordinates().get(0)+"";
        lat = aero.getStation().getGeometry().getCoordinates().get(1)+"";


        holder.rawText1.setText( aero.getRawText());
        //holder.rawText1.setText( splitToNChar(aero.getRawText(),0, "BECMG")+"");


        String debut = getDate(f1.getTimestamp().getFrom());
        String fin = getDate(f1.getTimestamp().getTo());


        holder.forecastPrediod1.setText( debut +" to " +fin );
        holder.forecastperiodType1.setText( f1.getChange()==null?"missing":f1.getChange().getIndicator().getDesc());
        holder.winds1.setText( f1.getWind()==null?"missing":f1.getWind().getDegrees() + " Deg ");
        holder.winds11.setText( f1.getWind()==null?"missing":f1.getWind().getSpeedMps() +" mps");

        holder.visibility1.setText( f1.getVisibility()== null?"missing":f1.getVisibility().getMiles() +" miles, ( " +f1.getVisibility().getMetersFloat()+" meter )" );
        //holder.ceiling1.setText( f1.getCeiling().getBaseFeetAgl()+ " feet AGL");
        holder.clouds1.setText( f1.getClouds().isEmpty()?"missing":f1.getClouds().get(0).getText());


        //holder.rawText2.setText( splitToNChar2(aero.getRawText(),160)+"");

        String debut2 = getDate(f2.getTimestamp().getFrom());
        String fin2 = getDate(f2.getTimestamp().getTo());


        holder.forecastPrediod2.setText( debut2 +" to " +fin2 );
        holder.forecastperiodType2.setText( f2.getChange().getIndicator().getDesc());

        if (f2.getWind() == null) {
            holder.winds2.setText( " missing");
            holder.winds22.setText( " missing");
        }
        else {
            holder.winds2.setText( f2.getWind()==null?"missing":f2.getWind().getDegrees() +" Deg");
            holder.winds22.setText( f2.getWind()==null?"missing":f2.getWind().getSpeedMps() +" mps");
        }


        holder.visibility2.setText( f2.getVisibility()==null?"missing": f2.getVisibility().getMiles() +" miles,  ( " +f2.getVisibility().getMetersFloat()+" meter )" );
        holder.weather2.setText( f2.getConditions().get(0).getText()==null?"missing":f2.getConditions().get(0).getText());
        holder.clouds2.setText( f2.getClouds().isEmpty()? "missing" : f2.getClouds().get(0).getText());
        holder.clouds22.setText( f2.getCeiling()== null? "missing" : f2.getCeiling().getBaseFeetAgl()+ " feet AGL");




        String debut3 = getDate(f3.getTimestamp().getFrom());
        String fin3 = getDate(f3.getTimestamp().getTo());


        holder.forecastPrediod3.setText( debut3 +" to " +fin3 );
        holder.forecastperiodType3.setText( f3.getChange().getIndicator().getDesc());
        if (f3.getWind() == null) {
            holder.winds3.setText( " missing");
            holder.winds33.setText( " missing");
        }
        else {
            holder.winds3.setText(f3.getWind().getDegrees() +" Deg");
            holder.winds33.setText(f3.getWind().getSpeedMps() +" mps");
        }
        //holder.winds3.setText( f3.getWind().getDegrees() + f3.getWind().getSpeedMps() +" mps");
        holder.visibility3.setText( f3.getVisibility()==null?"missing":f3.getVisibility().getMiles() +" miles, ( " +f3.getVisibility().getMetersFloat()+" meter )" );
        holder.weather3.setText( f3.getConditions()==null?"missing": f3.getConditions().get(0).getText()==null?"missing":f3.getConditions().get(0).getText());
        holder.clouds3.setText( f3.getClouds().isEmpty()? "missing" : f3.getClouds().get(0).getText());
        holder.clouds33.setText( f3.getCeiling()== null? "missing" : f3.getCeiling().getBaseFeetAgl()+ " feet AGL");


        String debut4 = getDate(f4.getTimestamp().getFrom());
        String fin4 = getDate(f4.getTimestamp().getTo());


        holder.forecastPrediod4.setText( debut4 +" to " +fin4 );
        holder.forecastperiodType4.setText( f4.getChange()==null?"missing":f4.getChange().getIndicator().getDesc());
        holder.winds4.setText( f4.getWind()==null?"missing":f4.getWind().getDegrees()+" Deg");
        holder.winds44.setText(f4.getWind()==null?"missing":f2.getWind().getSpeedMps() +" mps");

        holder.visibility4.setText( f4.getVisibility()==null?"missing":f4.getVisibility().getMiles() +" miles, ( " +f4.getVisibility().getMetersFloat()+" meter )" );
        holder.weather4.setText( f4.getConditions()==null?"missing":f4.getConditions().get(0).getText()==null?"missing":f4.getConditions().get(0).getText());
        holder.clouds4.setText( f4.getClouds()==null?"missing":f4.getClouds().isEmpty()? "missing" : f4.getClouds().get(0).getText());
        holder.clouds44.setText( f4.getCeiling()==null?"missing":f4.getCeiling()== null? "missing" : f4.getCeiling().getBaseFeetAgl()+ " feet AGL");








    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView name;
        private final TextView rawText1;
        private final TextView forecastPrediod1;
        private final TextView forecastperiodType1;
        private final TextView winds1;
        private final TextView visibility1;
        private final TextView winds11;
        private final TextView clouds1;

        private final TextView rawText2;
        private final TextView forecastPrediod2;
        private final TextView forecastperiodType2;
        private final TextView winds2;
        private final TextView winds22;
        private final TextView visibility2;
        private final TextView weather2;
        private final TextView clouds2;
        private final TextView clouds22;



        private final TextView forecastPrediod3;
        private final TextView forecastperiodType3;
        private final TextView winds3;
        private final TextView visibility3;
        private final TextView weather3;
        private final TextView clouds3;
        private final TextView winds33;
        private final TextView clouds33;


        private final TextView forecastPrediod4;
        private final TextView forecastperiodType4;
        private final TextView winds4;
        private final TextView visibility4;
        private final TextView weather4;
        private final TextView clouds4;
        private final TextView winds44;
        private final TextView clouds44;
        private final Button bpmaps;



        public ViewHolder(View view) {
            super(view);
            name = view.findViewById(R.id.name1);
            rawText1 = view.findViewById(R.id.rawText1);
            forecastPrediod1 = view.findViewById(R.id.forecastPrediod1);
            forecastperiodType1 = view.findViewById(R.id.forecastperiodType1);
            winds1 = view.findViewById(R.id.winds1);
            visibility1 = view.findViewById(R.id.visibility1);
            winds11 = view.findViewById(R.id.winds11);
            clouds1 = view.findViewById(R.id.clouds1);

            rawText2 = view.findViewById(R.id.rawText2);
            forecastPrediod2 = view.findViewById(R.id.forecastPrediod2);
            forecastperiodType2 = view.findViewById(R.id.forecastperiodType2);
            winds2 = view.findViewById(R.id.winds2);
            winds22 = view.findViewById(R.id.winds22);
            visibility2 = view.findViewById(R.id.visibility2);
            weather2 = view.findViewById(R.id.weather2);
            clouds2 = view.findViewById(R.id.clouds1);
            clouds22 = view.findViewById(R.id.clouds11);



            forecastPrediod3 = view.findViewById(R.id.forecastPrediod3);
            forecastperiodType3 = view.findViewById(R.id.forecastperiodType3);
            winds3 = view.findViewById(R.id.winds3);
            visibility3 = view.findViewById(R.id.visibility3);
            weather3 = view.findViewById(R.id.weather3);
            clouds3 = view.findViewById(R.id.clouds3);
            winds33 = view.findViewById(R.id.winds33);
            clouds33 = view.findViewById(R.id.clouds33);

            forecastPrediod4 = view.findViewById(R.id.forecastPrediod4);
            forecastperiodType4 = view.findViewById(R.id.forecastperiodType4);
            winds4 = view.findViewById(R.id.winds4);
            visibility4 = view.findViewById(R.id.visibility4);
            weather4 = view.findViewById(R.id.weather4);
            clouds4 = view.findViewById(R.id.clouds4);
            winds44 = view.findViewById(R.id.winds44);
            clouds44 = view.findViewById(R.id.clouds44);

            bpmaps = view.findViewById(R.id.bpmaps);


            bpmaps.setOnClickListener(new View.OnClickListener() {

                public void onClick(View v) {
                    Log.d(TAG, "onClick: ");
                    Intent INT=new Intent(context, Map.class);
                    INT.putExtra("lon",lon);
                    INT.putExtra("lat",lat);
                    INT.putExtra("name",oaci);
                    context.startActivity(INT);

                }
            });


        }
    }

}
