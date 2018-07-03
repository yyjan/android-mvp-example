package com.example.yun.androidmvpexample.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.yun.androidmvpexample.R;
import com.example.yun.androidmvpexample.data.Document;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemDetailActivity extends AppCompatActivity implements ItemDetailContract.View {

    public static final String EXTRA_DOCUMENT_LIST = "DOCUMENT_LIST";
    public static final String EXTRA_DOCUMENT_POSITION = "DOCUMENT_POSITION";

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private ItemDetailContract.Presenter presenter;

    private List<Document> items = new ArrayList<>();
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        items = (List<Document>) getIntent().getSerializableExtra(EXTRA_DOCUMENT_LIST);
        position = getIntent().getIntExtra(EXTRA_DOCUMENT_POSITION, 0);

        viewpager.setAdapter(new ViewPagerAdapter());
        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                showTitle(items.get(position).getTitle());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        presenter = new ItemDetailPresenter();
        presenter.onAttach(this);
        presenter.loadCurrentItem(items, position);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public void showTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            if (getSupportActionBar() != null) {
                getSupportActionBar().setTitle(title);
            }
        }
    }

    @Override
    public void showDescription(int position) {
        viewpager.setCurrentItem(position);
    }

    public class ViewPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
            return view == object;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {
            View view = LayoutInflater.from(container.getContext()).inflate(R.layout.view_content_detail, null);

            Document item = items.get(position);
            TextView tvContents = view.findViewById(R.id.tv_contents);
            ImageView ivThumb = view.findViewById(R.id.iv_thumb);

            if (!TextUtils.isEmpty(item.getContents())) {
                tvContents.setText(item.getContents());
            }
            if (!TextUtils.isEmpty(item.getThumbnail())) {
                Glide.with(container.getContext()).load(item.getThumbnail()).into(ivThumb);
            }
            container.addView(view);

            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
