package controller.myuniversity.com.myuniversity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class BDActivity extends AppCompatActivity {
    private EditText txtLogin, txtPassword;
    private Button btnAdd, btnUpdate, btnDelete, btnList;
    private String login, password;
    private BDUniversity bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bd);
        txtLogin=(EditText)findViewById(R.id.txtlogin);
        txtPassword=(EditText)findViewById(R.id.txtPassword);

        btnAdd=(Button) findViewById(R.id.btnAdd);
        btnUpdate=(Button) findViewById(R.id.btnUpdate);
        btnDelete=(Button) findViewById(R.id.btnDelete);
        btnList=(Button) findViewById(R.id.btnList);

        bd=new BDUniversity(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                login=txtLogin.getText().toString();
                password=txtPassword.getText().toString();

                boolean b=bd.addUser(login,password);

                if(b)
                    Toast.makeText(BDActivity.this, "Enregistrement réussi", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(BDActivity.this, "Enregistrement échoué", Toast.LENGTH_SHORT).show();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login=txtLogin.getText().toString();
                password=txtPassword.getText().toString();

                boolean b=bd.addUser(login,password);

                if(b)
                    Toast.makeText(BDActivity.this, "Modification réussi", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(BDActivity.this, "Modification échoué", Toast.LENGTH_SHORT).show();


            }
        });
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login=txtLogin.getText().toString();
                password=txtPassword.getText().toString();

                boolean b=bd.deleteUser(login);

                            if(b)
                    Toast.makeText(BDActivity.this, "suppression réussi", Toast.LENGTH_SHORT).show();
                             else
                    Toast.makeText(BDActivity.this, "suppression échoué", Toast.LENGTH_SHORT).show();

            }
        });
        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list=bd.getUsers();
                for (int i = 0; i < list.size(); i++) {
                    String user=list.get(i);
                    Toast.makeText(BDActivity.this,user, Toast.LENGTH_SHORT).show();


                }

            }
        });
    }
}
