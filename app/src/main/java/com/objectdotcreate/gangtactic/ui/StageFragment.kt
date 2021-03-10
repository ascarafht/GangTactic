package com.objectdotcreate.gangtactic.ui

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.objectdotcreate.gangtactic.GameLoop
import com.objectdotcreate.gangtactic.R
import com.objectdotcreate.gangtactic.databinding.StageBinding
import com.objectdotcreate.gangtactic.stage.Stage

/***
 *Project: GangTactic
 *From: com.objectdotcreate.gangtactic.ui
 *Created by ascarafht(Oscar Eduardo Mercado Soto) on 3/1/21
 *More info: www.objectdotcreate.com
 *All rights reserved 2021
 ***/
class StageFragment : Fragment() {

    private lateinit var mBinding: StageBinding
    //object gameLoop that will refresh the drawing for the animations
    private lateinit var mGameLoop:GameLoop
    private lateinit var mStage: Stage
    private lateinit var mBmp:Bitmap

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = StageBinding.inflate(inflater, container, false)

        mBmp= BitmapFactory.decodeResource(resources, R.drawable.orc)
        mGameLoop= GameLoop(mBinding.gsvGameStage)
        mStage= Stage()
        mBinding.gsvGameStage.setStage(mStage)

        return mBinding.root
    }
}