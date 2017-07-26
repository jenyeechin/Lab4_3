package my.edu.tarc.lab4_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listView;
    UserDataSource userDataSource;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);
        listView.setOnItemClickListener(this);

    }

    public void insertRecord(View v) {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
    }

    public void addRecord(View v) {
        Intent intent = new Intent(this, InsertActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        updateList();
        super.onResume();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Toast.makeText(this, "Position :" + position, Toast.LENGTH_SHORT).show();
    }

    private void updateList() {
        //Retrieve records from SQLite
        userDataSource = new UserDataSource(this);
        userDataSource.open();
        final List<UserRecord> values = userDataSource.getAllUsers();
        UserRecordAdapter adapter = new UserRecordAdapter(this, R.layout.record_layout, values);
        //Link adapter to ListView
        listView.setAdapter(adapter);
        //ListView <----Adapter<-----DB
        //        ----->
        //     custom layout

    }

    protected void onPause() {
        userDataSource.close();
        super.onPause();
    }


}




