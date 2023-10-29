package com.andihasan7.lib.irsyadulmurid.AwalBulan

import com.andihasan7.lib.irsyadulmurid.TahwilTarikh.NumberToString

class TanggalHarpas(val vrJDIjtima: Double, val vrWIwd: Double) {
	// Z
    val vrZ = vrJDIjtima.toInt()
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
    val vrTGL = (vrB - vrD - (30.6001 * vrE).toInt()).toInt()
    // jika Ijtima > 24 maka hari berikutnya 
    // TGL FIX
    val vrTGLFix = 
    	if (vrWIwd > 24) {
    		vrTGL + 1
    	} else {
        	vrTGL
        }
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
    val vrPA = vrZ + 2
    // PA FIX
    val vrPAFix = 
    	if (vrWIwd > 24) {
        	vrPA + 1
        } else {
        	vrPA
        }
    // Hari
    val hari = vrPAFix - ((vrPAFix).toDouble() / 7).toInt() * 7
    fun hari(): String = NumberToString.numberAhad(hari) // Hari
    
    // Pasaran 
    val pasaran = vrPAFix - ((vrPAFix).toDouble() / 5).toInt() * 5
    fun pasaran(): String = NumberToString.numberKliwon(pasaran)
}
