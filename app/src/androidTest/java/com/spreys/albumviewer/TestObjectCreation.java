package com.spreys.albumviewer;

import android.app.Application;
import android.test.AndroidTestCase;
import android.test.ApplicationTestCase;

import com.spreys.albumviewer.Model.Album;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 24/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class TestObjectCreation extends AndroidTestCase {

    public void testCreateAlbum() {
        String jsonString = "{\n" +
                "  \"userId\": 4,\n" +
                "  \"id\": 5,\n" +
                "  \"title\": \"test title\"\n" +
                "}";

        Album album = new Album(jsonString);
        assertEquals(album.getId(), 5);
        assertEquals(album.getTitle(), "test title");
        assertEquals(album.getUserId(), 4);
    }

    public void testCratePhoto() {
        String jsonString = "{\n" +
                "  \"albumId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"accusamus beatae ad facilis cum similique qui sunt\",\n" +
                "  \"url\": \"http://placehold.it/600/92c952\",\n" +
                "  \"thumbnailUrl\": \"http://placehold.it/150/30ac17\"\n" +
                "}";

    }
}
