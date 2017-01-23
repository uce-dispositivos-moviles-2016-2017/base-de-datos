package com.darwindeveloper.noteu.myfragments;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.darwindeveloper.noteu.R;
import com.darwindeveloper.noteu.classes.Person;

import java.util.ArrayList;

/**
 * Created by DARWIN on 20/1/2017.
 */

public class PersonsAdater extends RecyclerView.Adapter<PersonsAdater.MyViewHolder> {

    private Context context;
    private ArrayList<Person> persons;


    public PersonsAdater(Context context, ArrayList<Person> persons) {
        this.persons = persons;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_person, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Person person = persons.get(position);

        holder.c_id.setText(person.getC_id());
        holder.name.setText(person.getName());


    }

    @Override
    public int getItemCount() {
        return persons.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, c_id;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.textView_name);
            c_id = (TextView) itemView.findViewById(R.id.textView_ci);
        }
    }
}
