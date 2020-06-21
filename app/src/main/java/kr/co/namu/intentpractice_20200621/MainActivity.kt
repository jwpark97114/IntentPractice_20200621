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
    }
}