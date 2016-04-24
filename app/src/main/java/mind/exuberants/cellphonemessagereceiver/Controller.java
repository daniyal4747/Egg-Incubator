package mind.exuberants.cellphonemessagereceiver;

import android.content.Context;
import android.database.Cursor;

/**
 * Created by Daniyal on 24-04-2016.
 */
public class Controller {
    private Context context;

    private static PhoneDb database;
    private static Controller instance = null;


    public Controller() {
    }

    private Controller(Context context) {
        this.context = context;
        database = new PhoneDb(context);
    }

    public void setController(Context context) {
        if (instance == null) {
            instance = new Controller(context);

        }
    }
    public  static                  Controller getInstance() {
        if (instance == null) {
            instance = new Controller();

        }
        return instance;
    }

    public void setData(String data) {

        database.deleteUser();
        database.setUserData(data);
    }

    public String getPhNumber() {
        return database.getPhone();
    }

    public void saveMsg(String body) {
        database.deleteData();
        database.setMsgData(body);
    }

    public Cursor msgDataexist() {
        
        return  database.dataOfMsgExists();
    }

    public String getMsg() {
        return database.getMsg();
    }
}