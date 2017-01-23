package com.darwindeveloper.noteu.classes;

/**
 * Created by DARWIN on 20/1/2017.
 */

public class Person {
    private int id;
    private String name, c_id;
    private boolean isTeacher;

    public Person(int id, String name, String c_id,boolean isTeacher) {
        this.id = id;
        this.name = name;
        this.c_id = c_id;
        this.isTeacher=isTeacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public boolean getIsTeacher() {
        return isTeacher;
    }

    public void SetIsTeacher(boolean teacher) {
        isTeacher = teacher;
    }
}
