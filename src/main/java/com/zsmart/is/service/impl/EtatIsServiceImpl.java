
package com.zsmart.is.service.impl ;
import com.zsmart.is.service.facade.EtatIsService ; 
import com.zsmart.is.dao.EtatIsDao ;
import com.zsmart.is.service.util.SearchUtil;
import com.zsmart.is.bean.EtatIs;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class EtatIsServiceImpl implements EtatIsService  {


 @Autowired 

 private EtatIsDao etatisDao;

 @Autowired 

 private EntityManager entityManager; 

 @Override 
public EtatIs  save (EtatIs etatis){

if(etatis== null){ 
 return null; 
}else {
 etatisDao.save(etatis);
return etatis;
}
}

 @Override 
public List< EtatIs>  findAll(){
 return etatisDao.findAll();
}

 @Override 
public EtatIs findById(Long id){
 return etatisDao.getOne(id);
}

 @Override 
public int delete(EtatIs etatis){
if(etatis== null){ 
  return -1; 
}else {
 etatisDao.delete(etatis);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       etatisDao.deleteById(id);
}
public void clone(EtatIs etatis,EtatIs etatisClone){
if(etatis!= null && etatisClone != null){
etatisClone.setId(etatis.getId());
etatisClone.setLibelle(etatis.getLibelle());
etatisClone.setCode(etatis.getCode());
}
}
public EtatIs clone(EtatIs etatis){
if(etatis== null){       return null ;
}else{EtatIs etatisClone= new EtatIs();
 clone(etatis,etatisClone);
return etatisClone;
}
}
public List<EtatIs> clone(List<EtatIs>etatiss){
if(etatiss== null){
       return null ;
}else{List<EtatIs> etatissClone = new ArrayList();
	 	 	 etatiss.forEach((etatis)->{etatissClone.add(clone(etatis));
});return etatissClone;
}
}
 @Override 
 public List< EtatIs>  findByCriteria(String libelle,String code,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(libelle,code,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String libelle,String code,Long idMin,Long idMax){
String query = "SELECT e FROM EtatIs e where 1=1 ";
query += SearchUtil.addConstraint( "e", "libelle","=",libelle);
query += SearchUtil.addConstraint( "e", "code","=",code);
query += SearchUtil.addConstraintMinMax("e", "id", idMin, idMax);

  return query; 
}
}
