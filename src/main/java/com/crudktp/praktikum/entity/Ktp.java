package com.crudktp.praktikum.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Ktp")
public class Ktp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String nomorKtp;

    @Column(nullable = false)
    private String namaLengkap;

    @Column(nullable = false)
    private String alamat;

    @Column(nullable = false)
    private LocalDate tanggalLahir;

    @Column(nullable = false)
    private String jenisKelamin;
}
