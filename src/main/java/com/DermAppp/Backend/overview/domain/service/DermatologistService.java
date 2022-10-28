package com.DermAppp.Backend.overview.domain.service;

import com.DermAppp.Backend.overview.domain.model.entity.Dermatologist;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DermatologistService {

    List<Dermatologist> getAll();
    Page<Dermatologist> getAll(Pageable pageable);
    Dermatologist getById(Long dermatologistId);
    Dermatologist create(Dermatologist dermatologist);
    Dermatologist update(Long dermatologistId, Dermatologist request);
    ResponseEntity<?> delete(Long dermatologistId);



}
