/*
 * This file is part of lib-hisab-irsyadulmurid.
 *
 * lib-hisab-irsyadulmurid is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * lib-hisab-irsyadulmurid is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with lib-hisab-irsyadulmurid.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

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
