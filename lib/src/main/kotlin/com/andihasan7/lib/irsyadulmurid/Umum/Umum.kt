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