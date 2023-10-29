package com.andihasan7.lib.irsyadulmurid.AwalBulan

import kotlin.math.sqrt
import kotlin.math.asin
import kotlin.math.sin
import kotlin.math.acos
import kotlin.math.cos
import kotlin.math.tan
import kotlin.math.atan
import kotlin.mod
import kotlin.math.abs
import kotlin.math.pow
import com.andihasan7.lib.irsyadulmurid.WaktuSholat.IrsyadSholat
import com.andihasan7.lib.irsyadulmurid.AwalBulan.TanggalHarpas
import com.andihasan7.lib.irsyadulmurid.round


class IrsyadBulan(
	val month: Number,
    val year: Number,
    val latitude: Double,
    val longitude: Double,
    val timeZone: Number,
    val elevation: Number,
    val check: Boolean) {
    
    // Hisab Ijtima`
    val bujurDaerah = timeZone.toDouble() * 15
    
    // JD Ijtima'
    val vrJDIjtima = HisabIjtima.hisabIjtima(month, year)
    
    // Waktu Ijtima UT/ GMT
    val vrWI = (vrJDIjtima).mod(1.0) * 24 // frac(vrJDIjtima) x 24
    // Waktu Ijtima sebelum kondisi > 24
    val vrWIwd = vrWI + (timeZone).toDouble()
    // Waktu Ijtima` Waktu Daerah Fix
    val vrWIWD =
    	if (vrWIwd >= 24) {
        	vrWIwd - 24
    	} else {
        	vrWIwd
        }
    
    // Z
    
    val c = TanggalHarpas(vrJDIjtima, vrWIwd)
    // TGL FIX
    val vrTGLFix = c.fnTGL()
    // BLN
    val vrBLNFix = c.fnBLN() // Bulan Int
    // Tahun
    val vrTHN = c.fnTHN()
    
    // lanjut mengambil data maghrib tanpa ihthiyat, return type is Double 
    val maghribAwwal = IrsyadSholat(vrTGLFix, vrBLNFix, vrTHN, latitude, longitude, timeZone, elevation, 0).maghrib()
    
    
    // Hisab Hilal
    // pengkondisian bulan & tahun
    /*
    	Sebelum saya tambahkan kondisi pada bulan & tahun yang disimpan dalam
        variable vrMonth & vrYear, program akan mengalami error hisab hilal saat bulan masehi
        kurang dari maret. tinggi hilal dll akan tidak sesuai.
    */
    val vrMonth =
    	if (vrBLNFix < 3) {
        	vrBLNFix + 12
        } else {
        	vrBLNFix
        }
    
    val vrYear =
    	if (vrBLNFix < 3) {
        	vrTHN - 1
        } else {
        	vrTHN
        }
        
    // B    
    val vrBh = 2 - ((vrYear).toDouble() / 100).toInt() + (((vrYear).toDouble() / 100).toInt().toDouble() / 4).toInt()
    // JD
    val vrJDh = (365.25 * (vrYear + 4716)).toInt() + (30.6001 * (vrMonth + 1)).toInt() + vrTGLFix + ((maghribAwwal - (timeZone).toDouble()) / 24) + vrBh - 1524.5
    // T hisab hilal, disini nanti pengecekan sehari setelah Ijtima'
    // Jika true maka hari itu juga, jika false satu hari setelah Ijtima'
    val vrTh =
        if (check == true) {
            (vrJDh - 2451545) / 36525
        } else {
            ((vrJDh + 1) - 2451545) / 36525
        }
    
    
    // Data Matahari
    // S
    // S'
    val vrS1 = DataMatahari.dataMatahari(vrTh)[4]
    // Q'
    val vrQ1 = DataMatahari.dataMatahari(vrTh)[3]
    // Deklinasi Matahari 
    val vrDekM = Math.toDegrees(asin(sin(Math.toRadians(vrS1)) * sin(Math.toRadians(vrQ1))))
    // PTm
    val vrPTM = Math.toDegrees(atan(tan(Math.toRadians(vrS1)) * cos(Math.toRadians(vrQ1))))
    // PTm Fix, Ascension Recta Matahari
    val vrPTMFix =
    	if (vrS1 >= 0.0 && vrS1 <= 90.0) {
        	 vrPTM
        } else if (vrS1 >= 90.0 && vrS1 <= 270.0) {
        	vrPTM + 180
        } else {
        	vrPTM + 360
        }
      
    // m
    val vrmM = DataMatahari.dataMatahari(vrTh)[0] 
    // e Equation of time Matahari 
    val vreM = (-1.915 * sin(Math.toRadians(vrmM)) + -0.02 * sin(Math.toRadians(2 * vrmM)) + 2.466 * sin(Math.toRadians(2 * vrS1)) + -0.053 * sin(Math.toRadians(4 * vrS1))) / 15
    // sd Semidiameter Matahari
    val vrsdM = 0.267 / (1 - 0.017 * cos(Math.toRadians(vrmM)))
    // dip, Kerendahan ufuk
    val vrdip = (1.76/60) * sqrt((elevation).toDouble())
    // h Maghrib
    val vrh = -(vrsdM + 0.575 + vrdip)
    // t
    val vrt = Math.toDegrees(acos(-tan(Math.toRadians(latitude)) * tan(Math.toRadians(vrDekM)) + sin(Math.toRadians(vrh)) / cos(Math.toRadians(latitude)) / cos(Math.toRadians(vrDekM))))
    // Maghrib terkoreksi
    val maghribFix = (vrt / 15) + (12 - vreM) - ((longitude - bujurDaerah) / 15)
    // Azimuth Matahari
    val vrAM = Math.toDegrees(atan(-sin(Math.toRadians(latitude)) / tan(Math.toRadians(vrt)) + cos(Math.toRadians(latitude)) * tan(Math.toRadians(vrDekM)) / sin(Math.toRadians(vrt))))
    // Azimuth Matahari UTSB
    val vrAMUTSB = vrAM + 270
    /*
        if (vrt < 180) {
        	vrAM + 270
        } else {
        	vrAM + 90
        }
        */
    // Jarak pusat Bumi ke pusat Matahari satuan AU
    val vrRau = (1.00014 - 0.01671 * cos(Math.toRadians(vrmM)) - 0.00014 * cos(Math.toRadians(2 * vrmM))).round(9)
    // satuan KM
    val vrRkm = vrRau * 149597870
    
    
    // DataBulan
    // M
    // T1
    val vrT1 = DataBulan.dataBulan(vrTh)[0]
    // Mo
    val vrMo = DataBulan.dataBulan(vrTh)[1]
    // A'
    val vrA1 = DataBulan.dataBulan(vrTh)[2]
    // L'
    val vrL1 = DataBulan.dataBulan(vrTh)[3]
    // x
    val vrx = DataBulan.dataBulan(vrTh)[4]
    // y
    val vry = DataBulan.dataBulan(vrTh)[5]
    // Dekc, Deklinasi Bulan
    val vrDekc = Math.toDegrees(asin(sin(Math.toRadians(vrMo)) * sin(Math.toRadians(vrQ1)) * sin(Math.toRadians(vry)) / sin(Math.toRadians(vrx))))
    // PTc, Assensiorekta Bulan
    val vrPTc = Math.toDegrees(acos(cos(Math.toRadians(vrMo)) * cos(Math.toRadians(vrL1)) / cos(Math.toRadians(vrDekc))))
    // PTc Fix
    val vrPTcFix =
    	if (vrMo >= 0.0 && vrMo <= 180.0) {
        	vrPTc
        } else {
        	360 - vrPTc
        }
    // tc
    val vrtc = (vrPTMFix - vrPTcFix) + vrt
    // hc, Tinggi Hilal hakiki
    val vrhc = Math.toDegrees(asin(sin(Math.toRadians(latitude)) * sin(Math.toRadians(vrDekc)) + cos(Math.toRadians(latitude)) * cos(Math.toRadians(vrDekc)) * cos(Math.toRadians(vrtc))))
    // p
    val vrp = (384401 * (1 - 0.0549.pow(2))).toDouble() / (1 + 0.0549 * cos(Math.toRadians(vrA1 + vrT1)))
    // p'
    val vrp1 = vrp / 384401
    // HP, Horizontal Parallax
    val vrHP = 0.9507 / vrp1
    // sdc, Semidiameter Bulan
    val vrsdc = (0.5181 / vrp1) / 2
    // P, Parallax
    val vrP = vrHP * cos(Math.toRadians(vrhc))
    // Refraksi
    val vrRef = 0.0167 / tan(Math.toRadians(vrhc + 7.31 / (vrhc + 4.4)))
    // hc' Tinggi Hilal mar'i upper
    val vrhcu = vrhc - vrP + vrsdc + vrRef + vrdip
    // hc' Mar'i center
    val vrhcc = vrhcu - vrsdc
    // hc' Mar'i lower
    val vrhcl = vrhc - vrP - vrsdc + vrRef + vrdip
    // Azimuth Hilal
    val vrAzc_ = Math.toDegrees(atan(-sin(Math.toRadians(latitude)) / tan(Math.toRadians(vrtc)) + cos(Math.toRadians(latitude)) * tan(Math.toRadians(vrDekc)) / sin(Math.toRadians(vrtc))))
    // Azimuth Hilal UTSB
    val vrAzc = vrAzc_ + 270
    /*
        if (vrtc < 180) {
        	vrAzc_ + 270
        } else {
        	vrAzc_ + 90
        }
        */
    // z, Posisi Hilal
    val vrz = vrAzc - vrAMUTSB
    // Posisi Hilal String
    val vrzS =
    	if (vrz > 0) {
        	"Utara Matahari"
        } else {
        	"Selatan Matahari"
        }
    // Dc, Lama Hilal
    val vrDc = (vrPTcFix - vrPTMFix) / 15
    // AL
    val vrAL = Math.toDegrees(acos(cos(Math.toRadians(abs(vrhcu - vrh))) * cos(Math.toRadians(abs(vrz)))))
    // Cw, Samkul Hilal
    val vrCw = (1 - cos(Math.toRadians(vrAL))) * vrsdc * 60
    // EL, Elongasi
    val vrEL = Math.toDegrees(acos(cos(Math.toRadians(vrMo - vrS1)) * cos(Math.toRadians(vrL1))))
    // Fla
    val vrFla = Math.toDegrees(acos(-cos(Math.toRadians(vrEL))))
    // FI, Nurul Hilal
    val vrFI = (1 + cos(Math.toRadians(vrFla))) / 2
    // Ms, Ghurub Hilal
    val vrMs = maghribFix + vrDc
    // Umur Hilal
    val vruH =
    	if (check == true) {
        	maghribFix - vrWIWD
        } else {
        	24 + (maghribFix - vrWIWD) // umur hilal dihitung dari Ijtima sampai matahari terbenam, ikut bertambah saat sehari setelah Ijtima
        }
    
    // Perkiraan Awal Bulan
    // Jika T Hilal Mar'i Center lebih atau sama dengan 2, maka besok Bulan baru, jika tidak, maka 2 hari lagi
    val jdPrediksi =
    	if (vrhcc >= 2) {
        	vrJDIjtima + 1
        } else {
        	vrJDIjtima + 2
        }
        
    val prediksi = TanggalHarpas(jdPrediksi, vrWIwd)
    val tglPrediksi = prediksi.fnTGL()
    val blnPrediksi = prediksi.fnBLNString()
    val thnPrediksi = prediksi.fnTHN()
    val hariPrediksi = prediksi.hari()
    val pasaranPrediksi = prediksi.pasaran()
    
    // Prediksi
    fun awalBulanPrediksi(): String =
        if (check == true) {
        	"$hariPrediksi $pasaranPrediksi, $tglPrediksi $blnPrediksi $thnPrediksi"
        } else {
        	"Beralihlah ke saat Ijtima'"
        }
    // JD Ijtima
    fun jdIjtima(): Double = vrJDIjtima
    // Ijtima UT/ GMT
    fun ijtimaUT(): Double = vrWI
    // Ijtima Waktu Daerah (WIB, WIT, WITA, dll)
    fun ijtimaWD(): Double = vrWIWD
    // Tanggal, Perhatian! Jika menghitung sehari setelah Ijtima' maka Hari Pasaran Tanggal Bulan Tahun Maghrib dll akan menyesuaikan penambahan hari, sementara waktu Ijtima tetap
    fun tanggal(): Int = vrTGLFix
    // Bulan String
    fun bulanString(): String = c.fnBLNString()  
    // Tahun
    fun tahun(): Int = vrTHN 
    // Hari
    fun hari(): String = c.hari()
    // Pasaran 
    fun pasaran(): String = c.pasaran()
    
    // Maghrib terkoreksi
    fun maghribFinal(): Double = maghribFix
    // Azimuth Matahari 
    fun azimuthMatahari(): Double = vrAM
    // Azimuth Matahari UTSB
    fun azimuthMatahariUTSB(): Double = vrAMUTSB
    
    // Tinggi Hilal Hakiki
    fun tinggiHakiki(): Double = vrhc
    // Tinggi Hilal Mar'i upper
    fun tinggiUpper(): Double = vrhcu
    // Tinggi Hilal Mar'i center
    fun tinggiCenter(): Double = vrhcc
    // Tinggi Hilal Mar'i lower
    fun tinggiLower(): Double = vrhcl
    // Azimuth Hilal
    fun azimuthHilal(): Double = vrAzc_
    // Azimuth Hilal UTSB
    fun azimuthHilalUTSB(): Double = vrAzc
    // Posisi Hilal
    fun posisiHilal(): Double = vrz
    // Posisi Hilal String
    fun posisiHilalString(): String = vrzS
    // Muktsul Hilal
    fun lamaHilal(): Double = vrDc
    // Elongasi
    fun elongasi(): Double = vrEL
    // Nurul Hilal
    fun nurulHilal(): Double = vrFI
    // Ghurub Hilal
    fun ghurubHilal(): Double = vrMs
    // Samkul Hilal
    fun samkulHilal(): Double = vrCw
    // Umur Hilal
    fun umurHilal(): Double = vruH
    
    
    // Deklinasi Matahari
    fun deklinasiMatahari(): Double = vrDekM
    // Equation of Time Matahari
    fun equationMatahari(): Double = vreM
    // Semidiameter Matahari
    fun semidiameterMatahari(): Double = vrsdM
    // Deklinasi Bulan
    fun deklinasiBulan(): Double = vrDekc
    // Semidiameter Bulan
    fun semidiameterBulan(): Double = vrsdc
    // RightAscension Matahari 
    fun ascensionRectaMatahari(): Double = vrPTMFix
    // RightAscension Bulan 
    fun ascensionRectaBulan(): Double = vrPTcFix
    // True Distance Obliquity AU
    fun trueDistanceAU(): Double = vrRau
    // True Distance Obliquity KM
    fun trueDistanceKM(): Double = vrRkm
    
    
}
