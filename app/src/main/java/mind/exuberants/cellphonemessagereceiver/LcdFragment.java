package mind.exuberants.cellphonemessagereceiver;

import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Daniyal on 24-04-2016.
 */
public class LcdFragment extends Fragment implements View.OnClickListener,SmsReceiver.Listener {

    Controller controller;
    Button btT, btH, btLT, btLTF, btLTS, btOFF;
<<<<<<< HEAD
    TextView tvHumidity, tvTemp, tvStatus, Egg, Number;
=======
    TextView tvHumidity;
    TextView tvTemp;
    TextView tvStatus;
    TextView Egg;
    TextView Number;
>>>>>>> 338d242f79d2431de4c3807f57eb0d70b69d6d0a


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.lcd_layout, container, false);
        controller= Controller.getInstance();

        setLayout(view);
        SmsReceiver s=new SmsReceiver();
        s.setListener(this);
        return view;

    }

    @Override
    public void onClick(View v) {
        if (v == btT) {
            sendMesg("B");
        } else if (v == btH) {
            sendMesg("C");

        } else if (v == btLT) {
            sendMesg("H");

        } else if (v == btLTF) {
            sendMesg("L");

        } else if (v == btLTS) {
            sendMesg("S");

        } else if (v == btOFF) {
            sendMesg("F");

        }


    }

    public void setLayout(View view) {
        btT = (Button) view.findViewById(R.id.t);
        btH = (Button) view.findViewById(R.id.h);
        btLT = (Button) view.findViewById(R.id.LT);
        btLTF = (Button) view.findViewById(R.id.ltf);
        btLTS = (Button) view.findViewById(R.id.lts);
        btOFF = (Button) view.findViewById(R.id.off);

        btT.setOnClickListener(this);
        btH.setOnClickListener(this);
        btLT.setOnClickListener(this);
        btLTF.setOnClickListener(this);
        btLTS.setOnClickListener(this);
        btOFF.setOnClickListener(this);

        tvHumidity = (TextView) view.findViewById(R.id.humidity);
        tvTemp = (TextView) view.findViewById(R.id.temp);
        tvStatus = (TextView) view.findViewById(R.id.status);
        Egg = (TextView) view.findViewById(R.id.egg);
        Number = (TextView) view.findViewById(R.id.number);
    }

    public void sendMesg(String msg) {
        SmsManager smsManager = SmsManager.getDefault();
        String ph = Controller.getInstance().getPhNumber();
        smsManager.sendTextMessage(ph, null, msg, null, null);
    }

    public void setDatatoLcd(String data) {
        if(data.equalsIgnoreCase("Alert.dec humidity") || data.equalsIgnoreCase("Alert.inc humidity") ){
            tvHumidity.setText(data);

            tvStatus.setText(tvStatus.getText());
            Egg.setText(Egg.getText());
            Number.setText(Number.getText());
            tvTemp.setText(tvTemp.getText());
        }
        ////////////////////////////////////////////////////////////////////////////////////////
        else if(data.equalsIgnoreCase("Alert.dec temperature") || data.equalsIgnoreCase("Alert.inc humidity")){
            tvTemp.setText(data);

            tvHumidity.setText(tvHumidity.getText());
            tvStatus.setText(tvStatus.getText());
            Egg.setText(Egg.getText());
            Number.setText(Number.getText());
        }
        ///////////////////////////////////////////////////////////////////////////////////////
        else if(data.equalsIgnoreCase("LOAD STATUS ON") || data.equalsIgnoreCase("LOAD STATUS OFF")){
            tvStatus.setText(data);

            tvTemp.setText(tvTemp.getText());
            tvHumidity.setText(tvHumidity.getText());
            Egg.setText(Egg.getText());
            Number.setText(Number.getText());

        }
        //////////////////////////////////////////////////////////////////////////////////////
        else if (data.equalsIgnoreCase("PENOY EGG")||data.equalsIgnoreCase("BELUTE EGG")) {
            Egg.setText(data);

            tvStatus.setText(tvStatus.getText());
            tvTemp.setText(tvTemp.getText());
            tvHumidity.setText(tvHumidity.getText());
            Number.setText(Number.getText());

        }
        else{
            Number.setText(data);

            Egg.setText(Egg.getText());
            tvStatus.setText(tvStatus.getText());
            tvTemp.setText(tvTemp.getText());
            tvHumidity.setText(tvHumidity.getText());
        }
    }

    @Override
    public void setMsg(String msg) {
        setDatatoLcd(msg);
    }
}
