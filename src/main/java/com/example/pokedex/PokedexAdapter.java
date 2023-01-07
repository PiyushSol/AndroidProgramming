package com.example.pokedex;

import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

public class PokedexAdapter extends RecyclerView.Adapter<PokedexAdapter.PokedexViewHolder>{
 public static class PokedexViewHolder extends RecyclerView.ViewHolder{
     public LinearLayout containerview;
     public TextView textView;
     PokedexViewHolder(View view){
         super(view);
         containerview =view.findViewById(R.id.pokedex_row);
          textView =view.findViewById(R.id.pokedex_row_text_view);

          containerview.setOnClickListener(new View.OnClickListener(){
              @Override
              public void onClick(View v){
                  Pokemon current = (Pokemon)containerview.getTag();
                  Intent intent = new Intent(v.getContext(),PokemonActivity.class);
                  intent.putExtra("name",current.getName());
                  intent.putExtra("number",current.getNumber());

                  v.getContext().startActivity(intent);
              }
          });
      }
    }

    private List<Pokemon> pokemon = Arrays.asList(
            new Pokemon("Bulbasur", 1),
            new Pokemon("Ivasaur",2),
            new Pokemon("Nanusaur",3)
    );

    @NonNull
    @Override
    public PokedexViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokedex_row,parent , false);
        return new PokedexViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokedexViewHolder holder, int position) {
       Pokemon current = pokemon.get(position);
       holder.textView.setText(current.getName());
       holder.containerview.setTag(current);
    }

    @Override
    public int getItemCount() {
        return pokemon.size();
    }
}
