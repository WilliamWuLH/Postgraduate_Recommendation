package com.example.postgraduaterecommendation;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class LinearAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<String> School = Arrays.asList("百度搜索", "北京大学","北京大学深圳研究生院", "清华大学","清华大学深圳研究生院","哈工大深圳",
            "上海交通大学","复旦大学","浙江大学","南京大学","中国科学技术大学",
            "同济大学","武汉大学","华中科技大学","电子科技大学","中国人民大学","北京航天航空大学",
            "国防科技大学","中山大学","华南理工大学","中南大学");
    private List<String> website = Arrays.asList(
            "https://m.baidu.com/",
            "https://admission.pku.edu.cn/zsxx/index.htm",
            "http://www.pkusz.edu.cn/",
            "http://yz.tsinghua.edu.cn/publish/yjszs/index.html",
            "http://www.tsinghua-sz.edu.cn/",
            "http://yzb.hitsz.edu.cn/zs",
            "https://yzb.sjtu.edu.cn/",
            "http://www.gsao.fudan.edu.cn/",
            "http://grs.zju.edu.cn/yjszs/",
            "https://grawww.nju.edu.cn/899/list.htm",
            "https://yz.ustc.edu.cn/",
            "http://yz.tongji.edu.cn/",
            "http://210.42.121.116/wdyz/",
            "http://gszs.hust.edu.cn/",
            "https://yz.uestc.edu.cn/",
            "http://pgs.ruc.edu.cn/",
            "http://yzb.buaa.edu.cn/",
            "http://yjszs.nudt.edu.cn/index/index.view",
            "http://graduate.sysu.edu.cn/zsw/postgraduate",
            "http://www2.scut.edu.cn/graduate/",
            "http://gra.csu.edu.cn/zsgz.aspx?wjdlb=1&wjxlb=2&id=a2"
    );

    private List<String> cs_website = Arrays.asList(
            "http://www.ds.pku.edu.cn/index.htm",
            "http://www.ece.pku.edu.cn/admissions/admission/",
            "https://iiis.tsinghua.edu.cn/list-364-1.html",
            "http://www.thss.tsinghua.edu.cn/publish/soft/index.html",
            "http://cs.hitsz.edu.cn/rcpy/zsjh.htm",
            "http://www.cs.sjtu.edu.cn/index.aspx",
            "http://www.cs.fudan.edu.cn/",
            "http://www.cs.zju.edu.cn/csen/",
            "https://cs.nju.edu.cn/",
            "http://cs.ustc.edu.cn/",
            "https://see.tongji.edu.cn/index.htm",
            "http://cs.whu.edu.cn/",
            "http://cs.hust.edu.cn/",
            "http://www.scse.uestc.edu.cn/",
            "http://info.ruc.edu.cn/index.php",
            "http://scse.buaa.edu.cn/",
            "https://www.nudt.edu.cn/",
            "http://sdcs.sysu.edu.cn/",
            "http://www2.scut.edu.cn/cs/",
            "http://cse.csu.edu.cn/"
    );


    public LinearAdapter(Context context){
        this.mContext = context;
    }

    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType == 0)
            return new LinearViewHolder2(LayoutInflater.from(mContext).inflate(R.layout.linear_item2,parent,false));
        else
            return new LinearViewHolder(LayoutInflater.from(mContext).inflate(R.layout.linear_item,parent,false));
    }

    @Override
    public int getItemViewType(int position) {
        if(position == 0)
            return 0;
        else
            return 1;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(getItemViewType(position) == 0){
            LinearViewHolder2 mholder = (LinearViewHolder2)holder;
            mholder.btn1.setText(School.get(position));
            mholder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, WebviewActivity.class);
                    Bundle bundle = new Bundle();
                    String mURL = website.get(position);
                    bundle.putString("URL",mURL);
                    intent.putExtra("bundle", bundle);
                    mContext.startActivity(intent);
                }
            });
        }
        else{
            LinearViewHolder mholder = (LinearViewHolder)holder;
            mholder.btn1.setText(School.get(position));
            mholder.btn2.setText("计算机院");
            mholder.btn1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, WebviewActivity.class);
                    Bundle bundle = new Bundle();
                    String mURL = website.get(position);
                    bundle.putString("URL",mURL);
                    intent.putExtra("bundle", bundle);
                    mContext.startActivity(intent);
                }
            });
            mholder.btn2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext, WebviewActivity.class);
                    Bundle bundle = new Bundle();
                    String mURL = cs_website.get(position-1);
                    bundle.putString("URL",mURL);
                    intent.putExtra("bundle", bundle);
                    mContext.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return School.size();
    }

    class LinearViewHolder extends RecyclerView.ViewHolder{

        private Button btn1,btn2;
        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            btn1 = itemView.findViewById(R.id.btn_school);
            btn2 = itemView.findViewById(R.id.btn_cs);
        }
    }
    class LinearViewHolder2 extends RecyclerView.ViewHolder{

        private Button btn1;
        public LinearViewHolder2(@NonNull View itemView) {
            super(itemView);
            btn1 = itemView.findViewById(R.id.btn_school);
        }
    }
}
