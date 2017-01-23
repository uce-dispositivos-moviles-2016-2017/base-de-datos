package com.darwindeveloper.noteu.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.darwindeveloper.noteu.classes.Constants;
import com.darwindeveloper.noteu.classes.Person;


import java.util.ArrayList;

/**
 * Created by DARWIN on 20/1/2017.
 */

public class DatabaseManager {
    private Context context;
    private SQLiteDatabase sqLiteDatabase;

    public DatabaseManager(Context context, SQLiteDatabase sqLiteDatabase) {
        this.context = context;
        this.sqLiteDatabase = sqLiteDatabase;
    }


    public ArrayList<Person> getStudents() {

        ArrayList<Person> students = new ArrayList<>();

        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + Constants.TABLE_STUDENTS, null);

        if (cursor == null) return null;

        cursor.moveToFirst();
        do {
            String id = cursor.getString(cursor.getColumnIndex("student_id"));
            String name = cursor.getString(cursor.getColumnIndex("student_name"));
            String c_id = cursor.getString(cursor.getColumnIndex("c_id"));
            students.add(new Person(Integer.parseInt(id), name, c_id, false));
        } while (cursor.moveToNext());
        cursor.close();

        return students;

    }

}
