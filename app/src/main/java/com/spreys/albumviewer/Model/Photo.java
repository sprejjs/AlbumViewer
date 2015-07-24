package com.spreys.albumviewer.Model;

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
    private URL url;
    private URL thumbnailUrl;

    public Photo(String jsonString){

    }

    public int getAlbumId() {
        return -1;
    }

    public int getId() {
        return -1;
    }

    public String getTitle() {
        return null;
    }

    public URL getUrl() {
        return null;
    }

    public URL getThumbnailUrl() {
        return null;
    }
}
