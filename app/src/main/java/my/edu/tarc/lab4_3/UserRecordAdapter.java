package my.edu.tarc.lab4_3;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 25/7/2017.
 */



public class UserRecordAdapter extends ArrayAdapter<UserRecord> {



    public UserRecordAdapter(Context context, int resource, List<UserRecord> values) {
        super(context, resource);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //Retrieve a record from DB by calling getItem
        UserRecord userRecord = getItem(position);

        //get layout of current activity
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext())
                    .inflate(R.layout.record_layout, parent, false);
        }


        TextView textViewName, textViewEmail;
        textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewEmail = (TextView) convertView.findViewById(R.id.textViewEmail);

        textViewName.setText("Name:" + userRecord.getName());
        textViewEmail.setText("Email:" + userRecord.getEmail());
        return convertView;
    }

}
