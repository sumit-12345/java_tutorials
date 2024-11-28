package com.msf.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Book implements Serializable {
    private int isbnNo;
    private String title;
    private String authorName;
    private LocalDate publishedDate;
    private String publisherName;
    private double price;

    public int getIsbnNo() {
        return isbnNo;
    }

    public void setIsbnNo(int isbnNo) {
        this.isbnNo = isbnNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book book)) return false;
        return getIsbnNo() == book.getIsbnNo() && Double.compare(getPrice(), book.getPrice()) == 0 && Objects.equals(getTitle(), book.getTitle()) && Objects.equals(getAuthorName(), book.getAuthorName()) && Objects.equals(getPublishedDate(), book.getPublishedDate()) && Objects.equals(getPublisherName(), book.getPublisherName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbnNo(), getTitle(), getAuthorName(), getPublishedDate(), getPublisherName(), getPrice());
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbnNo=" + isbnNo +
                ", title='" + title + '\'' +
                ", authorName='" + authorName + '\'' +
                ", publishedDate=" + publishedDate +
                ", publisherName='" + publisherName + '\'' +
                ", price=" + price +
                '}';
    }
}
