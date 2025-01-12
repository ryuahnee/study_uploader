package com.clovasentiment.test.apitest.service;

import com.clovasentiment.test.apitest.entity.DeskEntity;
import com.clovasentiment.test.apitest.repository.DeskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeskService {

    private final DeskRepository deskRepository;

    public DeskService(DeskRepository deskRepository) {
        this.deskRepository = deskRepository;
    }

    public DeskEntity selectByMember(Long memberNumber) {
        Optional<DeskEntity> byId = deskRepository.findById(memberNumber);
        return byId.get();
    }


}
