package msku.ceng.madlab.tarimlaapp;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    //private View fragmentView;

    private BottomNavigationView bottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bottomNavigationView = findViewById(R.id.bottomNav);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);

        NavigationUI.setupWithNavController(bottomNavigationView, navHostFragment.getNavController());



        //MyOnBackPressedCallback callback = new MyOnBackPressedCallback(true, this);
        //getOnBackPressedDispatcher().addCallback(this, callback);

        //bottomNavigationView.setVisibility(View.INVISIBLE);

    }


    /*
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = findViewById(R.id.navHostFragment).getRootView();



        // Fragment'ın view'unu sakla
        fragmentView = rootView;

        return rootView;
    }
    */


/*
    private static class MyOnBackPressedCallback extends OnBackPressedCallback {

        private final MainActivity activity;

        public MyOnBackPressedCallback(boolean enabled, MainActivity activity) {
            super(enabled);
            this.activity = activity;
        }

        @Override
        public void handleOnBackPressed() {
            // Bu metod, geri tuşuna basıldığında çağrılır
            // Burada fragmenta özel işlemleri gerçekleştirebilirsiniz

            Fragment currentFragment = getCurrentFragment();

            if (currentFragment instanceof ProductDetailsPageFragment) {
                Navigation.findNavController(currentFragment.getView()).navigate(R.id.action_homeFragment_to_sellerProfileFragment);

                // İlgili fragmenta özel işlemler
                // Örneğin:
                // ((YourFragmentType) fragment).onBackPressed();
            }

            if (currentFragment instanceof SellerProfileFragment) {
                Navigation.findNavController(currentFragment.getView()).navigate(R.id.action_sellerProfileFragment_to_homeFragment);

                // İlgili fragmenta özel işlemler
                // Örneğin:
                // ((YourFragmentType) fragment).onBackPressed();
            }


            // Geri tuşu işlemi tamamlandığında, geri tuşunun varsayılan davranışını tetiklemek için çağırın
            if (isEnabled()) {
                currentFragment.requireActivity().onBackPressed();
            }
        }

        private Fragment getCurrentFragment() {
            // Mevcut fragmentı almak için
            FragmentManager fragmentManager = activity.getSupportFragmentManager();
            int fragmentCount = fragmentManager.getBackStackEntryCount();

            if (fragmentCount > 0) {
                // Son eklenen fragmentın adını al
                FragmentManager.BackStackEntry backEntry = fragmentManager.getBackStackEntryAt(fragmentCount - 1);
                String fragmentTag = backEntry.getName();

                // Fragmentı bul
                return fragmentManager.findFragmentByTag(fragmentTag);
            }

            return null;
        }
    }*/
}