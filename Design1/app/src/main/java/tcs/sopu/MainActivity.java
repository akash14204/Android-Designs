package tcs.sopu;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Animation animBounce = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
        final Animation animBlink = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);

        final ImageButton img1= (ImageButton) findViewById(R.id.imageButton);
        assert img1 != null;
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.startAnimation(animBlink);
            }
        });
        final ImageButton img2= (ImageButton) findViewById(R.id.imageButton2);
        assert img2 != null;
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img2.startAnimation(animBlink);
            }
        });
        final ImageButton img3= (ImageButton) findViewById(R.id.imageButton3);
        assert img3 != null;
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img3.startAnimation(animBlink);
            }
        });






        final TextView myTextView1 = (TextView) findViewById(R.id.textView1);
        Typeface typeface1 = Typeface.createFromAsset(getAssets(), "fonts/lob.ttf");
        myTextView1.setTypeface(typeface1);
        myTextView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTextView1.startAnimation(animBounce);
                //WRITE CODE HERE
            }
        });

        final TextView myTextView2 = (TextView) findViewById(R.id.textView2);
        Typeface typeface2 = Typeface.createFromAsset(getAssets(), "fonts/lob.ttf");
        myTextView2.setTypeface(typeface2);
        myTextView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTextView2.startAnimation(animBounce);
                //WRITE CODE HERE
            }
        });
        final TextView myTextView3 = (TextView) findViewById(R.id.textView3);
        Typeface typeface3 = Typeface.createFromAsset(getAssets(), "fonts/lob.ttf");
        myTextView3.setTypeface(typeface3);
        myTextView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTextView3.startAnimation(animBounce);
                //WRITE CODE HERE
            }
        });
        final TextView myTextView4 = (TextView) findViewById(R.id.textView4);
        Typeface typeface4 = Typeface.createFromAsset(getAssets(), "fonts/lob.ttf");
        myTextView4.setTypeface(typeface4);
        myTextView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myTextView4.startAnimation(animBounce);
                //WRITE CODE HERE
            }
        });
    }
}
