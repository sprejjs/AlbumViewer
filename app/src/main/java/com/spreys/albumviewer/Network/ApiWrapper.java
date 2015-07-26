package com.spreys.albumviewer.Network;

import com.spreys.albumviewer.Model.Album;
import com.spreys.albumviewer.Model.Photo;
import com.spreys.albumviewer.Model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 24/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class ApiWrapper {
    //TODO add caching logic
    private final static String BASE_API_URL = "http://jsonplaceholder.typicode.com/";
    private final static String API_URL_PHOTOS = "photos/";
    private final static String API_URL_ALBUMS = "albums/";
    private final static String API_URL_USERS = "users/";

    //TODO apply singleton design pattern

    //Caching
    HashMap<Integer, Photo> photosHash = new HashMap<>();
    HashMap<Integer, Album> albumHash = new HashMap<>();
    HashMap<Integer, User> userHash = new HashMap<>();

    public Photo getPhoto(int id) {
        String url = BASE_API_URL + API_URL_PHOTOS + String.valueOf(id);
        JSONObject jsonObject = getJsonObjectFromUrl(url);
        return new Photo(jsonObject);
    }

    public ArrayList<Photo> getPhotos() {
        String url = BASE_API_URL + API_URL_PHOTOS;
        JSONArray jsonArray = getJsonArrayFromUrl(url);

        ArrayList<Photo> photos = new ArrayList<>();
        try {
            for (int i = 0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                photos.add(new Photo(jsonObject));
            }
        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }

        return photos;
    }

    public Album getAlbum(int id) {
        String url = BASE_API_URL + API_URL_ALBUMS + String.valueOf(id);
        JSONObject jsonObject = getJsonObjectFromUrl(url);
        return new Album(jsonObject);
    }

    public ArrayList<Album> getAlbums() {
        String url = BASE_API_URL + API_URL_ALBUMS;
        JSONArray jsonArray = getJsonArrayFromUrl(url);

        ArrayList<Album> albums = new ArrayList<>();
        try {
            for (int i = 0; i<jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                albums.add(new Album(jsonObject));
            }
        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }

        return albums;
    }

    public User getUser(int id) {
        String url = BASE_API_URL + API_URL_USERS + String.valueOf(id);
        JSONObject jsonObject = getJsonObjectFromUrl(url);
        return new User(jsonObject);
    }

    public ArrayList<User> getUsers() {
        String url = BASE_API_URL + API_URL_USERS;
        JSONArray jsonArray = getJsonArrayFromUrl(url);

        ArrayList<User> users = new ArrayList<>();
        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject object = jsonArray.getJSONObject(i);
                users.add(new User(object));
            }
        } catch (JSONException | NullPointerException e) {
            e.printStackTrace();
        }

        return users;
    }

    private JSONArray getJsonArrayFromUrl(String url) {

        try {
            return new JSONArray(getStringFromUrl(url));
        } catch (JSONException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    private JSONObject getJsonObjectFromUrl(String url) {
        try {
            return new JSONObject(getStringFromUrl(url));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String getStringFromUrl(String url) {
        URL myURL;
        try {
            myURL = new URL(url);
            URLConnection conn = myURL.openConnection();
            conn.setDoOutput(false);
            conn.setDoInput(true);

            InputStream is = conn.getInputStream();
            return convertStreamToString(is);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static String convertStreamToString(InputStream is) {

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
