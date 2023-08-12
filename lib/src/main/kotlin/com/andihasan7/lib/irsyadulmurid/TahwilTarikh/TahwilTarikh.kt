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