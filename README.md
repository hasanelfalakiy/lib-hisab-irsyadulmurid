<p align="center">
  <img src="./img/ic_banner.png" alt="app_banner"/>
</p>

<h2 align="center"><b>Irsyadul Murid</b></h2>
<p align="center">
<b>Library Hisab metode Kitab Irsyadul Murid</b>
<p><br>

<p align="center">
<!-- Latest release -->
<img src="https://img.shields.io/github/v/release/hasanelfalakiy/lib-hisab-irsyadulmurid?include_releases&label=latest%20release&style=for-the-badge&color=brightgreen" alt="latest_release"/>
<!-- Jitpack release -->
<img src="https://img.shields.io/jitpack/v/hasanelfalakiy/lib-hisab-irsyadulmurid.svg?style=for-the-badge&color=brightgreen" alt="jitpack_release">
<!-- Github Repo size -->
<img src="https://img.shields.io/github/repo-size/hasanelfalakiy/lib-hisab-irsyadulmurid?style=for-the-badge">
<!-- Build with Kotlin -->
<img src="https://img.shields.io/badge/Kotlin-C116E3?&style=for-the-badge&logo=kotlin&logoColor=white" alt="build_with_kotlin">
<!-- License -->
<img src="https://img.shields.io/github/license/hasanelfalakiy/lib-hisab-irsyadulmurid?color=blue&style=for-the-badge&color=brightgreen" alt="License">
</p>

## Tentang Kitab Irsyadul Murid

Kitab Irsyadul Murid merupakan kitab karya KH. Ahmad Ghozali Muhammad Fatchulloh terbitan Ponpes Al-Mubarok Lanbulan Madura Jawa Timur, termasuk kitab hisab kontemporer/modern untuk mengetahui pergerakan/posisi benda-benda langit sebagai keperluan ibadah umat Islam dengan keakuratan tinggi.

## Perhatian!

Saya menyadari program yang saya tulis ini masih banyak kekurangan, kiranya para ahli mau mengoreksi dan para pelajar yang ingin mempelajari dipersilakan.

## Note

- Tinggi tempat diatur ke 0 m (bagian dip), jika terdeteksi dibawah 0 (minus).
- Dalam kondisi tertentu khusus Rashdul qiblat tidak bisa menghitung alias bernilai NaN.

## Fitur

- [x] Fase-fase Bulan
- [x] Gerhana Bulan
- [x] Gerhana Matahari
- [x] Hisab Awal Waktu Sholat
- [x] Hisab Awal Bulan Hijriyah
- [x] Tahwil Tarikh
- [x] Umum

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
implementation("com.github.hasanelfalakiy:lib-hisab-irsyadulmurid:5.0.7")
```
jika menggunakan groovy dsl
```groovy
implementation 'com.github.hasanelfalakiy:lib-hisab-irsyadulmurid:5.0.7'
```
## Tutorial Youtube
Praktik implementasi library hisab irsyadul murid

- Part 1 [Membuat layout](https://youtu.be/UXJz_lqkXwk)
- Part 2 [Implementasi library](https://youtu.be/LefWCSdcV8s)
- Part 3 [Implementasi library](https://youtu.be/AxQ_ATx0imk)

## Cara menggunakan

Sebagian besar nilai kembalian nya berupa Double, untuk merubah ke format derajat menit detik (DMS)/ jam menit detik (HMS) silahkan gunakan library konversi yang sudah saya buat disini : https://github.com/hasanelfalakiy/lib-konversi

1. Hisab Waktu Sholat
```kotlin.kt
/* input nilai dimasukkan ke constructor class,
tanggal bulan tahun masehi,
zona waktu & tinggi tempat bisa integer/double
*/
class IrsyadSholat(
    val date: Int,
    val month: Int,
    val year: Int,
    val latitude: Double,
    val longitude: Double,
    val timeZone: Number,
    val elevation: Number,
    val ihthiyati: Int
  ) {}

// buat objek class
val s = IrsyadSholat(date, month, year, latitude, longitude, timeZone, elevation, ihthiyati)

// panggil function yang ada diclass IrsyadSholat()
val imsak = s.imsak() // Double waktu sholat imsak
// dan seterusnya

// daftar function di class IrsyadSholat()
// Imsak WD
fun imsak(): Double
    
// Shubuh WD
fun shubuh(): Double
    
// Thulu' WD
fun thulu(): Double
    
// Dluha WD
fun dluha(): Double
    
// Dzuhur WD
fun dzuhur(): Double
    
// Ashar WD
fun ashar(): Double
    
// Maghrib WD
fun maghrib(): Double
    
// Isya' WD
fun isya(): Double
    
// Tengah Malam WD
fun tengahMalam(): Double

// 2/3 Malam WD
fun duaPer3MalamWD(): Double
	
// fungsi getDeklinasi
fun deklinasi(): Double
	
// fungsi getEquationOfTime
fun equationOfTime(): Double
    
// fungsi semidiameter
fun semiDiameter(): Double
	
// fungsi Arah Qiblat B-U/B-S
fun qiblat(): Double
	
// fungsi Arah Qiblat UTSB
fun qiblatUTSB(): Double
	
// fungsi Rashdul Qiblat 1
fun rashdu1(): Double
	
// fungsi Rashdul Qiblat 2
fun rashdu2(): Double
    
// Selisih Jam antara Markaz ~ Makkah
fun selisihJam(): Double
    
// Jarak antara Markaz ~ Makkah (kilometer)
fun jarakKeduanya(): Double
    
// selisih deklinasi dengan Lintang Ka'bah
fun selisihLintangK(): Double
    
// selisih deklinasi dengan Lintang Tempat
fun selisihLintangT(): Double

```

2. Hisab Awal Bulan Hijriyah

```kotlin.kt

// input nilai (bulan, tahun hijriyah dll) dimasukkan ke constructor class

class IrsyadBulan(
    val month: Number,
    val year: Number,
    val latitude: Double,
    val longitude: Double,
    val timeZone: Number,
    val elevation: Number,
    val check: Boolean) {}

// buat objek class
val b = IrsyadBulan(month, year, latitude, longitude, timeZone, elevation, check) // check : jika true maka hari ijtima', jika false maka sehari setelah ijtima'

/*
Perhatian! Jika menghitung sehari setelah Ijtima' maka Hari Pasaran Tanggal Bulan Tahun Maghrib dll akan menyesuaikan penambahan hari, sementara jam Ijtima tetap
*/

// panggil function yang ada diclass IrsyadBulan()
val jdIjtima = b.jdIjtima() // Double jam ijtima
// dan seterusnya

/*
daftar function di class IrsyadBulan()
*/

// Prediksi awal bulan
fun awalBulanPrediksi(): String
// JD Ijtima
fun jdIjtima(): Double
// Ijtima UT/ GMT
fun ijtimaUT(): Double
// Ijtima Waktu Daerah (WIB, WIT, WITA, dll)
fun ijtimaWD(): Double
// Tanggal
fun tanggal(): Int
// Bulan String
fun bulanString(): String
// Tahun
fun tahun(): Int
// Hari
fun hari(): String
// Pasaran 
fun pasaran(): String
    
// Maghrib terkoreksi
fun maghribFinal(): Double
// Azimuth Matahari, jika positif utara titik barat, jika negative selatan titik barat, dihitung dari titik barat
fun azimuthMatahari(): Double
// Azimuth Matahari UTSB
fun azimuthMatahariUTSB(): Double

// Tinggi Hilal Hakiki
fun tinggiHakiki(): Double
// Tinggi Hilal Mar'i upper
fun tinggiUpper(): Double
// Tinggi Hilal Mar'i center
fun tinggiCenter(): Double
// Tinggi Hilal Mar'i lower
fun tinggiLower(): Double
// Azimuth Hilal, jika positif utara titik barat, jika negative selatan titik barat, dihitung dari titik barat
fun azimuthHilal(): Double
// Azimuth Hilal UTSB
fun azimuthHilalUTSB(): Double
// Posisi Hilal, jika positif utara matahari, jika negative selatan matahari
fun posisiHilal(): Double
// Posisi Hilal String
fun posisiHilalString(): String
// Muktsul Hilal/lama Hilal (HMS)
fun lamaHilal(): Double
// Elongasi
fun elongasi(): Double
// Nurul Hilal
fun nurulHilal(): Double
// Ghurub Hilal
fun ghurubHilal(): Double
// Samkul Hilal
fun samkulHilal(): Double
// Umur Hilal
fun umurHilal(): Double
    
    
// Deklinasi Matahari
fun deklinasiMatahari(): Double
// Equation of Time Matahari
fun equationMatahari(): Double
// Semidiameter Matahari
fun semidiameterMatahari(): Double
// Deklinasi Bulan
fun deklinasiBulan(): Double
// Semidiameter Bulan
fun semidiameterBulan(): Double
// RightAscension Matahari 
fun ascensionRectaMatahari(): Double
// RightAscension Bulan 
fun ascensionRectaBulan(): Double
// True Distance Obliquity AU
fun trueDistanceAU(): Double
// True Distance Obliquity KM
fun trueDistanceKM(): Double

```

3. Tahwil Tarikh

```kotlin.kt

// Miladi/Masehi ke Hijriyah
// Jika tidak ingin input Jam & TimeZone, masukkan saja tanggal, bulan, tahun
val mTH = TahwilTarikh().miladiToHijri(date: Int, month: Int, year: Int, hour: Double = 0.0, timeZone: Double = 0.0): Array<String>
mTH[0] // String Hari
mTH[1] // String Pasaran
mTH[2] // String Tanggal
mTH[3] // String Bulan
mTH[4] // String Tahun

// Hijriyah ke Miladi/Masehi

val mTH = TahwilTarikh().hijriToMiladi(date: Int, month: Int, year: Int): Array<String>
mTH[0] // String Hari
mTH[1] // String Pasaran
mTH[2] // String Tanggal
mTH[3] // String Bulan
mTH[4] // String Tahun

// Anda juga bisa menggunakan methode yang lain
// Miladi ke Julian Day (JD)
// masukkan saja tanggal, bulan, tahun jika tidak ingin input jam & timezone
val mTJ = TarikhToJD.miladiToJD(date: Int, month: Int, year: Int, hour: Double = 0.0, timeZone: Double = 0.0): Double
mTJ // Double Julian Day

// Hijri ke Julian Day (JD)
val hTJ = TarikhToJD.hijriToJD(date: Int, month: Int, year: Int): Double
hTJ // Double Julian Day

// Julian Day ke Miladi/Masehi
val jTM = JDToTarikh.jdToMiladi(jd: Double): Array<String>
jTM[0] // String Tanggal
jTM[1] // String Bulan
jTM[2] // String Tahun

// Julian Day ke Hijriyah
val jTH = JDToTarikh.jdToHijri(jd: Double): Array<String>
jTH[0] // String Tanggal
jTH[1] // String Bulan
jTH[2] // String Tahun

// Julian Day ke Hari & Pasaran
val harpas = TahwilTarikh().jdToHarpas(jd: Double): Array<String>
harpas[0] // String Hari
harpas[1] // String Pasaran

```
4. Umum
```kotlin.kt

// menghitung hari selamatan orang meninggal
// perhitungan ini tidak berdasarkan visibilitas hilal

val jdMng = Umum.selamatan(jd: Double) DoubleArray // menggunakan julian day masehi ke hijriyah

// output dalam bentuk julianday, lalu ubah ke tarikh/hari pasaran, tanggal bulan tahun
val hariMeninggal = jdMng[0] // sama nilai input
val pendhak7 = jdMng[1] // 7 hari setelah meninggal 
val pendhak40 = jdMng[2] // 40 hari
val pendhak100 = jdMng[3] // 100 hari
val pendhakPisan = jdMng[4] // Satu tahun dalam hijriyah
val pendhakPindho = jdMng[5] // Dua tahun dalam hijriyah
val pendhakSewu = jdMng[6] // 1000 hari

```
5. Fase-fase bulan/Moon Phases
```kotlin.kt

// Contoh penggunaan

/*
    New Moon/Ijtima'
    semua fase input bulan & tahun hijriyah, zona waktu bisa integer/double
*/
val bulan = 9
val tahun = 1445
val timeZone = 7
    
val n = MoonPhases(bulan, tahun, timeZone)
val newMoonUT = n.doubleNewMoonUT // jam UT, tipe Double
val newMoonWD = n.doubleNewMoonWD // jam lokal/waktu daerah, tipe Double
        
val hari = n.intHariNewMoon // hari Int dihitung dari Ahad/Minggu
val pasaran = n.intPasaranNewMoon // pasaran Int dihitung dari Kliwon
val tanggal = n.intTanggalNewMoon // Int
val bulan = n.intBulanNewMoon // Int
val tahun = n.intTahunNewMoon // Int
val hariString = n.stringHariNewMoon // String
val pasaranString = n.stringPasaranNewMoon // String
val bulanString = n.stringBulanNewMoon // String

/*
    First Quarter/Tarbi' Awwal
*/
// Jam First Quarter UT double
n.doubleFirstUT
// Jam First Quarter Waktu Daerah
n.doubleFirstWD
    
// hari Int
n.intHariFirst
// pasaran Int
n.intPasaranFirst
// tanggal Int
n.intTanggalFirst
// bulan Int
n.intBulanFirst
// tahun Int
n.intTahunFirst
	
// hari string
n.stringHariFirst
// pasaran string
n.stringPasaranFirst
// bulan string
n.stringBulanFirst

/*
    Full Moon/Istiqbal
*/
// Jam Full Moon UT double
n.doubleFullUT
// Jam Full Moon Waktu Daerah
n.doubleFullWD
    
// hari Int
n.intHariFull
// pasaran Int
n.intPasaranFull
// tanggal Int
n.intTanggalFull
// bulan Int
n.intBulanFull
// tahun Int
n.intTahunFull
	
// hari string
n.stringHariFull
// pasaran string
n.stringPasaranFull
// bulan string
n.stringBulanFull

/*
    Last Moon/Tarbi' Tsani
*/
// Jam Last Moon UT double
n.doubleLastUT
// Jam Last Moon Waktu Daerah
n.doubleLastWD
    
// hari Int
n.intHariLast
// pasaran Int
n.intPasaranLast
// tanggal Int
n.intTanggalLast
// bulan Int
n.intBulanLast
// tahun Int
n.intTahunLast
	
// hari string
n.stringHariLast
// pasaran string
n.stringPasaranLast
// bulan string
n.stringBulanLast

```
6. Gerhana Bulan
```kotlin.kt

// Input bulan & tahun hijriyah, zona waktu bisa integer/double
val b = IrsyadGerhanaBulan(bulan: Int, tahun: Int, timeZone: Number)

// Hari Int
b.hariInt
// Pasaran Int
b.pasaranInt
// Hari String
b.hariString
// Pasaran String
b.pasaranString
// Tanggal Int
b.tanggalInt
// Bulan Int
b.bulanInt
// Bulan String
b.bulanString
// Tahun Int
b.tahunInt

/*
Status ada kemungkinan gerhana atau tidaknya,
jika true maka kemungkinan gerhana, jika false maka tidak ada gerhana
*/
b.statusGB // true/false
// Jenis gerhana (Total, Sebagian/Partial, Penumbra, & Tidak ada Gerhana Bulan)
b.jenisGerhana

// Jam UT, semua bertipe Double
// awal penumbra
b.awalPenumbraUT
// awal umbra
b.awalUmbraUT
// awal total
b.awalTotalUT
// tengah gerhana
b.tengahGerhanaUT
// akhir total
b.akhirTotalUT
// akhir umbra
b.akhirUmbraUT
// akhir penumbra
b.akhirPenumbraUT


// Jam WD/Waktu Daerah sesuai Zona Waktu
b.awalPenumbraWD
// awal umbra
b.awalUmbraWD
// awal total
b.awalTotalWD
// tengah gerhana
b.tengahGerhanaWD
// akhir total
b.akhirTotalWD
// akhir umbra
b.akhirUmbraWD
// akhir penumbra
b.akhirPenumbraWD

// magnitude penumbra
b.magnitudePenumbra
// magnitude umbra
b.magnitudeUmbra
// magnitude umbra usbu', sebaiknya ubah ke DMS
b.magnitudeUsbu
// durasi penumbra
b.lamaPenumbra
// durasi hakiki/umbra
b.lamaUmbra
// durasi total
b.lamaTotal

```
7. Gerhana Matahari
```kotlin.kt

// Input bulan & tahun hijriyah, zona waktu bisa integer/double
val s = IrsyadGerhanaMatahari(bulan: Int, tahun: Int, timeZone: Number)

// Status gerhana
s.statusGM // true/false, true = terjadi gerhana & false = tidak terjadi gerhana
// Jenis gerhana
s.jenisGM // Total, Sebagian/Partial, Cincin/Annular, Hybrid, dan Tidak ada Gerhana Matahari

// Hari Int
s.hariIntGM
// Pasaran Int
s.pasaranIntGM
// Hari String
s.hariStringGM
// Pasaran String
s.pasaranStringGM
// Tanggal Int
s.tanggalIntGM
// Bulan Int
s.bulanIntGM
// Bulan String
s.bulanStringGM
// Tahun Int
s.tahunIntGM

// Awal gerhana jam UT
s.awalGMUT
// Awal total
s.awalTotalGMUT
// Tengah gerhana
s.tengahGMUT
// Akhir total
s.akhirTotalGMUT
// Akhir gerhana
s.akhirGMUT


// Awal gerhana jam WD (sesuai zona waktu)
s.awalGMWD
// Awal total
s.awalTotalGMWD
// Tengah gerhana
s.tengahGMWD
// Akhir total
s.akhirTotalGMWD
// Akhir gerhana
s.akhirGMWD

// Magnitude gerhana
s.magnitudeGM
// gamma
s.gammaGM
// Arah gerhana
s.arahGerhanaGM
// Lama gerhana
s.lamaGerhanaGM
// Lama gerhana total
s.lamaTotalGM


```

## Ingin berkontribusi?

> Jika Anda ingin berkontribusi, silahkan menggarpu (Fork) repositori ini, buat perubahan, kirim Pull request ke repositori ini

## Kontak Kami

- [Telegram](https://t.me/moonelfalakiy)
- [Grup diskusi Telegram](https://t.me/moonlight_studio01/9)

## License

```
Library Irsyadul Murid

Copyright (C) 2023-2025  Andi Hasan Ashari

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
Report to us if anyone violates the terms of the License, either by creating issues or writing to us directly.
