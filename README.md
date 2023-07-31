<p align="center">
  <img src="./img/ic_banner.png" alt="app_banner"/>
</p>

<h2 align="center"><b>Irsyadul Murid</b></h2>
<p align="center">
<b>Library Hisab metode Kitab Irsyadul Murid</b>
<p><br>

<p align="center">
<!-- Latest release -->
<img src="https://img.shields.io/github/v/release/andihasan97/lib-hisab-irsyadulmurid?include_releases&label=latest%20release&style=for-the-badge&color=brightgreen" alt="latest_release"/>
<!-- Github Repo size -->
<img src="https://img.shields.io/github/repo-size/andihasan97/lib-hisab-irsyadulmurid?style=for-the-badge">
<!-- Build with Kotlin -->
<img src="https://img.shields.io/badge/Kotlin-C116E3?&style=for-the-badge&logo=kotlin&logoColor=white" alt="build_with_kotlin">
<!-- License -->
<img src="https://img.shields.io/github/license/andihasan97/lib-hisab-irsyadulmurid?color=blue&style=for-the-badge&color=brightgreen" alt="License">
</p>

## Tentang Kitab Irsyadul Murid

Kitab Irsyadul Murid merupakan kitab karya KH. Ahmad Ghozali Muhammad Fatchulloh terbitan Ponpes Al-Mubarok Lanbulan Madura Jawa Timur, termasuk kitab hisab kontemporer/ modern untuk mengetahui pergerakan/ posisi benda-benda langit sebagai keperluan ibadah umat Islam dengan keakuratan tinggi.
  
## Fitur

- [x] Hisab Awal Waktu Sholat
- [x] Hisab Awal Bulan Hijriyah

## Fitur yang akan datang

- [ ] Tahwil Tarikh
- [ ] Fase-fase Bulan
- [ ] Gerhana Matahari
- [ ] Gerhana Bulan

## Konfigurasi pertama

1. masukkan kode ini ke settings.gradle.kts (root kotlin dsl) di blok ```repositories```
```kotlin.kts
  dependencyResolutionManagement {
    repositories {
      // contoh
      maven {
        url = uri("https://jitpack.io")
      }
    }
  }
```
jika menggunakan groovy dsl
```groovy
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
```
2. masukkan dependensi ke build.gradle.kts (app/build.gradle.kts kotlin dsl)
di blok ```dependencies``` 

```kotlin.kts
implementation("com.github.andihasan97:lib-hisab-irsyadulmurid:$version_release")
```
jika menggunakan groovy dsl
```groovy
implementation 'com.github.andihasan97:lib-hisab-irsyadulmurid:$version_release'
```

## Cara menggunakan

## License

```
Library Irsyadul Murid
Copyright (C) 2023  Andi Hasan Ashari

Library Irsyadul Murid is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Library Irsyadul Murid is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Library Irsyadul Murid.  If not, see <https://www.gnu.org/licenses/>.
```
Laporkan kepada kami jika ada yang melanggar ketentuan Lisensi, baik dengan membuat issues atau menulis surat langsung kepada kami.
