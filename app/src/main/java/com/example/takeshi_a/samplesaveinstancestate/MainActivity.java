package com.example.takeshi_a.samplesaveinstancestate;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 日時を表示する
        showClock();
    }


    /**
     * 画面破棄のタイミングで本メッソド内で定義した変数に値を保存する
     * ※メソッド呼出タイミング：画面が破棄される時
     * @param outState
     * @param outPersistentState
     */
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        TextView textResult = (TextView) findViewById(R.id.txt_clock);
        outState.putString("saveClock", textResult.getText().toString());
    }


    /**
     * onSaveInstanceStateで保存した値を復元する
     * ※メソッド呼出タイミング：画面が再生成される時
     * @param savedInstanceState
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        TextView txtResult = (TextView) findViewById(R.id.txt_clock);
        txtResult.setText(savedInstanceState.getString("saveClock"));
    }

    /**
     * 日時を表示する
     * 以下をlayout(activity_main.xml)に実装する
     *  - Button : ユーザに時刻表示を促すボタン
     *  - TextView : Buttonを押した際に時刻を表示するView
     */
    private void showClock() {

        // ボタン：日時表示ボタン
        Button buttonClock = (Button) findViewById(R.id.btn_clock);

        // クリック：現在の日時を表示する
        buttonClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView showClock = (TextView) findViewById(R.id.txt_clock);
                showClock.setText(new Date().toString());
            }
        });
    }

}
