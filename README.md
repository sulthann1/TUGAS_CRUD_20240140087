# Tugas CRUD KTP - Aplikasi Penduduk Berbasis Web

Repositori ini berisi proyek pembuatan aplikasi Sistem Manajemen KTP (Kartu Tanda Penduduk) menggunakan arsitektur pemisahan *Backend* dan *Frontend*. Proyek ini disusun untuk memenuhi tugas praktikum.

**Nama:** Sulthan Awaliya Firmansyah 
**NIM:** 20240140087

---

## 🚀 Teknologi yang Digunakan
* **Backend:** Java, Spring Boot, Spring Data JPA, Hibernate
* **Database:** MySQL
* **Frontend:** HTML5, CSS3 (Modern UI), JavaScript, JQuery (AJAX)
* **Lainnya:** Lombok, REST API API Architecture

---

## 📸 Screenshot Aplikasi


![Tampilan Halaman KTP](![Screenshot 2026-03-15 092759.png](../../Users/Lenovo/OneDrive/%EC%82%AC%EC%A7%84/Screenshots/Screenshot%202026-03-15%20092759.png)


---

## 🛠️ Persiapan dan Cara Menjalankan

### 1. Konfigurasi Database
1. Buka MySQL server Anda.
2. Buat database baru dengan menjalankan *query*:
   ```sql
   CREATE DATABASE spring;
📖 Dokumentasi REST API
API ini berjalan pada http://localhost:8080/ktp dan menerima serta mengirimkan data dalam format application/json.

1. Mengambil Semua Data KTP
Endpoint: GET /ktp

Response Sukses (200 OK):

JSON
{
  "status": "success",
  "message": "Data berhasil diambil",
  "data": [
    {
      "id": 1,
      "nomorKtp": "3273112233445566",
      "namaLengkap": "Budi Santoso",
      "alamat": "Jl. Merdeka No 1",
      "tanggalLahir": "1990-05-20",
      "jenisKelamin": "Laki-laki"
    }
  ]
}
2. Menambah Data KTP Baru
Endpoint: POST /ktp

Request Body:

JSON
{
  "nomorKtp": "3273112233445566",
  "namaLengkap": "Budi Santoso",
  "alamat": "Jl. Merdeka No 1",
  "tanggalLahir": "1990-05-20",
  "jenisKelamin": "Laki-laki"
}
Response Sukses (200 OK): Mengembalikan objek data KTP yang baru dibuat.

Response Gagal (400 Bad Request): Terjadi jika nomor KTP sudah terdaftar di database.

3. Mengambil Satu Data KTP (Berdasarkan ID)
Endpoint: GET /ktp/{id}

Response Sukses (200 OK): Mengembalikan satu objek data KTP yang sesuai dengan ID tersebut.

4. Memperbarui Data KTP
Endpoint: PUT /ktp/{id}

Request Body: Sama seperti metode POST.

Response Sukses (200 OK): Mengembalikan data KTP yang telah diperbarui.

Catatan: Terdapat validasi dari server untuk memastikan NIK yang baru diinput tidak bentrok dengan NIK milik orang lain di database.

5. Menghapus Data KTP
Endpoint: DELETE /ktp/{id}

Response Sukses (200 OK):

JSON
{
  "status": "success",
  "message": "Data berhasil dihapus",
  "data": null
}
