package com.zsmart.is.ws.rest.provided ;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.zsmart.is.service.facade.ImpotSocieteService;
import com.zsmart.is.bean.ImpotSociete;
import com.zsmart.is.ws.rest.vo.ImpotSocieteVo;
import com.zsmart.is.ws.rest.converter.ImpotSocieteConverter;
import com.zsmart.is.service.util.* ;
@RestController
@RequestMapping("/is/impotSociete")
@CrossOrigin(origins = {"http://localhost:4200"})
public class ImpotSocieteRest {

 @Autowired 
 private ImpotSocieteService impotSocieteService;
 
 
 @PostMapping("/save-is-et-is-facture/")
public int saveIsEtIsFacture(@RequestBody ImpotSociete impotSociete) {
	return impotSocieteService.saveIsEtIsFacture(impotSociete);
}
@GetMapping("/find-factures-by-annee/{annee}")
 public ImpotSociete findFacturesByAnnee(@PathVariable Integer annee) {
	return impotSocieteService.findFacturesByAnnee(annee);
}

@Autowired 
private ImpotSocieteConverter impotSocieteConverter ;

@PostMapping("/")
public ImpotSocieteVo save(@RequestBody ImpotSocieteVo impotSocieteVo){
ImpotSociete impotSociete= impotSocieteConverter.toItem(impotSocieteVo);
return impotSocieteConverter.toVo(impotSocieteService.save(impotSociete));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
impotSocieteService.deleteById(id);
}
@DeleteMapping("/{reference}")
public void  deleteByReference(@PathVariable String  reference){
impotSocieteService.deleteByReference(reference);
}
@GetMapping("/")
public List<ImpotSocieteVo> findAll(){
return impotSocieteConverter.toVo(impotSocieteService.findAll());
}

 public ImpotSocieteConverter getImpotSocieteConverter(){
return impotSocieteConverter;
}
 
 public void setImpotSocieteConverter(ImpotSocieteConverter impotSocieteConverter){
this.impotSocieteConverter=impotSocieteConverter;
}

 public ImpotSocieteService getImpotSocieteService(){
return impotSocieteService;
}
 
 public void setImpotSocieteService(ImpotSocieteService impotSocieteService){
this.impotSocieteService=impotSocieteService;
}

}