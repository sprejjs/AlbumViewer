package com.spreys.albumviewer.Model;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 24/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class Photo {
    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;

    public Photo(String jsonString) {
        try {
            initialiseObject(new JSONObject(jsonString));
        } catch (JSONException | NullPointerException exception) {
            exception.printStackTrace();
            throw new IllegalArgumentException("Unable to parse JSON");
        }
    }

    public Photo(JSONObject jsonObject) {
        initialiseObject(jsonObject);
    }

    private void initialiseObject(JSONObject jsonObject) {
        try {
            this.albumId = jsonObject.getInt("albumId");
            this.id = jsonObject.getInt("id");
            this.title = jsonObject.getString("title");
            this.url = jsonObject.getString("url");
            this.thumbnailUrl = jsonObject.getString("thumbnailUrl");
        } catch (JSONException exception) {
            exception.printStackTrace();
            throw new IllegalArgumentException("Unable to parse JSON");
        }
    }

    public int getAlbumId() {
        return albumId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }
}
