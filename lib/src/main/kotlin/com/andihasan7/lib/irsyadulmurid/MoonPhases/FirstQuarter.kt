package com.andihasan7.lib.irsyadulmurid.MoonPhases

import kotlin.math.round
import kotlin.math.pow
import kotlin.math.cos
import kotlin.math.sin
import kotlin.mod
import com.andihasan7.lib.irsyadulmurid.round
import com.andihasan7.lib.irsyadulmurid.AwalBulan.TanggalHarpas

class FirstQuarter(val month: Int, val year: Int, timeZone: Number) {
	
    val vrHY = year + (month * 29.53) / 354.3671
    val vrK1 = round((vrHY - 1410) * 12)
    val vrK2 = vrK1 - 0.75
    val vrT = vrK2 / 1200
    // JD diround 3
    val vrJD = (2447740.652 + 29.53058868 * vrK2 + 0.0001178 * vrT.pow(2)).round(3)
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
    val vrMT = vrMT1 + (0.0028 - 0.0004 * cos(Math.toRadians(vrM1)) + 0.0003 * cos(Math.toRadians(vrM1)))
    val vrJDFirstQuarter = (vrJD + 0.5 + vrMT).round(3)
    // Waktu First Quarter Waktu UT Fix
    val vrWT1 = ((vrJDFirstQuarter).mod(1.0) * 24)
    val vrWT1WD = vrWT1 + timeZone.toDouble() // masih diatas 24 jam
    // Waktu First Quarter Waktu Daerah Fix
    val vrWFWD =
    	if (vrWT1WD >= 24) {
        	vrWT1WD - 24
    	} else {
        	vrWT1WD
        }
        
    val t = TanggalHarpas(vrJDFirstQuarter, vrWT1WD)
    val hariFirstInt = t.hari
    val pasaranFirstInt = t.pasaran
    val tanggalFirstInt = t.vrTGLFix
    val bulanFirstInt = t.vrBLNFix
    val tahunFirstInt = t.vrTHN
    
    val hariFirstString = t.hari()
    val pasaranFirstString = t.pasaran()
    val bulanFirstString = t.fnBLNString()
}
