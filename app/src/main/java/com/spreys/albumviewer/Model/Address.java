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
public class Address {
    private String street;
    private String suite;
    private String city;
    private String zipCode;
    private String latitude;
    private String longitude;

    public Address (String jsonString) {
        try {
            initialiseObject(new JSONObject(jsonString));
        } catch (JSONException | NullPointerException e) {
            throw new IllegalArgumentException("Unable to parse JSON object");
        }
    }

    public Address (JSONObject jAddress) {
        initialiseObject(jAddress);
    }

    private void initialiseObject(JSONObject object){
        try {
            this.street = object.getString("street");
            this.suite = object.getString("suite");
            this.city = object.getString("city");
            this.zipCode = object.getString("zipcode");

            //Parse geo
            JSONObject geoObject = object.getJSONObject("geo");
            this.latitude = geoObject.getString("lat");
            this.longitude = geoObject.getString("lng");
        } catch (Exception ex) {
            throw new IllegalArgumentException("Unable to parse JSON object");
        }
    }

    public String getStreet(){
        return street;
    }

    public String getSuite(){
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
