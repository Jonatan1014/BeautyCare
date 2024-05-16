package com.example.beautycare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEW_TYPE_USER_MESSAGE = 1;
    private static final int VIEW_TYPE_BOT_MESSAGE = 2;

    private List<Message> messageList;

    public ChatAdapter(List<Message> messageList) {
        this.messageList = messageList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == VIEW_TYPE_USER_MESSAGE) {
            View userMessageView = inflater.inflate(R.layout.item_user_message, parent, false);
            return new UserMessageViewHolder(userMessageView);
        } else {
            View botMessageView = inflater.inflate(R.layout.item_bot_message, parent, false);
            return new BotMessageViewHolder(botMessageView);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Message message = messageList.get(position);
        if (holder instanceof UserMessageViewHolder) {
            ((UserMessageViewHolder) holder).bind(message);
        } else if (holder instanceof BotMessageViewHolder) {
            ((BotMessageViewHolder) holder).bind(message);
        }
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    @Override
    public int getItemViewType(int position) {
        Message message = messageList.get(position);
        return message.isUserMessage() ? VIEW_TYPE_USER_MESSAGE : VIEW_TYPE_BOT_MESSAGE;
    }

    private static class UserMessageViewHolder extends RecyclerView.ViewHolder {
        TextView textViewUserMessage;

        UserMessageViewHolder(View itemView) {
            super(itemView);
            textViewUserMessage = itemView.findViewById(R.id.text_view_user_message);
        }

        void bind(Message message) {
            textViewUserMessage.setText(message.getMessage());
        }
    }

    private static class BotMessageViewHolder extends RecyclerView.ViewHolder {
        TextView textViewBotMessage;

        BotMessageViewHolder(View itemView) {
            super(itemView);
            textViewBotMessage = itemView.findViewById(R.id.text_view_bot_message);
        }

        void bind(Message message) {
            textViewBotMessage.setText(message.getMessage());
        }
    }
}
