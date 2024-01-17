package msku.ceng.madlab.tarimlaapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;


public class RVAdapter2 extends RecyclerView.Adapter<RVAdapter2.cardViewTasarimNesneleriniTutucu2> { // Written by Arda Toprak
    private Context mcontext;
    private ArrayList<Add> addList;

    public RVAdapter2(Context mcontext, ArrayList<Add> addList) {
        this.mcontext = mcontext;
        this.addList = addList;
    }
    @Override
    public void onBindViewHolder(@NonNull cardViewTasarimNesneleriniTutucu2 holder, @SuppressLint("RecyclerView") int position) {
        Add add = addList.get(position);

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
                MyAddsFragment.goToProductDetails();
            }
        });
    }

    @NonNull
    @Override
    public cardViewTasarimNesneleriniTutucu2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_tasarim, parent, false);
        return new cardViewTasarimNesneleriniTutucu2(itemView2);
    }
    @Override
    public int getItemCount() {
        return addList.size();
    }

    public class cardViewTasarimNesneleriniTutucu2 extends RecyclerView.ViewHolder {
        public CardView satirCardView;
        public ImageView productImageCardView;
        public TextView productNameTextCardView;
        public TextView cityTextCardView;
        public TextView priceTextCardView;
        public TextView descriptionTextCardView;

        public cardViewTasarimNesneleriniTutucu2(View view) {
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
