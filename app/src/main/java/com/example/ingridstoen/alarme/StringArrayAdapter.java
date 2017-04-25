package com.example.ingridstoen.alarme;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by aminaettayebi on 26.03.2017.
 */

public class StringArrayAdapter extends BaseAdapter {



    //The class extends Baseadapter,

    ArrayList<String> names = new ArrayList<>();
    Context ctxt;
    LayoutInflater myInflater;

    public StringArrayAdapter(ArrayList<String>   arr, Context c) {
        names = arr;
        ctxt = c;
        myInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    public int getCount() {

        return names.size();

    }


    public Object getItem(int arg0) {

        return names.get(arg0);
    }

    public long getItemId(int arg0) {

        return arg0;
    }

    //main view
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        //create the cell (view) and populate it with an element of the array
        if (arg1 == null) {
            arg1 = myInflater.inflate(android.R.layout.simple_list_item_1, arg2, false);
        }
        TextView name = (TextView) arg1.findViewById(android.R.id.text1);
        name.setText(names.get(arg0));
        return arg1;

    }




    }



