package com.telusko.simpleWebApp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long prodId;
    private String category;
    private String description;
    private int quantity;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;
    private String prodName;
    private long price;
    private boolean availability;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public void setProdId(long prodId) {
        this.prodId = prodId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public long getProdId() {
        return prodId;
    }

    public String getCategory() {
        return category;
    }

    public String getDesc() {
        return description;
    }

    public int getQuantity() {
        return quantity;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public String getProdName() {
        return prodName;
    }

    public long getPrice() {
        return price;
    }

    public boolean isAvailability() {
        return availability;
    }



}
