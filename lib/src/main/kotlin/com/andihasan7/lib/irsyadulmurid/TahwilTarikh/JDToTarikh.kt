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

import com.andihasan7.lib.irsyadulmurid.TahwilTarikh.NumberToString
import kotlin.math.floor

object JDToTarikh {
	
    // fungsi mengubah Julian Day JD ke Tarikh Miladi/Masehi
    fun jdToMiladi(jd: Double): Array<String> {
    	val vrA = jd + 0.5
        val vrB = (vrA).toInt()
        val vrC = vrA - vrB
        val vrD = ((vrB - 1867216.25) / 36524.25).toInt()
        val vrE = vrB + 1 + vrD - ((vrD).toDouble() / 4).toInt()
        val vrF = if (vrB >= 2299161) {
        	vrE
        } else {
        	vrB
        }
        val vrG = vrF + 1524
        val vrH = ((vrG - 122.1) / 365.25).toInt() // nilai tahun
        val vrI = (365.25 * vrH).toInt()
        val vrJ = ((vrG - vrI).toDouble() / 30.6001).toInt()
        val vrK = (vrG - vrI - (30.6001 * vrJ).toInt() + vrC).toInt()
        val krBln =
        	if (vrJ < 13.5) {
            	vrJ - 1
            } else {
            	vrJ - 13
            }
        val bulanS = NumberToString.numberJanuari(krBln)    
        val krThn =
        	if (vrJ < 13.5) {
            	vrH - 4716
            } else {
            	vrH - 4715
            }
        return arrayOf(vrK.toString(), bulanS, krThn.toString())
    }
    
    // fungsi mengubah Julian Day JD ke Tarikh Hijriyah
    fun jdToHijri(jd: Double): Array<String> {
    	
        val vrA = jd - 1948440 + 0.5
        val vrB = vrA + 10632
        val vrC = (floor(((vrB - 1).toDouble() / 10631).toDouble())).toInt()
        val vrD = vrB - 10631 * vrC + 354
        val vrE = ((10985 - vrD).toDouble() / 5316).toInt()
        val vrF = ((50 * vrD).toDouble() / 17719).toInt()
        val vrG = ((vrD).toDouble() / 5670).toInt()
        val vrH = ((43 * vrD).toDouble() / 15238).toInt()
        val vrI = vrE * vrF + vrG * vrH
        val vrJ = ((30 - vrI).toDouble() / 15).toInt()
        val vrK = ((17719 * vrI).toDouble() / 50).toInt()
        val vrL = ((vrI).toDouble() / 16).toInt()
        val vrM = ((15238 * vrI).toDouble() / 43).toInt()
        val vrN = vrD - vrJ * vrK - vrL * vrM + 29
        val vrO = ((24 * vrN).toDouble() / 709).toInt()
        val vrQ = ((709 * vrO).toDouble() / 24).toInt()
        val vrR = (vrN - vrQ).toInt()
        val vrS = 30 * vrC + vrI.toInt() - 30 // tahun
        val vrT = if (vrR == 0) {
        	vrO - 1
        } else {
        	vrO
        } // bulan
        val vrU = ((709 * vrT).toDouble() / 24).toInt()
        val vrV = (vrN - vrU).toInt() // tanggal
        val bulan = NumberToString.numberMuharram(vrT)
        
        
        return arrayOf(vrV.toString(), bulan, vrS.toString())
    }
}
