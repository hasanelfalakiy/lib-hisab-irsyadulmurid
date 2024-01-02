/*
 * This file is part of lib-hisab-irsyadulmurid.
 *
 * lib-hisab-irsyadulmurid is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * lib-hisab-irsyadulmurid is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with lib-hisab-irsyadulmurid.  If not, see <https://www.gnu.org/licenses/>.
 *
 */

package com.andihasan7.lib.irsyadulmurid.TahwilTarikh

import kotlin.math.floor

object TarikhToJD {

	// fungsi mengubah tarikh miladi ke Julian Day (JD)
	fun miladiToJD(date: Int, month: Int, year: Int, hour: Double = 0.0, timeZone: Double = 0.0): Double {
    	
        date.toDouble()
        month.toDouble()
        year.toDouble()
        
        val krBln =
        	if (month < 3) {
            	month + 12
            } else {
            	month
            }
            
        val krThn =
        	if (month < 3) {
            	year - 1
            } else {
            	year
            }
            
        val krGregorius = year + month / 100 + date / 10000
        val krGregorius2 =
        	if (krGregorius < 1582.1015) {
            	0
            } else {
            	2 - (year / 100).toInt() + (((year / 100).toInt()).toDouble() / 4).toInt()
            }
            
        val vrJD = date + (30.6001 * (krBln + 1)).toInt() + (365.25 * (krThn + 4716)).toInt() + krGregorius2 + ((hour - timeZone) / 24) - 1524.5
        
        return vrJD
    }
    
    // fungsi mengubah tarikh hijriyah ke Julian Day (JD)
    fun hijriToJD(date: Int, month: Int, year: Int): Double {
    
    	date.toDouble()
        month.toDouble()
        year.toDouble()
        
        val vrA = (floor(((11 * year + 3).toDouble() / 30) + (354 * year))).toInt()
        val vrB = 30 * month
        val vrC = ((month - 1) / 2).toInt()
        val vrD = date + vrA + vrB - vrC - 385
        val vrJD = vrD + 1948440 - 0.5
        
        return vrJD
    }
}
