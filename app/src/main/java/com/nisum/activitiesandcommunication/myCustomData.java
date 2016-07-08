package com.nisum.activitiesandcommunication;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;


/**
 * Created by NIS1175m on 7/7/16.
 */
public class myCustomData implements Parcelable {

    public String textValue;
    public float floatValue;
    public mySerialData complexCustomData;

    public myCustomData(String value) {
        this.textValue = value;
    }

    public myCustomData(Parcel in){
        this.textValue = in.readString();
        this.floatValue = in.readFloat();
        this.complexCustomData = (mySerialData)in.readSerializable();
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.textValue);
        dest.writeFloat(this.floatValue);
        dest.writeSerializable(this.complexCustomData);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public myCustomData createFromParcel(Parcel in) {
            return new myCustomData(in);
        }

        public myCustomData[] newArray(int size) {
            return new myCustomData[size];
        }
    };
}
