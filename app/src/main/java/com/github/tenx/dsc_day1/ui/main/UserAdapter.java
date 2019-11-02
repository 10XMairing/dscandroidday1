package com.github.tenx.dsc_day1.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.tenx.dsc_day1.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserAdapter  extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private Context context;
    private List<String> mList;

    public UserAdapter(Context context) {
        this.context = context;
        mList = new ArrayList<>();
    }


    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View v = LayoutInflater.from(context).inflate(R.layout.listitem_user, parent, false);

        return new UserViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        String name = mList.get(position);
        holder.tvName.setText(name);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setListData(List<String> newData){
        this.mList = newData;
        notifyDataSetChanged();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvName;
        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_username);
        }
    }
}
