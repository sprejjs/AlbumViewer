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
public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;

    public User (String jsonString) {
        try {
            initialiseObject(new JSONObject(jsonString));
        } catch (JSONException | NullPointerException exception) {
            throw new IllegalArgumentException("Unable to parse json string");
        }

    }

    public User (JSONObject jUser) {
        initialiseObject(jUser);
    }

    private void initialiseObject(JSONObject jObject) {
        try {
            //Parse parameters
            this.id = jObject.getInt("id");
            this.name = jObject.getString("name");
            this.username = jObject.getString("username");
            this.email = jObject.getString("email");
            this.phone = jObject.getString("phone");
            this.website = jObject.getString("website");

            //Parse Address
            this.address = new Address(jObject.getJSONObject("address"));

            //Parse Company
            this.company = new Company(jObject.getJSONObject("company"));
        } catch (JSONException e) {
            throw new IllegalArgumentException("Unable to convert received parameter to JSONobject");
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public Company getCompany() {
        return company;
    }
}
