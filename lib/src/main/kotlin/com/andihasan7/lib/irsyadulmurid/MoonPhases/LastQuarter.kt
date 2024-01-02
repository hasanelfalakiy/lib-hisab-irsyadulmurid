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

package com.andihasan7.lib.irsyadulmurid.MoonPhases

import kotlin.math.round
import kotlin.math.pow
import kotlin.math.cos
import kotlin.math.sin
import kotlin.mod
import com.andihasan7.lib.irsyadulmurid.round
import com.andihasan7.lib.irsyadulmurid.AwalBulan.TanggalHarpas

class LastQuarter(val month: Int, val year: Int, timeZone: Number) {

	val vrHY = year + (month * 29.53) / 354.3671
    val vrK1 = round((vrHY - 1410) * 12)
    val vrK2 = vrK1 - 0.25
    val vrT = vrK2 / 1200
    // JD
    val vrJD = 2447740.652 + 29.53058868 * vrK2 + 0.0001178 * vrT.pow(2)
    // fungsi frac digantikan dengan mod
    val vrM = (((207.9587074 + 29.10535608 * vrK2 + -0.0000333 * vrT.pow(2)) / 360) * 360).mod(360.0)
    val vrM1 = (((111.1791307 + 385.81691806 * vrK2 + 0.0107306 * vrT.pow(2)) / 360) * 360).mod(360.0)
    val vrF = (((164.2162296 + 390.67050646 * vrK2 + -0.0016528 * vrT.pow(2)) / 360) * 360).mod(360.0)
    
    val vrT1 = (0.1721 - 0.0004 * vrT) * sin(Math.toRadians(vrM))
    val vrT2 = 0.0021 * sin(Math.toRadians(2 * vrM))
    val vrT3 = -0.6280 * sin(Math.toRadians(vrM1))
    val vrT4 = 0.0089 * sin(Math.toRadians(2 * vrM1))
    val vrT5 = -0.0004 * sin(Math.toRadians(3 * vrM1))
    val vrT6 = 0.0079 * sin(Math.toRadians(2 * vrF))
    val vrT7 = -0.0119 * sin(Math.toRadians(vrM + vrM1))
    val vrT8 = -0.0047 * sin(Math.toRadians(vrM - vrM1))
    val vrT9 = 0.0003 * sin(Math.toRadians(2 * vrF + vrM))
    val vrT10 = -0.0004 * sin(Math.toRadians(2 * vrF - vrM))
    val vrT11 = -0.0006 * sin(Math.toRadians(2 * vrF + vrM1))
    val vrT12 = 0.0021 * sin(Math.toRadians(2 * vrF - vrM1))
    val vrT13 = 0.0003 * sin(Math.toRadians(vrM + 2 * vrM1))
    val vrT14 = 0.0004 * sin(Math.toRadians(vrM - 2 * vrM1))
    val vrT15 = -0.0003 * sin(Math.toRadians(2 * vrM + vrM1))
    val vrMT1 = vrT1 + vrT2 + vrT3 + vrT4 + vrT5 + vrT6 + vrT7 + vrT8 + vrT9 + vrT10 + vrT11 + vrT12 + vrT13 + vrT14 + vrT15
    val vrMT = vrMT1 + (-0.0028 + 0.0004 * cos(Math.toRadians(vrM1)) - 0.0003 * cos(Math.toRadians(vrM1)))
    val vrJDLastQuarter = (vrJD + 0.5 + vrMT).round(3)
    // Waktu Last Quarter Waktu UT Fix
    val vrWLUT = ((vrJDLastQuarter).mod(1.0) * 24)
    val vrWL1WD = vrWLUT + timeZone.toDouble() // masih diatas 24 jam
    // Waktu First Quarter Waktu Daerah Fix
    val vrWLFWD =
    	if (vrWL1WD >= 24) {
        	vrWL1WD - 24
    	} else {
        	vrWL1WD
        }
        
    val t = TanggalHarpas(vrJDLastQuarter, vrWL1WD)
    val hariLastInt = t.hari
    val pasaranLastInt = t.pasaran
    val tanggalLastInt = t.vrTGLFix
    val bulanLastInt = t.vrBLNFix
    val tahunLastInt = t.vrTHN
    
    val hariLastString = t.hari()
    val pasaranLastString = t.pasaran()
    val bulanLastString = t.fnBLNString()
}
