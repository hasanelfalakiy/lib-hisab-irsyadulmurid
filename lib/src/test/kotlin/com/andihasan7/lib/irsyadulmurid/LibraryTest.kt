/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package com.andihasan7.lib.irsyadulmurid

import kotlin.test.Test
import kotlin.test.assertTrue
import kotlin.math.abs
import com.andihasan7.lib.irsyadulmurid.AwalBulan.IrsyadBulan
import com.andihasan7.lib.irsyadulmurid.WaktuSholat.IrsyadSholat
import com.andihasan7.lib.irsyadulmurid.round
import com.andihasan7.lib.irsyadulmurid.TahwilTarikh.TahwilTarikh
import com.andihasan7.lib.irsyadulmurid.Umum.Umum
import com.andihasan7.lib.irsyadulmurid.MoonPhases.MoonPhases
import com.andihasan7.lib.irsyadulmurid.GerhanaBulan.IrsyadGerhanaBulan
import com.andihasan7.lib.irsyadulmurid.GerhanaMatahari.IrsyadGerhanaMatahari

class LibraryTest {

    // DD° MM` SS,ss`` dibulatkan ke 2 angka di belakang koma
	fun toDegreeFullRound2(decimal: Double): String {
    	var degree = abs(decimal).toInt().toString()
    	var minute = ((abs(decimal) - degree.toDouble()) * 60).toInt().toString()
    	var second = ((((abs(decimal) - degree.toDouble()) * 60) - minute.toDouble()) * 60).round(2).toString()

        // Tambahkan nol sebelum angka yang kurang dari 10
        degree = degree.padStart(2, '0')
        minute = minute.padStart(2, '0')
        second = second.padStart(2, '0')
                
        if (decimal < 0) {
            degree = "-$degree"
        }

    	return "$degree\u00B0 $minute\u2032 $second\u2033"
	}
            
    @Test fun testAwalBulan() {
        /* val classUnderTest = Library()
        assertTrue(classUnderTest, "someLibraryMethod should return 'true'")
        */
	        val bln = 5
            val thn = 1445
            val lat = 5.576961111 //-7.43333333334 //-7.476111111 // -7.183333333
            val long = 100.4880194 //111.43333333334 //111.313055556 // 113.25
            val tZ = 8
            val tt = 20
            val check = true
    
            val b = IrsyadBulan(bln, thn, lat, long, tZ, tt, check)
            
            println(" ")
            println("Prediksi = ${b.awalBulanPrediksi()}")
            println("JD Ijtima = ${b.jdIjtima()}")
            println("TGL = ${b.tanggal()}") // variable vrTGLFix
            println("BLN = ${b.bulanString()}")
            println("THN = ${b.tahun()}")
            println("Hari = ${b.hari()}")
            println("Pasaran = ${b.pasaran()}")
            println("Ijtima' = ${toDegreeFullRound2(b.ijtimaWD())}")
            println("Maghrib = ${toDegreeFullRound2(b.maghribFinal())}")
            println("Azimuth Matahari = ${toDegreeFullRound2(b.azimuthMatahariUTSB())}")
            println("T Hilal Hakiki = ${toDegreeFullRound2(b.tinggiHakiki())}")
            println("T Hilal Mar'i Upper = ${toDegreeFullRound2(b.tinggiUpper())}")
            println("T Hilal Mar'i Center = ${toDegreeFullRound2(b.tinggiCenter())}")
            println("T Hilal Mar'i Lower = ${toDegreeFullRound2(b.tinggiLower())}")
            println("Azimuth Bulan = ${toDegreeFullRound2(b.azimuthHilalUTSB())}")
            println("Posisi Hilal = ${toDegreeFullRound2(b.posisiHilal())}")
            println("Posisi Hilal String = ${b.posisiHilalString()}")
            println("Lama Hilal = ${toDegreeFullRound2(b.lamaHilal())}")
            println("Elongasi = ${toDegreeFullRound2(b.elongasi())}")
            println("Nurul Hilal= ${b.nurulHilal()}")
            println("Ghurub Hilal= ${toDegreeFullRound2(b.ghurubHilal())}")
            println("Samkul Hilal= ${b.samkulHilal()}")
            println("Umur Hilal= ${toDegreeFullRound2(b.umurHilal())}")
            println(" ")
            
    }
    
    @Test
    fun testWaktuSholat() {
    
        val tgl = 1
        val m = 1
        val th = 2024
        val lt = -7.433333334
        val bj = 111.433333334
        val timez = 7
        val tinggi = 150
        val ith = 2
            
        val s = IrsyadSholat(tgl, m, th, lt, bj, timez, tinggi, ith)
            
        println("Imsak = ${toDegreeFullRound2(s.imsak())}")
        println("Shubuh = ${toDegreeFullRound2(s.shubuh())}")
        println("Terbit = ${toDegreeFullRound2(s.thulu())}")
        println("Dluha = ${toDegreeFullRound2(s.dluha())}")
        println("Dzuhur = ${toDegreeFullRound2(s.dzuhur())}")
        println("Ashar = ${toDegreeFullRound2(s.ashar())}")
        println("Maghrib = ${toDegreeFullRound2(s.maghrib())}")
        println("Isya = ${toDegreeFullRound2(s.isya())}")
        println("T Malam = ${toDegreeFullRound2(s.tengahMalam())}")
        println("2/3 Malam = ${toDegreeFullRound2(s.duaPer3MalamWD())}")
            
        println("Deklinasi = ${toDegreeFullRound2(s.deklinasi())}")
        println("EoT = ${toDegreeFullRound2(s.equationOfTime())}")
        println("Semi Diameter = ${toDegreeFullRound2(s.semiDiameter())}")
        println("Arah Qiblat = ${toDegreeFullRound2(s.qiblat())}")
        println("Arah Qiblat = ${toDegreeFullRound2(s.qiblatUTSB())}")
        println("Rashdul Qiblat 1 = ${toDegreeFullRound2(s.rashdu1())}")
        println("Rashdul Qiblat 2 = ${toDegreeFullRound2(s.rashdu2())}")
        println("Selisih Jam Markaz ~ Makkah = ${toDegreeFullRound2(s.selisihJam())}")
        println("Jarak Markaz ~ Makkah = ${s.jarakKeduanya()} Km")
        println("S Deklinasi ~ L Ka'bah = ${toDegreeFullRound2(s.selisihLintangK())}")
        println("S Deklinasi ~ L Tempat = ${toDegreeFullRound2(s.selisihLintangT())}")
        println("")
            
    }
    
    @Test
    fun testTahwil() {
        
        val tgl = 1
        val bln = 1
        val thn = 1
        
        val mTH = TahwilTarikh().hijriToMiladi(tgl, bln, thn)
        val hari = mTH[0]
        val pasaran = mTH[1]
        val tanggal = mTH[2]
        val bulan = mTH[3]
        val tahun = mTH[4]
        println(" ")
        println("$hari $pasaran, $tanggal $bulan $tahun")
        println(" ")
    }
    
    @Test
    fun testSelamatan() {
    
        val jd = 2453485.5
    
        val s = Umum.selamatan(jd)
    
        val self = s[0]
        val p7 = s[1]
        val p40 = s[2]
        val p100 = s[3]
        val p1 = s[4]
        val p2 = s[5]
        val sewu = s[6]
        
        println(" ")
        println("$self")
        println("$p7")
        println("$p40")
        println("$p100")
        println("$p1")
        println("$p2")
        println("$sewu")
        println(" ")
    
    }
    @Test
    fun testNewMoon() {
        // new moon
        val bNM = 9
        val thNM = 1445
        val tZN = 7
    
        val n = MoonPhases(bNM, thNM, tZN)
        val dUT = n.doubleNewMoonUT
        val dWD = n.doubleNewMoonWD
        println(" ")
        println("NewMoonUT = ${toDegreeFullRound2(dUT)}")
        println("NewMoonWD = ${toDegreeFullRound2(dWD)}")
        println("hari int = ${n.intHariNewMoon}")
        println("pasaran int = ${n.intPasaranNewMoon}")
        println("tanggal int = ${n.intTanggalNewMoon}")
        println("bulan int = ${n.intBulanNewMoon}")
        println("tahun int = ${n.intTahunNewMoon}")
        println("hari string = ${n.stringHariNewMoon}")
        println("pasaran string = ${n.stringPasaranNewMoon}")
        println("bulan string = ${n.stringBulanNewMoon}")
        println(" ")
    }
    
    @Test
    fun testFirstQuarter() {
        // new moon
        val bNM = 9
        val thNM = 1426
        val tZN = 7
    
        val n = MoonPhases(bNM, thNM, tZN)
        val dUT = n.doubleFirstUT
        val dWD = n.doubleFirstWD
        println(" ")
        println("FirstQuarterUT = ${toDegreeFullRound2(dUT)}")
        println("FirstQuarterWD = ${toDegreeFullRound2(dWD)}")
        println("hari int = ${n.intHariFirst}")
        println("pasaran int = ${n.intPasaranFirst}")
        println("tanggal int = ${n.intTanggalFirst}")
        println("bulan int = ${n.intBulanFirst}")
        println("tahun int = ${n.intTahunFirst}")
        println("hari string = ${n.stringHariFirst}")
        println("pasaran string = ${n.stringPasaranFirst}")
        println("bulan string = ${n.stringBulanFirst}")
        println(" ")
    }
    
    @Test
    fun testFullMoon() {
        // full moon
        val bNM = 8
        val thNM = 1425
        val tZF = 7
    
        val n = MoonPhases(bNM, thNM, tZF)
        val dUT = n.doubleFullUT
        val dWD = n.doubleFullWD
        println(" ")
        println("FullMoonUT = ${toDegreeFullRound2(dUT)}")
        println("FullMoonWD = ${toDegreeFullRound2(dWD)}")
        println("hari int = ${n.intHariFull}")
        println("pasaran int = ${n.intPasaranFull}")
        println("tanggal int = ${n.intTanggalFull}")
        println("bulan int = ${n.intBulanFull}")
        println("tahun int = ${n.intTahunFull}")
        println("hari string = ${n.stringHariFull}")
        println("pasaran string = ${n.stringPasaranFull}")
        println("bulan string = ${n.stringBulanFull}")
        println(" ")
    }
    
    @Test
    fun testLastQuarter() {
        // last quarter
        val bNM = 9
        val thNM = 1426
        val tZF = 7
    
        val n = MoonPhases(bNM, thNM, tZF)
        val dUT = n.doubleLastUT
        val dWD = n.doubleLastWD
        println(" ")
        println("LastUT = ${toDegreeFullRound2(dUT)}")
        println("LastWD = ${toDegreeFullRound2(dWD)}")
        println("hari int = ${n.intHariLast}")
        println("pasaran int = ${n.intPasaranLast}")
        println("tanggal int = ${n.intTanggalLast}")
        println("bulan int = ${n.intBulanLast}")
        println("tahun int = ${n.intTahunLast}")
        println("hari string = ${n.stringHariLast}")
        println("pasaran string = ${n.stringPasaranLast}")
        println("bulan string = ${n.stringBulanLast}")
        println(" ")
    }
    
    @Test
    fun testGerhanaBulan() {
        val b = IrsyadGerhanaBulan(3, 1447, 7)
    
        //val h = 0.0
        println(b.jenisGerhana)
        println(b.vrFInt)
        //println(h)
        //println(toDegreeFullRound2(h))
        println("")
        println("hari, pasaran : ${b.hariString} ${b.pasaranString} ${b.hariInt} ${b.pasaranInt}")
        println("tanggal bulan tahun : ${b.tanggalInt} ${b.bulanInt} ${b.bulanString} ${b.tahunInt}")
        println("awal penumbra  : ${toDegreeFullRound2(b.awalPenumbraUT)}")
        println("awal umbra     : ${toDegreeFullRound2(b.awalUmbraUT)}")
        println("awal total     : ${toDegreeFullRound2(b.awalTotalUT)}")
        println("tengah gerhana : ${toDegreeFullRound2(b.tengahGerhanaUT)}")
        println("akhir total    : ${toDegreeFullRound2(b.akhirTotalUT)}")
        println("akhir umbra    : ${toDegreeFullRound2(b.akhirUmbraUT)}")
        println("akhir penumbra : ${toDegreeFullRound2(b.akhirPenumbraUT)}")
        println("")
        println("awal penumbra  : ${toDegreeFullRound2(b.awalPenumbraWD)}")
        println("awal umbra     : ${toDegreeFullRound2(b.awalUmbraWD)}")
        println("awal total     : ${toDegreeFullRound2(b.awalTotalWD)}")
        println("tengah gerhana : ${toDegreeFullRound2(b.tengahGerhanaWD)}")
        println("akhir total    : ${toDegreeFullRound2(b.akhirTotalWD)}")
        println("akhir umbra    : ${toDegreeFullRound2(b.akhirUmbraWD)}")
        println("akhir penumbra : ${toDegreeFullRound2(b.akhirPenumbraWD)}")
        println("")
        println("magnitude penumbra : ${(b.magnitudePenumbra).round(4)}")
        println("magnitude umbra : ${(b.magnitudeUmbra).round(4)}")
        println("magnitude usbu' : ${toDegreeFullRound2(b.magnitudeUsbu)}")
        println("lama penumbra : ${toDegreeFullRound2(b.lamaPenumbra)}")
        println("lama umbra : ${toDegreeFullRound2(b.lamaUmbra)}")
        println("lama total : ${toDegreeFullRound2(b.lamaTotal)}")
        println("")
    }
    
    @Test
    fun testGerhanaMatahari() {
        val s = IrsyadGerhanaMatahari(3, 1425, 7)
    
        val hs = s.vrFInt
        println(hs)
        //println(toDegreeFullRound2(hs))
        println("status gerhana : ${s.statusGM}")
        println("jenis gerhana  : ${s.jenisGM}")
        println("tgl/bln/thn  : ${s.tanggalIntGM} ${s.bulanIntGM} ${s.tahunIntGM}")
        println("hari pasaran : ${s.hariIntGM} ${s.pasaranIntGM}")
        println("")
        println("awal gerhana   : ${toDegreeFullRound2(s.awalGMUT)}")
        println("awal total     : ${toDegreeFullRound2(s.awalTotalGMUT)}")
        println("tengah gerhana : ${toDegreeFullRound2(s.tengahGMUT)}")
        println("akhir total    : ${toDegreeFullRound2(s.akhirTotalGMUT)}")
        println("akhir gerhana  : ${toDegreeFullRound2(s.akhirGMUT)}")
        println("")
        println("awal gerhana   : ${toDegreeFullRound2(s.awalGMWD)}")
        println("awal total     : ${toDegreeFullRound2(s.awalTotalGMWD)}")
        println("tengah gerhana : ${toDegreeFullRound2(s.tengahGMWD)}")
        println("akhir total    : ${toDegreeFullRound2(s.akhirTotalGMWD)}")
        println("akhir gerhana  : ${toDegreeFullRound2(s.akhirGMWD)}")
        println("")
        println("magnitude gerhana  : ${s.magnitudeGM}")
        println("arah gerhana/gamma  : ${s.gammaGM} ${toDegreeFullRound2(s.gammaGM)} ${s.arahGerhanaGM}")
        println("lama gerhana  : ${toDegreeFullRound2(s.lamaGerhanaGM)}")
        println("lama gerhana total  : ${toDegreeFullRound2(s.lamaTotalGM)}")
    }
}
