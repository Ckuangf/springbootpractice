package com.cifor.practice.service.serviceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.cifor.practice.pojo.CiforUser;
import com.cifor.practice.repository.CiforUserRepository;
import com.cifor.practice.service.CiforUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(version = "1.0.0")
@Transactional
public class CiforUserServiceImpl implements CiforUserService {

    @Autowired
    private CiforUserRepository ciforUserRepository;

    @Override
    public CiforUser findById(String id) {
        return ciforUserRepository.findById(id).get();
    }

    @Override
    public List<CiforUser> findAll() {
        return ciforUserRepository.findAll();
    }

    @Override
    public List<CiforUser> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public CiforUser save(CiforUser ciforUser) {
        CiforUser save = ciforUserRepository.save(ciforUser);
        return save;
    }

    @Override
    public void delete(String id) {
        ciforUserRepository.delete(findById(id));
    }
}
