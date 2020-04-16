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
import com.zsmart.is.service.facade.TauxIsService;
import com.zsmart.is.bean.TauxIs;
import com.zsmart.is.ws.rest.vo.TauxIsVo;
import com.zsmart.is.ws.rest.converter.TauxIsConverter;
import com.zsmart.is.service.util.* ;
@RestController
@RequestMapping("/is/TauxIs")
@CrossOrigin(origins = {"http://localhost:4200"})
public class TauxIsRest {

 @Autowired 
 private TauxIsService tauxIsService;

 @Autowired 
private TauxIsConverter tauxIsConverter ;

@PostMapping("/")
public TauxIsVo save(@RequestBody TauxIsVo tauxIsVo){
TauxIs tauxIs= tauxIsConverter.toItem(tauxIsVo);
return tauxIsConverter.toVo(tauxIsService.save(tauxIs));
}
@DeleteMapping("/{id}")
public void deleteById(@PathVariable Long id){
tauxIsService.deleteById(id);
}
@GetMapping("/")
public List<TauxIsVo> findAll(){
return tauxIsConverter.toVo(tauxIsService.findAll());
}

 public TauxIsConverter getTauxIsConverter(){
return tauxIsConverter;
}
 
 public void setTauxIsConverter(TauxIsConverter tauxIsConverter){
this.tauxIsConverter=tauxIsConverter;
}

 public TauxIsService getTauxIsService(){
return tauxIsService;
}
 
 public void setTauxIsService(TauxIsService tauxIsService){
this.tauxIsService=tauxIsService;
}

}