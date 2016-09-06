package com.wzx.app;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by wzx001 on 2016/8/23.
 */
public class SimpleAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private List<String> mDatas;
    private Context mContext;
    private LayoutInflater inflater;

    public SimpleAdapter(Context mContext,List<String> mDatas){
        this.mContext = mContext;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.lv_simple_item,parent,false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.txvName.setText(mDatas.get(position));
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{
    TextView txvName;
    public MyViewHolder(View view) {
        super(view);
        txvName = (TextView) view.findViewById(R.id.txv_name);
    }
}