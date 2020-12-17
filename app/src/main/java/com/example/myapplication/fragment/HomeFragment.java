package com.example.myapplication.fragment;

import android.os.Bundle;
import android.util.Log;
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
import com.example.myapplication.adapter.RvAdapter;
import com.example.myapplication.bean.RvBean;
import com.example.myapplication.contrart.MainContrart;
import com.example.myapplication.presenter.RvPresenter;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements MainContrart.getRvView {

    private RecyclerView rv;
    private ArrayList<RvBean.NewsBean> list;
    private RvAdapter adapter;
    private RvPresenter rvPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.fragment_home, null);
        rvPresenter = new RvPresenter(this);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rv = view.findViewById(R.id.rv);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        list = new ArrayList<>();
        adapter = new RvAdapter(getActivity(), list);
        rv.setAdapter(adapter);
        rvPresenter.getRvPresenter();
        rv.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));
    }

    @Override
    public void RvOk(RvBean rvBean) {
        list.addAll(rvBean.getNews());
        adapter.notifyDataSetChanged();
    }

    @Override
    public void RvNo(String fail) {
        Log.d("TAG","list解析错误："+fail);
    }
}
