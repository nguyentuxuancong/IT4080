package session_bean;
import entity.Category;
import entity.ProductDetail;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ProductDetailSessionBean extends AbstractSessionBean<ProductDetail> {
    @PersistenceContext(unitName = "eMarketPU")
    private EntityManager em;
    protected EntityManager getEntityManager() {
        return em;
    }
    public ProductDetailSessionBean(){
        super(ProductDetail.class);
    }
}
