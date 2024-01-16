package msku.ceng.madlab.tarimlaapp;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import java.util.ArrayList;

public class HomeFragment extends Fragment  {
    private RecyclerView rv;
    private ArrayList<Add> adds;
    private RVAdapter adapter;
    private ImageButton accountButton;
    public static View v;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Constants.getDatasFromDb();
        Constants.getUsersFromDb();
        adds = Constants.Adds;
        adapter = new RVAdapter(getContext(),adds);  //getApplicationConcept de yazxabilridik glb

        rv = view.findViewById(R.id.rvHome);
        rv.setHasFixedSize(true);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.setAdapter(adapter);

        this.v =view;

        accountButton = view.findViewById(R.id.imageAccountButton);
        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_sellerProfileFragment);
            }
        }
        );
    }
    public static void goToProductDetails(){
        Navigation.findNavController(v).navigate(R.id.action_homeFragment_to_productDetailsPageFragment);
    }
}