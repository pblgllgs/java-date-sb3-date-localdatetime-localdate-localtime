package com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.controller;
/*
 *
 * @author pblgl
 * Created on 24-04-2024
 *
 */

import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.dto.DateTimeDetails;
import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.dto.HouseResponse;
import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.dto.HouseRequest;
import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/houses")
public class HouseController {

    private final HouseService houseService;

    @PostMapping
    public ResponseEntity<HouseResponse> save(@RequestBody HouseRequest requestHouse){
        return new ResponseEntity<>(houseService.createHouse(requestHouse), HttpStatus.CREATED);
    }

    @GetMapping("/{houseId}")
    public ResponseEntity<HouseResponse> findById(@PathVariable("houseId") Long houseId){
        return new ResponseEntity<>(houseService.findById(houseId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<HouseResponse>> findAll(){
        return new ResponseEntity<>(houseService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/date/{first}/{second}")
    public ResponseEntity<Boolean> isBefore(@PathVariable Long first, @PathVariable Long second){
        return new ResponseEntity<>(houseService.isDateBefore(first, second), HttpStatus.OK);
    }

    @GetMapping("/time/{first}/{second}")
    public ResponseEntity<Boolean> isTimeBefore(@PathVariable Long first, @PathVariable Long second){
        return new ResponseEntity<>(houseService.isTimeBefore(first, second), HttpStatus.OK);
    }

    @GetMapping("/datetime/{houseId}")
    public ResponseEntity<DateTimeDetails> getDateTimeDetails(@PathVariable Long houseId){
        return new ResponseEntity<>(houseService.getDateTimeDetails(houseId), HttpStatus.OK);
    }

}
