package com.spreys.albumviewer.Model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 24/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class Album {
    private int id;
    private int userId;
    private String title;

    public Album(String jsonString) {
        try {
            initialiseObject(new JSONObject(jsonString));
        } catch (JSONException | NullPointerException exception) {
            exception.printStackTrace();
            throw new IllegalArgumentException("Unable to parse jSON");
        }
    }

    public Album(JSONObject jsonObject) {
        initialiseObject(jsonObject);
    }

    private void initialiseObject(JSONObject jsonObject) {
        try {
            this.id = jsonObject.getInt("id");
            this.userId = jsonObject.getInt("userId");
            this.title = jsonObject.getString("title");
        } catch (JSONException exception) {
            exception.printStackTrace();
            throw new IllegalArgumentException("Unable to parse jSON");
        }
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public String getTitle() {
        return title;
    }
}
