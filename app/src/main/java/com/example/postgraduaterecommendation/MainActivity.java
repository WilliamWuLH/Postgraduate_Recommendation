package com.example.postgraduaterecommendation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvmain;
    private List<String> website = Arrays.asList(
            "https://m.baidu.com/",
            "https://admission.pku.edu.cn/zsxx/index.htm",
            "http://yz.tsinghua.edu.cn/publish/yjszs/index.html",
            "http://yzb.hitsz.edu.cn/zs",
            "https://yzb.sjtu.edu.cn/",
            "http://www.gsao.fudan.edu.cn/",
            "http://grs.zju.edu.cn/yjszs/",
            "https://grawww.nju.edu.cn/899/list.htm",
            "https://yz.ustc.edu.cn/",
            "http://yz.tongji.edu.cn/",
            "http://210.42.121.116/wdyz/",
            "http://gszs.hust.edu.cn/",
            "http://pgs.ruc.edu.cn/",
            "http://yzb.buaa.edu.cn/",
            "http://yjszs.nudt.edu.cn/index/index.view",
            "http://graduate.sysu.edu.cn/zsw/postgraduate",
            "http://www2.scut.edu.cn/graduate/",
            "http://gra.csu.edu.cn/zsgz.aspx?wjdlb=1&wjxlb=2&id=a2"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRvmain = findViewById(R.id.rv_main);
        mRvmain.setLayoutManager(new LinearLayoutManager(this));
        mRvmain.setAdapter(new LinearAdapter(this, new LinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Intent intent = new Intent(MainActivity.this, WebviewActivity.class);
                Bundle bundle = new Bundle();
                String mURL = website.get(pos);
                bundle.putString("URL",mURL);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        }));
    }
}
