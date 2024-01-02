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
 
package com.andihasan7.lib.irsyadulmurid.AwalBulan

import kotlin.math.sin
import kotlin.math.pow
import kotlin.math.round
import com.andihasan7.lib.irsyadulmurid.round

object HisabIjtima {
    fun hisabIjtima(month: Number, year: Number): Double {
        // HY
        val vrHY =
            year.toDouble() +
                ((month.toDouble() * 29.53) /
                    354.3671)
        // K
        val vrK = round((vrHY - 1410) * 12).toInt()
        // T
        val vrT = vrK.toDouble() / 1200.0
        // JD
        val vrJD = 2447740.652 + 29.53058868 * vrK + 0.0001178 * vrT.pow(2)
        // M
        val vrM =
            (((207.9587074 + 29.10535608 * vrK + -0.0000333 * vrT.pow(2)) / 360.0) * 360).mod(360.0)
        // M'
        val vrM1 =
            (((111.1791307 + 385.81691806 * vrK + 0.0107306 * vrT.pow(2)) / 360.0) * 360).mod(360.0)
        // F
        val vrF =
            (((164.2162296 + 390.67050646 * vrK + -0.0016528 * vrT.pow(2)) / 360.0) * 360).mod(360.0)
        // T1
        val vrT1 = (0.1734 - 0.000393 * vrT) * sin(Math.toRadians(vrM))
        val vrT2 = 0.0021 * sin(Math.toRadians(2 * vrM))
        val vrT3 = -0.4068 * sin(Math.toRadians(vrM1))
        val vrT4 = 0.0161 * sin(Math.toRadians(2 * vrM1))
        val vrT5 = -0.0004 * sin(Math.toRadians(3 * vrM1))
        val vrT6 = 0.0104 * sin(Math.toRadians(2 * vrF))
        val vrT7 = -0.0051 * sin(Math.toRadians(vrM + vrM1))
        val vrT8 = -0.0074 * sin(Math.toRadians(vrM - vrM1))
        val vrT9 = 0.0004 * sin(Math.toRadians(2 * vrF + vrM))
        val vrT10 = -0.0004 * sin(Math.toRadians(2 * vrF - vrM))
        val vrT11 = -0.0006 * sin(Math.toRadians(2 * vrF + vrM1))
        val vrT12 = 0.0010 * sin(Math.toRadians(2 * vrF - vrM1))
        val vrT13 = 0.0005 * sin(Math.toRadians(vrM + 2 * vrM1))
        // MT
        val vrMT =
            vrT1 +
                vrT2 +
                vrT3 +
                vrT4 +
                vrT5 +
                vrT6 +
                vrT7 +
                vrT8 +
                vrT9 +
                vrT10 +
                vrT11 +
                vrT12 +
                vrT13
        // JDI
        val vrJDIjtima = vrJD + 0.5 + vrMT

        return vrJDIjtima
    }
}
