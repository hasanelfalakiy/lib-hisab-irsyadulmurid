package com.andihasan7.lib.irsyadulmurid.Umum

object Umum {

    // selamatan meninggal
    fun selamatan(jd: Double): DoubleArray {
	    // jd masehi ke hijri
	    val self = jd
        val p7 = jd + 7
        val p40 = jd + 40
        val p100 = jd + 100
        val p1 = jd + 354
        val p2 = jd + 708
        val sewu = jd + 1000
    
        return doubleArrayOf(self, p7, p40, p100, p1, p2, sewu)
    }
}