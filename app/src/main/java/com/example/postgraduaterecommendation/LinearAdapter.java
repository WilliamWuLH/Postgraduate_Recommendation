package com.example.postgraduaterecommendation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.LinearViewHolder> {

    private Context mContext;
    private OnItemClickListener mListener;
    private List<String> School = Arrays.asList("北京大学", "清华大学","哈工大深圳", "上海交通大学","复旦大学","浙江大学","南京大学","中国科学技术大学",
            "同济大学","武汉大学","华中科技大学","中国人民大学","北京航天航空大学","国防科技大学","中山大学","华南理工大学","中南大学");

    public LinearAdapter(Context context, OnItemClickListener listener){
        this.mContext = context;
        this.mListener = listener;
    }

    public LinearAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.linear_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.LinearViewHolder holder, final int position) {
        holder.btn1.setText(School.get(position));
        holder.btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onClick(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return School.size();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private Button btn1;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            btn1 = itemView.findViewById(R.id.btn_school);
        }
    }

    public interface OnItemClickListener{
        void onClick(int pos);
    }
}
