# Laporan Tugas - Manajemen Data KTP (REST API & AJAX)

Repositori ini berisi hasil pengerjaan tugas untuk membangun aplikasi CRUD (Create, Read, Update, Delete) Sistem Manajemen KTP. Proyek ini memisahkan sisi **backend** menggunakan arsitektur REST API (Spring Boot) dan sisi **frontend** menggunakan antarmuka HTML/CSS Modern yang dihubungkan secara asinkron melalui JQuery AJAX.

### 👤 Identitas
* **Nama:** Sulthan Awaliya Firmansyah
* **NIM:** 20240140087
* **Program Studi:** Teknologi Informasi
* **Universitas:** Universitas Muhammadiyah Yogyakarta

---

## 📸 Preview Aplikasi
*(Ganti tulisan ini dengan men-drag and drop gambar screenshot website KTP-mu saat mengedit di GitHub)*
---

## 🛠️ Teknologi yang Digunakan

**Backend (Spring Boot):**
* Java 17 / 21
* Spring Boot 3.x
* **Dependencies:**
  * **Spring Web:** Membangun RESTful API.
  * **Spring Data JPA:** Interaksi dan manipulasi data di database.
  * **MySQL Driver:** Konektor ke database MySQL.
  * **Lombok:** Mengurangi *boilerplate code* (getter, setter, constructor otomatis).

**Frontend:**
* **HTML5 & CSS3:** Membangun struktur dan antarmuka web modern bergaya *Card* dan *Toast Notification*.
* **jQuery 3.6.0:** Manipulasi DOM dan eksekusi HTTP Requests (AJAX) tanpa *refresh* halaman.

---

## 📂 Struktur Direktori

Arsitektur backend menerapkan *Layered Pattern* untuk memisahkan tanggung jawab setiap komponen dengan rapi:

* `controller/`: Menerima *request* HTTP dari *client* (Frontend) dan mengembalikan *response* berformat JSON (`ApiResponse`).
* `entity/`: Kelas Java (`Ktp.java`) yang merepresentasikan struktur tabel di dalam database.
* `dto/`: Data Transfer Object (`KtpDto.java`) untuk membatasi dan mentransfer data antara *client* dan *server*.
* `repository/`: Antarmuka komunikasi langsung dengan database menggunakan Spring Data JPA (`KtpRepository.java`). Termasuk *custom query* untuk validasi nomor KTP.
* `service/`: Antarmuka yang mendefinisikan kerangka logika bisnis aplikasi (`KtpService.java`).
* `impl/`: Implementasi detail dari antarmuka logika bisnis (`KtpServiceImpl.java`), memuat proses validasi dan manipulasi sebelum masuk ke database.
* `mapper/`: Kelas utilitas (`KtpMapper.java`) untuk melakukan konversi/pemetaan data antara `Entity` dan `DTO` secara manual agar terkontrol.
* `util/`: Kelas bantuan seperti `GlobalExceptionHandler.java` untuk menangkap dan mengelola *error runtime* secara terpusat.

---
## 📖 Dokumentasi REST API

Semua endpoint berjalan di `http://localhost:8080/ktp` dan menggunakan format komunikasi `application/json`. Sistem ini menggunakan standar balikan (response) seragam yang terdiri dari `status`, `message`, dan `data`.

### 1. Mengambil Seluruh Data KTP
Mengambil daftar semua data penduduk yang ada di dalam database.
* **Method:** `GET`
* **Endpoint:** `/ktp`
* **Response Sukses (200 OK):**
  ```json
  {
    "status": "success",
    "message": "Data berhasil diambil",
    "data": [
      {
        "id": 1,
        "nomorKtp": "3273112233445566",
        "namaLengkap": "Sulthan Awaliya",
        "alamat": "Jl. Brawijaya No 10, Bantul",
        "tanggalLahir": "2000-08-15",
        "jenisKelamin": "Laki-laki"
      }
    ]
  }

## 🚀 Panduan Menjalankan Aplikasi

### 1. Konfigurasi Database
1. Pastikan server MySQL lokal (XAMPP/MySQL Workbench/DBeaver) dalam keadaan aktif.
2. Buat database baru dengan nama `spring` melalui query: `CREATE DATABASE spring;`
3. Pastikan konfigurasi pada `src/main/resources/application.properties` sudah sesuai dengan kredensial lokal Anda:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/spring?useSSL=false&serverTimezone=UTC
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.show-sql=true
