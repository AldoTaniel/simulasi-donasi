package com.simulasi_donasi.view.adapter;

import android.app.SearchManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.simulasi_donasi.R;
import com.simulasi_donasi.model.entity.Data;
import com.simulasi_donasi.model.entity.User;
import com.simulasi_donasi.model.session.SessionManager;
import com.simulasi_donasi.view.activity.MainActivity;
import com.simulasi_donasi.view.fragment.user.UserASC;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by Macdoze on 4/25/2017.
 */

public class UserRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<Data> datas;
    public Context context;
    ArrayList<Data> mModel;
    String searchString = "";

    public List<Data> getDatas() {
        return datas;
    }
    public void setDatas(List<Data> datas) {
        this.datas = datas;
    }
    public UserRVAdapter(List<Data> parkingList, Context context) {
        this.datas = parkingList;
        this.context = context;
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
        _holder.amount.setText(String.valueOf(_data.getAmount()));

        Data txt = datas.get(position);
        String nama = txt.getName().toLowerCase(Locale.getDefault());
        if (nama.contains(searchString)) {

            int startPos = nama.indexOf(searchString);
            int endPos = startPos + searchString.length();

            Spannable spanString = Spannable.Factory.getInstance().newSpannable(_holder.name.getText());
            spanString.setSpan(new ForegroundColorSpan(Color.RED), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

            _holder.name.setText(spanString);
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    private class ItemUserViewHolder extends RecyclerView.ViewHolder {
        private ImageView image;
        private TextView name, amount;

        public ItemUserViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_user_linear_image);
            name = (TextView) itemView.findViewById(R.id.item_user_linear_name);
            amount = (TextView) itemView.findViewById(R.id.item_user_linear_amount);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    String nama = name.getText().toString();
                }
            });

        }
    }

    public void setFilter(List<Data> countryModels) {
        mModel = new ArrayList<>();
        mModel.addAll(countryModels);
        notifyDataSetChanged();
    }
}

