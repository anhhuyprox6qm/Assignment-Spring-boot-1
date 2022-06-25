package com.example.assignmentspringboot1.api;

import com.example.assignmentspringboot1.entity.Street;
import com.example.assignmentspringboot1.service.StreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/street")
public class StreetApi {
    @Autowired
    StreetService streetService;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Street> save(@RequestBody Street street){
        return ResponseEntity.ok(streetService.save(street));
    }
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Street>> findAll(){return ResponseEntity.ok(streetService.findAll());}
    @RequestMapping(method = RequestMethod.GET,path = "{id}")
    public ResponseEntity<?> findById(@PathVariable int id){
        Optional<Street> street = streetService.findById(id);
        if (!street.isPresent()){
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(street.get());
    }
    @RequestMapping(method = RequestMethod.PUT,path = "{id}")
    public ResponseEntity<Street> update(@PathVariable int id,@RequestBody Street product){
        Optional<Street> productId = streetService.findById(id);
        if (!productId.isPresent()){
            ResponseEntity.badRequest().build();
        }
        Street exitsStreet = productId.get();
        exitsStreet.setName(product.getName());
        exitsStreet.setDistrict(product.getDistrict());
        exitsStreet.setFounding(product.getFounding());
        exitsStreet.setDescription(product.getDescription());
        exitsStreet.setStatus(product.getStatus());
        return ResponseEntity.ok(streetService.save(exitsStreet));
    }
    @RequestMapping(method = RequestMethod.DELETE,path = "{id}")
    public ResponseEntity<?> delete(@PathVariable int id){
        Optional<Street> street = streetService.findById(id);
        if (!street.isPresent()){
            ResponseEntity.badRequest().build();
        }
        streetService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
