package com.jpo.junit.service;

import java.util.List;

import com.jpo.junit.domain.SmartWatch;

public interface SmartWatchService {

    Integer count();

    List<SmartWatch> findAll();

    SmartWatch findOne(Long id);

    SmartWatch save(SmartWatch user);

    boolean delete(Long id);

    void deleteAll();
}
