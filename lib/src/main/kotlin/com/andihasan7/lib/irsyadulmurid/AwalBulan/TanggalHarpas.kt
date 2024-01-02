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

import com.andihasan7.lib.irsyadulmurid.TahwilTarikh.NumberToString

class TanggalHarpas(val vrJDIjtima: Double, val vrWIwd: Double) {
	// Z
    val vrZ = if (vrWIwd >= 24) {
    		vrJDIjtima.toInt() + 1
    	} else {
        	vrJDIjtima.toInt()
        }
    // AA
    val vrAA = ((vrZ - 1867216.25) / 36524.25).toInt()
    // A
    val vrA = vrZ + 1 + vrAA - ((vrAA).toDouble() / 4).toInt()
    // A Fix
    val vrAFix = if (vrZ < 2299161) {
    	vrZ
    } else {
    	vrA
    }
    // B
    val vrB = vrAFix + 1524
    // C
    val vrC = ((vrB - 122.1) / 365.25).toInt()
    // D
    val vrD = (365.25 * vrC).toInt()
    // E
    val vrE = ((vrB - vrD).toDouble() / 30.6001).toInt()
    // TGL
    val vrTGLFix = (vrB - vrD - (30.6001 * vrE).toInt()).toInt()
    
    fun fnTGL(): Int = vrTGLFix // Tanggal
    // BLN
    val vrBLN = vrE - 1
    // pengkondisian bulan
    // BLN FIX Int
    val vrBLNFix = 
    	if (vrE < 13.5) {
        	vrE - 1
        } else {
        	vrE - 13
        }
        
    fun fnBLN(): Int = vrBLNFix // Bulan Int
    fun fnBLNString(): String = NumberToString.numberJanuari(vrBLNFix) // Bulan String
    // THN
    val vrTHN =
    	if (vrBLNFix > 2.5) {
        	vrC - 4716
        } else {
        	vrC - 4715
        }
    fun fnTHN(): Int = vrTHN // Tahun
    
    // PA
    val vrPAFix = vrZ + 2
    
    // Hari
    val hari = vrPAFix - ((vrPAFix).toDouble() / 7).toInt() * 7
    fun hari(): String = NumberToString.numberAhad(hari) // Hari
    
    // Pasaran 
    val pasaran = vrPAFix - ((vrPAFix).toDouble() / 5).toInt() * 5
    fun pasaran(): String = NumberToString.numberKliwon(pasaran)
}
