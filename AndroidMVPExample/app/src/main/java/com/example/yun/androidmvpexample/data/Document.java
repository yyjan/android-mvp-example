package com.example.yun.androidmvpexample.data;

import android.os.Parcel;
import android.os.Parcelable;

public class Document implements Parcelable{
    private String title;

    public String getTitle() {
        return title;
    }

    public Document(String title) {
        this.title = title;
    }

    protected Document(Parcel in) {
        title = in.readString();
    }

    public static final Creator<Document> CREATOR = new Creator<Document>() {
        @Override
        public Document createFromParcel(Parcel in) {
            return new Document(in);
        }

        @Override
        public Document[] newArray(int size) {
            return new Document[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
    }
}
