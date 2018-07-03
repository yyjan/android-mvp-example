package com.example.yun.androidmvpexample.main.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yun.androidmvpexample.R;
import com.example.yun.androidmvpexample.data.Document;
import com.example.yun.androidmvpexample.main.MainListActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainListAdapter extends RecyclerView.Adapter<MainListAdapter.ItemHolder>
        implements AdapterContract.View, AdapterContract.Model {

    private Context context;
    private ArrayList<Document> items = new ArrayList<>();
    private MainListActivity.ItemListener itemListener;

    public MainListAdapter(Context context, MainListActivity.ItemListener itemListener) {
        this.context = context;
        this.itemListener = itemListener;
    }

    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        if (holder == null) return;
        holder.onBind(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void loadItems(List<Document> items) {
        this.items.addAll(items);
    }

    @Override
    public void addItem(Document item) {
        this.items.add(item);
    }

    public ArrayList<Document> getItems() {
        return items;
    }

    public class ItemHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_title)
        TextView tvTitle;

        @BindView(R.id.iv_thumb)
        ImageView ivThumb;

        public ItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void onBind(final int position) {
            final Document item = items.get(position);

            if (!TextUtils.isEmpty(item.getTitle())) {
                tvTitle.setText(item.getTitle());
            }

            if (!TextUtils.isEmpty(item.getThumbnail())) {
                Glide.with(context).load(item.getThumbnail()).into(ivThumb);
            }

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemListener.onItemClick(position);
                }
            });
        }
    }
}
