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

    private val RC_SIGN_IN = 123
    private var isConnexion = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        authButton.setOnClickListener {
            startSignInActivity()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        super.onActivityResult(requestCode, resultCode, data)
        // 4 - Handle SignIn Activity response on activity result
        this.handleResponseAfterSignIn(requestCode, resultCode, data)
        if (isConnexion)
        {
            startActivity(Intent(this, WallActivity::class.java))
        } else {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun handleResponseAfterSignIn(requestCode: Int, resultCode: Int, data: Intent) {

        val response = IdpResponse.fromResultIntent(data)

        if (requestCode == RC_SIGN_IN) {
            if (resultCode == Activity.RESULT_OK) { // SUCCESS
                Log.d("-----------------------", "Connexion succeed")
                isConnexion = true
            } else { // ERRORS
                when {
                    response == null -> Log.d("-----------------------", "error_authentication_canceled")
                    response.error?.errorCode == ErrorCodes.NO_NETWORK -> Log.d("-----------------------", "error_no_internet")
                    response.error?.errorCode == ErrorCodes.UNKNOWN_ERROR -> Log.d("-----------------------", "error_unknown_error")
                }
            }
        }
    }

    private fun startSignInActivity() {
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
