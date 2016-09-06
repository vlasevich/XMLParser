package com.home.vlas.xmlparser.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.home.vlas.xmlparser.R;
import com.home.vlas.xmlparser.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class ContactAdapter extends BaseAdapter {

    private List<Contact> contactList = new ArrayList<>();
    private Activity activity;
    private LayoutInflater layoutInflater;

    public ContactAdapter(Activity activity, List<Contact> contactList) {
        this.activity = activity;
        this.contactList = contactList;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int i) {
        return contactList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (layoutInflater == null) {
            layoutInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null) {
            view = layoutInflater.inflate(R.layout.contact_list_row, null);
        }
        TextView firstName = (TextView) view.findViewById(R.id.firstName);
        TextView lastName = (TextView) view.findViewById(R.id.lastName);
        TextView phone = (TextView) view.findViewById(R.id.phone);

        firstName.setText(contactList.get(i).getFirstName());
        lastName.setText(contactList.get(i).getLastName());
        phone.setText(contactList.get(i).getPhone());

        return view;
    }
}
