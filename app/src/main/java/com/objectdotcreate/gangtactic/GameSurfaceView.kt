package com.objectdotcreate.gangtactic

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.SurfaceView
import com.objectdotcreate.gangtactic.stage.Stage

/***
 *Project: GangTactic
 *From: com.objectdotcreate.gangtactic.ui
 *Created by ascarafht(Oscar Eduardo Mercado Soto) on 3/1/21
 *More info: www.objectdotcreate.com
 *All rights reserved 2021
 ***/
class GameSurfaceView(context: Context?, attrs: AttributeSet?) : SurfaceView(context, attrs) {
    //SurfaceView is a View of lower level than View.
    //So SurfaceView does not call for onDraw and other methods
    private var mStage: Stage?= null

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.drawColor(Color.BLACK)//Background color Black
        mStage?.onDraw(canvas)
    }

    fun loopDraw(canvas:Canvas?){
        onDraw(canvas)
    }
    fun setStage(stage: Stage){
        mStage=stage
    }
}