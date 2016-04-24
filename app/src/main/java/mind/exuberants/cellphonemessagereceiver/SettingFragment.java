package mind.exuberants.cellphonemessagereceiver;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Daniyal on 24-04-2016.
 */
public class SettingFragment extends Fragment implements View.OnClickListener {
    Button confirm;
    EditText phone;
    PhoneDb phoneDb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.setting_layout, container, false);
        phoneDb =new PhoneDb(getActivity());

        phone   = (EditText) view.findViewById(R.id.phone);
        confirm = (Button) view.findViewById(R.id.confirm);
        confirm.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        String ph=phone.getText().toString();
        if(ph.length()>9){
            Controller controller=Controller.getInstance();
            controller.setData(ph);
            Toast.makeText(getContext(),"Phone Number Updated Successfully",Toast.LENGTH_SHORT).show();

        }
        else{
            Toast.makeText(getContext(),"Enter Valid Phone Number",Toast.LENGTH_SHORT).show();
        }
    }
}
