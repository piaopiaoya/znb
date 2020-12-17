package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.RvBean;

import java.util.ArrayList;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.ViewHodel> {
    private Context context;
    private ArrayList<RvBean.NewsBean> list;


    public RvAdapter(Context context, ArrayList<RvBean.NewsBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.tiaomu, null);
        return new ViewHodel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodel holder, int position) {
        holder.mTvDesc.setText(list.get(position).getContent());
        holder.mTvTitle.setText(list.get(position).getTile());
        Glide.with(context).load(list.get(position).getImageUrl()).into(holder.mIv);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHodel extends RecyclerView.ViewHolder {
        private ImageView mIv;
        private TextView mTvTitle;
        private TextView mTvDesc;

        public ViewHodel(@NonNull View itemView) {
            super(itemView);
            mIv = (ImageView) itemView.findViewById(R.id.iv);
            mTvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            mTvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
        }
    }
}
