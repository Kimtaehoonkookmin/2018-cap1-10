package com.kookmin.jongmin.kookimincommunity.community;

/**
 * Created by JongMin on 2018-03-14.
 */

public class CommunityListItem {
    private String title;
    private String date;
    private String author;
    private int hits;
    private int id;

    public CommunityListItem(int id, String author, String title, String date, int hits) {
        this.title = title;
        this.date = date;
        this.hits = hits;
        this.id = id;
        this.author = author;
    }

    public String getTitle() {
        if(title.length() >10) {
            return title.substring(0, 10).concat("...");
        } else {
            return title;
        }
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getHits() {
        return hits;
    }

    public String getAuthor() {
        return author;
    }
}
