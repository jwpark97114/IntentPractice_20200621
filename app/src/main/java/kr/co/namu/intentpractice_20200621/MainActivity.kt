package kr.co.namu.intentpractice_20200621

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        firstActivityBtn.setOnClickListener {
//            Intent 객체를 생성 (비행기 티켓 발권과 비슷)
            val myIntent = Intent(this, FirstActivity::class.java)
//            실제로 인텐트 사용(비행기 탑승 or 출발)
            startActivity(myIntent)
        }

        secondActivityBtn.setOnClickListener {
            val myIntent = Intent(this, SecondActivity::class.java)
            startActivity(myIntent)
//            ctrl alt L (윈도우) Cmd option L (맥)  => 들여쓰기 자동 정리

        }

        goToThirdBtn.setOnClickListener {
//            1.적혀있는 메세지를 받아서 => 2. 화면이동시 전달

//            메세지 내용을 변수에 저장
            val inputMessage = messageEdt.text.toString()

//            화면이동 코드부터 작성
            val myIntent = Intent(this, ThirdActivity::class.java)
//            인텐트에 추가 데이터를 첨부; 이름표/ 실제값 쌍으로 첨부.
            myIntent.putExtra("message", inputMessage)
            startActivity(myIntent)
        }
    }
}