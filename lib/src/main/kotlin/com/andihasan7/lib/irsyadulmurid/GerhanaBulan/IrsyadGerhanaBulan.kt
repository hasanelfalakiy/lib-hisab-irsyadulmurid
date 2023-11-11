package com.andihasan7.lib.irsyadulmurid.GerhanaBulan

import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.sin
import kotlin.math.sqrt
import kotlin.math.pow
import com.andihasan7.lib.irsyadulmurid.round
import com.andihasan7.lib.irsyadulmurid.AwalBulan.TanggalHarpas

class IrsyadGerhanaBulan(val month: Int, val year: Int, val timeZone: Number) {

	val vrHY = year + (month * 29.53) / 354.3671
    val vrK = ((vrHY - 1410) * 12).round(1) - 0.5
    val vrT = vrK / 1200
    // vrF untuk mengetahui kemungkinan gerhana bulan
    val vrF = (164.2159288 + 390.67050274 * vrK + -0.0016341 * (vrT).pow(2) + -0.00000227 * (vrT).pow(3)).mod(360.0)
    val vrFInt = vrF.toInt()
    /*
    	jika vrFInt diantara 0 ~ 12 atau 168 ~ 192 atau 348 ~ 360, maka mungkin terjadi gerhana bulan
    */
    
    val statusGB =
    	when (vrFInt) {
        	in 0..14 -> true // true = mungkin terjadi gerhana bulan
            in 168..193 -> true
            in 348..360 -> true
            else -> false // false = tidak terjadi gerhana bulan
        }
    val vrJD = 2447740.651689 + 29.530588853 * vrK + 0.0001337 * (vrT).pow(2) - 0.00000015 * (vrT).pow(3) - (2.0 / 1700)
    val vrM = (207.9623868 + 29.10535669 * vrK + -0.0000218 * (vrT).pow(2)).mod(360.0)
    val vrM1 = (111.1797657 + 385.81693528 * vrK + 0.0107438 * (vrT).pow(2) + 0.00001239 * (vrT).pow(3)).mod(360.0)
    val _E = (326.4991207 + -1.5637558 * vrK + 0.0020691 * (vrT).pow(2) + 0.00000215 * (vrT).pow(3)).mod(360.0)
    val vrF1 = (vrF - 0.02665 * sin(Math.toRadians(_E))).mod(360.0)
    val vrA1 = (285.9142682 + 0.107408 * vrK + -0.009173 * vrT.pow(2)).mod(360.0)
    val vrE = 1 - 0.002516 * vrT + -0.0000074 * vrT.pow(2)
    // ta'dil
    val vrT1 = -0.4065 * sin(Math.toRadians(vrM1))
    val vrT2 = 0.1727 * vrE * sin(Math.toRadians(vrM))
    val vrT3 = 0.0161 * sin(Math.toRadians(2 * vrM1))
    val vrT4 = -0.0097 * sin(Math.toRadians(2 * vrF1))
    val vrT5 = 0.0073 * vrE * sin(Math.toRadians(vrM1 - vrM))
    val vrT6 = -0.005 * vrE * sin(Math.toRadians(vrM1 + vrM))
    val vrT7 = -0.0023 * sin(Math.toRadians(vrM1 - 2 * vrF1))
    val vrT8 = 0.0021 * vrE * sin(Math.toRadians(2 * vrM))
    val vrT9 = 0.0012 * sin(Math.toRadians(vrM1 + 2 * vrF1))
    val vrT10 = 0.0006 * vrE * sin(Math.toRadians(2 * vrM1 + vrM))
    val vrT11 = -0.0004 * sin(Math.toRadians(3 * vrM1))
    val vrT12 = -0.0003 * vrE * sin(Math.toRadians(vrM + 2 * vrF1))
    val vrT13 = 0.0003 * sin(Math.toRadians(vrA1))
    val vrT14 = -0.0002 * vrE * sin(Math.toRadians(vrM + 2 * vrF1))
    val vrT15 = -0.0002 * vrE * sin(Math.toRadians(2 * vrM1 - vrM))
    val vrT16 = -0.0002 * sin(Math.toRadians(_E))
    val vrMT = vrT1 + vrT2 + vrT3 + vrT4 + vrT5 + vrT6 + vrT7 + vrT8 + vrT9 + vrT10 + vrT11 + vrT12 + vrT13 + vrT14 + vrT15 + vrT16
    val vrJDIstiqbal = vrJD + 0.5 + vrMT
    val vrT0 = (vrJDIstiqbal - (vrJDIstiqbal).toInt()).round(3) * 24 // jam UT
    val vrT0bef = vrT0 + (timeZone).toDouble() // jam WD sebelum - 24
    val vrT0wd = (vrT0bef).mod(24.0)
    
    val c = TanggalHarpas(vrJDIstiqbal, vrT0bef)
    // Hari Int
    val hariInt = c.hari
    // Pasaran Int
    val pasaranInt = c.pasaran
    // Hari String
    val hariString = c.hari()
    // Pasaran String
    val pasaranString = c.pasaran()
    // Tanggal Int
    val tanggalInt = c.fnTGL()
    // Bulan Int
    val bulanInt = c.fnBLN() // Bulan Int
    // Bulan String
    val bulanString = c.fnBLNString() // Bulan String
    // Tahun Int
    val tahunInt = c.fnTHN()
    
    // Lintang Bulan
    val vrS1 = -0.0048 * vrE * cos(Math.toRadians(vrM))
    val vrS2 = 0.0020 * vrE * cos(Math.toRadians(2 * vrM))
    val vrS3 = -0.3299 * cos(Math.toRadians(vrM1))
    val vrS4 = -0.0060 * vrE * cos(Math.toRadians(vrM + vrM1))
    val vrS5 = 0.0041 * vrE * cos(Math.toRadians(vrM - vrM1))
    val vrS = 5.2207 + vrS1 + vrS2 + vrS3 + vrS4 + vrS5
    
    // Al harokatul Mahfudzoh Al ula
    val vrC1 = 0.0024 * vrE * sin(Math.toRadians(2 * vrM))
    val vrC2 = -0.0392 * sin(Math.toRadians(vrM1))
    val vrC3 = 0.0116 * sin(Math.toRadians(2 * vrM1))
    val vrC4 = -0.0073 * vrE * sin(Math.toRadians(vrM + vrM1))
    val vrC5 = -0.0067 * vrE * sin(Math.toRadians(vrM - vrM1))
    val vrC6 = 0.0118 * sin(Math.toRadians(2 * vrF))
    val vrCC = 0.2070 * sin(Math.toRadians(vrM)) + vrC1 + vrC2 + vrC3 + vrC4 + vrC5 + vrC6
    
    // Al harokatul Mahfudzoh At tsani
    val vrw = abs(cos(Math.toRadians(vrF1)))
    
    // Al harokatul Mahfudzoh At tsalis
    val vry = (vrS * sin(Math.toRadians(vrF1)) + vrCC * cos(Math.toRadians(vrF1))) * (1 - 0.0048 * vrw)
    
    // Makhruqud dzil
    val vrU1 = 0.0046 * vrE * cos(Math.toRadians(vrM))
    val vrU2 = -0.0182 * cos(Math.toRadians(vrM1))
    val vrU3 = 0.0004 * cos(Math.toRadians(2 * vrM1))
    val vrU4 = -0.0005 * cos(Math.toRadians(vrM + vrM1))
    val vrU = 0.00059 + vrU1 + vrU2 + vrU3 + vrU4
    
    // Al mahfudzot
    val vrH = 1.5800 + vrU
    val vrP = 1.0128 - vrU
    val vrR = 0.4678 - vrU
    val vrN = 0.5458 + 0.0400 * cos(Math.toRadians(vrM1))
    
    // Miqdarul Khusuf/Besar Gerhana
    val vrMG = (1.0128 - vrU - abs(vry)) / 0.5450
    // Miqdarul Khusuf/Besar Gerhana Usbu'
    val vrMGUsbu = vrMG * 12
    /*
    	jika vrMG lebih besar atau samadengan 1, maka gerhana total
        jika kurang dari 1, maka gerhana sebagian
        jika kurang dari 0, maka penumbra
    */
    val jenisGerhana = when {
    	vrMG >= 1 -> "Total"
        vrMG < 1 && vrMG > 0 -> "Sebagian/Partial"
        vrMG < 0 && vrMG > -1 -> "Penumbra"
        else -> "Tidak ada Gerhana Bulan"
    }
    // vrt1 untuk jam masuk penumbra
    val vrt1 = if (statusGB == true) {
    	60.0 / vrN * sqrt((vrH).pow(2) - (vry).pow(2)) / 60
    } else {
    	00.0
    }
    // vrt2 untuk mengetahui gerhana hakiki
    val vrt2 = if (vrMG < 0) {
    	00.0
    } else {
    	60.0 / vrN * sqrt((vrP).pow(2) - (vry).pow(2)) / 60
    }
    // vrt3 untuk mengetahui jam gerhana total jika tidak maka tidak perlu dihitung
    val vrt3 = if (vrMG >= 1) {
    	60.0 / vrN * sqrt((vrR).pow(2) - (vry).pow(2)) / 60
    } else {
    	00.0
    }
    
    // Jam UT
    // awal penumbra
    val awalPenumbraUT = if (statusGB == true) {
    	(vrT0 - vrt1).mod(24.0)
    } else {
    	00.0
    }
    // awal umbra
    val awalUmbraUT = if (vrMG < 0) {
    	00.0
    } else {
    	(vrT0 - vrt2).mod(24.0)
    }
    // awal total
    val awalTotalUT = if (vrMG < 1 || vrMG < 0) {
    	00.0
    } else {
    	(vrT0 - vrt3).mod(24.0)
    }
    // tengah gerhana UT vrT0
    val tengahGerhanaUT = if (statusGB == true) {
    	vrT0
    } else {
    	00.0
    }
    // akhir total
    val akhirTotalUT = if (vrMG < 1 || vrMG < 0) {
    	00.0
    } else {
    	(vrT0 + vrt3).mod(24.0)
    }
    // akhir umbra
    val akhirUmbraUT = if (vrMG < 0) {
    	00.0
    } else {
    	(vrT0 + vrt2).mod(24.0)
    }
    // akhir penumbra
    val akhirPenumbraUT = if (statusGB == true) {
    	(vrT0 + vrt1).mod(24.0)
    } else {
    	00.0
    }
    
    // Jam WD/Waktu Daerah sesuai Zona Waktu
    val awalPenumbraWD = if (statusGB == true) {
    	(vrT0wd - vrt1).mod(24.0)
    } else {
    	00.0
    }
    val awalUmbraWD = if (vrMG < 0) {
    	00.0
    } else {
    	(vrT0wd - vrt2).mod(24.0)
    }
    val awalTotalWD = if (vrMG < 1 || vrMG < 0) {
    	00.0
    } else {
    	(vrT0wd - vrt3).mod(24.0)
    }    
    // tengah gerhana vrT0wd
    val tengahGerhanaWD = if (statusGB == true) {
    	vrT0wd
    } else {
    	00.0
    }
    val akhirTotalWD = if (vrMG < 1 || vrMG < 0) {
    	00.0
    } else {
    	(vrT0wd + vrt3).mod(24.0)
    }
    val akhirUmbraWD = if (vrMG < 0) {
    	00.0
    } else {
    	(vrT0wd + vrt2).mod(24.0)
    }
    val akhirPenumbraWD = if (statusGB == true) {
    	(vrT0wd + vrt1).mod(24.0)
    } else {
    	00.0
    }
    
    // magnitudo penumbra
    val magnitudePenumbra = vrMG
    // magnitude usbu'
    val magnitudeUsbu = vrMGUsbu
    // durasi penumbra
    val lamaPenumbra = akhirPenumbraUT - awalPenumbraUT
    // durasi hakiki/umbra
    val lamaUmbra = akhirUmbraUT - awalUmbraUT
    // durasi total
    val lamaTotal = akhirTotalUT - awalTotalUT
    
}
