package com.objectdotcreate.gangtactic.elements

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Rect


/***
 *Project: GangTactic
 *From: com.objectdotcreate.gangtactic
 *Created by ascarafht(Oscar Eduardo Mercado Soto) on 3/3/21
 *More info: www.objectdotcreate.com
 *All rights reserved 2021
 ***/



class Sprite (
    private val image:Bitmap,
    private val rows: Int = 0,
    private val columns: Int = 0
){
    private var mCurrentFrameColumn=0
    private var mCurrentFrameRow=0
    private val mFrameWidth=imageWidth()/columns
    private val mFrameHeight=imageHeight()/rows

    private fun imageWidth()=image.width
    private fun imageHeight()=image.height

    fun drawFrame(
        canvas: Canvas?,
        frameColumns:Int=0,
        frameRow:Int=0,
        posX:Int=0,
        posY:Int=0
    ){
        if(frameColumns>columns) throw ArithmeticException("Frame Columns exceeded value")
        if(frameRow>rows) throw ArithmeticException("Frame rows exceeded value")
        mCurrentFrameRow=frameRow
        nextFrame(frameColumns)

        val framePosX=mCurrentFrameColumn*mFrameWidth
        val framePosY=mCurrentFrameRow*mFrameHeight
        val frame = Rect(framePosX,framePosY,framePosX+mFrameWidth,framePosY+mFrameHeight)
        val frameLocation = Rect(posX,posY,posX+mFrameWidth,posY+mFrameHeight)

        onDraw(canvas,frame,frameLocation)
    }

    private fun nextFrame(frameColumns:Int){
        mCurrentFrameColumn=++mCurrentFrameColumn%frameColumns
    }

    private fun onDraw(canvas: Canvas?, frame:Rect, frameLocation:Rect){
        canvas?.drawBitmap(image,frame,frameLocation,null)
    }
}