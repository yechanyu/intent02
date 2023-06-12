package com.example.ddd2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity {
    public class ResultActivity extends Activity{
        protected void onCreate(Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            setContentView(R.layout.result);
            setTitle("투표 결과");

            Intent intent=getIntent();
            int [] voteResult=intent.getIntArrayExtra("voteCount");
            String[]imgName=intent.getStringArrayExtra("ImageName");
            TextView tv[]=new TextView[imgName.length];
            RatingBar rbar[]=new RatingBar[imgName.length];

            Integer imageId[]={R.id.div1,R.id.div2,R.id.div3,R.id.div4,R.id.div5,
                    R.id.div6,R.id.div7,R.id.div8,R.id.div9};
            Integer rbarId[]={R.id.rbar1,R.id.rbar2,R.id.rbar3,R.id.rbar4,
                    R.id.rbar5,R.id.rbar6,R.id.rbar7,R.id.rbar8,R.id.rbar9};

            for (int i=0;i<voteResult.length;i++){
                tv[i].setText(imgName[i]);
                rbar[i].setRating((float)voteResult[i]);
            }

            Button btn=(Button)findViewById(R.id.btnReturn);
            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
        }
    }
}
