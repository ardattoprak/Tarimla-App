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

public class ProductDetailsPage2Fragment extends Fragment { // Written by Arda Toprak
    public static int position;
    private ImageButton backButton2;
    private View rootView;
    private TextView productName2;
    private TextView productDescription2;
    private TextView productSellerEmail2;
    private TextView productAmount2;
    private TextView priceTextView2;
    private ImageView productImage2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_product_details_page2, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        backButton2 = view.findViewById(R.id.backImageButton1);
        productName2 = view.findViewById(R.id.productNameTextView);
        productDescription2 = view.findViewById(R.id.descriptionTextView);
        productSellerEmail2 = view.findViewById(R.id.sellersEmailTextView2);
        productAmount2 = view.findViewById(R.id.amountTextView);
        productImage2 = view.findViewById(R.id.productImageView);
        priceTextView2 = view.findViewById(R.id.priceTextView2);

        ArrayList<Add> dbDenGelenVeri = Constants.Adds;
        ArrayList<Add> tempAdds =  new ArrayList<>();

        String userEmail = MainActivity.user.getEmail();

        for (int i = 0; i < Constants.Adds.toArray().length; i++){
            Add add = dbDenGelenVeri.get(i);

            if (add.userEmail.equals(userEmail)){
                tempAdds.add(add);
            }
        }

        Add add = tempAdds.get(position);

        productName2.setText(add.productName );
        productDescription2.setText(add.description );
        productAmount2.setText(add.amount);
        productSellerEmail2.setText(userEmail.toString());
        productImage2.setImageResource(Constants.getImageId(add));
        priceTextView2.setText(add.price + "TL");

        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_productDetailsPage2Fragment_to_myAddsFragment);
            }
        });
    }
}