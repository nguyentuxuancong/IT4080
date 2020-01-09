package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ordered_product", schema = "emarket", catalog = "")
@IdClass(OrderedProductPK.class)
public class OrderedProduct {
    private int orderId;
    private int productId;
    private int quantity;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderedProduct that = (OrderedProduct) o;
        return orderId == that.orderId &&
                productId == that.productId &&
                quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, quantity);
    }
}
