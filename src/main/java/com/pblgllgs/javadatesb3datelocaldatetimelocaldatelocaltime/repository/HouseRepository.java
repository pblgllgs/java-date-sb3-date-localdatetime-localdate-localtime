package com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.repository;
/*
 *
 * @author pblgl
 * Created on 24-04-2024
 *
 */

import com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HouseRepository extends JpaRepository<House,Long> {
}
