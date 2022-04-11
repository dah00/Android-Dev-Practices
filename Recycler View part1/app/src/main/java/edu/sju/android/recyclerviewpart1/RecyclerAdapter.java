package edu.sju.android.recyclerviewpart1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.CountryViewHolder>{
    private ArrayList<String> countryNameList;
    private ArrayList<String> detailsLis;
    private ArrayList<Integer> imageList;

    private Context context;

    public RecyclerAdapter(ArrayList<String> countryNameList, ArrayList<String> detailsLis, ArrayList<Integer> imageList, Context context) {
        this.countryNameList = countryNameList;
        this.detailsLis = detailsLis;
        this.imageList = imageList;
        this.context = context;
    }

    @NonNull
    @Override
    public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_design, parent, false);

        return new CountryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        holder.textViewCountryName.setText(countryNameList.get(position));
        holder.textViewDetails.setText(detailsLis.get(position));
        holder.imageView.setImageResource(imageList.get(position));
        holder.cardView.setOnClickListener(view -> {
            if (position == 0){
                Toast.makeText(context, "You selected the United Kingdom Flag", Toast.LENGTH_SHORT).show();
            }
            else if (position == 1)
                Toast.makeText(context, "You selected the Australia Flag", Toast.LENGTH_SHORT).show();
            else if (position == 2)
                Toast.makeText(context, "You selected the USA Flag", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return countryNameList.size();
    }

    public class CountryViewHolder extends RecyclerView.ViewHolder {
        private TextView textViewCountryName, textViewDetails;
        private ImageView imageView;
        CardView cardView;

        public CountryViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewCountryName = itemView.findViewById(R.id.textViewCountryName);
            textViewDetails = itemView.findViewById(R.id.textViewDetail);
            imageView = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
