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
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;

    public Company (String jsonString) {
        try {
            initialiseObject(new JSONObject(jsonString));
        } catch (JSONException | NullPointerException exception) {
            exception.printStackTrace();
            throw new IllegalArgumentException("Unable to parse json");
        }
    }

    public Company (JSONObject jsonObject) {
        initialiseObject(jsonObject);
    }

    private void initialiseObject(JSONObject jsonObject){
        try {
            this.name = jsonObject.getString("name");
            this.catchPhrase = jsonObject.getString("catchPhrase");
            this.bs = jsonObject.getString("bs");
        } catch (JSONException exception) {
            exception.printStackTrace();
            throw new IllegalArgumentException("Unable to parse json");
        }
    }

    public String getName() {
        return name;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
