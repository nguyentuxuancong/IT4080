package entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "customer", schema = "emarket", catalog = "")
public class CustomerEntity {
    private int customerId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String cityRegion;
    private String ccNumber;
    private Collection<CustomerOrderEntity> customerOrdersByCustomerId;

    @Id
    @Column(name = "customer_id")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "city_region")
    public String getCityRegion() {
        return cityRegion;
    }

    public void setCityRegion(String cityRegion) {
        this.cityRegion = cityRegion;
    }

    @Basic
    @Column(name = "cc_number")
    public String getCcNumber() {
        return ccNumber;
    }

    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerEntity that = (CustomerEntity) o;
        return customerId == that.customerId &&
                Objects.equals(name, that.name) &&
                Objects.equals(email, that.email) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(address, that.address) &&
                Objects.equals(cityRegion, that.cityRegion) &&
                Objects.equals(ccNumber, that.ccNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, email, phone, address, cityRegion, ccNumber);
    }

    @OneToMany(mappedBy = "customerByCustomerId")
    public Collection<CustomerOrderEntity> getCustomerOrdersByCustomerId() {
        return customerOrdersByCustomerId;
    }

    public void setCustomerOrdersByCustomerId(Collection<CustomerOrderEntity> customerOrdersByCustomerId) {
        this.customerOrdersByCustomerId = customerOrdersByCustomerId;
    }
}
