package com.andihasan7.lib.irsyadulmurid.TahwilTarikh

object JenisTahun {
  // fungsi mengecek tahun Hijriyah kabisat/basithoh
  fun checkHijri(year: Int): Boolean {

    val arrayKabisat = arrayOf(2, 5, 7, 10, 13, 15, 18, 21, 24, 26, 29)

    val vrA = (year.toDouble() / 30).toInt()
    val vrB = vrA * 30
    val hasil = year - vrB

    val jenisTahun =
        if (hasil in arrayKabisat) {
          true // kabisat
        } else {
          false // basithoh
        }

    return jenisTahun
  }

  // fungsi mengecek tahun Miladi kabisat/basithoh
  fun checkMiladi(year: Int): Boolean {

    val jenisTahun =
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
          true // kabisat
        } else {
          false // basithoh
        }

    return jenisTahun
  }
}
