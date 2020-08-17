package com.orcchg.direcall.ui

import androidx.appcompat.app.AppCompatActivity
import com.orcchg.direcall.R
import com.orcchg.direcall.databinding.ActivityMainBinding
import com.orcchg.direcall.viewBindings

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding by viewBindings(ActivityMainBinding::inflate)
}
