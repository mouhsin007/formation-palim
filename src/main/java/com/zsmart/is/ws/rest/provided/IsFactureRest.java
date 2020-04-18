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
import com.zsmart.is.service.facade.IsFactureService;
import com.zsmart.is.bean.ImpotSociete;
import com.zsmart.is.bean.IsFacture;
import com.zsmart.is.ws.rest.vo.IsFactureVo;
import com.zsmart.is.ws.rest.converter.IsFactureConverter;
import com.zsmart.is.service.util.* ;
@RestController
@RequestMapping("/is/isFacture")
@CrossOrigin(origins = {"http://localhost:4200"})
public class IsFactureRest {

 @Autowired 
 private IsFactureService isFactureService;

 

@Autowired 
private IsFactureConverter isFactureConverter ;



@PostMapping("/")
public IsFactureVo save(@RequestBody IsFactureVo isFactureVo){
IsFacture isFacture= isFactureConverter.toItem(isFactureVo);
return isFactureConverter.toVo(isFactureService.save(isFacture));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
isFactureService.deleteById(id);
}
@GetMapping("/")
public List<IsFactureVo> findAll(){
return isFactureConverter.toVo(isFactureService.findAll());
}

 public IsFactureConverter getIsFactureConverter(){
return isFactureConverter;
}
 
 public void setIsFactureConverter(IsFactureConverter isFactureConverter){
this.isFactureConverter=isFactureConverter;
}

 public IsFactureService getIsFactureService(){
return isFactureService;
}
 
 public void setIsFactureService(IsFactureService isFactureService){
this.isFactureService=isFactureService;
}

}