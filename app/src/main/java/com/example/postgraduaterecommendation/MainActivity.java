package com.example.postgraduaterecommendation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRvmain;

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
                String mURL = sendURL(pos);
                bundle.putString("URL",mURL);
                intent.putExtra("bundle", bundle);
                startActivity(intent);
            }
        }));
    }

    private String sendURL(int pos){
        String URL = null;
        switch (pos){
            case 0:
                URL = "https://admission.pku.edu.cn/zsxx/index.htm";
                break;
            case 1:
                URL = "http://yz.tsinghua.edu.cn/publish/yjszs/index.html";
                break;
            case 2:
                URL = "http://yzb.hitsz.edu.cn/zs";
                break;
            case 3:
                URL = "https://yzb.sjtu.edu.cn/";
                break;
            case 4:
                URL = "http://www.gsao.fudan.edu.cn/";
                break;
            case 5:
                URL = "http://grs.zju.edu.cn/yjszs/";
                break;
            case 6:
                URL = "https://grawww.nju.edu.cn/899/list.htm";
                break;
            case 7:
                URL = "https://yz.ustc.edu.cn/";
                break;
            case 8:
                URL = "http://yz.tongji.edu.cn/";
                break;
            case 9:
                URL = "http://210.42.121.116/wdyz/";
                break;
            case 10:
                URL = "http://gszs.hust.edu.cn/";
                break;
            case 11:
                URL = "http://pgs.ruc.edu.cn/";
                break;
            case 12:
                URL = "http://yzb.buaa.edu.cn/";
                break;
            case 13:
                URL = "http://yjszs.nudt.edu.cn/index/index.view";
                break;
            case 14:
                URL = "http://graduate.sysu.edu.cn/zsw/postgraduate";
                break;
            case 15:
                URL = "http://www2.scut.edu.cn/graduate/";
                break;
            case 16:
                URL = "http://gra.csu.edu.cn/zsgz.aspx?wjdlb=1&wjxlb=2&id=a2";
                break;
        }
        return URL;
    }
}
