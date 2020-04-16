
package com.zsmart.is.service.impl ;
import com.zsmart.is.service.facade.ImpotSocieteService ; 
import com.zsmart.is.dao.ImpotSocieteDao ;
import com.zsmart.is.service.util.SearchUtil;
import com.zsmart.is.bean.ImpotSociete;
import org.springframework.beans.factory.annotation.Autowired; 
import java.util.ArrayList; 
import java.math.BigDecimal; 
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Date; 
import org.springframework.stereotype.Service; 
import java.util.List; 
import com.zsmart.is.bean.TauxIs; 
import com.zsmart.is.service.facade.TauxIsService ; 
import com.zsmart.is.bean.EtatIs; 
import com.zsmart.is.service.facade.EtatIsService ; 
import com.zsmart.is.service.facade.IsFactureService ; 
import com.zsmart.is.bean.IsFacture ; 

 @Service  

 public class ImpotSocieteServiceImpl implements ImpotSocieteService  {


 @Autowired 

 private ImpotSocieteDao impotsocieteDao;

 @Autowired 

 private EntityManager entityManager; 

 @Autowired 

 private IsFactureService isfactureService; 

 @Autowired 

 private TauxIsService tauxisService; 

 @Autowired 

 private EtatIsService etatisService; 

 @Override 
public ImpotSociete  save (ImpotSociete impotsociete){

if(impotsociete== null){ 
 return null; 
}else {
 impotsocieteDao.save(impotsociete);
return impotsociete;
}
}

 @Override 
public ImpotSociete  saveWithIsFactures (ImpotSociete impotsociete){

if(impotsociete== null){ 
        return null; 
}else {
   if(impotsociete.getIsFactures().isEmpty()){
            return null;
        }else{
impotsocieteDao.save(impotsociete);
            for (IsFacture isfacture : impotsociete.getIsFactures()) {
isfacture.setImpotSociete(impotsociete);
 isfactureService.save(  isfacture);          
            }
return impotsociete;
}
}
            }

 @Override 
public List< ImpotSociete>  findAll(){
 return impotsocieteDao.findAll();
}

 @Override 
public ImpotSociete findById(Long id){
 return impotsocieteDao.getOne(id);
}

 @Override 
public ImpotSociete  findByReference(String  reference){
 return impotsocieteDao.findByReference(reference);
}

 @Override 
public int delete(ImpotSociete impotsociete){
if(impotsociete== null){ 
  return -1; 
}else {
 impotsocieteDao.delete(impotsociete);
return 1 ;
}
}

 @Override 
public void deleteById(Long id){
       impotsocieteDao.deleteById(id);
}

 @Override 
public void  deleteByReference(String  reference){
  impotsocieteDao.deleteByReference(reference);
}
public void clone(ImpotSociete impotsociete,ImpotSociete impotsocieteClone){
if(impotsociete!= null && impotsocieteClone != null){
impotsocieteClone.setId(impotsociete.getId());
impotsocieteClone.setTotalCharge(impotsociete.getTotalCharge());
impotsocieteClone.setTotalGain(impotsociete.getTotalGain());
impotsocieteClone.setProfit(impotsociete.getProfit());
impotsocieteClone.setMontantTotal(impotsociete.getMontantTotal());
impotsocieteClone.setMontantBaseIs(impotsociete.getMontantBaseIs());
impotsocieteClone.setMontantRetard(impotsociete.getMontantRetard());
impotsocieteClone.setMontantMajoration(impotsociete.getMontantMajoration());
impotsocieteClone.setMontantPenalite(impotsociete.getMontantPenalite());
impotsocieteClone.setNomberMoisRetard(impotsociete.getNomberMoisRetard());
impotsocieteClone.setDescription(impotsociete.getDescription());
impotsocieteClone.setReference(impotsociete.getReference());
impotsocieteClone.setReferenceComptableValidateur(impotsociete.getReferenceComptableValidateur());
impotsocieteClone.setReferenceComptableCreateur(impotsociete.getReferenceComptableCreateur());
impotsocieteClone.setAnne(impotsociete.getAnne());
impotsocieteClone.setMois(impotsociete.getMois());
impotsocieteClone.setHonoraire(impotsociete.getHonoraire());
impotsocieteClone.setPenalite(impotsociete.getPenalite());
impotsocieteClone.setMajoration(impotsociete.getMajoration());
impotsocieteClone.setDateValidation(impotsociete.getDateValidation());
impotsocieteClone.setDateSoumission(impotsociete.getDateSoumission());
impotsocieteClone.setDateAffectationComptable(impotsociete.getDateAffectationComptable());
impotsocieteClone.setDateFinalisation(impotsociete.getDateFinalisation());
impotsocieteClone.setDateSaisie(impotsociete.getDateSaisie());
impotsocieteClone.setTauxIs(tauxisService.clone(impotsociete.getTauxIs()));
impotsocieteClone.setEtatIs(etatisService.clone(impotsociete.getEtatIs()));
impotsocieteClone.setIsFactures(isfactureService.clone(impotsociete.getIsFactures()));
}
}
public ImpotSociete clone(ImpotSociete impotsociete){
if(impotsociete== null){       return null ;
}else{ImpotSociete impotsocieteClone= new ImpotSociete();
 clone(impotsociete,impotsocieteClone);
return impotsocieteClone;
}
}
public List<ImpotSociete> clone(List<ImpotSociete>impotsocietes){
if(impotsocietes== null){
       return null ;
}else{List<ImpotSociete> impotsocietesClone = new ArrayList();
	 	 	 impotsocietes.forEach((impotsociete)->{impotsocietesClone.add(clone(impotsociete));
});return impotsocietesClone;
}
}
 @Override 
 public List< ImpotSociete>  findByCriteria(String description,String reference,String referenceComptableValidateur,String referenceComptableCreateur,Long idMin,Long idMax,BigDecimal totalChargeMin,BigDecimal totalChargeMax,BigDecimal totalGainMin,BigDecimal totalGainMax,BigDecimal profitMin,BigDecimal profitMax,BigDecimal montantTotalMin,BigDecimal montantTotalMax,BigDecimal montantBaseIsMin,BigDecimal montantBaseIsMax,BigDecimal montantRetardMin,BigDecimal montantRetardMax,BigDecimal montantMajorationMin,BigDecimal montantMajorationMax,BigDecimal montantPenaliteMin,BigDecimal montantPenaliteMax,Integer nomberMoisRetardMin,Integer nomberMoisRetardMax,Integer anneMin,Integer anneMax,Integer moisMin,Integer moisMax,BigDecimal honoraireMin,BigDecimal honoraireMax,BigDecimal penaliteMin,BigDecimal penaliteMax,BigDecimal majorationMin,BigDecimal majorationMax,Date dateValidationMin,Date dateValidationMax,Date dateSoumissionMin,Date dateSoumissionMax,Date dateAffectationComptableMin,Date dateAffectationComptableMax,Date dateFinalisationMin,Date dateFinalisationMax,Date dateSaisieMin,Date dateSaisieMax){
 return entityManager.createQuery(constructQuery(description,reference,referenceComptableValidateur,referenceComptableCreateur,idMin,idMax,totalChargeMin,totalChargeMax,totalGainMin,totalGainMax,profitMin,profitMax,montantTotalMin,montantTotalMax,montantBaseIsMin,montantBaseIsMax,montantRetardMin,montantRetardMax,montantMajorationMin,montantMajorationMax,montantPenaliteMin,montantPenaliteMax,nomberMoisRetardMin,nomberMoisRetardMax,anneMin,anneMax,moisMin,moisMax,honoraireMin,honoraireMax,penaliteMin,penaliteMax,majorationMin,majorationMax,dateValidationMin,dateValidationMax,dateSoumissionMin,dateSoumissionMax,dateAffectationComptableMin,dateAffectationComptableMax,dateFinalisationMin,dateFinalisationMax,dateSaisieMin,dateSaisieMax)).getResultList(); 
 }
private String constructQuery(String description,String reference,String referenceComptableValidateur,String referenceComptableCreateur,Long idMin,Long idMax,BigDecimal totalChargeMin,BigDecimal totalChargeMax,BigDecimal totalGainMin,BigDecimal totalGainMax,BigDecimal profitMin,BigDecimal profitMax,BigDecimal montantTotalMin,BigDecimal montantTotalMax,BigDecimal montantBaseIsMin,BigDecimal montantBaseIsMax,BigDecimal montantRetardMin,BigDecimal montantRetardMax,BigDecimal montantMajorationMin,BigDecimal montantMajorationMax,BigDecimal montantPenaliteMin,BigDecimal montantPenaliteMax,Integer nomberMoisRetardMin,Integer nomberMoisRetardMax,Integer anneMin,Integer anneMax,Integer moisMin,Integer moisMax,BigDecimal honoraireMin,BigDecimal honoraireMax,BigDecimal penaliteMin,BigDecimal penaliteMax,BigDecimal majorationMin,BigDecimal majorationMax,Date dateValidationMin,Date dateValidationMax,Date dateSoumissionMin,Date dateSoumissionMax,Date dateAffectationComptableMin,Date dateAffectationComptableMax,Date dateFinalisationMin,Date dateFinalisationMax,Date dateSaisieMin,Date dateSaisieMax){
String query = "SELECT i FROM ImpotSociete i where 1=1 ";
query += SearchUtil.addConstraint( "i", "description","=",description);
query += SearchUtil.addConstraint( "i", "reference","=",reference);
query += SearchUtil.addConstraint( "i", "referenceComptableValidateur","=",referenceComptableValidateur);
query += SearchUtil.addConstraint( "i", "referenceComptableCreateur","=",referenceComptableCreateur);
query += SearchUtil.addConstraintMinMax("i", "id", idMin, idMax);
query += SearchUtil.addConstraintMinMax("i", "totalCharge", totalChargeMin, totalChargeMax);
query += SearchUtil.addConstraintMinMax("i", "totalGain", totalGainMin, totalGainMax);
query += SearchUtil.addConstraintMinMax("i", "profit", profitMin, profitMax);
query += SearchUtil.addConstraintMinMax("i", "montantTotal", montantTotalMin, montantTotalMax);
query += SearchUtil.addConstraintMinMax("i", "montantBaseIs", montantBaseIsMin, montantBaseIsMax);
query += SearchUtil.addConstraintMinMax("i", "montantRetard", montantRetardMin, montantRetardMax);
query += SearchUtil.addConstraintMinMax("i", "montantMajoration", montantMajorationMin, montantMajorationMax);
query += SearchUtil.addConstraintMinMax("i", "montantPenalite", montantPenaliteMin, montantPenaliteMax);
query += SearchUtil.addConstraintMinMax("i", "nomberMoisRetard", nomberMoisRetardMin, nomberMoisRetardMax);
query += SearchUtil.addConstraintMinMax("i", "anne", anneMin, anneMax);
query += SearchUtil.addConstraintMinMax("i", "mois", moisMin, moisMax);
query += SearchUtil.addConstraintMinMax("i", "honoraire", honoraireMin, honoraireMax);
query += SearchUtil.addConstraintMinMax("i", "penalite", penaliteMin, penaliteMax);
query += SearchUtil.addConstraintMinMax("i", "majoration", majorationMin, majorationMax);
query += SearchUtil.addConstraintMinMaxDate("i"," dateValidation", dateValidationMin, dateValidationMax);
query += SearchUtil.addConstraintMinMaxDate("i"," dateSoumission", dateSoumissionMin, dateSoumissionMax);
query += SearchUtil.addConstraintMinMaxDate("i"," dateAffectationComptable", dateAffectationComptableMin, dateAffectationComptableMax);
query += SearchUtil.addConstraintMinMaxDate("i"," dateFinalisation", dateFinalisationMin, dateFinalisationMax);
query += SearchUtil.addConstraintMinMaxDate("i"," dateSaisie", dateSaisieMin, dateSaisieMax);

  return query; 
}
}
