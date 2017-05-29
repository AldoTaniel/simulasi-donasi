package com.simulasi_donasi.view.fragment.user;


import android.app.SearchManager;
import android.content.Context;
import android.support.v7.appcompat.BuildConfig;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.simulasi_donasi.R;
import com.simulasi_donasi.model.entity.Data;
import com.simulasi_donasi.model.entity.User;
import com.simulasi_donasi.view.activity.MainActivity;
import com.simulasi_donasi.view.adapter.UserRVAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserASC extends Fragment implements SearchView.OnQueryTextListener{
    String searchString="";
    private RecyclerView rv;
    private UserRVAdapter adapter;
    private Context mContext;

    public UserASC() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Data.datas.clear();
        Data da = new Data("Sumbangan untuk korban gempa bumi","blablablablablablablablablabla",10000000);
        da.setImg(R.drawable.gempa);
        Data db = new Data("Sumbangan untuk korban banjir","blablablablablablablabla",58000000);
        db.setImg(R.drawable.banjir);
        Data dc = new Data("Sumbangan untuk korban tsunami","blablablablablablabla",25000000);
        dc.setImg(R.drawable.tsunami);
        Data dd = new Data("Pembangunan Masjid","blablablablablablablablablabla",10000000);
        dd.setImg(R.drawable.masjid);
        Data de = new Data("Pembangunan Gereja","blablablablablablablabla",55000000);
        de.setImg(R.drawable.gereja);
        Data df = new Data("Pembangunan Vihara","blablablablablablabla",25000000);
        df.setImg(R.drawable.vihara);
        Data dg = new Data("Operasi Katarak","blablablablablablablablablabla",10000000);
        dg.setImg(R.drawable.katarak);
        Data dh = new Data("Pembuatan Kaki Palsu","blablablablablablablabla",150000000);
        dh.setImg(R.drawable.kakipalsu);
        Data di = new Data("Operasi Bibir Sumbing","blablablablablablabla",3500000);
        di.setImg(R.drawable.bibirsumbing);
        Data.datas.add(da);
        Data.datas.add(db);
        Data.datas.add(dc);
        Data.datas.add(dd);
        Data.datas.add(de);
        Data.datas.add(df);
        Data.datas.add(dg);
        Data.datas.add(dh);
        Data.datas.add(di);
        mContext=getActivity();
        setHasOptionsMenu(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View _view = inflater.inflate(R.layout.fragment_user_asc, container, false);

        /* initiate & instantiate */
        adapter = new UserRVAdapter();
        rv = (RecyclerView) _view.findViewById(R.id.user_asc_rv);

        /* setting */
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setDatas(Data.datas);
        rv.setAdapter(adapter);
        return _view;
    }
    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        final List<Data> filteredModelList = filter(Data.datas, newText);
        if (filteredModelList.size() > 0) {
            adapter.setFilter(filteredModelList);
            return true;
        } else {
            return false;
        }
    }

    private List<Data> filter(List<Data> models, String query) {

        query = query.toLowerCase();
        this.searchString=query;

        final List<Data> filteredModelList = new ArrayList<>();
        for (Data model : models) {
            final String text = model.getName().toLowerCase();
            if (text.contains(query)) {
                filteredModelList.add(model);
            }
        }
        adapter = new UserRVAdapter(filteredModelList,getContext());
        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        return filteredModelList;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        TextView searchText = (TextView)
                searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
        searchText.setHint("Cari...");
        searchView.setOnQueryTextListener(this);

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
