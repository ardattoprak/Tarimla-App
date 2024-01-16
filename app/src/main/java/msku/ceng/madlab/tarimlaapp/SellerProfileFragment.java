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
import android.widget.TextView;

public class SellerProfileFragment extends Fragment {
    private View rootView;
    private ImageButton backButton1;
    private Button logOutButton;
    private TextView nameText;
    private TextView phoneText;
    private TextView emailText;
    private TextView cityText;
    private TextView wareHouseCapacity;
    UsersInfo user = null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_seller_profile, container, false);
        return rootView;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        backButton1 = view.findViewById(R.id.backImageButton1);
        logOutButton = view.findViewById(R.id.logOutButton);

        nameText = view.findViewById(R.id.userNameText);
        phoneText = view.findViewById(R.id.phoneNumberText);
        emailText = view.findViewById(R.id.userEmailText);
        cityText = view.findViewById(R.id.userCityText);
        wareHouseCapacity = view.findViewById(R.id.userWareHouseCapacity);

        String userEmail = MainActivity.user.getEmail();

        for (int i = 0; i < Constants.Users.toArray().length; i++){
            String email = Constants.Users.get(i).email;

            if (userEmail.equals(email)){
                user = Constants.Users.get(i);
            }
        }

        nameText.setText(user.name);
        phoneText.setText(user.phoneNumber);
        emailText.setText(user.email);
        cityText.setText(user.city);
        wareHouseCapacity.setText(user.wareHouseCapacity);
        backButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_sellerProfileFragment_to_homeFragment);
            }
        });
        logOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.logOut();
            }
        });
    }
}