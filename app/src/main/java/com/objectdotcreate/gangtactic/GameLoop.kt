package com.objectdotcreate.gangtactic

import kotlinx.coroutines.*
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

/***
 *Project: GangTactic
 *From: com.objectdotcreate.gangtactic
 *Created by ascarafht(Oscar Eduardo Mercado Soto) on 3/2/21
 *More info: www.objectdotcreate.com
 *All rights reserved 2021
 ***/

class GameLoop(private val view: GameSurfaceView) {

    private var mJobGameLoop: Job? = null

    //Similar to synchronized instruction in Java
    private val mMutex = Mutex()
    //Flag that indicates if the Coroutine is running or paused
    private var mRunning: Boolean = false
    //constant FPS of the game
    private val mFPS = 10L

    init {
        //listeners to know when to print on our screen are in holder.
        //So we add a callback to holder where we will have the listeners
        view.holder.addCallback(StageSurfaceHolder(this))
    }

    fun start() {
        mRunning = true
        mJobGameLoop = if (mJobGameLoop == null) run() else null
    }

    private fun run() = GlobalScope.launch {
        val ticksPS = 1000 / mFPS//ticks per seconds
        var startTime: Long
        var sleepTime: Long
        while (mRunning) {
            startTime = System.currentTimeMillis()//save current time
            gameDraw()
            sleepTime =
                ticksPS - (System.currentTimeMillis() - startTime)//check difference time between current time and time taken at the start of the loop
            delay(sleepTime)
        }
    }

    private suspend fun gameDraw() {
        mMutex.withLock {
            val canvas = view.holder.lockCanvas()
            view.loopDraw(canvas)
            view.holder.unlockCanvasAndPost(canvas)
        }
    }

    fun pause() = runBlocking {
        mRunning = false
        mJobGameLoop?.cancel()
        mJobGameLoop?.join()
        mJobGameLoop = null
    }
}