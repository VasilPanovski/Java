package com.cars.models.viewModels;


public class PartViewModel {

    private Long id;

    private String name;

    private Double price;

    private Long quantity;

    private SupplierViewModel supplier;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public SupplierViewModel getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierViewModel supplier) {
        this.supplier = supplier;
    }
}
