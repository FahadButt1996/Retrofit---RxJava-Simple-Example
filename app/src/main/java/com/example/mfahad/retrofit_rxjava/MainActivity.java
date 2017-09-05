package com.example.mfahad.retrofit_rxjava;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    List<Data> list ;
    Context context;
    private TextView showList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = this;
        showList = (TextView) findViewById(R.id.list_View);
        list = new ArrayList<>();
        Api api = ApiUtils.getApiInterface();
        final Observable<List<Data>> data = api.getData();
        data.subscribeOn(Schedulers.io())
             .observeOn(AndroidSchedulers.mainThread())
             .subscribe(new Observer<List<Data>>() {
            @Override
            public void onSubscribe(Disposable d) {
                Toast.makeText(MainActivity.this, "OnSubscribe", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(List<Data> value) {
                Toast.makeText(MainActivity.this, "OnNext", Toast.LENGTH_SHORT).show();
                // Use the list<data> as you want
                showList.setText(value.toString());
            }

            @Override
            public void onError(Throwable e) {
                Toast.makeText(MainActivity.this, "OnError" + e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onComplete() {
                Toast.makeText(MainActivity.this, "OnComplete", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
