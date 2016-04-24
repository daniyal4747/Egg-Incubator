package mind.exuberants.cellphonemessagereceiver;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button butLcd,butSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        Controller controller=new Controller();
        controller.setController(getApplicationContext());


        FragmentManager mFragmentManager= getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction= mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.frame, new LcdFragment()).commit();

        butLcd      = (Button) findViewById(R.id.lcd);
        butSetting  = (Button) findViewById(R.id.setting);

        butLcd.setOnClickListener(this);
        butSetting.setOnClickListener(this);


        if(getIntent().getExtras()!=null)
        {
            FragmentManager mFragmentManager2= getSupportFragmentManager();
            FragmentTransaction mFragmentTransaction2= mFragmentManager2.beginTransaction();
            mFragmentTransaction2.replace(R.id.frame, new LcdFragment()).commit();


        }



    }

    @Override
    public void onClick(View v) {

        FragmentManager mFragmentManager= getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction= mFragmentManager.beginTransaction();




        if(v==butLcd){
            mFragmentTransaction.replace(R.id.frame, new LcdFragment()).commit();


        }
        else if(v==butSetting){
            mFragmentTransaction.replace(R.id.frame, new SettingFragment()).commit();


        }
    }
}
