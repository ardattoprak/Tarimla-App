package msku.ceng.madlab.tarimlaapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class ProductDetailsPageFragment extends Fragment {


    private ImageButton backButton1;

    private View rootView;



    private TextView productName;
    private TextView productDescription;
    private TextView productSellerEmail1;
    private TextView productAmount;
    private ImageView productImage;




    public static int position;




    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ProductDetailsPageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProductDetailsPageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProductDetailsPageFragment newInstance(String param1, String param2) {
        ProductDetailsPageFragment fragment = new ProductDetailsPageFragment();
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



    //ÖRNEK KOD
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_product_details_page, container, false);

        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        backButton1 = view.findViewById(R.id.backImageButton1);
        productName = view.findViewById(R.id.productNameTextView);
        productDescription = view.findViewById(R.id.descriptionTextView);
        productSellerEmail1 = view.findViewById(R.id.sellersEmailTextView);
        productAmount = view.findViewById(R.id.amountTextView);
        productImage = view.findViewById(R.id.productImageView);


        ArrayList<Add> dbDenGelenVeri = Constants.Adds;

        Add add =dbDenGelenVeri.get(position);

        productName.setText(add.productName );
        //productImage
        productDescription.setText(add.description );
        //productListingDate.setText(add. );
        productAmount.setText(add.price);
        productSellerEmail1.setText(add.userEmail);
        productImage.setImageResource(Constants.getImageId(add));

        //BURAYA İF ELSE İLE YAZICAZ R.İD.RESMİN İSMİ FALAN YAPICAZ KOALY İŞ
        //productImage.setImageResource();


        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_productDetailsPageFragment_to_homeFragment);
            }
        });




    }

}