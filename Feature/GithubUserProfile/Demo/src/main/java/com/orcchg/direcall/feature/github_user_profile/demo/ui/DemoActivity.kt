package com.orcchg.direcall.feature.github_user_profile.demo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.fragment.app.commit
import com.orcchg.direcall.androidutil.viewBindings
import com.orcchg.direcall.feature.github_user_profile.demo.R
import com.orcchg.direcall.feature.github_user_profile.demo.databinding.ActivityDemoBinding
import com.orcchg.direcall.feature.github_user_profile.ui.presentation.ui.GithubUserProfileFragment

class DemoActivity : AppCompatActivity(R.layout.activity_demo) {

    private val binding by viewBindings(ActivityDemoBinding::inflate)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState ?:
            supportFragmentManager.commit {
                replace(
                    binding.flContainer.id,
                    GithubUserProfileFragment().apply {
                        arguments = bundleOf("login" to "orcchg")
                    },
                    "GithubUserProfileFragmentTag"
                )
            }
    }
}
