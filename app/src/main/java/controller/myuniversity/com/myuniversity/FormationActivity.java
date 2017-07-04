package controller.myuniversity.com.myuniversity;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class FormationActivity extends AppCompatActivity {

    private String tabFormation[] ,tabDetailsFormation[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formation);

        tabFormation=getResources().getStringArray(R.array.tab_formation);
        tabDetailsFormation=getResources().getStringArray(R.array.tab_details_formation);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(FormationActivity.this, android.R.layout.simple_list_item_1, tabFormation);
        ListView listFormation=(ListView)findViewById(R.id.listFormation);
        listFormation.setAdapter(adapter);

        listFormation.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                final String formation=tabFormation[position];
                final String details=tabDetailsFormation[position];

                AlertDialog.Builder dialog=new AlertDialog.Builder(FormationActivity.this);
                dialog.setTitle(formation);
                dialog.setMessage(details);
                dialog.setIcon(R.mipmap.esmt);

                dialog.setPositiveButton("S'inscrire", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {

                        Intent intent=new Intent(FormationActivity.this, SubscribeActivity.class);
                        startActivity(intent);
                    }
                });

                dialog.setNegativeButton("Annuler", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                dialog.show();

            }
        });
    }
}
