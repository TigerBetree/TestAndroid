package com.tiger.test.stickyheader;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiger.test.R;

public class TestStickyHeaderLayoutActivity extends AppCompatActivity {

    private RecyclerView recycler;
    private StickyHeaderLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_stickyheaderlayout);
        layout = findViewById(R.id.sh_layout);
        recycler = findViewById(R.id.recycler);

        layout.setShowStickItemPosition(5);
        layout.setOnStickItemStateChangeListener(new StickyHeaderLayout.OnStickItemStateChangeListener() {
            @Override
            public void onStickItemStateChanged(RecyclerView.ViewHolder holder, boolean visible) {
                if (holder instanceof MyAdapter.TopViewHolder) {
                    MyAdapter.TopViewHolder topViewHolder = (MyAdapter.TopViewHolder) holder;
                    topViewHolder.onTop(visible);
                }
            }
        });
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.setAdapter(new MyAdapter());
    }

    public class MyAdapter extends RecyclerView.Adapter {

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            if (viewType == StickyHeaderLayout.TYPE_STICKY_LAYOUT) {
                return new TopViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sticky_header, parent, false));
            } else {
                return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item, parent, false));
            }
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            if (getItemViewType(position) == StickyHeaderLayout.TYPE_STICKY_LAYOUT) {
                TopViewHolder vhTop = (TopViewHolder) holder;
            } else {
                MyViewHolder vh = (MyViewHolder) holder;
            }
        }

        @Override
        public int getItemCount() {
            return 40;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 5) {
                return StickyHeaderLayout.TYPE_STICKY_LAYOUT;
            } else {
                return super.getItemViewType(position);
            }
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;

            public MyViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv_text);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(textView.getContext(), "item点击", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }

        class TopViewHolder extends RecyclerView.ViewHolder {
            private TextView textView;

            public TopViewHolder(@NonNull View itemView) {
                super(itemView);
                textView = itemView.findViewById(R.id.tv_text);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(textView.getContext(), "头部点击", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            public void onTop(boolean onTop) {
                if (onTop) {
                    textView.setText("~~~~~OnTop~~~~~~");
                } else {
                    textView.setText("~~~~~~可置顶数据~~~~~~");
                }
            }
        }
    }
}
