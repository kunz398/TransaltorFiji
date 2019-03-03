package com.kunz.udacity3;

/**
 * Created by kunz on 11/27/2016.
 * <p>
 * ColorsActivity,FamilyActivity,NumberActivity,PhraseActivity All use this class
 */

public class Word {

    //Varibles
    private String FijianWords; //Fijian Word
    private String EnglishWords; //English translation of the Fijian word
    private int imageResourceid;
    private String pronunciation;

    //Constructor
    public Word(String FijianWords, String EnglishWords, int imageResourceid) {
        this.FijianWords = FijianWords; //Since the name is the same use the this keyword
        this.EnglishWords = EnglishWords;
        this.imageResourceid = imageResourceid;
    }

    //COnstructor number two
    public Word(String FijianWords, String EnglishWords, int imageResourceid, String pronunciation) {
        this.FijianWords = FijianWords; //Since the name is the same use the this keyword
        this.EnglishWords = EnglishWords;
        this.imageResourceid = imageResourceid;
        this.pronunciation = pronunciation;
    }

    //Setters

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }


    public void setEnglishWords(String englishWords) {
        EnglishWords = englishWords;
    }

    public void setFijianWords(String fijianWords) {
        FijianWords = fijianWords;
    }

    public void setImageResourceid(int imageResourceid) {
        this.imageResourceid = imageResourceid;
    }


    //Getters
    public String getFijianWords() {
        return FijianWords;
    }

    public String getEnglishWords() {
        return EnglishWords;
    }

    public int getImageResourceid() {
        return imageResourceid;
    }

    public String getPronunciation() {
        return pronunciation;
    }


}
