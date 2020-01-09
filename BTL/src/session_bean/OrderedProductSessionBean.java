package session_bean;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import entity.OrderedProduct;

/**
 *
 * @author ThanDieu
 */
@Stateless
public class OrderedProductSessionBean extends AbstractSessionBean<OrderedProduct> {
	@PersistenceContext
	private EntityManager em;

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	public OrderedProductSessionBean() {
		super(OrderedProduct.class);
	}

	public List<OrderedProduct> findByOrderId(Object id) {
        return em.createNamedQuery("OrderedProduct.findByOrderId").setParameter("orderId",id).getResultList();
    }
	public List<OrderedProduct> findByProductId(Object id) {
        return em.createNamedQuery("OrderedProduct.findByProductId").setParameter("productId",id).getResultList();
    }
}