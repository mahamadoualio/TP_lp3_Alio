package controller.myuniversity.com.myuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class SubscribeActivity extends AppCompatActivity {

    private EditText txtFirstName, txtLastName;
    private CheckBox cbBac, cbLicence, cbMaster;
    private Button btnSave;
    private String firstName, lastName, degrees;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subscribe);

        txtFirstName=(EditText)findViewById(R.id.txtFirstName);
        txtLastName=(EditText)findViewById(R.id.txtLastName);
        cbBac=(CheckBox)findViewById(R.id.cbBac);
        cbLicence=(CheckBox)findViewById(R.id.cbLicence);
        cbMaster=(CheckBox)findViewById(R.id.cbMaster);
        btnSave=(Button)findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                firstName=txtFirstName.getText().toString();
                lastName=txtLastName.getText().toString();
                degrees="";
                if(cbBac.isChecked())
                    degrees+=cbBac.getText().toString()+" ";
                if(cbLicence.isChecked())
                    degrees+=cbLicence.getText().toString()+" ";
                if(cbMaster.isChecked())
                    degrees+=cbMaster.getText().toString();

                String resume=firstName+"\n"+lastName+"\n"+degrees;
                Toast.makeText(SubscribeActivity.this, resume, Toast.LENGTH_SHORT).show();


            }
        });

    }
}
