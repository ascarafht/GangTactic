package com.objectdotcreate.gangtactic

import android.view.SurfaceHolder

/***
 *Project: GangTactic
 *From: com.objectdotcreate.gangtactic
 *Created by ascarafht(Oscar Eduardo Mercado Soto) on 3/4/21
 *More info: www.objectdotcreate.com
 *All rights reserved 2021
 ***/
class StageSurfaceHolder(private val gameLoop: GameLoop): SurfaceHolder.Callback{

    //View creates listener
    override fun surfaceCreated(holder: SurfaceHolder) {
        gameLoop.start()
    }

    //View changes listener
    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {
        //TODO("Not yet implemented")
    }

    //View destroys listener
    override fun surfaceDestroyed(holder: SurfaceHolder) {
        gameLoop.pause()
    }
}