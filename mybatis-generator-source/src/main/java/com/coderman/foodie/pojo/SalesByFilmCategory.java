package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class SalesByFilmCategory implements Serializable {
    private String category;

    private BigDecimal totalSales;

    private static final long serialVersionUID = 1L;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", category=").append(category);
        sb.append(", totalSales=").append(totalSales);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}