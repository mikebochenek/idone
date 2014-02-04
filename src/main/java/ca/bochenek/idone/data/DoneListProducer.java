package ca.bochenek.idone.data;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ca.bochenek.idone.entity.DoneItem;

@RequestScoped
public class DoneListProducer {


    @Inject
    private EntityManager em;

    @SuppressWarnings("unchecked")
	public List<DoneItem> loadAll() {
    	return em.createQuery("select p from DoneItem p").getResultList();
    }
    
    public DoneItem findById(long id) {
    	return em.find(DoneItem.class, id);
    }

}
