package Clogica;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by julio on 27/04/2017.
 */

public class RutasAdapter extends ArrayAdapter<Rutas> {
    Context myContext;
    int myLayoutResourseID;
    Rutas mydata[] =null;

    public RutasAdapter(Context context , int layoutResourseID,Rutas[] data){
        super(context,layoutResourseID,data);
        this.myContext=context;
        this.myLayoutResourseID=layoutResourseID;
        this.mydata=data;
    }
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;

        RutasHolder holder = null;
        if(row==null){
            LayoutInflater inflater = ((Activity)myContext).getLayoutInflater();
            row =inflater.inflate(myLayoutResourseID,parent,false);
            holder = new RutasHolder();
            holder.imagen = (ImageView)row.findViewById(R.id.image);
            holder.textview =(TextView)row.findViewById(R.id.tvList);
        }else{
            holder= (RutasHolder)row.getTag();
        }
        Rutas rutas = mydata[position];
        holder.textview.setText(rutas.title);
        holder.imagen.setImageResource(rutas.icon);
        return  row;
    }
    static class RutasHolder{
        ImageView imagen;
        TextView textview;
    }
}
