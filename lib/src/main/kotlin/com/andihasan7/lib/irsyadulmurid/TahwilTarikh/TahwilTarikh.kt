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

import com.andihasan7.lib.irsyadulmurid.TahwilTarikh.TarikhToJD
import com.andihasan7.lib.irsyadulmurid.TahwilTarikh.JDToTarikh
import com.andihasan7.lib.irsyadulmurid.TahwilTarikh.NumberToString

class TahwilTarikh {
	
    // fungsi tahwil miladi ke hijriyah
    fun miladiToHijri(date: Int, month: Int, year: Int, hour: Double = 0.0, timeZone: Double = 0.0): Array<String> {
    
    	val vrJD = TarikhToJD.miladiToJD(date, month, year, hour, timeZone)
        val hari = jdToHarpas(vrJD)[0]
        val pasaran = jdToHarpas(vrJD)[1]
        val jdH = JDToTarikh.jdToHijri(vrJD)
        val tanggal = jdH[0]
        val bulan = jdH[1]
        val tahun = jdH[2]
        
        return arrayOf(hari, pasaran, tanggal, bulan, tahun)
    }
    
    // fungsi tahwil hijriyah ke miladi
    fun hijriToMiladi(date: Int, month: Int, year: Int): Array<String> {
    	val vrJD = TarikhToJD.hijriToJD(date, month, year)
        val hari = jdToHarpas(vrJD)[0]
        val pasaran = jdToHarpas(vrJD)[1]
        val jdM = JDToTarikh.jdToMiladi(vrJD)
        val tanggal = jdM[0]
        val bulan = jdM[1]
        val tahun = jdM[2]
        
        return arrayOf(hari, pasaran, tanggal, bulan, tahun)
    }
    
    // fungsi JD ke Harpas
    fun jdToHarpas(jd: Double): Array<String> {
    
    	val vrA = (jd).toInt() + 17
        val vrH = vrA - ((vrA).toDouble() / 7).toInt() * 7
        val hari = NumberToString.numberAhad(vrH)
        val vrP = vrA - ((vrA).toDouble() / 5).toInt() * 5
        val pasaran = NumberToString.numberLegi(vrP)
        
        return arrayOf(hari, pasaran)
    }
}