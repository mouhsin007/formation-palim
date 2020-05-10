
package com.zsmart.is.service.impl ;
import com.zsmart.is.service.facade.FactureService ; 
import com.zsmart.is.dao.FactureDao ;
import com.zsmart.is.service.util.SearchUtil;
import com.zsmart.is.bean.Facture;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 

 @Service  

 public class FactureServiceImpl implements FactureService  {


 @Autowired 

 private FactureDao factureDao;
 
 @Autowired 
 
 private FactureService factureService;
 
 @Autowired 

 private EntityManager entityManager; 

 @Override 
public Facture  save (Facture facture){

if(facture== null){ 
 return null; 
}else {
 factureDao.save(facture);
return facture;
}
}

 @Override 
public List< Facture>  findAll(){
 return factureDao.findAll();
}

 @Override 
public Facture findById(Long id){
 return factureDao.getOne(id);
}

 @Override 
public Facture  findByReference(String  reference){
 return factureDao.findByReference(reference);
}

 @Override 
public int delete(Facture facture){
if(facture== null){ 
  return -1; 
}else {
 factureDao.delete(facture);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       factureDao.deleteById(id);
}

 @Override 
public void  deleteByReference(String  reference){
  factureDao.deleteByReference(reference);
}
public void clone(Facture facture,Facture factureClone){
if(facture!= null && factureClone != null){
factureClone.setId(facture.getId());
factureClone.setReference(facture.getReference());
factureClone.setTypeFacture(facture.getTypeFacture());
factureClone.setAnnee(facture.getAnnee());
factureClone.setMois(facture.getMois());
factureClone.setTrimester(facture.getTrimester());
factureClone.setTotalHt(facture.getTotalHt());
factureClone.setTotalTtc(facture.getTotalTtc());
factureClone.setTva(facture.getTva());
factureClone.setTotalPayerHt(facture.getTotalPayerHt());
factureClone.setTotalRestantHt(facture.getTotalRestantHt());
factureClone.setDateFacture(facture.getDateFacture());
factureClone.setDateSaisie(facture.getDateSaisie());
factureClone.setReferenceSociete(facture.getReferenceSociete());
}
}
public Facture clone(Facture facture){
if(facture== null){       return null ;
}else{Facture factureClone= new Facture();
 clone(facture,factureClone);
return factureClone;
}
}
public List<Facture> clone(List<Facture>factures){
if(factures== null){
       return null ;
}else{List<Facture> facturesClone = new ArrayList();
	 	 	 factures.forEach((facture)->{facturesClone.add(clone(facture));
});return facturesClone;
}
}
 @Override 
 public List< Facture>  findByCriteria(String reference,String typeFacture,String referenceSociete,long serialVersionUIDMin,long serialVersionUIDMax,Long idMin,Long idMax,Integer anneeMin,Integer anneeMax,Integer moisMin,Integer moisMax,Integer trimesterMin,Integer trimesterMax,BigDecimal totalHtMin,BigDecimal totalHtMax,BigDecimal totalTtcMin,BigDecimal totalTtcMax,BigDecimal tvaMin,BigDecimal tvaMax,BigDecimal totalPayerHtMin,BigDecimal totalPayerHtMax,BigDecimal totalRestantHtMin,BigDecimal totalRestantHtMax,Date dateFactureMin,Date dateFactureMax,Date dateSaisieMin,Date dateSaisieMax){
 return entityManager.createQuery(constructQuery(reference,typeFacture,referenceSociete,serialVersionUIDMin,serialVersionUIDMax,idMin,idMax,anneeMin,anneeMax,moisMin,moisMax,trimesterMin,trimesterMax,totalHtMin,totalHtMax,totalTtcMin,totalTtcMax,tvaMin,tvaMax,totalPayerHtMin,totalPayerHtMax,totalRestantHtMin,totalRestantHtMax,dateFactureMin,dateFactureMax,dateSaisieMin,dateSaisieMax)).getResultList(); 
 }
private String constructQuery(String reference,String typeFacture,String referenceSociete,long serialVersionUIDMin,long serialVersionUIDMax,Long idMin,Long idMax,Integer anneeMin,Integer anneeMax,Integer moisMin,Integer moisMax,Integer trimesterMin,Integer trimesterMax,BigDecimal totalHtMin,BigDecimal totalHtMax,BigDecimal totalTtcMin,BigDecimal totalTtcMax,BigDecimal tvaMin,BigDecimal tvaMax,BigDecimal totalPayerHtMin,BigDecimal totalPayerHtMax,BigDecimal totalRestantHtMin,BigDecimal totalRestantHtMax,Date dateFactureMin,Date dateFactureMax,Date dateSaisieMin,Date dateSaisieMax){
String query = "SELECT f FROM Facture f where 1=1 ";
query += SearchUtil.addConstraint( "f", "reference","=",reference);
query += SearchUtil.addConstraint( "f", "typeFacture","=",typeFacture);
query += SearchUtil.addConstraint( "f", "referenceSociete","=",referenceSociete);
query += SearchUtil.addConstraintMinMax("f", "serialVersionUID", serialVersionUIDMin, serialVersionUIDMax);
query += SearchUtil.addConstraintMinMax("f", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("f", "annee", anneeMin, anneeMax);
query += SearchUtil.addConstraintMinMax("f", "mois", moisMin, moisMax);
query += SearchUtil.addConstraintMinMax("f", "trimester", trimesterMin, trimesterMax);
query += SearchUtil.addConstraintMinMax("f", "totalHt", totalHtMin, totalHtMax);
query += SearchUtil.addConstraintMinMax("f", "totalTtc", totalTtcMin, totalTtcMax);
query += SearchUtil.addConstraintMinMax("f", "tva", tvaMin, tvaMax);
query += SearchUtil.addConstraintMinMax("f", "totalPayerHt", totalPayerHtMin, totalPayerHtMax);
query += SearchUtil.addConstraintMinMax("f", "totalRestantHt", totalRestantHtMin, totalRestantHtMax);
query += SearchUtil.addConstraintMinMaxDate("f"," dateFacture", dateFactureMin, dateFactureMax);
query += SearchUtil.addConstraintMinMaxDate("f"," dateSaisie", dateSaisieMin, dateSaisieMax);

  return query; 
}

@Override
public List<Facture> factureCharge( Integer anne) {
	
	return factureDao.findByAnneeAndTypeFacture( anne,"charge");
}

@Override
public List<Facture> factureGain( Integer anne) {
	
	return factureDao.findByAnneeAndTypeFacture( anne, "gain");
}

@Override
public Facture ajouter(Facture facture) {
	Facture myClone=clone(facture);
	Facture facture2=factureService.findByReference(facture.getReference());
	if(facture2==null)
		return myClone;
	else
	return null;
}

@Override
public int saveListFacture(List<Facture> factures) {
	for (Facture facture : factures) {
	Facture	fte=factureService.findByReference(facture.getReference());
		if(fte==null) {
			factureService.save(facture);
		}
	}
	return 1;
}



}
