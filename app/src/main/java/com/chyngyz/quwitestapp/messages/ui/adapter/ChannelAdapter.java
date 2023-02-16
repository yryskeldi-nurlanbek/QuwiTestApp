package com.chyngyz.quwitestapp.messages.ui.adapter;

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
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChannelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final AsyncListDiffer<Channel> differ = new AsyncListDiffer<Channel>(this, new DiffCallback());

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

    public Channel getItem(int position) {
        return differ.getCurrentList().get(position);
    }

    @Override
    public int getItemCount() {
        return differ.getCurrentList().size();
    }

    public void submit(List<Channel> items) {
        differ.submitList(items);
    }

    public class ChannelsResponse {
        @SerializedName("channels")
        List<ChannelResponse> channels;
    }

    public enum ChannelType {
        @SerializedName("pm") PM,
        @SerializedName("custom") CUSTOM;
    }

    public class ChannelResponse {
        @SerializedName("id")
        private String id;
        @SerializedName("type")
        private ChannelType type;
        @SerializedName("dta_created")
        private String createdAt;
        @SerializedName("id_partner")
        private String partnerId;
        @SerializedName("message_last")
        private String lastMessage;
    }

//    public class Mapper {
//        public List<Channel> fromNetwork(List<ChannelResponse> items) {
//            return
//        }
//
//        public static Channel fromNetwork(ChannelResponse value) {
//            return new Channel(
//                    value.id,
//
//                    );
//        }
//    }

    public class Channel {
        private String id;
        private String avatarUrl;
        private String name;
        private String lastMessage;
        private ChannelType type;

        public Channel(String id, String avatarUrl, String name, String lastMessage, ChannelType type) {
            this.id = id;
            this.avatarUrl = avatarUrl;
            this.name = name;
            this.lastMessage = lastMessage;
            this.type = type;
        }

        public String getId() {
            return "";
        }

        public String getAvatarUrl() {
            return "";
        }

        public String getChannelName() {
            return "";
        }

        public String getLastMessage() {
            return "";
        }

        public boolean isSelfMessage() {
            return false;
        }
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

        public void onBind(Channel Channel) {
            Glide.with(itemView).load(Channel.getAvatarUrl()).into(imageView);
            titleTextView.setText(Channel.getChannelName());
            messageTextView.setText(Channel.getLastMessage());
            messageTextView.setVisibility(Channel.isSelfMessage() ? View.INVISIBLE : View.VISIBLE);
        }
    }

    private class DiffCallback extends DiffUtil.ItemCallback<Channel> {

        @Override
        public boolean areItemsTheSame(@NonNull Channel oldItem, @NonNull Channel newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Channel oldItem, @NonNull Channel newItem) {
            return oldItem == newItem;
        }
    }
}
