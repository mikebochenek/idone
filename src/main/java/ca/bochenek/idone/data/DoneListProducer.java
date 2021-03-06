package ca.bochenek.idone.data;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ca.bochenek.idone.entity.DoneItem;

@RequestScoped
public class DoneListProducer {


    @Inject
    private EntityManager em;

    @SuppressWarnings("unchecked")
	public List<DoneItem> loadAll() {
    	return em.createQuery("select d from DoneItem d").getResultList();
    }
    
    public DoneItem findById(long id) {
    	return em.find(DoneItem.class, id);
    }
    
    public DoneItem create(String text, Date doneDate, long category) {
    	DoneItem item = new DoneItem();
    	item.setText(text);
    	item.setDate(doneDate);
    	item.setCategory(category);
    	item.setOwner(1L); //TODO
    	item.setDoneDay(item.currentDay());
    	return update(item);
    }
    
    public DoneItem update(DoneItem item) {
    	return em.merge(item);
    }
    
    public List<DoneItem> findByDoneDay(long doneDay, long owner) {
		//String dateStr = " where donedate between " + "-01-01' and '" + "-12-31'"; //this is bad, and also prone to SQL injection
    	Query query = em.createQuery("select d from DoneItem d where d.doneDay = :doneDayParam and d.owner = :ownerParam ");
    	query.setParameter ("doneDayParam", doneDay);
    	query.setParameter ("ownerParam", 1L); //TODO extract from session?
    	return query.getResultList();
    }
}
