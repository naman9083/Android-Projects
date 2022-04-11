package com.tanz.tanzexpressnews;

import java.util.ArrayList;

public class mainNews {
    private String status;
    private String totalresults;
    private ArrayList<Model> articles;

    public mainNews(String status, String totalresults, ArrayList<Model> articles) {
        this.status = status;
        this.totalresults = totalresults;
        this.articles = articles;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalresults() {
        return totalresults;
    }

    public void setTotalResults(String totalresults) {
        this.totalresults = totalresults;
    }

    public ArrayList<Model> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<Model> articles) {
        this.articles = articles;
    }
}
