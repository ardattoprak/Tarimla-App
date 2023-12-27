package msku.ceng.madlab.tarimlaapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.cardViewTasarimNesneleriniTutucu> {
    private Context mcontext;
    private ArrayList<Add> addList;
    private Fragment fragment;

    public RVAdapter(Context mcontext, ArrayList<Add> addList) {
        this.mcontext = mcontext;
        this.addList = addList;
        this.fragment = fragment;
    }
    @Override
    public void onBindViewHolder(@NonNull cardViewTasarimNesneleriniTutucu holder, @SuppressLint("RecyclerView") int position) {
        Add add = addList.get(position);

        //holder.productImageCardView.setImageDrawable(row.imageView);
        holder.productNameTextCardView.setText(add.productName);
        holder.cityTextCardView.setText(add.city);
        holder.priceTextCardView.setText(add.price);
        holder.descriptionTextCardView.setText(add.description);

        holder.satirCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bu func u kullanarak segue yi çalıştırız, veya bu olmazsa position öğesini gerekli fragment dosyasındaki functiona yollarız.
                //handleButtonClick();




                Toast.makeText(mcontext,"Row number : " + position,Toast.LENGTH_LONG).show();
            }
        });
    }

/*  
    private void handleButtonClick() {
        // Eğer şuanki fragment MyAddsFragment ise
        if (getFragmentManager().findFragmentById(R.id.nav_host_fragment) instanceof MyAddsFragment) {
            // action_myAddsFragment_to_productDetailsPageFragment aksiyonunu kullan
            Bundle bundle = new Bundle();
            bundle.putInt("clickedIndex", 1); // Tıklandığı değeri buradan alabilirsiniz
            Navigation.findNavController(requireView()).navigate(R.id.action_myAddsFragment_to_productDetailsPageFragment, bundle);
        } else if (getFragmentManager().findFragmentById(R.id.nav_host_fragment) instanceof HomeFragment) {
            // Eğer şuanki fragment HomeFragment ise
            // action_productDetailsPageFragment_to_homeFragment aksiyonunu kullan
            Bundle bundle = new Bundle();
            bundle.putInt("clickedIndex", 1); // Tıklandığı değeri buradan alabilirsiniz
            Navigation.findNavController(requireView()).navigate(R.id.action_productDetailsPageFragment_to_homeFragment, bundle);
        }
    }*/
    //CLASSS



    @NonNull
    @Override
    public cardViewTasarimNesneleriniTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim, parent, false);
        return new cardViewTasarimNesneleriniTutucu(itemView);
    }



    @Override
    public int getItemCount() {
        return addList.size();
    }

    public class cardViewTasarimNesneleriniTutucu extends RecyclerView.ViewHolder {
        public CardView satirCardView;
        public ImageView productImageCardView;
        public TextView productNameTextCardView;
        public TextView cityTextCardView;
        public TextView priceTextCardView;
        public TextView descriptionTextCardView;

        public cardViewTasarimNesneleriniTutucu(View view) {
            super(view);

            satirCardView = view.findViewById(R.id.satirCardView);
            productImageCardView = view.findViewById(R.id.productImageCardView);
            productNameTextCardView = view.findViewById(R.id.productNameTextCardView);
            cityTextCardView = view.findViewById(R.id.cityTextCardView);
            priceTextCardView = view.findViewById(R.id.priceTextCardView);
            descriptionTextCardView = view.findViewById(R.id.descriptionTextCardView);
        }
    }

}
