package mind.exuberants.cellphonemessagereceiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

/**
 * Created by Daniyal on 23-04-2016.
 */
public class SmsReceiver extends BroadcastReceiver {
    static Listener listener;
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle extras = intent.getExtras();
        PhoneDb phoneDb=new PhoneDb(context);
        String phoneNumber;
        if(phoneDb.dataOfUserExists()) {
            phoneNumber = phoneDb.getPhone();


            if (extras == null)
                return;
            //toast

            Object[] pdus = (Object[]) extras.get("pdus");

            for (int i = 0; i < pdus.length; i++) {
                SmsMessage SMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
                String sender = SMessage.getOriginatingAddress();
                String body = SMessage.getMessageBody().toString();

                if (sender.equals(phoneNumber)) {

                    if(body.equalsIgnoreCase("B") || body.equalsIgnoreCase("H") || body.equalsIgnoreCase("S") ||
                            body.equalsIgnoreCase("C") || body.equalsIgnoreCase("L") || body.equalsIgnoreCase("F")){

                        abortBroadcast();

                    }
                    else {
                        abortBroadcast();
                        listener.setMsg(body);
                        //Controller controller =Controller.getInstance();
                        //controller.saveMsg(body);
                        /*Intent intent1 = new Intent(context, MainActivity.class);
                        intent1.putExtra("data", body);
                        intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent1);*/
                        return;
                    }

                }

            }
        }
        else{
            Toast.makeText(context, "Please set Phone Number first", Toast.LENGTH_SHORT).show();

        }

    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public interface Listener{
        public void setMsg(String msg);
    }
}