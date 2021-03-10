package com.objectdotcreate.gangtactic.elements

import android.graphics.Canvas

/***
 *Project: GangTactic
 *From: com.objectdotcreate.gangtactic.elements
 *Created by ascarafht(Oscar Eduardo Mercado Soto) on 3/5/21
 *More info: www.objectdotcreate.com
 *All rights reserved 2021
 ***/
open class Element(
    private val sprite: Sprite,
    private val frameMap:Map<String, IntArray>,
    private var posX: Int = 0,
    private var posY: Int = 0,
    private var layer: Int = 0,
    private var speed: Int = 0
) {
    
    fun move(directionX:Int=0,directionY: Int=0,canvas:Canvas){
        val moveFrame= frameMap["forward"]
        var frameRow =0
        var frameColumns =1
        if(moveFrame!=null){
            frameRow= moveFrame[0]
            frameColumns= moveFrame[1]
        }
        onDraw(canvas,frameColumns,frameRow)
    }

    private fun onDraw(
        canvas: Canvas?,
        frameColumns: Int = 1,
        frameRow: Int = 0
    ) {
        sprite.drawFrame(canvas, frameColumns, frameRow, posX, posY)
    }
}