package com.example.deltatask1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var bn=findViewById<Button>(R.id.btnnext)
        var score=0
        newQstn(score)
        bn.setOnClickListener{
            score=0
            newQstn(score)

        }


    }

    fun newQstn(score: Int) {


        var d: Int
        var m = Random.nextInt(1, 12)
        var y = Random.nextInt(1000, 2999)

        if (m == 2) {

            d = Random.nextInt(1, 28)
        }
        else {
            d = Random.nextInt(1, 30)
        }


        var tv3 = findViewById(R.id.textView3) as TextView
        tv3.text = "$d/$m/$y"


        var days =arrayOf("sunday","monday", "tuesday", "wednesday", "thursday", "friday","saturday")
        var bt1 = findViewById(R.id.button1) as Button
        var bt2 = findViewById(R.id.button2) as Button
        var bt3 = findViewById(R.id.button3) as Button
        var bt4 = findViewById(R.id.button4) as Button
        bt1.setClickable(true)
        bt2.setClickable(true)
        bt3.setClickable(true)
        bt4.setClickable(true)
        bt1.setBackgroundColor(getResources().getColor(R.color.blue))
        bt2.setBackgroundColor(getResources().getColor(R.color.blue))
        bt3.setBackgroundColor(getResources().getColor(R.color.blue))
        bt4.setBackgroundColor(getResources().getColor(R.color.blue))
        var a = arrayOf("a", "b", "c", "d", "e","f")
        var num = 0
        var i = 0

        var rd = result( d, m, y)
        var nw = arrayOf(bt1, bt2, bt3, bt4)
        bt1.text = days[rd]
        for (num in 0..6)
        {

            if (days[rd] != days[num])
            {

                a[i] = days[num]
                i++
            }

        }
        i = 1
        var j = 0
        var k = 0
        var z=0
        for (i in 1..3)
        {
            j = 0
            nw[i].text = a[Random.nextInt(0, 5-z)]
            for (j in 0..5-z)
            {
                k = j
                if (a[j] == nw[i].text)
                {
                    for (k in j..(5-z-1))
                    {
                        a[k] = a[k + 1]
                    }
                    z++
                }

            }

        }
        //to shuffle
        var temp="a"
        var p=0
        for(i in 0..3)
        {
            temp= nw[i].text as String
            p=Random.nextInt(0, 3)
            nw[i].text=nw[p].text
            nw[p].text=temp
        }

        bt1.setOnClickListener {

            final(bt1, days[rd], bt2, bt3, bt4,score)

        }
        bt2.setOnClickListener {

            final(bt2, days[rd], bt1, bt3, bt4, score)

        }
        bt3.setOnClickListener {

            final(bt3, days[rd], bt2, bt1, bt4, score)

        }
        bt4.setOnClickListener {

            final(bt4, days[rd], bt2, bt3, bt1, score)

        }
    }




    fun final(b1: Button, s: String, b2: Button, b3: Button, b4: Button, score: Int) {
        var score1=score

        if (b1.text == s) {
            b1.setBackgroundColor(getResources().getColor(R.color.green))

            score1=score1+5
            newQstn(score1)
        } else {
            b1.setBackgroundColor(getResources().getColor(R.color.red))
            var scr=findViewById<TextView>(R.id.textView4)
            scr.text="last score:$score1"
            if (b2.text == s)
                b2.setBackgroundColor(getResources().getColor(R.color.green))

            else if (b3.text == s)
                b3.setBackgroundColor(getResources().getColor(R.color.green))
            else if (b4.text == s)
                b4.setBackgroundColor(getResources().getColor(R.color.green))
            b1.setClickable(false)
            b2.setClickable(false)
            b3.setClickable(false)
            b4.setClickable(false)
        }
    }

    fun result(d:Int,m:Int,yr:Int): Int {
        var mt =arrayOf (0,3,2,5,0,3,5,1,4,6,2,4)
        var y=yr
        if(m<3)
            y-=1
        return ((y+y/4-y/100+y/400+mt[m-1]+d)%7)
    }

}

