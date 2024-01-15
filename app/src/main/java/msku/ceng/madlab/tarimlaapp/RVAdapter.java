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

    private static int position;

    public RVAdapter(Context mcontext, ArrayList<Add> addList) {
        this.mcontext = mcontext;
        this.addList = addList;

    }
    @Override
    public void onBindViewHolder(@NonNull cardViewTasarimNesneleriniTutucu holder, @SuppressLint("RecyclerView") int position) {
        Add add = addList.get(position);

        //holder.productImageCardView.setImageDrawable(row.imageView);
        holder.productNameTextCardView.setText(add.productName);
        holder.cityTextCardView.setText(add.city);
        holder.priceTextCardView.setText(add.price);
        holder.descriptionTextCardView.setText(add.description);

        holder.productImageCardView.setImageResource(Constants.getImageId(add));

        holder.satirCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProductDetailsPageFragment.position = position;
                ProductDetailsPage2Fragment.position = position;



                HomeFragment.goToProductDetails();
            }
        });
    }

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
