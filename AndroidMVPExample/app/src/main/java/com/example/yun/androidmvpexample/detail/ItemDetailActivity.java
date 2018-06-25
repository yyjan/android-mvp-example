package com.example.yun.androidmvpexample.detail;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.example.yun.androidmvpexample.R;
import com.example.yun.androidmvpexample.data.Document;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ItemDetailActivity extends AppCompatActivity implements ItemDetailContract.View {

    public static final String EXTRA_DOCUMENT = "DOCUMENT";

    @BindView(R.id.tv_title)
    TextView tvTitle;

    ItemDetailContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        ButterKnife.bind(this);

        Document document = getIntent().getParcelableExtra(EXTRA_DOCUMENT);

        presenter = new ItemDetailPresenter();
        presenter.onAttach(this);
        presenter.loadItems(document);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public void showTitle(String title) {
        if (!TextUtils.isEmpty(title)) {
            tvTitle.setText(title);
        }
    }
}
