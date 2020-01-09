package entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "emarket", catalog = "")
public class ProductEntity {
    private int productId;
    private String name;
    private BigDecimal price;
    private String description;
    private Timestamp lastUpdate;
    private String image;
    private String thumbImage;
    private String descriptionDetail;
    private Collection<OrderedProductEntity> orderedProductsByProductId;
    private CategoryEntity categoryByCategoryId;

    @Id
    @Column(name = "product_id")
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "last_update")
    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Basic
    @Column(name = "image")
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Basic
    @Column(name = "thumb_image")
    public String getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(String thumbImage) {
        this.thumbImage = thumbImage;
    }

    @Basic
    @Column(name = "description_detail")
    public String getDescriptionDetail() {
        return descriptionDetail;
    }

    public void setDescriptionDetail(String descriptionDetail) {
        this.descriptionDetail = descriptionDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return productId == that.productId &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(description, that.description) &&
                Objects.equals(lastUpdate, that.lastUpdate) &&
                Objects.equals(image, that.image) &&
                Objects.equals(thumbImage, that.thumbImage) &&
                Objects.equals(descriptionDetail, that.descriptionDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price, description, lastUpdate, image, thumbImage, descriptionDetail);
    }

    @OneToMany(mappedBy = "productByProductId")
    public Collection<OrderedProductEntity> getOrderedProductsByProductId() {
        return orderedProductsByProductId;
    }

    public void setOrderedProductsByProductId(Collection<OrderedProductEntity> orderedProductsByProductId) {
        this.orderedProductsByProductId = orderedProductsByProductId;
    }

    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false)
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }
}
