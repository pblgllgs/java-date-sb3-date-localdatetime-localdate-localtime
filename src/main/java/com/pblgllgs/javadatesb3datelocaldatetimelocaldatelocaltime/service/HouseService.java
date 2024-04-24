package com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.service;
/*
 *
 * @author pblgl
 * Created on 24-04-2024
 *
 */

import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.dto.DateTimeDetails;
import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.dto.HouseResponse;
import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.dto.HouseRequest;

import java.util.List;

public interface HouseService {

    HouseResponse createHouse(HouseRequest requestHouse);

    HouseResponse findById(Long houseId);

    List<HouseResponse> findAll();

    boolean isDateBefore(Long first, Long second);
    boolean isTimeBefore(Long first, Long second);

    DateTimeDetails getDateTimeDetails(Long houseId);
}
