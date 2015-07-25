package com.spreys.albumviewer;

import android.test.AndroidTestCase;

import com.spreys.albumviewer.Model.Address;
import com.spreys.albumviewer.Model.Album;
import com.spreys.albumviewer.Model.Company;
import com.spreys.albumviewer.Model.Photo;
import com.spreys.albumviewer.Model.User;

import junit.framework.Assert;

import java.net.URL;

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
        assertEquals(album.getId(), 5);
        assertEquals(album.getTitle(), "test title");
        assertEquals(album.getUserId(), 4);
    }

    public void testCreateAlbum_NullArgument() {
        String jsonString = null;

        try {
            new Album(jsonString);
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
        assertEquals(photo.getAlbumId(), 2);
        assertEquals(photo.getId(), 6);
        assertEquals(photo.getTitle(), "random title");

        try {
            assertEquals(photo.getUrl(), new URL("http://placehold.it/600/92c952"));
            assertEquals(photo.getThumbnailUrl(), new URL("http://placehold.it/150/30ac17"));
        } catch (Exception ex) {
            Assert.fail("Exception received");
        }
    }

    public void testCreatePhoto_NullArgument() {
        try {
            new Photo(null);
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
        assertEquals(company.getName(), "Romaguera-Crona");
        assertEquals(company.getCatchPhrase(), "Whatever Forever");
        assertEquals(company.getBs(), "harness real-time e-markets");
    }

    public void testCreateCompany_NullArgument() {
        try {
            new Company(null);
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
        assertEquals(address.getStreet(), "Kulas Light");
        assertEquals(address.getSuite(), "Apt. 556");
        assertEquals(address.getCity(), "Gwenborough");
        assertEquals(address.getZipCode(), "92998-3874");
        assertEquals(address.getLatitude(), "-37.3159");
        assertEquals(address.getLongitude(), "81.1496");
    }

    public void testCreateAddress_NullPointer() {
        try {
            new Address(null);
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
        assertEquals(user.getId(), 1);
        assertEquals(user.getName(), "Leanne Graham");
        assertEquals(user.getUsername(), "Bret");
        assertEquals(user.getEmail(), "Sincere@april.biz");
        assertEquals(user.getPhone(), "1-770-736-8031 x56442");
        assertEquals(user.getWebsite(), "hildegard.org");
    }

    public void testCreateUser_NullPointer() {
        try {
            new User(null);
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
