package msku.ceng.madlab.tarimlaapp;



import static android.content.ContentValues.TAG;

import android.graphics.drawable.Drawable;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Constants {


    public static ArrayList<Add> Adds = new ArrayList<>();




    static FirebaseFirestore db ;

    public static void getDatasFromDb() {

        db.collection("Adds")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if (task.isSuccessful()) {
                            ArrayList<Add> addsTemp = new ArrayList<>();

                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Log.d(TAG, document.getId() + " => " + document.getData());

                                Add add = new Add(document.getString("productName"),document.getString("description"),document.getString("city"),document.getString("price"),document.getString("amount"),document.getString("userEmail"));
                                // Or if you have setter methods
                                // Add add = new Add();
                                // add.setId(document.getId());
                                // add.setSomeProperty(document.getString("someProperty"));

                                // Add the created Add object to your list or perform any other operations
                                addsTemp.add(add);
                            }
                            Adds = addsTemp;
                        } else {
                            Log.d(TAG, "Error getting documents: ", task.getException());
                        }
                    }
                });
    }


    public static ArrayList<String> getProductSpinnerChoises(){
        ArrayList<String> products  = new ArrayList<>();

        String product1 = "Tomato";
        String product2 = "Onion";
        String product3 = "Milk";
        String product4 = "Potatoes";
        String product5 = "Apple";


        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        return products;
    }

    public static ArrayList<String> getCitySpinnerChoises(){
        ArrayList<String> cities  = new ArrayList<>();

        String city1 = "Adana";
        String city2 = "Adıyaman";
        String city3 = "Afyonkarahisar";
        String city4 = "Ağrı";
        String city5 = "Amasya";


        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);
        cities.add(city5);

        return cities;
    }

}
