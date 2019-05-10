package dk.gruppe5.koerskolepriser.adaptere;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import dk.gruppe5.koerskolepriser.objekter.Priser;

public class PrisAdapter_Opret<T> extends ArrayAdapter<T> {


    public PrisAdapter_Opret(@NonNull Context context, int resource, @NonNull T[] objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getPrisView(position, convertView, parent);
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent)
    {
        return getPrisView(position, convertView, parent);
    }

    private View getPrisView(int position, View convertView, ViewGroup parent){
        View view = super.getView(position, convertView, parent);
        TextView text = (TextView) view;
        text.setText(String.format("%d kr.", Priser.priser[position]));
        return view;
    }
}
