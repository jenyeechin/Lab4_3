package my.edu.tarc.lab4_3;

import java.util.ArrayList;
import java.util.List;
import my.edu.tarc.lab4_3.UserContract.User;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDataSource {
	private SQLiteDatabase database;
	private UserSQLHelper dbHelper;
	private String[] allColumn = {
			User.COLUMN_NAME,
			User.COLUMN_EMAIL
	};
	
	public UserDataSource(Context context){
		dbHelper = new UserSQLHelper(context);
	}
	
	public void open() throws SQLException{
		database = dbHelper.getWritableDatabase();
	}
	
	public void close(){
		dbHelper.close();
	}

	//insert new user record to DB
	public void insertUser(UserRecord userRecord){
		ContentValues values = new ContentValues(); //save in database
		
		values.put(User.COLUMN_NAME, userRecord.getName()); //where to put, what to put
		values.put(User.COLUMN_EMAIL, userRecord.getEmail()); //Pair of values (Name of field, value)

		open();
		database.insert(User.TABLE_NAME, null, values); //calling default insert method
		database.close();
	}


	//Retrieve all user records
	public List<UserRecord> getAllUsers(){
		List<UserRecord> records = new ArrayList<UserRecord>();
		
		Cursor cursor = database.query(User.TABLE_NAME, allColumn , null, null, null, null, null);
		//INSER INTO table name ()field-list VALUES (value-list)

		cursor.moveToFirst();
		
		while(!cursor.isAfterLast()){ //not the end of file
			UserRecord userRecord = new UserRecord();
			userRecord.setName(cursor.getString(0)); //first field - name
			userRecord.setEmail(cursor.getString(1)); //email
			records.add(userRecord); //(s)
			cursor.moveToNext();
		}
		
		cursor.close(); //release resource
		return records;
	}
}
