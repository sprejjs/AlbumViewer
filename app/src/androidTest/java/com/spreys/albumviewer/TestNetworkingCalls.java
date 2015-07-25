package com.spreys.albumviewer;

import android.test.AndroidTestCase;

import com.spreys.albumviewer.Model.Album;
import com.spreys.albumviewer.Model.Photo;
import com.spreys.albumviewer.Model.User;
import com.spreys.albumviewer.Network.ApiWrapper;

import java.util.List;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 24/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class TestNetworkingCalls extends AndroidTestCase {

    public void test_getAlbum() {
        ApiWrapper apiWrapper = new ApiWrapper();
        Album album = apiWrapper.getAlbum(2);

        assertEquals(2, album.getId());
        assertEquals(1, album.getUserId());
        assertEquals("sunt qui excepturi placeat culpa", album.getTitle());
    }

    public void test_getAlbums() {
        ApiWrapper apiWrapper = new ApiWrapper();
        List<Album> albums = apiWrapper.getAlbums();
        assertEquals(albums.size(), 100);
    }

    public void test_getUser() {
        ApiWrapper apiWrapper = new ApiWrapper();
        User user = apiWrapper.getUser(3);

        assertEquals("Clementine Bauch", user.getName());
        assertEquals(3, user.getId());
        assertEquals("Nathan@yesenia.net", user.getEmail());
        assertEquals("1-463-123-4447", user.getPhone());
        assertEquals("ramiro.info", user.getWebsite());
    }

    public void test_getUsers() {
        ApiWrapper apiWrapper = new ApiWrapper();

        List<User> users = apiWrapper.getUsers();
        assertEquals(users.size(), 10);
    }

    public void test_getPhoto() {
        ApiWrapper apiWrapper = new ApiWrapper();
        Photo photo = apiWrapper.getPhoto(6);

        assertEquals(1, photo.getAlbumId());
        assertEquals(6, photo.getId());
        assertEquals("accusamus ea aliquid et amet sequi nemo", photo.getTitle());
        assertEquals("http://placehold.it/600/56a8c2", photo.getUrl());
        assertEquals("http://placehold.it/150/c672a0", photo.getThumbnailUrl());
    }

    public void test_getPhotos() {
        ApiWrapper apiWrapper = new ApiWrapper();
        List<Photo> photos = apiWrapper.getPhotos();
        assertEquals(photos.size(), 5000);
    }
}
