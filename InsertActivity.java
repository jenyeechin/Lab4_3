package my.edu.tarc.lab4_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InsertActivity extends AppCompatActivity {

    EditText editTextName, editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
    }

    public void saveRecord(View v){
        editTextName = (EditText)findViewById(R.id.editTextName);
        editTextEmail = (EditText)findViewById(R.id.editTextEmail);

        UserRecord userRecord = new UserRecord();
        userRecord.setName(editTextName.getText().toString());
        userRecord.setEmail(editTextEmail.getText().toString());

        UserDataSource userDataSource = new UserDataSource(this);
        userDataSource.open();
        userDataSource.insertUser(userRecord);
        userDataSource.close();

        this.finish(); //Terminate this Activity
    }
}
