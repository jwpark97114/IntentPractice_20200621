package kr.co.namu.intentpractice_20200621

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nick_name.*

class EditNickNameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nick_name)

        okBtn.setOnClickListener {
//            새 화면을 실행하는게 아니라 기존 화면으로 복귀 + 입력한 닉네임을 결과로 가지고 복귀


//          입력한 닉네임 저장
            val nick = nickNameEdt.text.toString()

//            돌아갈 때 데이터를 첨부하는 용도의 Intent 생성 => 복귀시 출발지와 도착지 명시 X
            val myIntent = Intent()

//            데이터 첨부 putExtra
            myIntent.putExtra("newNickName", nick)

//            정말 반영해달라고 결과 설정 => 최종 OK + 왕복 티켓 첨부 (이 내부에 newNickName이 들어있다)
            setResult(Activity.RESULT_OK, myIntent)

//            모든 작업이 끝나면 최종적으로 복귀
            finish()
        }
    }

}