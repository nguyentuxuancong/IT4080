package entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ordered_product", schema = "emarket", catalog = "")
@IdClass(OrderedProductEntityPK.class)
public class OrderedProductEntity {
    private int orderId;
    private int productId;
    private int quantity;
    private CustomerOrderEntity customerOrderByOrderId;
    private ProductEntity productByProductEntityId;

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
        OrderedProductEntity that = (OrderedProductEntity) o;
        return orderId == that.orderId &&
                productId == that.productId &&
                quantity == that.quantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, quantity);
    }

    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false)
    public CustomerOrderEntity getCustomerOrderByOrderId() {
        return customerOrderByOrderId;
    }

    public void setCustomerOrderByOrderId(CustomerOrderEntity customerOrderByOrderId) {
        this.customerOrderByOrderId = customerOrderByOrderId;
    }

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false)
    public ProductEntity getProductByProductEntityId() {
        return productByProductEntityId;
    }

    public void setProductByProductEntityId(ProductEntity productByProductEntityId) {
        this.productByProductEntityId = productByProductEntityId;
    }
}
