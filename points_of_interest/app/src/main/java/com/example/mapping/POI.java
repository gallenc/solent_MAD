package com.example.mapping;

public class POI {

    //The Crown,pub,nice pub,-1.4011,50.9319

/*- name (the point of interest name)
- type (the point of interest type)
- description (the point of interest description)
- lat (the latitude)
- lon (the longitude).*/

private String name;
private String type;
private String description;
private Double lat;
private Double lon;

    public POI() {
        this.name = name;
        this.type = type;
        this.description = description;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "POI{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
