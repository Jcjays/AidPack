package com.example.aidpack;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] _title;
    private int[] _img;
    private final Context _context;
    private String[] _links;

    private String[] _description_1;
    private String[] _description_2;
    private String[] _description_3;
    private String[] _description_4;
    private String[] _description_5;
    private String[] _description_6;


    public MyAdapter(Context ct, String[] Title, int[] images, String[] description, String[] description_2, String[] description_3, String[] description_4, String[] description_5, String[] description_6, String[] links){
        this._title = Title;
        this._img = images;
        this._context = ct;
        this._links = links;

        this._description_1 = description;
        this._description_2 = description_2;
        this._description_3 = description_3;
        this._description_4 = description_4;
        this._description_5 = description_5;
        this._description_6 = description_6;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(_context);
        View view = inflater.inflate(R.layout.first_aid_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder._firstAidTitle.setText(_title[position]);
        holder._firstAidImage.setImageResource(_img[position]);
        holder._firstAidLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(_context, FirstAidDisplayInfo.class);
                intent.putExtra("image_1", _img[position]);
                intent.putExtra("youtubelinks", _links[position]);
                intent.putExtra("description_1", _description_1[position]);
                intent.putExtra("description_2", _description_2[position]);
                intent.putExtra("description_3", _description_3[position]);
                intent.putExtra("description_4", _description_4[position]);
                intent.putExtra("description_5", _description_5[position]);
                intent.putExtra("description_6", _description_6[position]);
                _context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return _title.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView _firstAidTitle;
        ImageView _firstAidImage;
        ConstraintLayout _firstAidLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            _firstAidTitle = itemView.findViewById(R.id.first_aid_service_title);
            _firstAidImage = itemView.findViewById(R.id.first_aid_service_icons);
            _firstAidLayout = itemView.findViewById(R.id.first_aid_service_layout);
        }
    }
}
