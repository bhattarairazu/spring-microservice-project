package io.javabrains.moviecatalogservice;

public class CatalogItem {
    private String movie;
    private String desc;
    private int rating;

    public CatalogItem(String movie, String desc, int rating) {
        this.movie = movie;
        this.desc = desc;
        this.rating = rating;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
