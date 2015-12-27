package com.example.abhishek.hackercheckin;

/**
 * Created by Abhishek on 11/22/2015.
 */
public class hackerdetails {

    public String getFirstName() {
        return hackerFirstName;
    }

    public void setFirstName(String hackerFirstName) {
        this.hackerFirstName = hackerFirstName;
    }

    public String getLastName() {
        return hackerLastName;
    }

    public void setLastName(String hackerLastName) {
        this.hackerLastName =  hackerLastName;

    }

    public String getHackerUniv() {
        return hackerUniv;
    }

    public void setHackerUniv(String hackerUniv) {
        this.hackerUniv = hackerUniv;
    }

    public String getHackerAge() {
        return hackerAge;
    }

    public void setHackerAge(String hackerAge) {
        this.hackerAge = hackerAge;
    }

    public String getHackerYear() {
        return hackerYear;
    }

    public void setHackerYear(String hackerYear) {
        this.hackerYear = hackerYear;
    }

    public String getHackerMajor() {
        return hackerMajor;
    }

    public void setHackerMajor(String hackerMajor) {
        this.hackerMajor = hackerMajor;
    }

    public String getHackerNumHacks() {
        return hackerNumHacks;
    }

    public void setHackerNumHacks(String hackerNumHacks) {
        this.hackerNumHacks = hackerNumHacks;
    }

    public String getHackerShirtSize() {
        return hackerShirtSize;
    }

    public void setHackerShirtSize(String hackerShirtSize) {
        this.hackerShirtSize = hackerShirtSize;
    }

    public String getHackerMail() {
        return hackerMail;
    }

    public void setHackerMail(String hackerMail) {
        this.hackerMail = hackerMail;
    }

    public String getHackerPhone() {
        return hackerPhone;
    }

    public void setHackerPhone(String hackerPhone) {
        this.hackerPhone = hackerPhone;
    }

    public String getHackerGender() {
        return hackerGender;
    }

    public void setHackerGender(String hackerGender) {
        this.hackerGender = hackerGender;
    }

    /**
     * Item name
     */
    @com.google.gson.annotations.SerializedName("hackerFirstName")
    private String hackerFirstName;

    @com.google.gson.annotations.SerializedName("hackerLastName")
    private String hackerLastName;
    /**
     * Item univ
     */
    @com.google.gson.annotations.SerializedName("hackerUniv")
    private String hackerUniv;

    /**
     * Item age
     */
    @com.google.gson.annotations.SerializedName("hackerAge")
    private String hackerAge;


    @com.google.gson.annotations.SerializedName("hackerGender")
    private String hackerGender;

    /**
     * Item text
     */
    @com.google.gson.annotations.SerializedName("hackerYear")
    private String hackerYear;

    /**
     * Item text
     */
    @com.google.gson.annotations.SerializedName("hackerMajor")
    private String hackerMajor;

    /**
     * Item Id
     */
    @com.google.gson.annotations.SerializedName("hackerNumHacks")
    private String hackerNumHacks;

    /**
     * Item text
     */
    @com.google.gson.annotations.SerializedName("hackerShirtSize")
    private String hackerShirtSize;


    /**
     * Item text
     */
    @com.google.gson.annotations.SerializedName("id")
    private String mId;

    /**
     * Item name
     */
    @com.google.gson.annotations.SerializedName("hackerMail")
    private String hackerMail;

    /**
     * Item name
     */
    @com.google.gson.annotations.SerializedName("hackerPhone")
    private String hackerPhone;

    /**
     * hackerdetails constructor
     */
    public hackerdetails() {

    }


    /**
     * Initializes a new hackerdetails
     *
     * @param name
     *            The item name
     * @param id
     *            The item id
     */
    public hackerdetails(String firstName, String lastName, String id, String age, String gender, String shirtSize, String year, String hackerNumHacks, String hackerMajor, String univ, String hackerMail, String hackerPhone) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        this.setId(id);
        this.setHackerGender(gender);
        this.setHackerAge(age);
        this.setHackerMajor(hackerMajor);
        this.setHackerNumHacks(hackerNumHacks);
        this.setHackerShirtSize(shirtSize);
        this.setHackerUniv(univ);
        this.setHackerYear(year);
        this.setHackerMail(hackerMail);
        this.setHackerPhone(hackerPhone);
    }

    /**
     * Returns the item id
     */
    public String getId() {
        return mId;
    }

    /**
     * Sets the item id
     *
     * @param id
     *            id to set
     */
    public final void setId(String id) {
        mId = id;
    }

    /**
     * Indicates if the item is marked as completed
     */


    @Override
    public boolean equals(Object o) {
        return o instanceof hackerdetails && ((hackerdetails) o).mId == mId;
    }
}
