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

    private List<Person> persons;
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
        persons.add(new Person("Ashish Pujari", "24 years old", R.drawable.ic_launcher));
        persons.add(new Person("Sachin Wagh", "23 years old", R.drawable.ic_launcher));
        persons.add(new Person("Yo Yo", "35 years old", R.drawable.ic_launcher));
        persons.add(new Person("Saurbha", "24 years old", R.drawable.ic_launcher));
        persons.add(new Person("Yuraj", "23 years old", R.drawable.ic_launcher));
        persons.add(new Person("Ms", "35 years old", R.drawable.ic_launcher));
        persons.add(new Person("Shakshi", "24 years old", R.drawable.ic_launcher));
        persons.add(new Person("Suresh", "23 years old", R.drawable.ic_launcher));
        persons.add(new Person("Ashwin", "35 years old", R.drawable.ic_launcher));
        persons.add(new Person("John", "24 years old", R.drawable.ic_launcher));
        persons.add(new Person("Sachin Wagh", "23 years old", R.drawable.ic_launcher));
        persons.add(new Person("df", "35 years old", R.drawable.ic_launcher));


    }

    private void initializeAdapter(){
        RVAdapter adapter = new RVAdapter(persons);
        rv.setAdapter(adapter);
    }
}
