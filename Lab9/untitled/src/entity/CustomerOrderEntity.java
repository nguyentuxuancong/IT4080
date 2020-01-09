package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customer_order", schema = "emarket", catalog = "")
public class CustomerOrderEntity {
    private int orderId;
    private BigDecimal amount;
    private String dateCreated;
    private int confirmationNumber;
    private CustomerEntity customerByCustomerId;
    private Collection<OrderedProductEntity> orderedProductsByOrderId;

    @Id
    @Column(name = "order_id")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "amount")
    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "date_created")
    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Basic
    @Column(name = "confirmation_number")
    public int getConfirmationNumber() {
        return confirmationNumber;
    }

    public void setConfirmationNumber(int confirmationNumber) {
        this.confirmationNumber = confirmationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerOrderEntity that = (CustomerOrderEntity) o;
        return orderId == that.orderId &&
                confirmationNumber == that.confirmationNumber &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(dateCreated, that.dateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, amount, dateCreated, confirmationNumber);
    }

    @ManyToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id", nullable = false)
    public CustomerEntity getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(CustomerEntity customerByCustomerId) {
        this.customerByCustomerId = customerByCustomerId;
    }

    @OneToMany(mappedBy = "customerOrderByOrderId")
    public Collection<OrderedProductEntity> getOrderedProductsByOrderId() {
        return orderedProductsByOrderId;
    }

    public void setOrderedProductsByOrderId(Collection<OrderedProductEntity> orderedProductsByOrderId) {
        this.orderedProductsByOrderId = orderedProductsByOrderId;
    }
}
