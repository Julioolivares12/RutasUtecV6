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

import java.util.ArrayList;




/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Inicio_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class Inicio_fragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private ListView listView;
    Context context = getActivity().getApplicationContext();
    ArrayList myList = new ArrayList();
    String[] title = new String[]{
      "Ruta 7","Ruta 11","Ruta 29","Ruta 3","Ruta 11"
    };
    int[] img = new int[]{
      R.drawable.ic_menu_gallery,R.drawable.ic_menu_manage,R.drawable.ic_menu_manage,R.drawable.ic_menu_manage,R.drawable.ic_menu_gallery
    };

    public Inicio_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio_fragment, container, false);

        // con este arreglo rutas se llena la lista

       /*
        //creo el adaptador para la lista*/
        String[] rutas ={"Ruta 7","Ruta 11","Ruta 29","Ruta 3","Ruta","Ruta 101"};
        /*Rutas rutas_datos[] = new Rutas[]{
                new Rutas(android.R.drawable.ic_lock_idle_alarm,"ruta 7"),
                new Rutas(android.R.drawable.ic_dialog_map,"ruta 11"),
                new Rutas(android.R.drawable.ic_dialog_map,"ruta 29"),
                new Rutas(android.R.drawable.ic_dialog_map,"ruta 3"),
                new Rutas(android.R.drawable.ic_dialog_map,"ruta 101")
        };*/
       ArrayAdapter<String> adaptador = new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1,rutas);



      //  RutasAdapter adapter new RutasAdapter(this,R.layout.list_view_row,rutas_datos);

        //asigno el adaptado a mi lista
        listView=(ListView)view.findViewById(R.id.list_item);
        //listView=(ListView)getActivity().findViewById(R.id.list_item);
        //RutasAdapter adapter = new RutasAdapter(getActivity(),R.layout.listview_item_row,rutas_datos);
        //View header = (View)getLayoutInflater.inflate(android.R.layout.list_content);
        //View header = (View)getActivity().getLayoutInflater().inflate(R.layout.list_header_row,null);
        listView.setAdapter(adaptador);
       // listView.addHeaderView(header);
       // ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(),android.R.layout.simple_list_item_1,rutas);
       // getDataList();
       // listView.setAdapter(new RutasBaseAdapter(context,myList));

        return view;
    }
    /*public void getDataList(){
        for (int i=0;i<=title.length;i++){
            RutasModel listaRutas = new RutasModel();
            listaRutas.setTitle(title[i]);
            listaRutas.setImgResid(img[i]);
            myList.add(listaRutas);
        }
    }*/

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

