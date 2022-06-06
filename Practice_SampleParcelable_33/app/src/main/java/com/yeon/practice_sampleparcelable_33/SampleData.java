package com.yeon.practice_sampleparcelable_33;

import android.os.Parcel;
import android.os.Parcelable;

public class SampleData implements Parcelable {

    int number;
    String message;

    public SampleData(int num, String msg) {
        number = num;
        message = msg;
    }

    public SampleData(Parcel src) {
        number = src.readInt();
        message = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {

        public SampleData createFromParcel(Parcel in) {
            return new SampleData(in);
        }

        public SampleData[] newArray(int size) {
            return new SampleData[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
