package com.objectdotcreate.gangtactic.elements

/***
 *Project: GangTactic
 *From: com.objectdotcreate.gangtactic.elements
 *Created by ascarafht(Oscar Eduardo Mercado Soto) on 3/4/21
 *More info: www.objectdotcreate.com
 *All rights reserved 2021
 ***/
class NPC(
    sprite:Sprite,
    frameMap:Map<String, IntArray>,
    posX:Int=0,
    posY:Int=0,
    layer:Int=0,
    speed:Int=0
):Monster(sprite,frameMap,posX,posY,layer,speed){
}