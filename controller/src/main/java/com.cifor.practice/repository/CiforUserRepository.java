package com.cifor.practice.repository;

import com.cifor.practice.pojo.CiforUser;
import org.springframework.stereotype.Repository;

@Repository
public interface CiforUserRepository extends BaseRepository<CiforUser,String> {
}
