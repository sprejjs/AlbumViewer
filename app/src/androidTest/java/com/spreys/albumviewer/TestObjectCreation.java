package com.spreys.albumviewer;

import android.test.AndroidTestCase;

import com.spreys.albumviewer.Model.Address;
import com.spreys.albumviewer.Model.Album;
import com.spreys.albumviewer.Model.Company;
import com.spreys.albumviewer.Model.Photo;
import com.spreys.albumviewer.Model.User;

import junit.framework.Assert;

/**
 * Created with Android Studio
 *
 * @author vspreys
 *         Date: 24/07/15
 *         Project: AlbumViewer
 *         Contact by: vlad@spreys.com
 */
public class TestObjectCreation extends AndroidTestCase {

    //Test album creation
    public void testCreateAlbum_Success() {
        String jsonString = "{\n" +
                "  \"userId\": 4,\n" +
                "  \"id\": 5,\n" +
                "  \"title\": \"test title\"\n" +
                "}";

        Album album = new Album(jsonString);
        assertEquals(5, album.getId());
        assertEquals("test title", album.getTitle());
        assertEquals(4, album.getUserId());
    }

    public void testCreateAlbum_NullArgument() {
        try {
            new Album((String) null);
            Assert.fail("Application did not throw illegal pointer exception");
        } catch (IllegalArgumentException ex) {
            //Success
        } catch (Exception exception) {
            Assert.fail("Incorrect type of exception received");
        }
    }

    public void testCreateAlbum_InvalidJson() {
        String jsonString = "{\n" +
                "  \"albumId\": 1,\n" +
                "  \"id\": 1,\n" +
                "  \"title\": \"accusamus beatae ad facilis cum similique qui sunt\",\n" +
                "  \"url\": \"http://placehold.it/600/92c952\",\n" +
                "  \"thumbnailUrl\": \"http://placehold.it/150/30ac17\"\n" +
                "}";

        try {
            new Album(jsonString);
            Assert.fail("Application did not throw illegal argument exception");
        } catch (IllegalArgumentException ex) {
            //Success
        } catch (Exception exception) {
            Assert.fail("Incorrect type of exception received");
        }
    }

    //Test photo creation
    public void testCreatePhoto_Success() {
        String jsonString = "{\n" +
                "  \"albumId\": 2,\n" +
                "  \"id\": 6,\n" +
                "  \"title\": \"random title\",\n" +
                "  \"url\": \"http://placehold.it/600/92c952\",\n" +
                "  \"thumbnailUrl\": \"http://placehold.it/150/30ac17\"\n" +
                "}";

        Photo photo = new Photo(jsonString);
        assertEquals(2, photo.getAlbumId());
        assertEquals(6, photo.getId());
        assertEquals("random title", photo.getTitle());

        try {
            assertEquals("http://placehold.it/600/92c952", photo.getUrl());
            assertEquals("http://placehold.it/150/30ac17", photo.getThumbnailUrl());
        } catch (Exception ex) {
            Assert.fail("Exception received");
        }
    }

    public void testCreatePhoto_NullArgument() {
        try {
            new Photo((String) null);
            Assert.fail("Application did not throw illegal argument exception");
        } catch (IllegalArgumentException ex) {
            //Success
        } catch (Exception exception) {
            Assert.fail("Incorrect type of exception received");
        }
    }

    public void testCreatePhoto_InvalidJson() {
        String jsonString = "{\n" +
                "  \"userId\": 4,\n" +
                "  \"id\": 5,\n" +
                "  \"title\": \"test title\"\n" +
                "}";

        try {
            new Photo(jsonString);
            Assert.fail("Application did not throw illegal argument exception");
        } catch (IllegalArgumentException ex) {
            //Success
        } catch (Exception exception) {
            Assert.fail("Incorrect type of exception received");
        }
    }

    //Test company creation
    public void testCreateCompany_Success(){
        String jsonString = "{\n" +
                "    \"name\": \"Romaguera-Crona\",\n" +
                "    \"catchPhrase\": \"Whatever Forever\",\n" +
                "    \"bs\": \"harness real-time e-markets\"\n" +
                "  }";

        Company company = new Company(jsonString);
        assertEquals("Romaguera-Crona", company.getName());
        assertEquals("Whatever Forever", company.getCatchPhrase());
        assertEquals("harness real-time e-markets", company.getBs());
    }

    public void testCreateCompany_NullArgument() {
        try {
            new Company((String) null);
            Assert.fail("Illegal argument exception not throwned");
        } catch (IllegalArgumentException exception) {
            //Success
        } catch (Exception exception) {
            Assert.fail("Incorrect type of exception received");
        }
    }

    public void testCreateCompany_InvalidJson() {
        String jsonString = "{\n" +
                "  \"userId\": 4,\n" +
                "  \"id\": 5,\n" +
                "  \"title\": \"test title\"\n" +
                "}";

        try {
            new Company(jsonString);
            Assert.fail("Illegal argument exception not throwned");
        } catch (IllegalArgumentException exception) {
            //Success
        } catch (Exception exception) {
            Assert.fail("Incorrect type of exception received");
        }
    }

    //Test address creation
    public void testCreateAddress_Success() {
        String jsonString = "{\n" +
                "    \"street\": \"Kulas Light\",\n" +
                "    \"suite\": \"Apt. 556\",\n" +
                "    \"city\": \"Gwenborough\",\n" +
                "    \"zipcode\": \"92998-3874\",\n" +
                "    \"geo\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"lng\": \"81.1496\"\n" +
                "    }\n" +
                "  }";

        Address address = new Address(jsonString);
        assertEquals("Kulas Light", address.getStreet());
        assertEquals("Apt. 556", address.getSuite());
        assertEquals("Gwenborough", address.getCity());
        assertEquals("92998-3874", address.getZipCode());
        assertEquals("-37.3159", address.getLatitude());
        assertEquals("81.1496", address.getLongitude());
    }

    public void testCreateAddress_NullPointer() {
        try {
            new Address((String) null);
            Assert.fail("Illegal argument exception not throwned");
        } catch (IllegalArgumentException exception) {
            //Success
        } catch (Exception exception) {
            Assert.fail("Incorrect type of exception received");
        }
    }

    public void testCreateAddress_IllegalArgument() {
        String jsonString = "{\n" +
                "  \"userId\": 4,\n" +
                "  \"id\": 5,\n" +
                "  \"title\": \"test title\"\n" +
                "}";
        try {
            new Address(jsonString);
            Assert.fail("Illegal argument exception not throwned");
        } catch (IllegalArgumentException exception) {
            //Success
        } catch (Exception exception) {
            Assert.fail("Incorrect type of exception received");
        }
    }

    //Test user creation
    public void testCreateUser_Success() {
        String jsonString = "{\n" +
                "  \"id\": 1,\n" +
                "  \"name\": \"Leanne Graham\",\n" +
                "  \"username\": \"Bret\",\n" +
                "  \"email\": \"Sincere@april.biz\",\n" +
                "  \"address\": {\n" +
                "    \"street\": \"Kulas Light\",\n" +
                "    \"suite\": \"Apt. 556\",\n" +
                "    \"city\": \"Gwenborough\",\n" +
                "    \"zipcode\": \"92998-3874\",\n" +
                "    \"geo\": {\n" +
                "      \"lat\": \"-37.3159\",\n" +
                "      \"lng\": \"81.1496\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"phone\": \"1-770-736-8031 x56442\",\n" +
                "  \"website\": \"hildegard.org\",\n" +
                "  \"company\": {\n" +
                "    \"name\": \"Romaguera-Crona\",\n" +
                "    \"catchPhrase\": \"Multi-layered client-server neural-net\",\n" +
                "    \"bs\": \"harness real-time e-markets\"\n" +
                "  }\n" +
                "}";

        User user = new User(jsonString);
        assertEquals(1, user.getId());
        assertEquals("Leanne Graham", user.getName());
        assertEquals("Bret", user.getUsername());
        assertEquals("Sincere@april.biz", user.getEmail());
        assertEquals("1-770-736-8031 x56442", user.getPhone());
        assertEquals("hildegard.org", user.getWebsite());
    }

    public void testCreateUser_NullPointer() {
        try {
            new User((String) null);
            Assert.fail("Illegal argument exception not throwned");
        } catch (IllegalArgumentException exception) {
            //Success
        } catch (Exception exception) {
            Assert.fail("Incorrect type of exception received");
        }
    }

    public void testCreateUser_InvalidJson() {
        String jsonString = "{\n" +
                "  \"userId\": 4,\n" +
                "  \"id\": 5,\n" +
                "  \"title\": \"test title\"\n" +
                "}";
        try {
            new User(jsonString);
            Assert.fail("Illegal argument exception not throwned");
        } catch (IllegalArgumentException exception) {
            //Success
        } catch (Exception exception) {
            Assert.fail("Incorrect type of exception received");
        }
    }
}
