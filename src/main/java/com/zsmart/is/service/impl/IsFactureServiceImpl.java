
package com.zsmart.is.service.impl ;
import com.zsmart.is.service.facade.IsFactureService ; 
import com.zsmart.is.dao.IsFactureDao ;
import com.zsmart.is.service.util.SearchUtil;
import com.zsmart.is.bean.IsFacture;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.is.bean.ImpotSociete; 
import com.zsmart.is.service.facade.ImpotSocieteService ; 

 @Service  

 public class IsFactureServiceImpl implements IsFactureService  {


 @Autowired 

 private IsFactureDao isfactureDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private ImpotSocieteService impotsocieteService; 

 @Override 
public IsFacture  save (IsFacture isfacture){

if(isfacture== null){ 
 return null; 
}else {
 isfactureDao.save(isfacture);
return isfacture;
}
}

 @Override 
public List< IsFacture>  findAll(){
 return isfactureDao.findAll();
}

 @Override 
public IsFacture findById(Long id){
 return isfactureDao.getOne(id);
}

 @Override 
public int delete(IsFacture isfacture){
if(isfacture== null){ 
  return -1; 
}else {
 isfactureDao.delete(isfacture);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       isfactureDao.deleteById(id);
}
public void clone(IsFacture isfacture,IsFacture isfactureClone){
if(isfacture!= null && isfactureClone != null){
isfactureClone.setId(isfacture.getId());
isfactureClone.setReferenceFacture(isfacture.getReferenceFacture());
isfactureClone.setReferenceSociete(isfacture.getReferenceSociete());
isfactureClone.setImpotSociete(impotsocieteService.clone(isfacture.getImpotSociete()));
}
}
public IsFacture clone(IsFacture isfacture){
if(isfacture== null){       return null ;
}else{IsFacture isfactureClone= new IsFacture();
 clone(isfacture,isfactureClone);
return isfactureClone;
}
}
public List<IsFacture> clone(List<IsFacture>isfactures){
if(isfactures== null){
       return null ;
}else{List<IsFacture> isfacturesClone = new ArrayList();
	 	 	 isfactures.forEach((isfacture)->{isfacturesClone.add(clone(isfacture));
});return isfacturesClone;
}
}
 @Override 
 public List< IsFacture>  findByCriteria(String referenceFacture,String referenceSociete,long serialVersionUIDMin,long serialVersionUIDMax,Long idMin,Long idMax){
 return entityManager.createQuery(constructQuery(referenceFacture,referenceSociete,serialVersionUIDMin,serialVersionUIDMax,idMin,idMax)).getResultList(); 
 }
private String constructQuery(String referenceFacture,String referenceSociete,long serialVersionUIDMin,long serialVersionUIDMax,Long idMin,Long idMax){
String query = "SELECT i FROM IsFacture i where 1=1 ";
query += SearchUtil.addConstraint( "i", "referenceFacture","=",referenceFacture);
query += SearchUtil.addConstraint( "i", "referenceSociete","=",referenceSociete);
query += SearchUtil.addConstraintMinMax("i", "serialVersionUID", serialVersionUIDMin, serialVersionUIDMax);
query += SearchUtil.addConstraintMinMax("i", "id", idMin, idMax);

  return query; 
}
}
