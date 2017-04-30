package Clogica;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.proyecto.julio.rutasutecv6.R;

import java.util.ArrayList;

/**
 * Created by julio on 29/04/17.
 */

public class RutasBaseAdapter extends BaseAdapter {
    ArrayList myList = new ArrayList();
    LayoutInflater inflater;
    Context context;

    public RutasBaseAdapter(Context context, ArrayList myList){
        this.context=context;
        this.myList=myList;
        inflater =LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return myList.size();
    }

    @Override
    public Object getItem(int position) {
        return myList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MyViewHolder myViewHolder;
        if (convertView==null){
            convertView=inflater.inflate(R.layout.listview_item_row,parent,false);
            myViewHolder=new MyViewHolder(convertView);
            convertView.setTag(myViewHolder);
        }else
        {
            myViewHolder=(MyViewHolder)convertView.getTag();
        }
        RutasModel currentListData = (RutasModel) getItem(position);
        myViewHolder.titulo.setText(currentListData.getTitle());
        myViewHolder.ico.setImageResource(currentListData.getImgResid());
        return convertView;
    }
    private class MyViewHolder{
        TextView titulo;
        ImageView ico;

        public MyViewHolder(View view){
            titulo=(TextView)view.findViewById(R.id.tvList);
            ico=(ImageView)view.findViewById(R.id.imageList);
        }
    }
}
