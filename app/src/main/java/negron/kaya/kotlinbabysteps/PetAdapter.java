package negron.kaya.kotlinbabysteps;

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
import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    private List<Pet> pets;
    private Context context;
    private OnClickListener listener;

    PetAdapter(Context context, OnClickListener listener) {
        pets = new ArrayList<>();
        this.listener = listener;
        this.context = context;
    }

    public void replaceData(List<Pet> pets){
        this.pets.clear();
        this.pets.addAll(pets);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PetViewHolder(LayoutInflater.from(context).inflate(R.layout.item_pet, parent, false), listener);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        holder.bindPet(pets.get(position));
    }

    @Override
    public int getItemCount() {
        return pets.size();
    }


    class PetViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private OnClickListener listener;
        TextView textNamePet;
        TextView textAgePet;
        CardView cardView;
        ImageView imgOwner;
        ImageView imgPet;

        public PetViewHolder(@NonNull View itemView, OnClickListener listener) {
            super(itemView);


            this.listener = listener;

            cardView = itemView.findViewById(R.id.card_view);
            textAgePet = itemView.findViewById(R.id.text_age_pet);
            textNamePet = itemView.findViewById(R.id.text_name_pet);
            imgOwner = itemView.findViewById(R.id.img_owner);
            imgPet = itemView.findViewById(R.id.img_pet);

            imgOwner.setOnClickListener(this);
            imgPet.setOnClickListener(this);
            cardView.setOnClickListener(this);
        }

        private void bindPet(Pet pet) {
            textNamePet.setText(pet.getName());
            textAgePet.setText(String.format(context.getString(R.string.format_age), pet.getAge()));
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.card_view:
                    listener.clickCard();
                    break;
                case R.id.img_owner:
                    Owner owner = pets.get(getAdapterPosition()).getOwner();
                    listener.showOwner(owner);
                    break;
                case R.id.img_pet:
                    Pet pet = pets.get(getAdapterPosition());
                    listener.showHumanAge(pet);
            }
        }
    }
}
