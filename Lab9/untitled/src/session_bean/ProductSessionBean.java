package session_bean;

import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class ProductSessionBean extends AbstractSessionBean<Product> {
    @PersistenceContext(unitName = "NewPersistenceUnit")
    private EntityManager em;
    protected EntityManager getEntityManager() {
        return em;
    }
    public ProductSessionBean(){
        super(Product.class);
    }
}
