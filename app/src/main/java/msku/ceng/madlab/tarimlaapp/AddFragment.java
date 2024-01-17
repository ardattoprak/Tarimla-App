package msku.ceng.madlab.tarimlaapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class AddFragment extends Fragment {  // Written by Burak Yılmaz
    private Spinner productSpinner;
    private Spinner citySpinner;
    private ArrayList<String> spinnerProducts;
    private ArrayList<String> spinnerCities;
    private EditText amounTextView, descriptionTextView, priceTextView;
    private ArrayAdapter<String> productAdapter;
    private ArrayAdapter<String> cityAdapter;
    private FirebaseAuth mAuth;
    private FirebaseUser user;
    private Button saveButton;
    FirebaseFirestore db;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        user = mAuth.getCurrentUser();
        db = FirebaseFirestore.getInstance();

        amounTextView = view.findViewById(R.id.amountAddEditText);
        descriptionTextView = view.findViewById(R.id.DescriptionAddEditText);
        priceTextView = view.findViewById(R.id.PriceAddEditText);

        db = FirebaseFirestore.getInstance();

        productSpinner = view.findViewById(R.id.productSpinner);
        citySpinner = view.findViewById(R.id.citySpinner);

        saveButton = view.findViewById(R.id.saveButton);

        spinnerProducts = Constants.getProductSpinnerChoises();
        spinnerCities = Constants.getCitySpinnerChoices();

        productAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                spinnerProducts);

        cityAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                spinnerCities);

        productSpinner.setAdapter(productAdapter);
        citySpinner.setAdapter(cityAdapter);

        productSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(view.getContext(), "Product selected : " + spinnerProducts.get(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        citySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(view.getContext(), "Product selected : " + spinnerCities.get(position), Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String productName = spinnerProducts.get(productSpinner.getSelectedItemPosition());
                String city = spinnerCities.get(citySpinner.getSelectedItemPosition());

                String userEmail = user.getEmail();

                String amount = amounTextView.getText().toString();
                String description = descriptionTextView.getText().toString();
                String price = priceTextView.getText().toString();

                //BURALARA MESELA STRİNGLER BOŞ İSE RETURN YAPTIR FLN YAZILCAK

                Add add = new Add(productName,description,city,price, amount, userEmail);

                db.collection("Adds").add(add).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(view.getContext(), "Product Added ", Toast.LENGTH_SHORT).show();
                        Constants.getDatasFromDb();
                    }
                })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(view.getContext(), "Product Add failed ", Toast.LENGTH_SHORT).show();
                            }
                        });
                //Toast.makeText(view.getContext(), "Product selected : " + spinnerProducts.get(productSpinner.getSelectedItemPosition()), Toast.LENGTH_SHORT).show();
                //Toast.makeText(view.getContext(), "Product selected : " + spinnerCities.get(citySpinner.getSelectedItemPosition()), Toast.LENGTH_SHORT).show();
            }
        });
    }
}