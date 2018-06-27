package com.example.yun.androidmvpexample.detail;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.yun.androidmvpexample.R;
import com.example.yun.androidmvpexample.data.Document;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemDetailActivity extends AppCompatActivity implements ItemDetailContract.View {

    public static final String EXTRA_DOCUMENT_LIST = "DOCUMENT_LIST";
    public static final String EXTRA_DOCUMENT_ID = "DOCUMENT_ID";

    @BindView(R.id.viewpager)
    ViewPager viewpager;

    private ItemDetailContract.Presenter presenter;

    private List<Document> items = new ArrayList<>();
    private int documentId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        items = (List<Document>) getIntent().getSerializableExtra(EXTRA_DOCUMENT_LIST);
        documentId = getIntent().getIntExtra(EXTRA_DOCUMENT_ID, 0);

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
        presenter.loadCurrentItem(items, documentId);
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
            TextView textView = new TextView(container.getContext());
            textView.setText(items.get(position).getTitle().toString());
            textView.setGravity(Gravity.CENTER);
            container.addView(textView);
            return textView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }
    }

}
