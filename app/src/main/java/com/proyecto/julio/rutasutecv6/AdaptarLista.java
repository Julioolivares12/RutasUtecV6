package com.proyecto.julio.rutasutecv6;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

/**
 * Created by julio on 04-29-17.
 */

public class AdaptarLista extends ArrayAdapter {
    Activity context;

    public AdaptarLista(@NonNull Context context, @LayoutRes int resource) {
        super(context, resource);
    }
}
