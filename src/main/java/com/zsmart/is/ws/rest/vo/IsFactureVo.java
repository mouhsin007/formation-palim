package com.zsmart.is.ws.rest.vo;

import java.util.ArrayList;
import java.util.List;


public class IsFactureVo{

private String serialVersionUID;
private String serialVersionUIDMin ;
private String serialVersionUIDMax ;
private String id ;
private String referenceFacture ;
private String referenceSociete ;
private ImpotSocieteVo impotSocieteVo ;



public String  getSerialVersionUID(){
    return serialVersionUID;
}

public void setSerialVersionUID(String  serialVersionUID){
     this.serialVersionUID = serialVersionUID;
}

public String  getSerialVersionUIDMin(){
    return serialVersionUIDMin;
}

public void setSerialVersionUIDMin(String  serialVersionUIDMin){
     this.serialVersionUIDMin = serialVersionUIDMin;
}

public String  getSerialVersionUIDMax(){
    return serialVersionUIDMax;
}

public void setSerialVersionUIDMax(String  serialVersionUIDMax){
     this.serialVersionUIDMax = serialVersionUIDMax;
}

public String  getId(){
    return id;
}

public void setId(String  id){
     this.id = id;
}

public String  getReferenceFacture(){
    return referenceFacture;
}

public void setReferenceFacture(String  referenceFacture){
     this.referenceFacture = referenceFacture;
}

public String  getReferenceSociete(){
    return referenceSociete;
}

public void setReferenceSociete(String  referenceSociete){
     this.referenceSociete = referenceSociete;
}

public ImpotSocieteVo  getImpotSocieteVo (){
    return impotSocieteVo ;
}

public void setImpotSocieteVo (ImpotSocieteVo  impotSocieteVo ){
     this.impotSocieteVo  = impotSocieteVo ;
}




}