package com.tjoeun.a20191107_01_numberbaseballgame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.tjoeun.a20191107_01_numberbaseballgame.adapters.ChatAdapter
import com.tjoeun.a20191107_01_numberbaseballgame.datas.ChatData
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : BaseActivity() {
    // 471 -> 4,7,1

    var chatList = ArrayList<ChatData>()
    var chatAdapter:ChatAdapter? = null

    var questNumArray = ArrayList<Int>()        //컴퓨터가 낸 문제
    var userInputNumArray = ArrayList<Int>()    //유저가 입력한 숫자의 배열
            
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupEvents()
        setValues()
        createQuestion()
    }

    fun createQuestion(){
        while (true){
            val number = Random.nextInt(1,10)

            //지금 들고 있는 숫자가 방금 나온 숫자가 아니면...
            if (!questNumArray.contains((number))){
                questNumArray.add(number)
            }

            //3개의 값을 다 받았으면 while를 빠져나와라..
            if (questNumArray.size == 3) {
                break
            }
        }

        for(num in questNumArray) {
            Log.d("출제숫자", num.toString())
        }
    }

    fun checkAnswer(){
        
        for(i in 0..2){
            for (j in 0..2){
                
            }
        }
        
    }
    
    override fun setupEvents() {
        inputBtn.setOnClickListener {
            var inputNum = inputEdt.text.toString()
            chatList.add(ChatData(inputNum, "ME"))

            chatAdapter?.notifyDataSetChanged()

            userInputNumArray.clear()                                   //들어있는 배열의값을 지운다.
            userInputNumArray.add(inputNum.toInt() / 100)               //앞 숫자 추출
            userInputNumArray.add((inputNum.toInt() / 10) % 10)         //가운데 숫자 추출
            userInputNumArray.add(inputNum.toInt() % 10)                //뒤 숫자 추출 
            
            chatListView.smoothScrollToPosition(chatList.size-1)
            
            checkAnswer()
        }

    }

    override fun setValues() {
        chatAdapter = ChatAdapter(this, chatList)
        chatListView.adapter = chatAdapter
    }

}
