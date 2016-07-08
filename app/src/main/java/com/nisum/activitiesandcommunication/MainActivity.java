package com.nisum.activitiesandcommunication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends Activity {

    final static int SECOND_ACTIVITY_ID = 100;
    final static int THRID_ACTIVITY_ID = 102;
    final static int CAMERAID = 103;
    private EditText mTextField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        System.out.println("************* onCreate **************");
        mTextField = (EditText)findViewById(R.id.editText);
        // retreive the last saved data
        SharedPreferences sharedPref = getSharedPreferences("somekey", Context.MODE_PRIVATE);

        String str = sharedPref.getString("lastenteredmsg","default value");

        mTextField.setText(str+"");

        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
               // showScaleAnimation(findViewById(R.id.button));
                showTranslationAnimation(findViewById(R.id.button1));
                //showScaleAnimation(findViewById(R.id.button2));
                showTranslationAnimation(findViewById(R.id.button3));
                //showScaleAnimation(findViewById(R.id.button4));
            }
        },1000);

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

    private void showScaleAnimation(View v){
        AnimatorSet set = new AnimatorSet();
        set.play(ObjectAnimator.ofFloat(v, View.SCALE_X, 0, 1));
        set.play(ObjectAnimator.ofFloat(v, View.SCALE_Y, 0, 1));
       // set.play(ObjectAnimator.ofFloat(v, View.TRANSLATION_X, -500, 0));
        set.setDuration(1000);
        set.setInterpolator(new DecelerateInterpolator());
        set.start();
    }

    private void showTranslationAnimation(View v){
        AnimatorSet set = new AnimatorSet();
        set.play(ObjectAnimator.ofFloat(v, View.ALPHA, 0,1));
//        set.play(ObjectAnimator.ofFloat(v, View.SCALE_Y, 0, 1));
        // set.play(ObjectAnimator.ofFloat(v, View.TRANSLATION_X, -500, 0));
        set.setDuration(1000);
        set.setInterpolator(new DecelerateInterpolator());
        set.start();
    }

    @Override
    protected void onStart() {
        System.out.println("************* onStart **************");
        super.onStart();
    }

    @Override
    protected void onResume() {
        System.out.println("************* onResume **************");
        super.onResume();

        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // explict intent usage
                Intent i = new Intent(MainActivity.this,MainActivityThree.class);
                startActivityForResult(i,THRID_ACTIVITY_ID);

            }
        });


        findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer m = new MediaPlayer();
//                m.set
                m.start();


            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // implict intent usage
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERAID);


            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //custome broadcast messgae
                Intent intent = new Intent();
                intent.setAction("com.nisum.delete.myevent");
                Bundle b = new Bundle();
                b.putString("mycustomedata","some data");
                intent.putExtras(b);

                sendBroadcast(intent);
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // save the data using shared preference
                SharedPreferences sharedPref = getSharedPreferences("somekey", Context.MODE_PRIVATE);

                //editing the data
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("lastenteredmsg", mTextField.getText().toString());

                //saving
                editor.commit();

            }
        });

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Explict intent
//                Intent i = new Intent(MainActivity.this,MainActivityTwo.class);
//
//                Bundle bundle = new Bundle();
////                bundle.putString("EditTextValue",mTextField.getText().toString());
//
//                myCustomData customData = new myCustomData(mTextField.getText().toString());
//                bundle.putParcelable("myData",customData);
//
//                i.putExtras(bundle);
//                System.out.println("************* Data in first screen **************"+customData.textValue);
//                startActivity(i);

                //implict intent
//                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent,111);

                //finish();
                // data communication from activity one to activity two.
                // Launch my firstactivity
                // from first activity i launch second activity
                // first activity is going to background  ( onpause will get called )
                // passed some data from first to second
                // second on create, on resume
                // on second, user clicked on close button -> he is calling finish
                // on second on pause and on destroy
                // the first screen on resume, beacuse he has not mentioned finish before calling startactivity


                // data communication from activity second to activity first.

                // there is need that first activity want to know the status/data from the second activity
                // data we want from second to first, in such situtaiton we use startActivityForResult
                // startActivityForResult you can use any (implict or explict)

                Intent i = new Intent(MainActivity.this,MainActivityTwo.class);
                startActivityForResult(i,SECOND_ACTIVITY_ID);


                // will cover the below today
                //Boardcast receiver
                //launch the camera/sending email/share/ done
                //animations
                //shared preference



                // pending things
                //service
                //content providers
                //data storages
                //multimedia (video)
                //multimedia (audio)
                //unit test
                // scene and activity animation


                //hybrid

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        System.out.println("************* onActivityResult ************** requestCode "+requestCode+ " resultCode "+resultCode );

        switch (requestCode){
            case SECOND_ACTIVITY_ID:{
                System.out.println("************* response from second");
                if(resultCode == Activity.RESULT_OK){
                    // retreive the data
                    Bundle b = data.getExtras();
                    System.out.println("************* data from second" + b.getString("data"));
                }
                // do specific to second activity response
                break;
            }
            case THRID_ACTIVITY_ID:{
                System.out.println("************* response from third");
                // do specific to third activity response
                break;
            }
            case CAMERAID:{
                if(resultCode == Activity.RESULT_OK) {
                    Bitmap photo = (Bitmap) data.getExtras().get("data");
                    ((ImageView) findViewById(R.id.capturedimage)).setImageBitmap(photo);
                }
                break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
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
}
