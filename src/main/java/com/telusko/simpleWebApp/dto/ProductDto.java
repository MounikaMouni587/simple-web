package com.telusko.simpleWebApp.dto;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductDto {
    private long prodId;
    private String category;
    private String description;
    private int quantity;
    private Date releaseDate;
    private String prodName;
    private long price;
    private boolean availability;

    public void setProdId(long prodId) {
        this.prodId = prodId;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setDescription(String desc) {
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

    public String getDescription() {
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
