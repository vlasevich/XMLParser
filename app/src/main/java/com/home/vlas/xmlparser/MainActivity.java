package com.home.vlas.xmlparser;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.home.vlas.xmlparser.adapter.ContactAdapter;
import com.home.vlas.xmlparser.model.Contact;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String XML_TAG = "contact";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listView);
        ContactAdapter adapter = new ContactAdapter(this, getXMLData());
        listView.setAdapter(adapter);
    }

    private List<Contact> getXMLData() {
        List<Contact> list = new ArrayList<>();
        try {
            XmlPullParser parser = getResources().getXml(R.xml.contacts);
            while (parser.getEventType() != XmlPullParser.END_DOCUMENT) {
                if (parser.getEventType() == XmlPullParser.START_TAG && parser.getName().equals(XML_TAG)) {
                    list.add(new Contact(
                            parser.getAttributeValue(0),
                            parser.getAttributeValue(1),
                            parser.getAttributeValue(2)
                    ));
                }
                parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            Log.e(TAG, e.getMessage());
        }
        return list;
    }
}
