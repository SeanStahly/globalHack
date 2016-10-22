package com.example.Client;

import java.util.Date;

/**
 * Created by sean on 10/22/16.
 */
public class Client {

    private long id;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String nationality;
    private char gender;
    private char veternStatus;
    private String medicalStatus;
    private String phoneNumber;
    private int identifyingNumber;
    private boolean abused;
    private int currentShelter;


    public Client(long id, String firstName, String lastName, Date dateOfBirth, String nationality, char gender, char veternStatus, String medicalStatus, String phoneNumber, int identifyingNumber, boolean abused, int currentShelter) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.gender = gender;
        this.veternStatus = veternStatus;
        this.medicalStatus = medicalStatus;
        this.phoneNumber = phoneNumber;
        this.identifyingNumber = identifyingNumber;
        this.abused = abused;
        this.currentShelter = currentShelter;
    }

    @Override
    public String toString() {
        return String.format("Client[id=%d, name = '%s %s']", id, firstName, lastName);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public char getVeternStatus() {
        return veternStatus;
    }

    public void setVeternStatus(char veternStatus) {
        veternStatus = veternStatus;
    }

    public String getMedicalStatus() {
        return medicalStatus;
    }

    public void setMedicalStatus(String medicalStatus) {
        this.medicalStatus = medicalStatus;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdentifyingNumber() {
        return identifyingNumber;
    }

    public void setIdentifyingNumber(int identifyingNumber) {
        this.identifyingNumber = identifyingNumber;
    }

    public boolean isAbused() {
        return abused;
    }

    public void setAbused(boolean abused) {
        this.abused = abused;
    }

    public int getCurrentShelter() {
        return currentShelter;
    }

    public void setCurrentShelter(int currentShelter) {
        this.currentShelter = currentShelter;
    }
}
