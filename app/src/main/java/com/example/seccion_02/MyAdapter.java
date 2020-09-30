package com.example.seccion_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<String> nameList;

    public MyAdapter(Context context, int layout, List<String> nameList) {
        this.context = context;
        this.layout = layout;
        this.nameList = nameList;
    }

    @Override
    public int getCount() {
        return this.nameList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.nameList.get(position);
    }

    @Override
    public long getItemId(int id) {
        return id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        // View Holder Pattern
        ViewHolder holder;
        if(convertView == null) {
            // Inflamos la vista que llega con nuestro layout
            LayoutInflater layoutInflater = LayoutInflater.from(this.context);
            convertView = layoutInflater.inflate(this.layout, null);

            holder = new ViewHolder();
            // Referenciamos el elemento a modificar y lo rellenamos
            holder.nameTextView = convertView.findViewById(R.id.textViewList);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        // Traemos el valor actual dependiente de la posición
        String currentName = nameList.get(position);

        // Referenciamos el elemento a modificar y lo rellenamos
        holder.nameTextView.setText(currentName);

        return convertView;
    }

    private static class ViewHolder {
        private TextView nameTextView;
    }
}