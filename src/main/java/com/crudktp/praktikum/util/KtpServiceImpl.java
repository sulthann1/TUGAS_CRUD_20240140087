package com.crudktp.praktikum.util;

import com.crudktp.praktikum.dto.KtpDto;
import com.crudktp.praktikum.entity.Ktp;
import com.crudktp.praktikum.mapper.KtpMapper;
import com.crudktp.praktikum.repository.KtpRepository;
import com.crudktp.praktikum.service.KtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KtpServiceImpl implements KtpService {
    @Autowired
    private KtpRepository ktpRepository;

    @Autowired
    private KtpMapper ktpMapper;

    @Override
    public KtpDto createKtp(KtpDto ktpDto) {
        if (ktpRepository.existsByNomorKtp(ktpDto.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        Ktp ktp = ktpMapper.toEntity(ktpDto);
        return ktpMapper.toDto(ktpRepository.save(ktp));
    }

    @Override
    public List<KtpDto> getAllKtp() {
        return ktpRepository.findAll().stream()
                .map(ktpMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public KtpDto getKtpById(Integer id) {
        Ktp ktp = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan"));
        return ktpMapper.toDto(ktp);
    }

    @Override
    public KtpDto updateKtp(Integer id, KtpDto ktpDto) {
        Ktp existing = ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan"));

        if (ktpRepository.existsByNomorKtpAndIdNot(ktpDto.getNomorKtp(), id)) {
            throw new RuntimeException("Nomor KTP sudah digunakan oleh data lain!");
        }

        existing.setNomorKtp(ktpDto.getNomorKtp());
        existing.setNamaLengkap(ktpDto.getNamaLengkap());
        existing.setAlamat(ktpDto.getAlamat());
        existing.setTanggalLahir(ktpDto.getTanggalLahir());
        existing.setJenisKelamin(ktpDto.getJenisKelamin());

        return ktpMapper.toDto(ktpRepository.save(existing));
    }

    @Override
    public void deleteKtp(Integer id) {
        if (!ktpRepository.existsById(id)) {
            throw new RuntimeException("Data KTP tidak ditemukan");
        }
        ktpRepository.deleteById(id);
    }
}



