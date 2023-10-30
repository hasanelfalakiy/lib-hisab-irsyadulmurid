package com.andihasan7.lib.irsyadulmurid.MoonPhases

import com.andihasan7.lib.irsyadulmurid.AwalBulan.HisabIjtima
import com.andihasan7.lib.irsyadulmurid.AwalBulan.TanggalHarpas

class NewMoon(val month: Int, val year: Int, timeZone: Number) {

	// penambahan: bulan - 1 agar input untuk bulan saat itu
    val kBln = month.toInt() - 1
    
    // koreksi bulan fix
    val kBlnFix = if (kBln == 0) {
    	12
    } else {
    	kBln
    }
    
    // koreksi tahun
    val kThnFix = if (kBln == 0) {
    	year.toInt() - 1
    } else {
    	year.toInt()
    }

	// JD Ijtima'/NewMoon
    val vrJDNewMoon = HisabIjtima.hisabIjtima(kBlnFix, kThnFix)
    	
    // Waktu NewMoon UT/ GMT
    val vrWN = (vrJDNewMoon).mod(1.0) * 24 // frac(vrNewMoon) x 24
    // Waktu NewMoon sebelum kondisi > 24
    val vrWNwd = vrWN + (timeZone).toDouble()
    // Waktu NewMoon Waktu Daerah Fix
    val vrWNWD =
    	if (vrWNwd >= 24) {
        	vrWNwd - 24
    	} else {
        	vrWNwd
        }
    
    val c = TanggalHarpas(vrJDNewMoon, vrWNwd)
    // hari Int
    val vrHariInt = c.hari
    // pasaran Int
    val vrPasaranInt = c.pasaran
    // TGL FIX
    val vrTGLFix = c.fnTGL()
    // BLN
    val vrBLNFix = c.fnBLN() // Bulan Int
    // Tahun
    val vrTHNFix = c.fnTHN()
	
    // hari string
    val vrHariString = c.hari()
    // pasaran string
    val vrPasaranString = c.pasaran()
    // bulan string
    val vrBulanString = c.fnBLNString()
}
