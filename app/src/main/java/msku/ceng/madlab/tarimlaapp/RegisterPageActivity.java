package msku.ceng.madlab.tarimlaapp;

import static java.security.AccessController.getContext;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class RegisterPageActivity extends AppCompatActivity {

    EditText nameText,lastNameText, emailText, passwordText, wareHouseText, phoneNumberText;
    TextView goToLoginPageText;
    Button registerButton;
    ProgressBar progressBar1;
    private FirebaseAuth mAuth;

    private Spinner cityRegisterSpinner;

    private ArrayList<String> spinnerCitiesRegister;

    private ArrayAdapter<String> cityRegisterAdapter;


    FirebaseFirestore dbb ;

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent intent = new Intent(RegisterPageActivity.this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        mAuth = FirebaseAuth.getInstance();

        nameText = findViewById(R.id.name_signup_edit_text);
        lastNameText = findViewById(R.id.last_name_signup_edit_text);
        emailText = findViewById(R.id.email_signup_edit_text);
        passwordText = findViewById(R.id.password_signup_edit_text);
        wareHouseText = findViewById(R.id.warehouse_capacity_signup_edit_text);
        phoneNumberText = findViewById(R.id.phone_number_signup_edit_text);
        registerButton = findViewById(R.id.register_signup_button);
        progressBar1 = findViewById(R.id.progressBar1);
        goToLoginPageText = findViewById(R.id.gotToLogin);

        cityRegisterSpinner = findViewById(R.id.cityRegisterSpinner);

        spinnerCitiesRegister = Constants.getCitySpinnerChoices();

        cityRegisterAdapter = new ArrayAdapter<>(getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                spinnerCitiesRegister);

        cityRegisterSpinner.setAdapter(cityRegisterAdapter);


        cityRegisterSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                //Toast.makeText(view.getContext(), "Product selected : " + spinnerCities.get(position), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        goToLoginPageText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterPageActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email, password, name, lastName, wareHouse, phoneNumber;

                name = String.valueOf(nameText.getText());
                lastName = String.valueOf(lastNameText.getText());
                email = String.valueOf(emailText.getText());
                password = String.valueOf(passwordText.getText());
                wareHouse = String.valueOf(wareHouseText.getText());
                phoneNumber = String.valueOf(phoneNumberText.getText());
                String city = spinnerCitiesRegister.get(cityRegisterSpinner.getSelectedItemPosition());



                if (TextUtils.isEmpty(name)) {
                    Toast.makeText(RegisterPageActivity.this,"Enter name",Toast.LENGTH_LONG);
                    return;
                }
                if (TextUtils.isEmpty(lastName)) {
                    Toast.makeText(RegisterPageActivity.this,"Enter lastname",Toast.LENGTH_LONG);
                    return;
                }

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(RegisterPageActivity.this,"Enter email",Toast.LENGTH_LONG);
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(RegisterPageActivity.this,"Enter Password",Toast.LENGTH_LONG);
                    return;
                }

                if (TextUtils.isEmpty(wareHouse)) {
                    Toast.makeText(RegisterPageActivity.this,"Enter warehouse",Toast.LENGTH_LONG);
                    return;
                }
                if (TextUtils.isEmpty(phoneNumber)) {
                    Toast.makeText(RegisterPageActivity.this,"Enter phoneNumber",Toast.LENGTH_LONG);
                    return;
                }
                if (TextUtils.isEmpty(city)) {
                    Toast.makeText(RegisterPageActivity.this,"Enter city",Toast.LENGTH_LONG);
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                UsersInfo user = new UsersInfo(name,lastName,email,wareHouse,phoneNumber,city);
                                if (task.isSuccessful()) {
                                    Constants.setUsersToDb(user);
                                    // Sign in success, update UI with the signed-in user's information
                                    // BURAYI BEN KAPADIM FirebaseUser user = mAuth.getCurrentUser();
                                    Toast.makeText(RegisterPageActivity.this, "Account Created.",
                                            Toast.LENGTH_SHORT).show();

                                } else {
                                    // If sign in fails, display a message to the user.

                                    Toast.makeText(RegisterPageActivity.this, "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();
                                    return;
                                }

                            }
                        });
            }
        });
    }
}