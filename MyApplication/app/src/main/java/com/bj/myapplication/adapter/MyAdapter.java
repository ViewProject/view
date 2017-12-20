package com.bj.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bj.myapplication.R;
import com.bj.myapplication.bean.JavaBean;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by 郑文杰 on 2017/12/19.
 */

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final List<JavaBean.DataBean.ComingBean> list;
    private final Context context;
    public MyAdapter(Context context, List<JavaBean.DataBean.ComingBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder holder1 = (MyViewHolder) holder;
        JavaBean.DataBean.ComingBean comingBean = list.get(position);
        holder1.mvName.setText(comingBean.nm);
        holder1.mvDate.setText(comingBean.showInfo);
        holder1.mvDec.setText(comingBean.scm);
        String url = comingBean.img;
        String imageurl = url.replaceAll("w.h", "50.80");//字符串替换
        Log.e("图片路径", url);
        Glide.with(context).load(imageurl).into(holder1.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView mvName;
        TextView tvPeople;
        TextView tvProfessional;
        TextView mvDec;
        TextView mvDate;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.image);
            mvName = (TextView) itemView.findViewById(R.id.mv_name);
            tvPeople = (TextView) itemView.findViewById(R.id.tv_people);
            tvProfessional = (TextView) itemView.findViewById(R.id.tv_professional);
            mvDec = (TextView) itemView.findViewById(R.id.mv_dec);
            mvDate = (TextView) itemView.findViewById(R.id.mv_date);
        }

    }
}