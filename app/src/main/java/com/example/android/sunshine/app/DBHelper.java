package com.example.android.sunshine.app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by owner on 2014. 12. 28..
 */
public class DBHelper extends SQLiteOpenHelper {
    private int DB_VERSION = 2;
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }
    /*
    예를 들어서
    최초 앱 만들시
    man table에 name, age column만 존재. version = 1
    -> 다음 앱 업데이트 때 job column이 추가되어야 함 version = 2
    -> 그 다음 업데이트 때 location column이 추가되어야 함. version = 3


     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion == 1){
           //job column 추가
        } else if(oldVersion == 2){
           //location column 추가
        }
    }
}
