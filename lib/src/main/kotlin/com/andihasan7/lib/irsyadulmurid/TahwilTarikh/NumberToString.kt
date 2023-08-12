package com.andihasan7.lib.irsyadulmurid.TahwilTarikh

object NumberToString {
	
    fun numberAhad(number: Int): String {
    	val hari =
        	when (number) {
            	1 -> "Ahad"
                2 -> "Senin"
                3 -> "Selasa"
                4 -> "Rabu"
                5 -> "Kamis"
                6 -> "Jum`at"
                7 -> "Sabtu"
                else -> "Sabtu"
            }
        return hari
    }
    
    fun numberLegi(number: Int): String {
    	val pasaran =
        	when (number) {
            	1 -> "Legi"
                2 -> "Pahing"
                3 -> "Pon"
                4 -> "Wage"
                5 -> "Kliwon"
                else -> "Kliwon"
            }
        return pasaran
    }
    
    fun numberKliwon(number: Int): String {
    	val pasaran =
        	when (number) {
            	1 -> "Kliwon"
                2 -> "Legi"
                3 -> "Pahing"
                4 -> "Pon"
                5 -> "Wage"
                else -> "Wage"
            }
        return pasaran
    }
    
    fun numberJanuari(number: Int): String {
    	val bulan =
        	when (number) {
        	1 -> "Januari"
            2 -> "Februari"
            3 -> "Maret"
            4 -> "April"
            5 -> "Mei"
            6 -> "Juni"
            7 -> "Juli"
            8 -> "Agustus"
            9 -> "September"
            10 -> "Oktober"
            11 -> "November"
            12 -> "Desember"
            else -> "Desember"
        }
        return bulan
    }
    
    fun numberMuharram(number: Int): String {
    	val bulan =
        	when (number) {
        	1 -> "Muharram"
            2 -> "Shafar"
            3 -> "Rabi`ul Awwal"
            4 -> "Rabi`ul Akhir"
            5 -> "Jumadil Awwal"
            6 -> "Jumadil Akhir"
            7 -> "Rajab"
            8 -> "Sya`ban"
            9 -> "Ramadhan"
            10 -> "Syawwal"
            11 -> "Dzul Qo`dah"
            12 -> "Dzul Hijjah"
            else -> "Dzul Hijjah"
        }
        return bulan
    }
}
