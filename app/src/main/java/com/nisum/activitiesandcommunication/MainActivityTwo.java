package com.nisum.activitiesandcommunication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivityTwo extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintwo);
        System.out.println("************* onCreate **************");

        try{
            Bundle b = getIntent().getExtras();
            myCustomData customData = b.getParcelable("myData");
            System.out.println("************* Data in second screen **************"+customData.textValue);
            ((TextView)findViewById(R.id.textView)).setText(customData.textValue);
        }catch(Exception e){

        }

    }

    // Fragment 
//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        System.out.println("************* onSaveInstanceState **************"+mTextField.getText().toString());
//        outState.putString("TextFieldData",mTextField.getText().toString());
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//        System.out.println("************* onRestoreInstanceState **************"+savedInstanceState.getString("TextFieldData"));
//        mTextField.setText(savedInstanceState.getString("TextFieldData"));
//    }

    @Override
    protected void onStart() {
        System.out.println("************* onStart **************");
        super.onStart();
    }

    @Override
    protected void onResume() {
        System.out.println("************* onResume **************");
        super.onResume();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                Bundle b = new Bundle();
                b.putString("data","sometext");
                i.putExtras(b);
                setResult(Activity.RESULT_OK,i);
                finish();
            }
        });
    }

    @Override
    protected void onPause() {
        System.out.println("************* onPause **************");
        super.onPause();
    }

    @Override
    protected void onStop() {
        System.out.println("************* onStop **************");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        System.out.println("************* onDestroy **************");
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
