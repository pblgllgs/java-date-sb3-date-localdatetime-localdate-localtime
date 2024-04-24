package com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.service.impl;
/*
 *
 * @author pblgl
 * Created on 24-04-2024
 *
 */

import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.dto.DateTimeDetails;
import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.dto.HouseResponse;
import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.dto.HouseRequest;
import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.entity.House;
import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.repository.HouseRepository;
import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.service.HouseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class HouseServiceImpl implements HouseService {

    private final HouseRepository houseRepository;

    @Override
    public HouseResponse createHouse(HouseRequest requestHouse) {
        House house = House.builder()
                .address(requestHouse.address())
                .build();
        House saved = houseRepository.save(house);
        return new HouseResponse(
                saved.getId(),
                saved.getAddress(),
                saved.getCreatedAt(),
                saved.getUpdatedAt()
        );
    }

    @Override
    public HouseResponse findById(Long houseId) {
        House house = houseRepository.findById(houseId).orElseThrow(() -> new RuntimeException("NOT_FOUND"));
        return new HouseResponse(
          house.getId(),
          house.getAddress(),
          house.getCreatedAt(),
          house.getUpdatedAt()
        );
    }

    @Override
    public List<HouseResponse> findAll() {
        return houseRepository.findAll().stream().map(
                house -> new HouseResponse(house.getId(),house.getAddress(),house.getCreatedAt(),house.getUpdatedAt())
        ).toList();
    }

    @Override
    public boolean isDateBefore(Long first, Long second) {
        House house1 = houseRepository.findById(first).orElseThrow(() -> new RuntimeException("NOT_FOUND"));
        House house2 = houseRepository.findById(second).orElseThrow(() -> new RuntimeException("NOT_FOUND"));
        LocalDate date1 = LocalDate.parse(house1.getCreatedAt().substring(0,10).replace("/","-"));
        System.out.println(date1);
        LocalDate date2 = LocalDate.parse(house2.getCreatedAt().substring(0,10).replace("/","-"));
        System.out.println(date2);
        if (date1.isBefore(date2)){
            return true;
        }
        return false;
    }

    @Override
    public boolean isTimeBefore(Long first, Long second) {
        House house1 = houseRepository.findById(first).orElseThrow(() -> new RuntimeException("NOT_FOUND"));
        House house2 = houseRepository.findById(second).orElseThrow(() -> new RuntimeException("NOT_FOUND"));
        LocalTime date1 = LocalTime.parse(house1.getCreatedAt().substring(11,19).replace("/","-"));
        System.out.println(date1);
        LocalTime date2 = LocalTime.parse(house2.getCreatedAt().substring(11,19).replace("/","-"));
        System.out.println(date2);
        if (date1.isBefore(date2)){
            return true;
        }
        return false;
    }

    @Override
    public DateTimeDetails getDateTimeDetails(Long houseId) {
        House house = houseRepository.findById(houseId).orElseThrow(() -> new RuntimeException("NOT_FOUND"));
        LocalDate localDate = LocalDate.parse(house.getCreatedAt().substring(0,10).replace("/","-"));
        return new DateTimeDetails.Builder()
                .day(localDate.getDayOfMonth())
                .month(localDate.getMonth())
                .numberOfMonth(localDate.getMonth().getValue())
                .numberOfDay(localDate.getDayOfWeek().getValue())
                .nameOfDay(localDate.getDayOfWeek().getDisplayName(TextStyle.FULL, new Locale("es", "ES")))
                .year(localDate.getYear())
                .dayOfYear(localDate.getDayOfYear())
                .build();
    }


}
