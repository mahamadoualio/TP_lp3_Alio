package controller.myuniversity.com.myuniversity;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class BDUniversity extends SQLiteOpenHelper {

    public BDUniversity(Context context){

        super(context, "dbuniv.db", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE user (id INTEGER PRIMARY KEY AUTOINCREMENT, login VARCHAR (50), password VARCHAR(50) );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS user;");
        onCreate(db);
    }
    public boolean addUser (String login, String password)
    {
        try {
        SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("login" , login);
            cv.put("password" , password);
            db.insert("user", null, cv);
            db.close();
            return true;

        } catch (Exception e)  {
            e.printStackTrace();
            return false;
    }
}
    public boolean updateUser (String login, String password)
    {
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            ContentValues cv=new ContentValues();
            cv.put("login" , login);
            cv.put("password" , password);
            db.update("user", cv, "login='"+login+"'", null);
            db.close();
            return true;

        } catch (Exception e)  {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteUser (String login)
    {
        try {
            SQLiteDatabase db=this.getWritableDatabase();
            db.delete("user", "login='"+login+"'", null);
            db.close();
            return true;

        } catch (Exception e)  {
            e.printStackTrace();
            return false;
        }
    }
    public List<String> getUsers ()
    {
        List<String> list=new ArrayList<>();
        try {
            SQLiteDatabase db=this.getReadableDatabase();
            Cursor c=db.query("user", null, null, null, null, null, null);

            if (c.getCount()>0)

            {
                c.moveToFirst();
                do {
                    String login=c.getString(1);
                    String password=c.getString(c.getColumnIndex("password"));
                    list.add(login+"/"+password);

                }while (c.moveToNext());
            }
            db.close();
            return list;
            
        } catch (Exception e)  {
            e.printStackTrace();
            return list;
        }
    }
}
