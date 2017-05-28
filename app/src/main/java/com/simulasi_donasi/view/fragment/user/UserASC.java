package com.simulasi_donasi.view.fragment.user;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.simulasi_donasi.R;
import com.simulasi_donasi.model.entity.Data;
import com.simulasi_donasi.view.adapter.UserRVAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserASC extends Fragment {


    private RecyclerView rv;
    private UserRVAdapter adapter;

    public UserASC() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
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

}
