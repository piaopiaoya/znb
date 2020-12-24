package com.example.myapplication.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.adapter.NumAdapter;
import com.example.myapplication.bean.NumberBean;
import com.example.myapplication.contrart.MainContrart;
import com.example.myapplication.presenter.NumPresenter;

import java.util.ArrayList;

public class CollFragment extends Fragment implements MainContrart.getNumberView {

    private RecyclerView rv_coll;
    private ArrayList<NumberBean.StudenlistBean> list;
    private NumAdapter adapter;
    private NumPresenter numPresenter;
    private int mposition;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_coll, null);
        numPresenter = new NumPresenter(this);
        initView(view);
        initListener();
        return view;
    }

    private void initListener() {
        //设置长按监听
        adapter.setOnLongClickItemListener(new NumAdapter.OnLongClickItemListener() {
            @Override
            public void onLongClickItem(int position) {
                //创建一个新位置 把它移出去
                mposition = position;
                list.remove(mposition);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void initView(View view) {
        rv_coll = view.findViewById(R.id.rv_coll);
        rv_coll.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new NumAdapter(getActivity(), list);
        rv_coll.setAdapter(adapter);
        numPresenter.getNumberPresenter();
        rv_coll.addItemDecoration(new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL));
    }

    @Override
    public void OnNumberOk(NumberBean numberBean) {
        list.addAll(numberBean.getStudenlist());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void OnNumberNO(String fail) {

    }
}
