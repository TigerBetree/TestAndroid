package com.tiger.test.coordinatorlayout2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tiger.test.R;
import com.tiger.test.frag.BaseFragment;
import com.tiger.test.utils.LogUtil;


/**
 * Created by tiger on 2018/3/5.
 */

public class TestCLExploreFragment2 extends BaseFragment implements View.OnClickListener {

    private View layoutView;
    private RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        LogUtil.logd(this.getClass().getSimpleName() + " -> onCreateView.");
        layoutView = inflater.inflate(R.layout.fragment_explore2, container, false);
        return layoutView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        init();
    }

    private void init() {
        recyclerView = layoutView.findViewById(R.id.rc_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        String[] datas = new String[50];
        for (int i = 0; i < 50; i++) {
            datas[i] = "Explore_" + (i + 1);
        }
        MyAdapter myAdapter = new MyAdapter(datas);
        recyclerView.setAdapter(myAdapter);
    }

    @Override
    public void onClick(View v) {
    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
        public String[] datas = null;

        public MyAdapter(String[] datas) {
            this.datas = datas;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.story_item, viewGroup, false);
            ViewHolder vh = new ViewHolder(view);
            return vh;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
            viewHolder.storyText.setText(datas[position]);
        }

        //获取数据的数量
        @Override
        public int getItemCount() {
            return datas.length;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView storyText;

            public ViewHolder(View view) {
                super(view);
                storyText = (TextView) view.findViewById(R.id.story_text);
            }
        }
    }
}
