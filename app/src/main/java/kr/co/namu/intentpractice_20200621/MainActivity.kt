package kr.co.namu.intentpractice_20200621

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_NICKNAME = 1000;

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

        setNickNameBtn.setOnClickListener {
            val myIntent = Intent(this, EditNickNameActivity::class.java)
//            결과를 가지러 가는 이동은 startActivityForResult로 가야한다
//            이런 방식의 이동은 어떤 결과(닉네임, 비밀번호)를 가지러 가는지 숫자로 구별해야 한다 Ex. 1000번
            startActivityForResult(myIntent, REQ_FOR_NICKNAME)
        }
    }

    //          어떤 종류가 되었든, 결과를 가지고 돌아올때 실행되는 함수

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

//        이 함수가 실행된 이유 (어떤 요청?) => 1000번인가? => 닉 변경을 위한것인가?
        if (requestCode == REQ_FOR_NICKNAME) {

//            확인을 누른것이 맞는가? => 취소를 한게 아닌지?
            if(resultCode == Activity.RESULT_OK){

//                닉변화면에서 입력 첨부해준 newNickName String값을 저장
                val newNick = data?.getStringExtra("newNickName")

//                받아온 닉네임을 텍스트뷰에 표시
                nickNameTxt.text = newNick

            }
        }
    }
}