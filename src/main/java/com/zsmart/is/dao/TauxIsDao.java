package com.zsmart.is.dao;
import com.zsmart.is.bean.TauxIs;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
 public interface TauxIsDao extends JpaRepository<TauxIs,Long> {




}
