package com.andihasan7.lib.irsyadulmurid.AwalBulan

import kotlin.math.sin
import kotlin.math.tan
import kotlin.math.atan


object DataBulan {
    fun dataBulan(vrTh: Double): DoubleArray {
        // M
        val vrM = (((218.31617 + 481267.88088 * vrTh) / 360) * 360).mod(360.0)
        // A
        val vrA = (((134.96292 + 477198.86753 * vrTh) / 360) * 360).mod(360.0)
        // F
        val vrF = (((093.27283 + 483202.01873 * vrTh) / 360) * 360).mod(360.0)
        // D
        val vrD = (((297.85027 + 445267.11135 * vrTh) / 360) * 360).mod(360.0)
        // T1, be return
        val vrT1 = (22640.0 / 3600) * sin(Math.toRadians(vrA))
        // T2
        val vrT2 = (-4586.0 / 3600) * sin(Math.toRadians(vrA - 2 * vrD))
        // T3
        val vrT3 = (2370.0 / 3600) * sin(Math.toRadians(2 * vrD))
        // T4
        val vrT4 = (769.0 / 3600) * sin(Math.toRadians(2 * vrA))
        // m
        val vrmM = DataMatahari.dataMatahari(vrTh)[0]
        // T5
        val vrT5 = (-668.0 / 3600) * sin(Math.toRadians(vrmM))
        // T6
        val vrT6 = (-412.0 / 3600) * sin(Math.toRadians(2 * vrF))
        // T7
        val vrT7 = (-212.0 / 3600) * sin(Math.toRadians(2 * vrA - 2 * vrD))
        // T8
        val vrT8 = (-206.0 / 3600) * sin(Math.toRadians(vrA + vrmM - 2 * vrD))
        // T9
        val vrT9 = (192.0 / 3600) * sin(Math.toRadians(vrA + 2 * vrD))
        // T10
        val vrT10 = (-165.0 / 3600) * sin(Math.toRadians(vrmM - 2 * vrD))
        // T11
        val vrT11 = (148.0 / 3600) * sin(Math.toRadians(vrA - vrmM))
        // T12
        val vrT12 = (-125.0 / 3600) * sin(Math.toRadians(vrD))
        // T13
        val vrT13 = (-110.0 / 3600) * sin(Math.toRadians(vrA + vrmM))
        // T14
        val vrT14 = (-55.0 / 3600) * sin(Math.toRadians(2 * vrF - 2 * vrD))
        // C
        val vrC =
            vrT1 +
                vrT2 +
                vrT3 +
                vrT4 +
                vrT5 +
                vrT6 +
                vrT7 +
                vrT8 +
                vrT9 +
                vrT10 +
                vrT11 +
                vrT12 +
                vrT13 +
                vrT14
        // K' K"
        val vrK1 = DataMatahari.dataMatahari(vrTh)[1]
        val vrK2 = DataMatahari.dataMatahari(vrTh)[2]
        // Mo, be return
        val vrMo = (vrM + vrC + vrK1 + vrK2 - (20.47 / 3600))
        // A', be return
        val vrA1 = vrA + vrT2 + vrT3 + vrT5
        // L', be return
        val vrL1 =
            (18461.0 / 3600) * sin(Math.toRadians(vrF)) +
                (1010.0 / 3600) * sin(Math.toRadians(vrA + vrF)) +
                (1000.0 / 3600) * sin(Math.toRadians(vrA - vrF)) -
                (624.0 / 3600) * sin(Math.toRadians(vrF - 2 * vrD)) -
                (199.0 / 3600) * sin(Math.toRadians(vrA - vrF - 2 * vrD)) -
                (167.0 / 3600) * sin(Math.toRadians(vrA + vrF - 2 * vrD))
        // Q'
        val vrQ1 = DataMatahari.dataMatahari(vrTh)[3]
        // x, be return
        val vrx = Math.toDegrees(atan(sin(Math.toRadians(vrMo)) * tan(Math.toRadians(vrQ1))))
        // y, be return
        val vry = vrL1 + vrx
        
        return doubleArrayOf(vrT1, vrMo, vrA1, vrL1, vrx, vry)
    }
}
