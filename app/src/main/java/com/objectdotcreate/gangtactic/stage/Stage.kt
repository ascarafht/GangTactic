package com.objectdotcreate.gangtactic.stage

import android.graphics.Canvas
import com.objectdotcreate.gangtactic.elements.*

/***
 *Project: GangTactic
 *From: com.objectdotcreate.gangtactic.stage
 *Created by ascarafht(Oscar Eduardo Mercado Soto) on 3/4/21
 *More info: www.objectdotcreate.com
 *All rights reserved 2021
 ***/
class Stage(private val map:String="default") {

    private var elementsList= arrayOf<Element>()
    private var npcsList= arrayOf<NPC>()
    private var pc= arrayOf<PC>()

    fun onDraw(canvas: Canvas?) {
        //TODO("Not yet implemented")
    }
}