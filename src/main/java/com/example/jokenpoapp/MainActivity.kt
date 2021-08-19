package com.example.jokenpoapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btn_Papel.setOnClickListener {
            tv_Result.text = joga(0)
        }
        btn_Pedra.setOnClickListener {
            tv_Result.text = joga(1)
        }
        btn_Tesoura.setOnClickListener {
            tv_Result.text = joga(2)
        }
    }

    private fun joga(num: Int): String {
        iv_Comp.visibility = View.VISIBLE
        val comp = Random.nextInt(3)
        var end: String = ""
        when(comp) {
            0 -> iv_Comp.setImageDrawable(getDrawable(R.drawable.papel))
            1 -> iv_Comp.setImageDrawable(getDrawable(R.drawable.pedra))
            2 -> iv_Comp.setImageDrawable(getDrawable(R.drawable.tesoura))
        }

        if(comp == num){
            end = "Empate"
            tv_Result.setTextColor(Color.WHITE)
        }
        else if((comp == 0 && num == 1) || (comp == 1 && num == 2) || (comp == 2 && num == 0)) {
            end = "Perdeu Preiboy"
            tv_Result.setTextColor(Color.RED)
        }
        else {
            end = "Miserávi, acertô"
            tv_Result.setTextColor(Color.GREEN)
        }
        return end
    }
}
