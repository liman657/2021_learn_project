package com.coderman.foodie.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

public class SalesByStore implements Serializable {
    private String store;

    private String manager;

    private BigDecimal totalSales;

    private static final long serialVersionUID = 1L;

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store == null ? null : store.trim();
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager == null ? null : manager.trim();
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
        sb.append(", store=").append(store);
        sb.append(", manager=").append(manager);
        sb.append(", totalSales=").append(totalSales);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}