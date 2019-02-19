package fr.isen.firstpackage.gothamcasino

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.firebase.ui.auth.AuthUI
import com.google.firebase.FirebaseApp
import kotlinx.android.synthetic.main.activity_post.*
import java.util.*



class PostActivity : AppCompatActivity() {

    private val RC_SIGN_IN = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_post)

        authButton.setOnClickListener {
            startSignInActivity()
        }

    }


    private fun startSignInActivity() {
        FirebaseApp.initializeApp(this)
        startActivityForResult(
            AuthUI.getInstance()
                .createSignInIntentBuilder()
                .setTheme(R.style.LoginTheme)
                .setAvailableProviders(
                    Arrays.asList(AuthUI.IdpConfig.EmailBuilder().build())
                )
                .setIsSmartLockEnabled(false, true)
                //.setLogo(R.drawable.ic_logo_auth)
                .build(),
            RC_SIGN_IN
        )
    }

}
