package com.cifor.practice.service;

import com.cifor.practice.pojo.CiforUser;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CiforUserService {

    CiforUser findById(String id);

    List<CiforUser> findAll();

    List<CiforUser> findAll(Pageable pageable);

    CiforUser save(CiforUser ciforUser);

    void delete(String id);

}
