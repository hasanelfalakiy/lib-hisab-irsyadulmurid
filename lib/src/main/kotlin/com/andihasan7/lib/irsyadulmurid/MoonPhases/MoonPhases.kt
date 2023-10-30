package com.andihasan7.lib.irsyadulmurid.MoonPhases

class MoonPhases(val month: Int, val year: Int, val timeZone: Number) {
	
    /*
    	NewMoon/Ijtima
    */
    val _newMoon = NewMoon(month, year, timeZone)
    
    // Jam NewMoon/Ijtima' UT double
    val doubleNewMoonUT = _newMoon.vrWN
    // Jam NewMoon/Ijtima' Waktu Daerah
    val doubleNewMoonWD = _newMoon.vrWNWD
    
    
    // hari Int dihitung dari Ahad/Minggu
    val intHariNewMoon = _newMoon.vrHariInt
    // pasaran Int dihitung dari Kliwon
    val intPasaranNewMoon = _newMoon.vrPasaranInt
    // tanggal Int
    val intTanggalNewMoon = _newMoon.vrTGLFix
    // bulan Int
    val intBulanNewMoon = _newMoon.vrBLNFix // Bulan Int
    // tahun Int
    val intTahunNewMoon = _newMoon.vrTHNFix
	
    // hari string
    val stringHariNewMoon = _newMoon.vrHariString
    // pasaran string
    val stringPasaranNewMoon = _newMoon.vrPasaranString
    // bulan string
    val stringBulanNewMoon = _newMoon.vrBulanString
    
    
    /*
    	First Quarter
    */
    
}
