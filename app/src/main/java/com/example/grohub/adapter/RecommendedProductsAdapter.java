 package com.example.grohub.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.grohub.R;
import com.example.grohub.Tomato;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

 public class RecommendedProductsAdapter extends RecyclerView.Adapter<RecommendedProductsAdapter.ViewHolder> {


    List<Integer> images;
    LayoutInflater inflater;

    private Context context;




    public RecommendedProductsAdapter(Context ctx,List<Integer> images){

        this.images=images;
        this.inflater = LayoutInflater.from(ctx);
        this.context = context;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.recommended_row_items,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.gridIcon.setImageResource(images.get(position));

      /*  holder.constraintLayout.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context.getApplicationContext(), Tomato.class);
                intent.putExtra("Images",images.get(position));
                intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                context.getApplicationContext().startActivity(intent);
            }
        });
*/

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView gridIcon;
        //ConstraintLayout constraintLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent i = new Intent(v.getContext(),Tomato.class);
                    i.putExtra("Images", images.get(getAdapterPosition()));
                    v.getContext().startActivity(i);
                }
            });


            gridIcon = itemView.findViewById(R.id.imageView4);
            //constraintLayout = itemView.findViewById(R.id.mainLayout);



        }


    }

}

