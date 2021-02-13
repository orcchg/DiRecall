package com.orcchg.direcall.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.orcchg.direcall.R
import toothpick.ktp.KTP

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        KTP.openRootScope()
            .openSubScope(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        KTP.closeScope(this)
    }
}
