package com.example.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

public class CsvData {

    @JsonProperty("ZipCode")
    private String zipcode;
    @JsonProperty("PlaceName")
    private String placeName;
    @JsonProperty("Country")
    private String country;
    @JsonProperty("StateCode")
    private String stateCode;
    @JsonProperty("State")
    private String state;
    @JsonProperty("City")
    private String city;
    @JsonProperty("Latitude")
    private String latitude;
    @JsonProperty("Longitude")
    private String longitude;
    private CharSequence district;
    private CharSequence village;

    public CsvData() {
    }

    public CsvData(String placeName, String country, String stateCode, String state, String city, String latitude,
                   String longitude) {
        this.placeName = placeName;
        this.country = country;
        this.stateCode = stateCode;
        this.state = state;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public CsvData(String zipcode, String placeName, String country, String stateCode, String state, String city,
                   String latitude, String longitude) {
        super();
        this.zipcode = zipcode;
        this.placeName = placeName;
        this.country = country;
        this.stateCode = stateCode;
        this.state = state;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

//	    public Address(FileWriter fileWriter) {
//	    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Address [zipcode=" + zipcode + ", placeName=" + placeName + ", country=" + country + ", stateCode="
                + stateCode + ", state=" + state + ", city=" + city + ", latitude=" + latitude + ", longitude="
                + longitude + "]";
    }

    public String toCsvString() {

        return String.join(",", zipcode, placeName, country, stateCode, state, city, district, village, latitude, longitude);
    }
}
