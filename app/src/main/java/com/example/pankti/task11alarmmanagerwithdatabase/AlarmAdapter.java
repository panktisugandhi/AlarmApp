package com.example.pankti.task11alarmmanagerwithdatabase;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by welcome on 3/9/2017.
 */

public class AlarmAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<String> id;
    private ArrayList<String> name;
    private ArrayList<String> date;
    private ArrayList<String> time;

    public AlarmAdapter(Context context, ArrayList<String> id, ArrayList<String> name, ArrayList<String> date, ArrayList<String> time) {

        this.context = context;
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;

    }


    @Override
    public int getCount() {
        return id.size();
    }

    @Override
    public Object getItem(int position) {
        return id.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder {
        TextView id;
        TextView name;
        TextView date;
        TextView time;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        ViewHolder holder = new ViewHolder();

        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.listalarm,null);
            holder.id = (TextView)view.findViewById(R.id.txtid);
            holder.name = (TextView)view.findViewById(R.id.txtname);
            holder.date = (TextView)view.findViewById(R.id.txtdate);
            holder.time = (TextView)view.findViewById(R.id.txttime);
            view.setTag(holder);
        }else {
            holder = (ViewHolder) view.getTag();
        }
        holder.id.setText(id.get(position));
        holder.name.setText(name.get(position));
        holder.date.setText(date.get(position));
        holder.time.setText(time.get(position));

        return view;
    }


}