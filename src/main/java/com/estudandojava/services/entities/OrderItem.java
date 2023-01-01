package com.estudandojava.services.entities;

/*import com.estudandojava.services.entities.pk.OrderItemPK;*/
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name="tb_order_item")
public class OrderItem implements Serializable {
    /*@EmbeddedId
    private OrderItemPK id= new OrderItemPK();*/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer quantity;
    private Double price;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;


    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;



    public OrderItem(){

    }

    public OrderItem(Order order, Product product,Integer quantity, Double price) {
        /*id.setOrder(order);
        id.setProduct(product);*/
        this.order=order;
        this.product=product;
        this.quantity = quantity;
        this.price = price;
    }
    @JsonIgnore
    public Order getOrder(){
       /* return id.getOrder();*/
        return this.order;
    }
    public void setOrder(Order order){
       /* id.setOrder(order);*/
        this.order=order;
    }

    public Product getProduct(){
       /* return id.getProduct();*/
        return this.product;
    }

    public void setProduct(Product product){
      /*  id.setProduct(product);*/
        this.product=product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderItem orderItem = (OrderItem) o;
        return Objects.equals(id, orderItem.id) && Objects.equals(quantity, orderItem.quantity) && Objects.equals(price, orderItem.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity, price);
    }
}
