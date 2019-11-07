package com.tjoeun.a20191107_01_numberbaseballgame.datas

import java.io.Serializable

class ChatData(inputMessage:String, inputSpeaker:String) : Serializable {

    var message = inputMessage
    var speaker = inputSpeaker

}