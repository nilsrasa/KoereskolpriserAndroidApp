package dk.gruppe5.koerskolepriser.fragmenter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;

import dk.gruppe5.koerskolepriser.MinData;
import dk.gruppe5.koerskolepriser.R;
import dk.gruppe5.koerskolepriser.adaptere.TilbudAdapter;
import dk.gruppe5.koerskolepriser.fragmenter.dummy.DummyContent;
import dk.gruppe5.koerskolepriser.fragmenter.dummy.DummyContent.DummyItem;


public class MineTilbudFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_minetilbud, container, false);

        ListView lv = view.findViewById(R.id.lv_mine_fragment);
        ListAdapter adapter = new TilbudAdapter(getContext(), MinData.getInstance().getAlleTilbud());
        lv.setAdapter(adapter);

        return view;
    }
}
