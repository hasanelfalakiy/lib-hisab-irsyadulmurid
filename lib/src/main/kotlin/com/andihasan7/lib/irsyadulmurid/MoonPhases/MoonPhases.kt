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
    val _firstQuarter = FirstQuarter(month, year, timeZone)
    
    // Jam First Quarter UT double
    val doubleFirstUT = _firstQuarter.vrWT1
    // Jam First Quarter Waktu Daerah
    val doubleFirstWD = _firstQuarter.vrWFWD
    
    
    // hari Int dihitung dari Ahad/Minggu
    val intHariFirst = _firstQuarter.hariFirstInt
    // pasaran Int dihitung dari Kliwon
    val intPasaranFirst = _firstQuarter.pasaranFirstInt
    // tanggal Int
    val intTanggalFirst = _firstQuarter.tanggalFirstInt
    // bulan Int
    val intBulanFirst = _firstQuarter.bulanFirstInt // Bulan Int
    // tahun Int
    val intTahunFirst = _firstQuarter.tahunFirstInt
	
    // hari string
    val stringHariFirst = _firstQuarter.hariFirstString
    // pasaran string
    val stringPasaranFirst = _firstQuarter.pasaranFirstString
    // bulan string
    val stringBulanFirst = _firstQuarter.bulanFirstString
    
    
    /*
    	Full Moon/Istiqbal
    */
    val _fullMoon = FullMoon(month, year, timeZone)
    
    // Jam Full Moon UT double
    val doubleFullUT = _fullMoon.vrWFUT
    // Jam Full Moon Waktu Daerah
    val doubleFullWD = _fullMoon.vrWFFWD
    
    // hari Int dihitung dari Ahad/Minggu
    val intHariFull = _fullMoon.hariFullInt
    // pasaran Int dihitung dari Kliwon
    val intPasaranFull = _fullMoon.pasaranFullInt
    // tanggal Int
    val intTanggalFull = _fullMoon.tanggalFullInt
    // bulan Int
    val intBulanFull = _fullMoon.bulanFullInt // Bulan Int
    // tahun Int
    val intTahunFull = _fullMoon.tahunFullInt
	
    // hari string
    val stringHariFull = _fullMoon.hariFullString
    // pasaran string
    val stringPasaranFull = _fullMoon.pasaranFullString
    // bulan string
    val stringBulanFull = _fullMoon.bulanFullString
    
    
    /*
    	Last Moon/Tarbi' Tsani
    */
    val _lastMoon = LastQuarter(month, year, timeZone)
    
    // Jam Last Moon UT double
    val doubleLastUT = _lastMoon.vrWLUT
    // Jam Last Moon Waktu Daerah
    val doubleLastWD = _lastMoon.vrWLFWD
    
    // hari Int dihitung dari Ahad/Minggu
    val intHariLast = _lastMoon.hariLastInt
    // pasaran Int dihitung dari Kliwon
    val intPasaranLast = _lastMoon.pasaranLastInt
    // tanggal Int
    val intTanggalLast = _lastMoon.tanggalLastInt
    // bulan Int
    val intBulanLast = _lastMoon.bulanLastInt // Bulan Int
    // tahun Int
    val intTahunLast = _lastMoon.tahunLastInt
	
    // hari string
    val stringHariLast = _lastMoon.hariLastString
    // pasaran string
    val stringPasaranLast = _lastMoon.pasaranLastString
    // bulan string
    val stringBulanLast = _lastMoon.bulanLastString
}
