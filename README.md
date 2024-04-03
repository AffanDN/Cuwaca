### Project Android : Cuwaca
<h1 align="center">CUWACA</h1>

## Tech Stack & Open-source Libraries

### Android

- [Package]
    - base: berisikan file BaseFragment yang dimana kita dapat membuat fragment lain dengan mudah dengan meng-extend kelas ini
    - data:
      - model: definisi dari respons JSON yang diharapkan dari API cuaca
      - remote: berisikan interface dan implementasi dari setiap API yang digunakan
      - WeatherService.kt: berisikan untuk meng-GET link-link dari API yang kita gunakan
    - di: berisikan modul-modul yang digunakan bagian dari konfigurasi Dependency Injection (DI) menggunakan Dagger Hilt dalam proyek Android
    - presentation:
      - detail_screen: menampilkan tampilan detail cuaca
        - view: berisikan fragment serta fungsi-fungsi untuk menampilkan data cuaca
        - viewmodel: berfungsi untuk mendapatkan data cuaca dari sehingga berbentuk list
      - home_screen: tampilan home
        - adapter: membuat fungsi untuk mendapatkan data yang ditampilkan oleh recycle view
        - view: berisikan fragment serta fungsi-fungsi untuk menampilkan data cuaca
        - viewmodel: berfungsi untuk mendapatkan data cuaca dari sehingga berbentuk list
      - splash_screen: tampilan awal yang berbentuk splash
      - util: berisi file-file untuk membantu utilitas pada activity / fragment
- [Retrofit]: Constructs the REST APIs.
- [Glide]: Image loading library for displaying network images.

### API
- Public API from [The openweathermap](https://api.openweathermap.org)

### Features

- **Get Started**
  - Tampilan awal yang simpel dengan button untuk pada saat aplikasi dijalankan

- **Home**
  - Menampilkan beberapa detail cuaca saat ini seperti kota, icon cuaca, cuaca, temprature. kelembapan, kecepatan angin
  - Menampilkan detail cuaca sesuai dengan 3 jam kedepan (Hourly)

- **Detail**
  - Menampilkan secara lengkap detail cuaca saat ini

- **Demo**

https://github.com/AffanDN/Cuwaca/assets/101490380/52efda88-549c-49f5-be92-d8a7066efb13

