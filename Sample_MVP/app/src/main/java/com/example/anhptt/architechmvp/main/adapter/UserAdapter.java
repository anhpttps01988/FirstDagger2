package com.example.anhptt.architechmvp.main.adapter;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.anhptt.architechmvp.R;
import com.example.anhptt.architechmvp.login.pojo.User;

import java.util.List;

public class UserAdapter extends ArrayAdapter<User> {

    private List<User> mUser;

    public UserAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<User> objects) {
        super(context, resource, objects);
        this.mUser = objects;
    }

    static class ViewHolder {
        private TextView tvUser;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, null);
            holder.tvUser = convertView.findViewById(R.id.tv_user);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tvUser.setText(mUser.get(position).getUser());
        return convertView;
    }
}
