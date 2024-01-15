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
import com.google.firebase.Firebase;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;


public class AddFragment extends Fragment {

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

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

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