import java.util.*;
import javax.ejb.*;
import javax.persistence.*;
import Calculation.*;

@Stateless
public class CalculationsList {
    @PersistenceContext
    private EntityManager em;

    public CalculationsList() {}
    
    public List<Calculation> All() {
        return em.createQuery("select c from Calculation c", Calculation.class).getResultList();
    }

    public void insert(Calculation calculation) {
    	em.persist(calculation);
    }

    
}