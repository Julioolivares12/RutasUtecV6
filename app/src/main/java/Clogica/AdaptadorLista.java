package Clogica;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by julio on 29/04/17.
 */

public class AdaptadorLista extends ArrayAdapter<Rutas> {
    private  static final String LOG_TAG= AdaptadorLista.class.getSimpleName();
    private Context context;
    private List<Rutas> rutas;

    public AdaptadorLista(@NonNull Context context, @LayoutRes int resource, @NonNull List<Rutas> rutas) {
        super(context, resource, rutas);
        this.rutas=rutas;
        this.context=context;
        setNotifyOnChange(true);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;
        return super.getView(position, convertView, parent);
    }
    public class ViewHolder{
        protected LinearLayout rootView;
        protected TextView titulo;
        protected ImageView ico;
    }
}
