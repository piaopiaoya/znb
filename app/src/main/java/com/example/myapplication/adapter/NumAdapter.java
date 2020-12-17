package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.bean.NumberBean;

import java.util.ArrayList;

public class NumAdapter extends RecyclerView.Adapter<NumAdapter.ViewHolder> {
    private Context context;
    private ArrayList<NumberBean.StudenlistBean> list;


    public NumAdapter(Context context, ArrayList<NumberBean.StudenlistBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.er, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.tvName.setText("姓名："+list.get(position).getName());
    holder.tvSkill.setText("机试成绩："+list.get(position).getSkill());
    holder.tvTheory.setText("理论成绩："+list.get(position).getTheory());
    holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View view) {
            onLongClickItemListener.onLongClickItem(position);
            return false;
        }
    });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvSkill;
        private TextView tvTheory;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = (TextView) itemView.findViewById(R.id.tv_name);
            tvSkill = (TextView) itemView.findViewById(R.id.tv_skill);
            tvTheory = (TextView) itemView.findViewById(R.id.tv_theory);
        }
    }

    public interface OnLongClickItemListener{
        void onLongClickItem(int position);
    }

    private OnLongClickItemListener onLongClickItemListener;

    public void setOnLongClickItemListener(OnLongClickItemListener onLongClickItemListener) {
        this.onLongClickItemListener = onLongClickItemListener;
    }
}
