package com.zsmart.is.dao;
import com.zsmart.is.bean.EtatIs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface EtatIsDao extends JpaRepository<EtatIs,Long> {




}
