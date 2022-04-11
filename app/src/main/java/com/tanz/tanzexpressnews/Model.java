package com.tanz.tanzexpressnews;

public class Model {
    String author,title,description,url,urlToImage,publishedAt;

    public Model(String author, String title, String description, String url, String urlToImage, String publishedAt) {
        this.author = author;
        this.title = title;
        this.description = description;
        this.url = url;
        this.urlToImage = urlToImage;
        this.publishedAt = publishedAt;
    }

    public String getAuthor() {
        String auth;
        if(author!=null)
            auth = "-By "+author;
        else
            auth ="-By ";
        return auth;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        String auth;
        if(author!=null)
            auth = description;
        else
            auth ="Data not available.....\nClick For details";
        return auth;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        String UtI;
        if(author!=null)
            UtI = urlToImage;
        else
            UtI ="https://d1rytvr7gmk1sx.cloudfront.net/wp-content/uploads/2018/07/googlenewshero.jpg";
        return UtI;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return "On "+publishedAt.substring(0,10) +" at " + publishedAt.substring(11,16);
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}

