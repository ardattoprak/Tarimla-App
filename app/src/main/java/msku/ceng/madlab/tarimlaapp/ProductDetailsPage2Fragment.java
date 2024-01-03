package msku.ceng.madlab.tarimlaapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ProductDetailsPage2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProductDetailsPage2Fragment extends Fragment {


    public static int position;

    private ImageButton backButton2;

    private View rootView;



    private TextView productName2;
    private TextView productDescription2;
    private TextView productListingDate2;
    private TextView productAmount2;
    private ImageView productImage2;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductDetailsPage2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductDetailsPage2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductDetailsPage2Fragment newInstance(String param1, String param2) {
        ProductDetailsPage2Fragment fragment = new ProductDetailsPage2Fragment();
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

        rootView = inflater.inflate(R.layout.fragment_product_details_page2, container, false);
        return rootView;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        backButton2 = view.findViewById(R.id.backImageButton1);
        productName2 = view.findViewById(R.id.productNameTextView);
        productDescription2 = view.findViewById(R.id.descriptionTextView);
        productListingDate2 = view.findViewById(R.id.listingDateTextView);
        productAmount2 = view.findViewById(R.id.amountTextView);
        productImage2 = view.findViewById(R.id.productImageView);

        ArrayList<Add> dbDenGelenVeri = Constants.Adds;


        Add add =dbDenGelenVeri.get(position);

        productName2.setText(add.productName );
        //productImage
        productDescription2.setText(add.description );
        //productListingDate.setText(add. );
        productAmount2.setText(add.price);


        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_productDetailsPage2Fragment_to_myAddsFragment);
            }
        });
    }


}