package mind.exuberants.cellphonemessagereceiver;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Daniyal on 06-03-2016.
 */
public class PhoneDb {

    Context context;
    private SQLiteDatabase db;
    private Cursor c;


    public PhoneDb(Context c) {
        context  = c;
        db       = context.openOrCreateDatabase("Phone", Context.MODE_PRIVATE, null);
        createUserTable();
<<<<<<< HEAD
=======
        createDataTable();
>>>>>>> 338d242f79d2431de4c3807f57eb0d70b69d6d0a
    }
    public void createUserTable() {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "User(phone VARCHAR);");
    }
<<<<<<< HEAD
=======
    public void createDataTable() {
        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Data(msg VARCHAR);");
    }
>>>>>>> 338d242f79d2431de4c3807f57eb0d70b69d6d0a

    public void deleteUser(){
        db.execSQL("Drop TABLE IF EXISTS User");

        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "User(phone VARCHAR);");

    }
    public void setUserData(String phone) {

        db.execSQL("INSERT INTO User " +
                "VALUES('"+ phone + "');");

    }

    public String getPhone() {
        String name = null;
        c = db.rawQuery("SELECT phone FROM User", null);
        while (c.moveToNext()) {
            name = c.getString(0).toString();
        }
        return name;
    }

    public boolean dataOfUserExists() {
        c = db.rawQuery("SELECT * FROM User", null);
        if(c.getCount()>0)return true;
        else return false;
    }
<<<<<<< HEAD
=======


    public void deleteData(){
        db.execSQL("Drop TABLE IF EXISTS Data");

        db.execSQL("CREATE TABLE IF NOT EXISTS " +
                "Data(msg VARCHAR);");

    }

    public void setMsgData(String msg) {

        db.execSQL("INSERT INTO Data " +
                "VALUES('"+ msg + "');");

    }
    public String getMsg() {
        String name = null;
        c = db.rawQuery("SELECT msg FROM Data", null);
        while (c.moveToNext()) {
            name = c.getString(0).toString();
        }
        return name;
    }

    public Cursor dataOfMsgExists() {
        c = db.rawQuery("SELECT * FROM Data", null);
        return c;
    }




>>>>>>> 338d242f79d2431de4c3807f57eb0d70b69d6d0a
}
