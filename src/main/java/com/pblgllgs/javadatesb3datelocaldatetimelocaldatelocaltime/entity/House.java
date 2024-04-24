package com.pblgllgs.javadatesb3datelocaldatetimelocaldatelocaltime.entity;
/*
 *
 * @author pblgl
 * Created on 24-04-2024
 *
 */

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "t_houses")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class House {
    @Id
    @SequenceGenerator(name = "primary_key_seq", sequenceName = "primary_key_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "primary_key_seq")
    @Column(name = "id", updatable = false)
    private Long id;
    private String address;
    @NotNull
    @Column(name = "created_at", nullable = false, updatable = false)
    private String createdAt;
    @Column(name = "updated_at", nullable = false)
    private String updatedAt;

    @PrePersist
    public void beforePersist() {
        setCreatedAt(formatDate(LocalDateTime.now()));
        setUpdatedAt(formatDate(LocalDateTime.now()));
    }

    @PreUpdate
    public void beforeUpdate() {
        setUpdatedAt(formatDate(LocalDateTime.now()));
    }

    private String formatDate(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd hh:mm:ss a");
        return dateTimeFormatter.format(localDateTime);
    }

}
