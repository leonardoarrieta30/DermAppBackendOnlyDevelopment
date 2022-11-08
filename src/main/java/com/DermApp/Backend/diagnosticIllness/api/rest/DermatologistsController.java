package com.DermApp.Backend.diagnosticIllness.api.rest;


import com.DermApp.Backend.diagnosticIllness.domain.service.DermatologistService;
import com.DermApp.Backend.diagnosticIllness.mapping.DematologistMapper;
import com.DermApp.Backend.diagnosticIllness.resource.CreateDermatologistResource;
import com.DermApp.Backend.diagnosticIllness.resource.DermatologistResource;
import com.DermApp.Backend.diagnosticIllness.resource.UpdateDermatologistResource;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/v1/dermatologists", produces = "application/json")
@Tag(name = "Dermatologists", description = "Create, read, update and delete dermatologists")
public class DermatologistsController {

    private final DermatologistService dermatologistService;

    private final DematologistMapper mapper;


    public DermatologistsController(DermatologistService dermatologistService, DematologistMapper mapper) {
        this.dermatologistService = dermatologistService;
        this.mapper = mapper;
    }
    @GetMapping
    public Page<DermatologistResource> getAllDermatologists(Pageable pageable) {
        return mapper.modelListPage(dermatologistService.getAll(), pageable);
    }


    @GetMapping("{dermatologistId}")
    public DermatologistResource getDermatologistById(@PathVariable Long dermatologistId){
        return mapper.toResource(dermatologistService.getById(dermatologistId));
    }

    @PostMapping
    public ResponseEntity<DermatologistResource> createDermatologist(@RequestBody CreateDermatologistResource resource){
        return new ResponseEntity<>(mapper.toResource(dermatologistService.create(mapper.toModel(resource))), HttpStatus.CREATED);
    }

    @PutMapping("{dermatologistId}")
    public DermatologistResource updateDermatologist(@PathVariable Long dermatologistId, @RequestBody UpdateDermatologistResource resource){
        return mapper.toResource(dermatologistService.update(dermatologistId,mapper.toModel(resource)));
    }


    @DeleteMapping("{dermatologistId}")
    public ResponseEntity<?> deleteDermatologist(@PathVariable Long dermatologistId){
        return dermatologistService.delete(dermatologistId);
    }

}
