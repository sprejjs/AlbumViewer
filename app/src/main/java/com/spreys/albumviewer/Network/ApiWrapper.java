package com.spreys.albumviewer.Network;

import com.spreys.albumviewer.Model.Album;
import com.spreys.albumviewer.Model.Photo;
import com.spreys.albumviewer.Model.User;

import java.lang.reflect.Array;
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
    //Caching
    HashMap<Integer, Photo> photosHash = new HashMap<>();
    HashMap<Integer, Album> albumHash = new HashMap<>();
    HashMap<Integer, User> userHash = new HashMap<>();

    public Photo getPhoto(int id) {
        return null;
    }

    public ArrayList<Photo> getPhotos() {
        return null;
    }

    public Album getAlbum(int id) {
        return null;
    }

    public ArrayList<Album> getAlbums() {
        return null;
    }

    public User getUser(int id) {
        return null;
    }

    public ArrayList<User> getUsers() {
        return null;
    }
}
