package msku.ceng.madlab.tarimlaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.auth.User;

public class MainActivity extends AppCompatActivity {


    //private View fragmentView;
    static FirebaseAuth auth;
    static FirebaseUser user;
    static MainActivity mainActivity;

    private BottomNavigationView bottomNavigationView;

    boolean isFirstTime = true;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivity = MainActivity.this;

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();



        Constants.db = FirebaseFirestore.getInstance();

        if (user == null) {
            Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        } else {
            // User is not null, fetch data from the database
        }

        bottomNavigationView = findViewById(R.id.bottomNav);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.navHostFragment);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

    }


    public static void logOut(){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(mainActivity, LoginActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        mainActivity.startActivity(intent);
        mainActivity.finish();
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