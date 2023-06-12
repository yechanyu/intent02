package com.example.ddd2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("선호도 조사");

        final int []voteCount=new int[9];
        for(int i=0;i<9;i++){
            voteCount[i]=0;
        }

        ImageView image[]=new ImageView[9];
        Integer imageId[]={R.id.div1,R.id.div2,R.id.div3,R.id.div4,R.id.div5,
                R.id.div6,R.id.div7,R.id.div8,R.id.div9};
        final  String imgName[]={"독서","꽃","부채","벼르망","잠소녀","테라스",
                "피아노","피아노 앞","해변"};

        for (int i=0;i<imageId.length;i++){
            final int index;//현재 번호 넣기 위해서
            index=i;
            image[index]=(ImageView) findViewById(imageId[index]);
            image[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    voteCount[index]++;
                    Toast.makeText(getApplicationContext(),imgName[index]+
                            ":총 "+voteCount[index]+"표",Toast.LENGTH_SHORT).show();
                }
            });
        }
        Button fi=(Button)findViewById(R.id.btn);
        fi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), ResultActivity.class);
                i.putExtra("voteCount",voteCount);
                i.putExtra("ImageName",imgName);
                startActivity(i);
            }
        });
    }
}