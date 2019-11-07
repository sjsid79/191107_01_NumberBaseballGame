package com.tjoeun.a20191107_01_numberbaseballgame

import androidx.appcompat.app.AppCompatActivity


abstract class BaseActivity : AppCompatActivity() {
    //추상 메소드
    abstract fun setupEvents()
    abstract fun setValues()


}