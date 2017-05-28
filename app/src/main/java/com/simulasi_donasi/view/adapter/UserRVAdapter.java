package com.simulasi_donasi.view.adapter;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.simulasi_donasi.R;
import com.simulasi_donasi.model.entity.Data;
import com.simulasi_donasi.model.entity.User;
import com.simulasi_donasi.model.session.SessionManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Macdoze on 4/25/2017.
 */

public class UserRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Data> datas;
    public List<Data> getDatas() {
        return datas;
    }
    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }

    public UserRVAdapter() {
        this.datas = new ArrayList<>();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View _view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user_linear, parent, false);
        return new ItemUserViewHolder(_view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final ItemUserViewHolder _holder = (ItemUserViewHolder) holder;
        final Data _data = this.datas.get(position);
        _holder.image.setImageResource(_data.getImg());
        _holder.name.setText(_data.getName());
        _holder.email.setText(_data.getBio());
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private class ItemUserViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name, email;

        public ItemUserViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_user_linear_image);
            name = (TextView) itemView.findViewById(R.id.item_user_linear_name);
            email = (TextView) itemView.findViewById(R.id.item_user_linear_email);
        }
    }
}
