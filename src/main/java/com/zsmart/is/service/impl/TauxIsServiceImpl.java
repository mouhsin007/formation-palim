
package com.zsmart.is.service.impl ;
import com.zsmart.is.service.facade.TauxIsService ; 
import com.zsmart.is.dao.TauxIsDao ;
import com.zsmart.is.service.util.SearchUtil;
import com.zsmart.is.bean.TauxIs;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class TauxIsServiceImpl implements TauxIsService  {


 @Autowired 

 private TauxIsDao tauxisDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public TauxIs  save (TauxIs tauxis){

if(tauxis== null){ 
 return null; 
}else {
 tauxisDao.save(tauxis);
return tauxis;
}
}

 @Override 
public List< TauxIs>  findAll(){
 return tauxisDao.findAll();
}

 @Override 
public TauxIs findById(Long id){
 return tauxisDao.getOne(id);
}

 @Override 
public int delete(TauxIs tauxis){
if(tauxis== null){ 
  return -1; 
}else {
 tauxisDao.delete(tauxis);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       tauxisDao.deleteById(id);
}
public void clone(TauxIs tauxis,TauxIs tauxisClone){
if(tauxis!= null && tauxisClone != null){
tauxisClone.setId(tauxis.getId());
tauxisClone.setProfitMin(tauxis.getProfitMin());
tauxisClone.setProfitMax(tauxis.getProfitMax());
tauxisClone.setPercentage(tauxis.getPercentage());
tauxisClone.setMajoration(tauxis.getMajoration());
tauxisClone.setPenalite(tauxis.getPenalite());
tauxisClone.setDateApplicationDebut(tauxis.getDateApplicationDebut());
tauxisClone.setDateApplicationFin(tauxis.getDateApplicationFin());
}
}
public TauxIs clone(TauxIs tauxis){
if(tauxis== null){       return null ;
}else{TauxIs tauxisClone= new TauxIs();
 clone(tauxis,tauxisClone);
return tauxisClone;
}
}
public List<TauxIs> clone(List<TauxIs>tauxiss){
if(tauxiss== null){
       return null ;
}else{List<TauxIs> tauxissClone = new ArrayList();
	 	 	 tauxiss.forEach((tauxis)->{tauxissClone.add(clone(tauxis));
});return tauxissClone;
}
}
 @Override 
 public List< TauxIs>  findByCriteria(Long idMin,Long idMax,BigDecimal profitMinMin,BigDecimal profitMinMax,BigDecimal profitMaxMin,BigDecimal profitMaxMax,BigDecimal percentageMin,BigDecimal percentageMax,BigDecimal majorationMin,BigDecimal majorationMax,BigDecimal penaliteMin,BigDecimal penaliteMax,Date dateApplicationDebutMin,Date dateApplicationDebutMax,Date dateApplicationFinMin,Date dateApplicationFinMax){
 return entityManager.createQuery(constructQuery(idMin,idMax,profitMinMin,profitMinMax,profitMaxMin,profitMaxMax,percentageMin,percentageMax,majorationMin,majorationMax,penaliteMin,penaliteMax,dateApplicationDebutMin,dateApplicationDebutMax,dateApplicationFinMin,dateApplicationFinMax)).getResultList(); 
 }
private String constructQuery(Long idMin,Long idMax,BigDecimal profitMinMin,BigDecimal profitMinMax,BigDecimal profitMaxMin,BigDecimal profitMaxMax,BigDecimal percentageMin,BigDecimal percentageMax,BigDecimal majorationMin,BigDecimal majorationMax,BigDecimal penaliteMin,BigDecimal penaliteMax,Date dateApplicationDebutMin,Date dateApplicationDebutMax,Date dateApplicationFinMin,Date dateApplicationFinMax){
String query = "SELECT t FROM TauxIs t where 1=1 ";
query += SearchUtil.addConstraintMinMax("t", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("t", "profitMin", profitMinMin, profitMinMax);
query += SearchUtil.addConstraintMinMax("t", "profitMax", profitMaxMin, profitMaxMax);
query += SearchUtil.addConstraintMinMax("t", "percentage", percentageMin, percentageMax);
query += SearchUtil.addConstraintMinMax("t", "majoration", majorationMin, majorationMax);
query += SearchUtil.addConstraintMinMax("t", "penalite", penaliteMin, penaliteMax);
query += SearchUtil.addConstraintMinMaxDate("t"," dateApplicationDebut", dateApplicationDebutMin, dateApplicationDebutMax);
query += SearchUtil.addConstraintMinMaxDate("t"," dateApplicationFin", dateApplicationFinMin, dateApplicationFinMax);

  return query; 
}
}
