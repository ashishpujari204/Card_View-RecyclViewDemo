package com.app.cardviewdemo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Activity {

    private List<PersonClass> persons;
    private RecyclerView rv;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.recyclerview_activity);

        context=RecyclerViewActivity.this;

        rv=(RecyclerView)findViewById(R.id.rv);

        rv.addOnItemTouchListener(
                new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        // do whatever
                        Toast.makeText(RecyclerViewActivity.this, "Clicked Item is---" + persons.get(position).name.toString(), Toast.LENGTH_LONG).show();
                    }
                })
        );

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData(){
        persons = new ArrayList<>();

        persons.add(new PersonClass("A", "35 years old", R.drawable.ic_launcher));
        persons.add(new PersonClass("B", "24 years old", R.drawable.ic_launcher));
        persons.add(new PersonClass("C", "23 years old", R.drawable.ic_launcher));
        persons.add(new PersonClass("D", "35 years old", R.drawable.ic_launcher));
        persons.add(new PersonClass("S", "24 years old", R.drawable.ic_launcher));
        persons.add(new PersonClass("a", "23 years old", R.drawable.ic_launcher));
        persons.add(new PersonClass("G", "35 years old", R.drawable.ic_launcher));
        persons.add(new PersonClass("E", "24 years old", R.drawable.ic_launcher));
        persons.add(new PersonClass("QW", "23 years old", R.drawable.ic_launcher));
        persons.add(new PersonClass("df", "35 years old", R.drawable.ic_launcher));

    }

    private void initializeAdapter(){
        MyAdapter adapter = new MyAdapter(persons);
        rv.setAdapter(adapter);
    }
}
