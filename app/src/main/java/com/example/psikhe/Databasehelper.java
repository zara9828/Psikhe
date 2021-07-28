package com.example.psikhe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Databasehelper extends  SQLiteOpenHelper {


    public Databasehelper(Context context) {
        super(context, "LoginSQLite.db", null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS session");
        db.execSQL("CREATE TABLE users(id integer PRIMARY KEY AUTOINCREMENT, username text, password text)");
        db.execSQL("insert into SESSION(ID, login) VALUES(1, 'kosong')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldversion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS session");
        db.execSQL("DROP TABLE IF EXISTS user");
        onCreate(db);

    }

    public Boolean upgradeSession(String sessionValues, int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("login", sessionValues);
        long update = db.update("session", contentValues, "id=" + id, null);
        if (update == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean insertUser(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long insert = db.insert("user", null, contentValues);
        if (insert == -1) {
            return false;
        } else {
            return true;
        }
    }


        public Boolean checkLogin(String username, String password) {
            SQLiteDatabase db = this.getWritableDatabase();
            Cursor cursor = db.rawQuery("SELECT * FROM user WHERE username = ? AND password = ?", new String[]{username, password});
            if (cursor.getCount() > 0) {
                return false;
            } else {
                return true;
            }
        }
    }


