package com.zsmart.is.ws.rest.provided ;


import java.math.BigDecimal;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.zsmart.is.service.facade.FactureService;
import com.zsmart.is.bean.Facture;
import com.zsmart.is.ws.rest.vo.FactureVo;
import com.zsmart.is.ws.rest.converter.FactureConverter;
import com.zsmart.is.service.util.* ;
@RestController
@RequestMapping("/is/facture")
@CrossOrigin(origins = {"http://localhost:4200"})
public class FactureRest {

 @Autowired 
 private FactureService factureService;
 
 
@PostMapping("/save-list-facture/")
public int saveListFacture(@RequestBody List<Facture> factures) {
	return factureService.saveListFacture(factures);
}
@PutMapping("/ajouter-une-facture/")
public Facture ajouter(@RequestBody Facture facture) {
	return factureService.ajouter(facture);
}

@Autowired 
 private FactureConverter factureConverter ;
@GetMapping("/find-facture-charge/annee/{anne}")
 public List<Facture> factureCharge(@PathVariable Integer anne) {
	return factureService.factureCharge(anne);
}
@GetMapping("/find-facture-gain/annee/{anne}")
public List<Facture> factureGain(@PathVariable Integer anne) {
	return factureService.factureGain(anne);
}


@PostMapping("/")
public FactureVo save(@RequestBody FactureVo factureVo){
Facture facture= factureConverter.toItem(factureVo);
return factureConverter.toVo(factureService.save(facture));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
factureService.deleteById(id);
}
@DeleteMapping("/{reference}")
public void  deleteByReference(@PathVariable String  reference){
factureService.deleteByReference(reference);
}
@GetMapping("/")
public List<FactureVo> findAll(){
return factureConverter.toVo(factureService.findAll());
}

 public FactureConverter getFactureConverter(){
return factureConverter;
}
 
 public void setFactureConverter(FactureConverter factureConverter){
this.factureConverter=factureConverter;
}

 public FactureService getFactureService(){
return factureService;
}
 
 public void setFactureService(FactureService factureService){
this.factureService=factureService;
}

}