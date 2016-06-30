package com.example.android.americanquiz;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Navendu Agarwal on 30-Jun-16.
 */
public class Score implements Parcelable {
    public static final Parcelable.Creator<Score> CREATOR = new Parcelable.Creator<Score>() {

        @Override
        public Score createFromParcel(Parcel parcel) {
            return new Score(parcel);
        }

        @Override
        public Score[] newArray(int size) {
            return new Score[size];
        }
    };
    private int totalScore;
    private int correctCount;

    public Score(int score, int count) {
        totalScore = score;
        correctCount = count;
    }

    public Score() {
        super();
    }

    public Score(Parcel p) {
        totalScore = p.readInt();
        correctCount = p.readInt();
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(totalScore);
        dest.writeInt(correctCount);
    }

    public int getCorrectCount() {
        return correctCount;
    }

    public void setCorrectCount(int correctCount) {
        this.correctCount = correctCount;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public int getGetTotalScore() {
        return totalScore;
    }

}
