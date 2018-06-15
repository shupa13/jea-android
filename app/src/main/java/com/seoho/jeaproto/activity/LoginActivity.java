package com.seoho.jeaproto.activity;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;
import com.seoho.jeaproto.R;

public class LoginActivity extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    ImageButton login_google_custom, login_facebook_custom;
    SignInButton googlebutton;
    LoginButton loginButton;

    private static final int RC_SIGN_IN = 10;
    private GoogleSignInClient mGoogleSignInClient;
    private FirebaseAuth mAuth;

    private EditText editTextEmail;
    private EditText editTextPassword;

    private CallbackManager mCallbackManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();

        // 구글 로그인

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        login_google_custom = (ImageButton)findViewById(R.id.login_google_custom);
        login_google_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

        googlebutton = (SignInButton)findViewById(R.id.login_google);
        googlebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signInIntent = mGoogleSignInClient.getSignInIntent();
                startActivityForResult(signInIntent, RC_SIGN_IN);
            }
        });

        // 이메일 로그인

        editTextEmail = (EditText)findViewById(R.id.editText_email);
        editTextPassword = (EditText)findViewById(R.id.editText_password);

        Button emailLogin = (Button)findViewById(R.id.email_login_button);
        emailLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createUser(editTextEmail.getText().toString(), editTextPassword.getText().toString());
            }
        });

        // 페이스북 로그인
        mCallbackManager = CallbackManager.Factory.create();

        login_facebook_custom = (ImageButton)findViewById(R.id.login_facebook_custom);
        login_facebook_custom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginButton.performClick();
            }
        });
        loginButton = findViewById(R.id.login_facebook);
        loginButton.setReadPermissions("email", "public_profile");
        loginButton.registerCallback(mCallbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                handleFacebookAccessToken(loginResult.getAccessToken());
            }
            public void onCancel() {
            }
            public void onError(FacebookException error) {
            }
        });
    }
    private void handleFacebookAccessToken(AccessToken token) {
        AuthCredential credential = FacebookAuthProvider.getCredential(token.getToken());
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this,"페이스북 로그인 성공",Toast.LENGTH_LONG).show();
                            MenuHome();
                        } else {
                            Toast.makeText(LoginActivity.this,"페이스북 로그인 실패",Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    private void createUser(String email, String password){
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this,"이메일 로그인 성공", Toast.LENGTH_LONG).show();
                            MenuHome();
                        } else {
                            Toast.makeText(LoginActivity.this,"이메일 로그인 실패", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mCallbackManager.onActivityResult(requestCode, resultCode, data);


        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                firebaseAuthWithGoogle(account);
            } catch (ApiException e) {
            }
        }
    }
    private void firebaseAuthWithGoogle(GoogleSignInAccount acct) {

        AuthCredential credential = GoogleAuthProvider.getCredential(acct.getIdToken(), null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "구글 로그인 성공", Toast.LENGTH_LONG).show();
                            MenuHome();
                        } else{
                            Toast.makeText(LoginActivity.this, "구글 로그인 실패", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
    }
    public void MenuHome(){
        Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
        startActivity(intent);
        finish();
    }
}