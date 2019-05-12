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
import dk.gruppe5.koerskolepriser.objekter.Tilbud;
import dk.gruppe5.koerskolepriser.objekter.TilbudTilBruger;

public class TilbudAdapter extends BaseAdapter {
    private Context context;
    private List<Tilbud> tilbudListe;

    public TilbudAdapter(Context context, List<Tilbud> tilbudListe){
        this.context = context;
        this.tilbudListe = tilbudListe;
    }

    @Override
    public int getCount() {
        return tilbudListe.size();
    }

    @Override
    public Object getItem(int i) {
        return tilbudListe.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroupt) {
        Tilbud tilbud = (Tilbud) getItem(i);

        if (view == null){
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_row_item_tilbud, null);
        }

        TextView tv = view.findViewById(R.id.list_text);

        tv.setText(Html.fromHtml(tilbud.toString()));


        return view;
    }
}
