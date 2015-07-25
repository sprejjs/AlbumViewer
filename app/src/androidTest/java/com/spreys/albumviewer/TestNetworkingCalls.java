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

        assertEquals(album.getId(), 2);
        assertEquals(album.getUserId(), 1);
        assertEquals(album.getTitle(), "sunt qui excepturi placeat culpa");
    }

    public void test_getAlbums() {
        ApiWrapper apiWrapper = new ApiWrapper();
        List<Album> albums = apiWrapper.getAlbums();
        assertEquals(albums.size(), 100);
    }

    public void test_getUser() {
        ApiWrapper apiWrapper = new ApiWrapper();
        User user = apiWrapper.getUser(3);

        assertEquals(user.getName(), "Clementine Bauch");
        assertEquals(user.getId(), 3);
        assertEquals(user.getEmail(), "Nathan@yesenia.net");
        assertEquals(user.getPhone(), "1-463-123-4447");
        assertEquals(user.getWebsite(), "ramiro.info");
    }

    public void test_getUsers() {
        ApiWrapper apiWrapper = new ApiWrapper();

        List<User> users = apiWrapper.getUsers();
        assertEquals(users.size(), 10);
    }

    public void test_getPhoto() {
        ApiWrapper apiWrapper = new ApiWrapper();
        Photo photo = apiWrapper.getPhoto(6);

        assertEquals(photo.getAlbumId(), 1);
        assertEquals(photo.getId(), 6);
        assertEquals(photo.getTitle(), "accusamus ea aliquid et amet sequi nemo");
        assertEquals(photo.getUrl(), "http://placehold.it/600/56a8c2");
        assertEquals(photo.getThumbnailUrl(), "http://placehold.it/150/c672a0");
    }

    public void test_getPhotos() {
        ApiWrapper apiWrapper = new ApiWrapper();
        List<Photo> photos = apiWrapper.getPhotos();
        assertEquals(photos.size(), 5000);
    }
}
