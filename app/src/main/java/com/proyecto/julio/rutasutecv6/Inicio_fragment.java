package com.proyecto.julio.rutasutecv6;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import Clogica.Rutas;
import Clogica.RutasAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Inicio_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Inicio_fragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ListView listView;


    public Inicio_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio_fragment, container, false);

        // con este arreglo rutas se llena la lista

       /* String[] rutas ={"Ruta 7","Ruta 11","Ruta 29","Ruta 3","Ruta","Ruta 101"};
        //creo el adaptador para la lista*/
        Rutas rutas_datos[] = new Rutas[]{
                new Rutas(android.R.drawable.ic_lock_idle_alarm,"ruta 7"),
                new Rutas(android.R.drawable.ic_dialog_map,"ruta 11"),
                new Rutas(android.R.drawable.ic_dialog_map,"ruta 29"),
                new Rutas(android.R.drawable.ic_dialog_map,"ruta 3"),
                new Rutas(android.R.drawable.ic_dialog_map,"ruta 101")
        };
       // ArrayAdapter<String> adaptador = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,rutas);



        RutasAdapter adapter new RutasAdapter(this,R.layout.list_view_row,rutas_datos);
        //asigno el adaptado a mi lista
        listView=(ListView)view.findViewById(R.id.list_item);
        View header = (View)getLayoutInflater().inflate(android.R.layout.list_header_row);
       // listView.setAdapter(adaptador);

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
