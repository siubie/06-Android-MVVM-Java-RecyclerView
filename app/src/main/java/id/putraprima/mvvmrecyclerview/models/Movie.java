package id.putraprima.mvvmrecyclerview.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String movieTitle;
    private String movieDescription;
    private Boolean movieStatus;

    public Movie() {
    }

    public Movie(String movieTitle, String description, Boolean movieStatus) {
        this.movieTitle = movieTitle;
        this.movieDescription = description;
        this.movieStatus = movieStatus;
    }

    protected Movie(Parcel in) {
        movieTitle = in.readString();
        movieDescription = in.readString();
        byte tmpMovieStatus = in.readByte();
        movieStatus = tmpMovieStatus == 0 ? null : tmpMovieStatus == 1;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(movieTitle);
        dest.writeString(movieDescription);
        dest.writeByte((byte) (movieStatus == null ? 0 : movieStatus ? 1 : 2));
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getMovieDescription() {
        return movieDescription;
    }

    public void setMovieDescription(String movieDescription) {
        this.movieDescription = movieDescription;
    }

    public Boolean getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(Boolean movieStatus) {
        this.movieStatus = movieStatus;
    }
}
