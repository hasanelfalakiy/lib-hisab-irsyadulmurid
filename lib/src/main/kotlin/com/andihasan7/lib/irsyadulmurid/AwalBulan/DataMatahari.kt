package com.andihasan7.lib.irsyadulmurid.AwalBulan

import kotlin.math.sin
import kotlin.math.cos
import kotlin.mod

object DataMatahari {
    fun dataMatahari(vrTh: Double): DoubleArray {
        // S
        val vrS = (((280.46645 + 36000.76983 * vrTh) / 360) * 360).mod(360.0)
        // m, be return
        val vrmM = (((357.52910 + 35999.05030 * vrTh) / 360) * 360).mod(360.0)
        // N
        val vrN = (((125.04 - 1934.136 * vrTh) / 360) * 360).mod(360.0)
        // K', be return
        val vrK1 =
            (17.264 / 3600) * sin(Math.toRadians(vrN)) +
                (0.206 / 3600) * sin(Math.toRadians(2 * vrN))
        // K", be return
        val vrK2 = (-1.264 / 3600) * sin(Math.toRadians(2 * vrS))
        // R'
        val vrR1 =
            (9.23 / 3600) * cos(Math.toRadians(vrN)) - (0.090 / 3600) * cos(Math.toRadians(2 * vrN))
        // R"
        val vrR2 = (0.548 / 3600) * cos(Math.toRadians(2 * vrS))
        // Q', be return
        val vrQ1 = 23.43929111 + vrR1 + vrR2 - (46.8150 / 3600) * vrTh
        // E
        val vrE =
            (6898.06 / 3600) * sin(Math.toRadians(vrmM)) +
                (72.095 / 3600) * sin(Math.toRadians(2 * vrmM)) +
                (0.966 / 3600) * sin(Math.toRadians(3 * vrmM))
        // S', be return
        val vrS1 = vrS + vrE + vrK1 + vrK2 - (20.47 / 3600)

        return doubleArrayOf(vrmM, vrK1, vrK2, vrQ1, vrS1)
    }
}
