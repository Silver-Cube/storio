package com.pushtorefresh.storio3.sqlite.annotations;

@StorIOSQLiteType(table = "table")
public class UnsupportedType {

    @StorIOSQLiteColumn(name = "id", key = true)
    long id;

    @StorIOSQLiteColumn(name = "class")
    UnsupprtedClass unsupprtedClass;

    public class UnsupprtedClass {

    }
}