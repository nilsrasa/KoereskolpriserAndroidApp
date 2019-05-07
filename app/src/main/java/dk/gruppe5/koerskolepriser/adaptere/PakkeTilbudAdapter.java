package dk.gruppe5.koerskolepriser.adaptere;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.objekter.PakkeTilbud;

public class PakkeTilbudAdapter extends BaseAdapter {
    private Context context;
    private List<PakkeTilbud> pakkeListe;

    public PakkeTilbudAdapter (Context context, List<PakkeTilbud> pakkeListe){
        this.context = context;
        this.pakkeListe = pakkeListe;
    }

    @Override
    public int getCount() {
        return pakkeListe.size();
    }

    @Override
    public Object getItem(int i) {
        return pakkeListe.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroupt) {
        PakkeTilbud pakke = (PakkeTilbud) getItem(i);

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_row_item_tilbud, null);
        }

        TextView tv = view.findViewById(R.id.list_text);

        tv.setText(Html.fromHtml(pakke.toString()));


        return view;
    }
}
