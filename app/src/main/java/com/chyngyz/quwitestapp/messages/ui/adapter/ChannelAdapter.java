package com.chyngyz.quwitestapp.messages.ui.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.AsyncListDiffer;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chyngyz.quwitestapp.R;
import com.chyngyz.quwitestapp.messages.model.Message;

import java.util.List;
import java.util.Objects;

public class ChannelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final AsyncListDiffer<Message> differ =
            new AsyncListDiffer<Message>(this, new DiffCallback());

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ChannelViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ChannelViewHolder) {
            ((ChannelViewHolder) holder).onBind(getItem(position));
        }
    }

    public Message getItem(int position) {
        return differ.getCurrentList().get(position);
    }

    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }

    public void submit(List<Message> items) {
        differ.submitList(items);
    }

    private class ChannelViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;
        private final TextView titleTextView;
        private final TextView messageTextView;

        public ChannelViewHolder(@NonNull ViewGroup parent) {
            this(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_chat, parent, false));
        }

        public ChannelViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            messageTextView = itemView.findViewById(R.id.descriptionTextView);
        }

        public void onBind(Message message) {
            String avatar = message.getUser().getAvatarUrl();
            if (avatar != null) {
                Glide.with(itemView).load(avatar).circleCrop().into(imageView);
            }
            titleTextView.setText(message.getUser().getName());
            messageTextView.setText(message.getLastMessage());
        }
    }

    private static class DiffCallback extends DiffUtil.ItemCallback<Message> {

        @Override
        public boolean areItemsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
            return Objects.equals(oldItem.getLastMessage(), newItem.getLastMessage());
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull Message oldItem, @NonNull Message newItem) {
            return oldItem == newItem;
        }
    }
}
