package com.example.assignmentspringboot1.api;

import com.example.assignmentspringboot1.entity.District;
import com.example.assignmentspringboot1.service.DistrictService;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/v1/district")
public class DistrictApi {
    @Autowired
    DistrictService districtService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<District> save(@RequestBody District district){
        return ResponseEntity.ok(districtService.save(district));
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<District>> findAll(){return ResponseEntity.ok(districtService.findAll());}
    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        Optional<District> district = districtService.findById(id);
        if (!district.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(district.get());
    }
    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<District> update(@PathVariable int id,@RequestBody District product){
        Optional<District> productId = districtService.findById(id);
        if (!productId.isPresent()){
            ResponseEntity.badRequest().build();
        }
        District exitsDistrict = productId.get();
        exitsDistrict.setName(product.getName());
        exitsDistrict.setStatus(product.getStatus());
        return ResponseEntity.ok(districtService.save(exitsDistrict));
    }
    @RequestMapping(method = RequestMethod.DELETE,path = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Optional<District> district = districtService.findById(id);
        if (!district.isPresent()){
            ResponseEntity.badRequest().build();
        }
        districtService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
