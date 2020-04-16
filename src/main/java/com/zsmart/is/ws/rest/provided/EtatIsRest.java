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
import com.zsmart.is.service.facade.EtatIsService;
import com.zsmart.is.bean.EtatIs;
import com.zsmart.is.ws.rest.vo.EtatIsVo;
import com.zsmart.is.ws.rest.converter.EtatIsConverter;
import com.zsmart.is.service.util.* ;
@RestController
@RequestMapping("/is/EtatIs")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EtatIsRest {

 @Autowired 
 private EtatIsService etatIsService;

 @Autowired 
private EtatIsConverter etatIsConverter ;

@PostMapping("/")
public EtatIsVo save(@RequestBody EtatIsVo etatIsVo){
EtatIs etatIs= etatIsConverter.toItem(etatIsVo);
return etatIsConverter.toVo(etatIsService.save(etatIs));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
etatIsService.deleteById(id);
}
@GetMapping("/")
public List<EtatIsVo> findAll(){
return etatIsConverter.toVo(etatIsService.findAll());
}

 public EtatIsConverter getEtatIsConverter(){
return etatIsConverter;
}
 
 public void setEtatIsConverter(EtatIsConverter etatIsConverter){
this.etatIsConverter=etatIsConverter;
}

 public EtatIsService getEtatIsService(){
return etatIsService;
}
 
 public void setEtatIsService(EtatIsService etatIsService){
this.etatIsService=etatIsService;
}

}