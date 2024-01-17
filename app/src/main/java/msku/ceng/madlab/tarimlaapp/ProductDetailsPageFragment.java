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

public class ProductDetailsPageFragment extends Fragment { // Written by Arda Toprak
    private ImageButton backButton1;
    private View rootView;
    private TextView productName;
    private TextView productDescription;
    private TextView productSellerEmail1;
    private TextView productAmount;
    private TextView priceView;
    private ImageView productImage;
    public static int position;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
        priceView = view.findViewById(R.id.priceTextView);

        ArrayList<Add> dbDenGelenVeri = Constants.Adds;
        Add add =dbDenGelenVeri.get(position);

        productName.setText(add.productName );
        productDescription.setText(add.description );
        productAmount.setText(add.amount);
        priceView.setText(add.price + "TL");
        productSellerEmail1.setText(add.userEmail);
        productImage.setImageResource(Constants.getImageId(add));

        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_productDetailsPageFragment_to_homeFragment);
            }
        });
    }
}