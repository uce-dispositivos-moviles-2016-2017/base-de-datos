package com.darwindeveloper.noteu.myfragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.darwindeveloper.noteu.MainActivity;
import com.darwindeveloper.noteu.R;
import com.darwindeveloper.noteu.database.DataBaseHelper;
import com.darwindeveloper.noteu.database.DatabaseManager;

import java.io.IOException;

/**
 * Created by DARWIN on 20/1/2017.
 */

public class StudentsFragment extends Fragment {

    private Context context;
    private ViewGroup rootView;
    private RecyclerView list;
    private PersonsAdater mAdater;


    DataBaseHelper dataBaseHelper;
    DatabaseManager databaseManager;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();

        dataBaseHelper = new DataBaseHelper(getActivity());
        try {
            dataBaseHelper.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
        }

        databaseManager = new DatabaseManager(context, dataBaseHelper.getWritableDatabase());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        rootView = (ViewGroup) inflater.inflate(
                R.layout.students_fragment, container, false);

        list = (RecyclerView) rootView.findViewById(R.id.recylerview_students);
        mAdater = new PersonsAdater(context, databaseManager.getStudents());
        list.setLayoutManager(new LinearLayoutManager(context));
        list.setAdapter(mAdater);

        return rootView;
    }
}
