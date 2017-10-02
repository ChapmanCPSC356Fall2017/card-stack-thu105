package heinmoethu.cardstack;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    private Stack<Card> cardStack = new Stack<>();
    private Stack<Integer> traceStack = new Stack<>();
    private Card c;
    private TextView tv_top, tv_bot;
    private ImageView iv_top, iv_bot, iv_temp;
    private RelativeLayout rl_temp;
    private final String[] n = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_top= (TextView) findViewById(R.id.top_num);
        tv_bot= (TextView) findViewById(R.id.bottom_num);
        iv_top= (ImageView) findViewById(R.id.top_p);
        iv_bot= (ImageView) findViewById(R.id.bottom_p);

        for (int x=0;x<=12;++x){
            for(int y=1;y<=4;++y){
                switch (y){
                    case 1:
                        c=new Card(x,Suit.SPADE);
                        break;
                    case 2:
                        c=new Card(x,Suit.CLOVER);
                        break;
                    case 3:
                        c=new Card(x,Suit.DIAMOND);
                        break;
                    case 4:
                        c=new Card(x,Suit.HEART);
                        break;
                    default:
                        c=new Card(0,Suit.SPADE);
                        break;
                }
                cardStack.push(c);
            }
        }
        Collections.shuffle(cardStack);
        showCard();
    }

    private void showCard(){
        if(cardStack.empty()){
            finish();
        }
        else{
            c=cardStack.pop();
        }
        buildCard(c);
    }
    private void buildCard(Card c){
        int d;
        int color;
        switch(c.getSuit()){
            case SPADE:
                color=Color.BLACK;
                d=R.drawable.spade;
                break;
            case CLOVER:
                color=Color.BLACK;
                d=R.drawable.clover;
                break;
            case DIAMOND:
                color=Color.RED;
                d=R.drawable.diamond;
                break;
            default:
                color=Color.RED;
                d=R.drawable.heart;
                break;
        }
        tv_top.setText(n[c.getNum()]);
        tv_top.setTextColor(color);
        tv_bot.setText(n[c.getNum()]);
        tv_bot.setTextColor(color);
        iv_bot.setImageResource(d);
        iv_top.setImageResource(d);
        emptyCard();
        switch(c.getNum()){
            case 0:
                buildA(d);
                break;
            case 1:
                build2(d);
                break;
            case 2:
                build3(d);
                break;
            case 3:
                build4(d);
                break;
            case 4:
                build5(d);
                break;
            case 5:
                build6(d);
                break;
            case 6:
                build7(d);
                break;
            case 7:
                build8(d);
                break;
            case 8:
                build9(d);
                break;
            case 9:
                build10(d);
                break;
            default:
                buildFace(d,color);
                break;


        }

    }
    private void buildA(int d){
        rl_temp= (RelativeLayout) findViewById(R.id.h1);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.h1);
        iv_temp= (ImageView) findViewById(R.id.h1p1);
        iv_temp.setImageResource(d);
    }
    private void build2(int d){
        rl_temp= (RelativeLayout) findViewById(R.id.h2);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.h2);
        iv_temp= (ImageView) findViewById(R.id.h2p1);
        iv_temp.setImageResource(d);
        iv_temp= (ImageView) findViewById(R.id.h2p2);
        iv_temp.setImageResource(d);
    }
    private void build3(int d){
        build2(d);
        rl_temp = (RelativeLayout) findViewById(R.id.h3);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.h3);
        iv_temp = (ImageView) findViewById(R.id.h3p3);
        iv_temp.setImageResource(d);
    }
    private void build4(int d){
        rl_temp = (RelativeLayout) findViewById(R.id.h4);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.h4);
        iv_temp = (ImageView) findViewById(R.id.h4p1);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h4p2);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h4p3);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h4p4);
        iv_temp.setImageResource(d);
    }
    private void build5(int d){
        build4(d);
        rl_temp = (RelativeLayout) findViewById(R.id.h5);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.h5);
        iv_temp = (ImageView) findViewById(R.id.h5p5);
        iv_temp.setImageResource(d);
    }
    private void build6(int d){
        build4(d);
        rl_temp = (RelativeLayout) findViewById(R.id.h6);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.h6);
        iv_temp = (ImageView) findViewById(R.id.h6p5);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h6p6);
        iv_temp.setImageResource(d);
    }
    private void build7(int d){
        build6(d);
        rl_temp = (RelativeLayout) findViewById(R.id.h7);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.h7);
        iv_temp = (ImageView) findViewById(R.id.h7p7);
        iv_temp.setImageResource(d);
    }
    private void build8(int d){
        rl_temp = (RelativeLayout) findViewById(R.id.h8);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.h8);
        iv_temp = (ImageView) findViewById(R.id.h8p1);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h8p2);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h8p3);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h8p4);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h8p5);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h8p6);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h8p7);
        iv_temp.setImageResource(d);
        iv_temp = (ImageView) findViewById(R.id.h8p8);
        iv_temp.setImageResource(d);
    }
    private void build9(int d){
        build8(d);
        rl_temp = (RelativeLayout) findViewById(R.id.h9);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.h9);
        iv_temp = (ImageView) findViewById(R.id.h9p9);
        iv_temp.setImageResource(d);
    }
    private void build10(int d){
        build9(d);
        rl_temp = (RelativeLayout) findViewById(R.id.h10);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.h10);
        iv_temp = (ImageView) findViewById(R.id.h10p10);
        iv_temp.setImageResource(d);
    }
    private void buildFace(int d,int color){
        rl_temp = (RelativeLayout) findViewById(R.id.f);
        rl_temp.setVisibility(View.VISIBLE);
        traceStack.push(R.id.f);
        iv_temp= (ImageView) findViewById(R.id.face);
        if(color==Color.BLACK) {
            if (c.getNum() == 10)
                iv_temp.setImageResource(R.drawable.jack);
            else if (c.getNum() == 11)
                iv_temp.setImageResource(R.drawable.queen);
            else
                iv_temp.setImageResource(R.drawable.king);
        }
        else {
            if (c.getNum() == 10)
                iv_temp.setImageResource(R.drawable.jack_red);
            else if (c.getNum()==11)
                iv_temp.setImageResource(R.drawable.queen_red);
            else
                iv_temp.setImageResource(R.drawable.king_red);
        }
    }
    private void emptyCard(){
        while(!traceStack.isEmpty()){
            rl_temp=(RelativeLayout) findViewById(traceStack.pop());
            rl_temp.setVisibility(View.GONE);
        }
    }
    public void onClickScreen(View view) {
        showCard();
    }
}
