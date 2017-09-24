package com.emp.model;

import java.util.*;

public interface EmpDAO_interface {
          public void insert(EmpVO empVO);
          public void update(EmpVO empVO);
          public void delete(Integer empno);
          public EmpVO findByPrimaryKey(Integer empno);
          public List<EmpVO> getAll();
          //給複合查詢的
          public List<EmpVO> getAll(Map<String, String[]> map); 
}
