package com.example.attempt2

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var fragmentFlag = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //val intent = Intent(this, SecondActivity::class.java)
        //startActivity(intent)

        if (savedInstanceState == null) {
          supportFragmentManager
              .beginTransaction()
              .replace(R.id.main_fragment, FragmentA())
              .commit()
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            val frag = if (fragmentFlag) FragmentB() else FragmentA()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.main_fragment, frag)
                .commit()
            fragmentFlag = !fragmentFlag

        }
    }
}