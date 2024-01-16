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
import java.util.ArrayList;

public class MyAddsFragment extends Fragment {
    private RecyclerView rv2;
    private ArrayList<Add> adds;
    private RVAdapter2 adapter;
    public static View v2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_my_adds, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        adds = Constants.Adds;

        ArrayList<Add> tempAdds =  new ArrayList<>();

        String userEmail = MainActivity.user.getEmail();
        for (int i = 0; i < Constants.Adds.toArray().length; i++){
            Add add = adds.get(i);

            if (add.userEmail.equals(userEmail)){
               tempAdds.add(add);
            }
        }
        adapter = new RVAdapter2(getContext(),tempAdds);

        rv2 = view.findViewById(R.id.rv);
        rv2.setHasFixedSize(true);
        rv2.setLayoutManager(new LinearLayoutManager(getContext()));
        rv2.setAdapter(adapter);
        this.v2 =view;
    }
    public static void goToProductDetails(){
        Navigation.findNavController(v2).navigate(R.id.action_myAddsFragment_to_productDetailsPage2Fragment);
    }



}