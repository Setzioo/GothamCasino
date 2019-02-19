package fr.isen.firstpackage.gothamcasino

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import kotlinx.android.synthetic.main.activity_post.*
import java.util.*
import android.content.Intent
import android.app.Activity
import android.util.Log
import com.firebase.ui.auth.ErrorCodes
import com.firebase.ui.auth.IdpResponse


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }
}
