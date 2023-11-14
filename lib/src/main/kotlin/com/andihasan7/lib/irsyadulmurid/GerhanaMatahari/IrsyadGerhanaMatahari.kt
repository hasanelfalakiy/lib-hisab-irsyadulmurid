package com.andihasan7.lib.irsyadulmurid.GerhanaMatahari

import kotlin.math.abs
import kotlin.math.atan
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.sin
import kotlin.math.sqrt
import com.andihasan7.lib.irsyadulmurid.round
import com.andihasan7.lib.irsyadulmurid.AwalBulan.TanggalHarpas


class IrsyadGerhanaMatahari(val month: Int, val year: Int, val timeZone: Number) {

	val vrHY = (year + (month * 29.53) / 354.3671).round(3)
    val vrK = ((vrHY - 1410) * 12).round(0)
    val vrT = vrK / 1200
    val vrF = (164.2162296 + 390.67050646 * vrK + -0.0016528 * (vrT).pow(2)).mod(360.0)
    // vrF Int
    val vrFInt = (vrF).toInt()
    // status terjadi gerhana matahari/tidaknya
    val statusGM = when(vrFInt) {
    	in 0..20 -> true
        in 160..200 -> true
        in 340..360 -> true
        else -> false
    }
    val vrJD = 2447740.652 + 29.53058868 * vrK
    val vrM = (207.9587074 + 29.10535608 * vrK + -0.0000333 * (vrT).pow(2)).mod(360.0)
    val vrM1 = (111.1791307 + 385.81691806 * vrK + 0.0107306 * (vrT).pow(2)).mod(360.0)
    val vrT1 = (0.1734 - 0.000393 * vrT) * sin(Math.toRadians(vrM))
    val vrT2 = 0.0021 * sin(Math.toRadians(2 * vrM))
    val vrT3 = -0.4068 * sin(Math.toRadians(vrM1))
    val vrT4 = 0.0161 * sin(Math.toRadians(2 * vrM1))
    val vrT5 = -0.0051 * sin(Math.toRadians(vrM + vrM1))
    val vrT6 = -0.0074 * sin(Math.toRadians(vrM - vrM1))
    val vrT7 = -0.0104 * sin(Math.toRadians(2 * vrF))
    val vrMT = vrT1 + vrT2 + vrT3 + vrT4 + vrT5 + vrT6 + vrT7
    val vrJDIjtima = vrJD + 0.5 + vrMT
    // vrT0 = tengah gerhana UT
    val vrT0 = (vrJDIjtima - (vrJDIjtima).toInt()).round(3) * 24
    val vrT0bef = vrT0 + (timeZone).toDouble() // jam WD sebelum - 24
    val vrT0wd = (vrT0bef).mod(24.0)
    
    val c = TanggalHarpas(vrJDIjtima, vrT0bef)
    // Hari Int
    val hariIntGM = c.hari
    // Pasaran Int
    val pasaranIntGM = c.pasaran
    // Hari String
    val hariStringGM = c.hari()
    // Pasaran String
    val pasaranStringGM = c.pasaran()
    // Tanggal Int
    val tanggalIntGM = c.fnTGL()
    // Bulan Int
    val bulanIntGM = c.fnBLN() // Bulan Int
    // Bulan String
    val bulanStringGM = c.fnBLNString() // Bulan String
    // Tahun Int
    val tahunIntGM = c.fnTHN()
    
    val vrS1 = -0.0048 * cos(Math.toRadians(vrM))
    val vrS2 = 0.002 * cos(Math.toRadians(2 * vrM))
    val vrS3 = -0.3283 * cos(Math.toRadians(vrM1))
    val vrS4 = -0.006 * cos(Math.toRadians(vrM + vrM1))
    val vrS5 = 0.0041 * cos(Math.toRadians(vrM - vrM1))
    val vrS = 5.19595 + vrS1 + vrS2 + vrS3 + vrS4 + vrS5
    
    val vrC1 = 0.0024 * sin(Math.toRadians(2 * vrM))
    val vrC2 = -0.039 * sin(Math.toRadians(vrM1))
    val vrC3 = 0.0115 * sin(Math.toRadians(2 * vrM1))
    val vrC4 = -0.0073 * sin(Math.toRadians(vrM + vrM1))
    val vrC5 = -0.0067 * sin(Math.toRadians(vrM - vrM1))
    val vrC6 = 0.0117 * sin(Math.toRadians(2 * vrF))
    val vrCC = 0.207 * sin(Math.toRadians(vrM)) + vrC1 + vrC2 + vrC3 + vrC4 + vrC5 + vrC6
    // azGM/gamma, arah gerhana matahari, jika positif = utara, negatif = selatan
    val azGM = vrS * sin(Math.toRadians(vrF)) + vrCC * cos(Math.toRadians(vrF))
    // arah gerhana matahari string
    val azGMString = if (azGM > 0) {
    	"Utara"
    } else {
    	"Selatan"
    }
    val vrU = 0.0059 + 0.0046 * cos(Math.toRadians(vrM)) - 0.0182 * cos(Math.toRadians(vrM1)) + 0.0004 * cos(Math.toRadians(2 * vrM1)) - 0.0005 * cos(Math.toRadians(vrM + vrM1))
    // jenis gerhana matahari
    val sbg = if (abs(azGM) + vrU > 0.9972 && abs(azGM) + vrU < 1.54332) {
    	true
    } else {
    	false
    }
    // sebaiknya diberi kondisi sesuai status kemungkinan gerhana pada variabel statusGM
    val jnsGM =
    	when {
        	sbg == true -> "Sebagian/Partial"
            vrU > 0.0047 -> "Cincin/Annular"
            vrU < 0 -> "Total"
            vrU > 0 && vrU < 0.0047 -> "Hybrid"
            else -> "Tidak ada Gerhana Matahari"
        }
    // yang dipakai jenisGM    
    val jenisGM =  if (statusGM == true) {
    	jnsGM
    } else {
    	"Tidak ada Gerhana Matahari"
    }
    val vrP = 1 + vrU + 0.5460
    val vrQ = 1 + vrU
    val vrN = 0.5458 + 0.0400 * cos(Math.toRadians(vrM1))
    // T1, lama gerhana
    val vrt1 = if (statusGM == true) {
    	60.0 / vrN * sqrt((vrP).pow(2) - (azGM).pow(2)) / 60
    } else {
    	00.0
    }
    // T2, lama total
    val vrt2 = if (sbg == false && statusGM == true) {
    	60.0 / vrN * sqrt((vrQ).pow(2) - (azGM).pow(2)) / 60
    } else {
    	00.0
    }
    
    // W1, awal gerhana UT
    val awalGMUT = if (statusGM == true) {
    	(vrT0 - vrt1).mod(24.0)
    } else {
    	00.0
    }
    // W2, awal total
    val awalTotalGMUT = if (sbg == false && statusGM == true) {
    	(vrT0 - vrt2).mod(24.0)
    } else {
    	00.0
    }
    // T0, tengah gerhana
    val tengahGMUT = if (statusGM == true) {
    	vrT0
    } else {
    	00.0
    }
    // W4, akhir total
    val akhirTotalGMUT = if (sbg == false && statusGM == true) {
    	(vrT0 + vrt2).mod(24.0)
    } else {
    	00.0
    }
    // W5, akhir gerhana
    val akhirGMUT = if (statusGM == true) {
    	(vrT0 + vrt1).mod(24.0)
    } else {
    	00.0
    }
    
    // W1, awal gerhana WD
    val awalGMWD = if (statusGM == true) {
    	(vrT0wd - vrt1).mod(24.0)
    } else {
    	00.0
    }
    // W2, awal total
    val awalTotalGMWD = if (sbg == false && statusGM == true) {
    	(vrT0wd - vrt2).mod(24.0)
    } else {
    	00.0
    }
    // T0, tengah gerhana
    val tengahGMWD = if (statusGM == true) {
    	vrT0wd
    } else {
    	00.0
    }
    // W4, akhir total
    val akhirTotalGMWD = if (sbg == false && statusGM == true) {
    	(vrT0wd + vrt2).mod(24.0)
    } else {
    	00.0
    }
    // W5, akhir gerhana
    val akhirGMWD = if (statusGM == true) {
    	(vrT0wd + vrt1).mod(24.0)
    } else {
    	00.0
    }
    
    // jika gerhana sebagian, maka mag ini yang dipakai
    val vrMag = (1.5432 + vrU - abs(azGM)) / (0.546 + 2 * vrU)
    val vrTT = (vrJDIjtima - 2415020) / 36525
    val vrX = (296.104608 + 477198.8491 * vrTT + 0.009192 * (vrTT).pow(2) + 0.0000144 * (vrTT).pow(3)).mod(360.0)
    val vrDD = (356.737486 + 445267.1142 * vrTT + (-0.001436) * (vrTT).pow(2) + 0.0000019 * (vrTT).pow(3)).mod(360.0)
    val vrZZ = (358.475833 + 35999.0498 * vrTT - 0.00015 * (vrTT).pow(2) - 0.0000033 * (vrTT).pow(3)).mod(360.0)
    val vrEE = 0.01675104 - 0.0000418 * vrTT - 0.000000126 * (vrTT).pow(2)
    val enom = Math.toDegrees(atan(sin(Math.toRadians(vrZZ)) / cos(Math.toRadians(vrZZ)) - vrEE))
    // Enom final
    val enomFinal =
    	when {
        	vrZZ < 91 -> enom
            vrZZ > 270 -> enom + 360 // chek dikitab, ada kemungkinan pakai sama atau lebih dari >=
            else -> enom + 180
        }
    val vrRR = 1.0000002 * (1 - vrEE * cos(Math.toRadians(enomFinal)))
    val vrsds = (959.63 / 3600) / vrRR
    val vrPM = 0.950724 + 0.051818 * cos(Math.toRadians(vrX)) + 0.009531 * cos(Math.toRadians(2 * vrDD - vrX)) + 0.007843 * cos(Math.toRadians(2 * vrDD)) + 0.002824 * cos(Math.toRadians(2 * vrX)) + 0.000857 * cos(Math.toRadians(2 * vrDD + vrX))
    val vrsdm = 0.272476 * vrPM
    val mag = vrsdm / vrsds
    
    // vrMag Final
    val magnitudeGM = if (sbg == true && statusGM == true) {
    	(vrMag).round(4)
    } else if (sbg == false && statusGM == true){
        (mag).round(4)
    } else {
    	00.0
    }
    
    // gamma
    val gammaGM = azGM
    // arah gerhana
    val arahGerhanaGM = azGMString
    // lama gerhana
    val lamaGerhanaGM = vrt1 * 2
    // lama total
    val lamaTotalGM = vrt2 * 2
}
