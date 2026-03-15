package com.crudktp.praktikum.controller;

import com.crudktp.praktikum.dto.KtpDto;
import com.crudktp.praktikum.model.ApiResponse;
import com.crudktp.praktikum.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/ktp")
public class KtpController {
    @Autowired
    private KtpService ktpService;

    @PostMapping
    public ResponseEntity<ApiResponse<KtpDto>> create(@RequestBody KtpDto dto) {
        KtpDto result = ktpService.createKtp(dto);
        return ResponseEntity.ok(new ApiResponse<>("success", "Data berhasil ditambahkan", result));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<KtpDto>>> getAll() {
        List<KtpDto> result = ktpService.getAllKtp();
        return ResponseEntity.ok(new ApiResponse<>("success", "Data berhasil diambil", result));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<KtpDto>> getById(@PathVariable Integer id) {
        KtpDto result = ktpService.getKtpById(id);
        return ResponseEntity.ok(new ApiResponse<>("success", "Data berhasil diambil", result));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<KtpDto>> update(@PathVariable Integer id, @RequestBody KtpDto dto) {
        KtpDto result = ktpService.updateKtp(id, dto);
        return ResponseEntity.ok(new ApiResponse<>("success", "Data berhasil diperbarui", result));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Integer id) {
        ktpService.deleteKtp(id);
        return ResponseEntity.ok(new ApiResponse<>("success", "Data berhasil dihapus", null));
    }
}
