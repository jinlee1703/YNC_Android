package com.example.mission08;

import android.os.Parcel;
import android.os.Parcelable;

public class MemberData implements Parcelable {
    String id;
    String pw;

    public MemberData(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public MemberData(Parcel src) {
        id = src.readString();
        pw = src.readString();
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public MemberData createFromParcel(Parcel in) {
            return new MemberData(in);
        }

        public MemberData[] newArray(int size) {
            return new MemberData[size];
        }
    };

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(pw);
    }
}
