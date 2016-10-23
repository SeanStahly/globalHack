package com.example.Shelter;

/**
 * Created by sean on 10/22/16.
 */
public class Shelter {

    private int id;
    private String address;
    private char gender;
    private boolean abused;
    private int ageLimit;
    private boolean veteranStatus;
    private int unknownOccupants;

    public Shelter(int id, String address, char gender, boolean abused, int ageLimit, boolean veteranStatus, int unknownOccupants) {
        this.id = id;
        this.address = address;
        this.gender = gender;
        this.abused = abused;
        this.ageLimit = ageLimit;
        this.veteranStatus = veteranStatus;
        this.unknownOccupants = unknownOccupants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public boolean isAbused() {
        return abused;
    }

    public void setAbused(boolean abused) {
        this.abused = abused;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public boolean isVeteranStatus() {
        return veteranStatus;
    }

    public void setVeteranStatus(boolean veteranStatus) {
        this.veteranStatus = veteranStatus;
    }

    public int getUnknownOccupants() {
        return unknownOccupants;
    }

    public void setUnknownOccupants(int unknownOccupants) {
        this.unknownOccupants = unknownOccupants;
    }
}
