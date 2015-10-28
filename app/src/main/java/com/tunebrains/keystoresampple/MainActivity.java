package com.tunebrains.keystoresampple;

import android.database.Cursor;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        readCursor(BuildConfig.MY_PROVIDER_URI);
        readCursor(BuildConfig.ANOTHER_PROVIDER_URI);
    }

    private void readCursor(String pAuthority) {
        Cursor c = null;
        try {
            c = getContentResolver().query(Uri.parse("content://" + pAuthority + "/query"), null, null, null, null);
            Log.d("Result", "" + c.getCount());
        }catch (Exception e){
            Log.d("Result", "Cannot access provider");
        }finally {
            if (c!=null){
                c.close();
            }
        }
    }
}
