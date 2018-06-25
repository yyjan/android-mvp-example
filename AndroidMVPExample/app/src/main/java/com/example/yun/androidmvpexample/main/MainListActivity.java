package com.example.yun.androidmvpexample.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.yun.androidmvpexample.R;
import com.example.yun.androidmvpexample.data.Document;
import com.example.yun.androidmvpexample.data.DocumentDataRepository;
import com.example.yun.androidmvpexample.detail.ItemDetailActivity;
import com.example.yun.androidmvpexample.main.adapter.MainListAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainListActivity extends AppCompatActivity implements MainListContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    MainListAdapter adapter;
    MainListContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = findViewById(R.id.fab);

        adapter = new MainListAdapter(this, itemListener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        presenter = new MainListPresenter();
        presenter.onAttach(this);
        presenter.setAdapterModel(adapter);
        presenter.setAdapterView(adapter);
        presenter.setSampleData(DocumentDataRepository.getInstance());
        presenter.loadItems();

    }

    @OnClick(R.id.fab)
    void onFabClick() {
        presenter.addNewItem(adapter.getItemCount());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }

    @Override
    public void showToast(String title) {
        Toast.makeText(this, String.format(getText(R.string.item_click).toString(), title), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showMessage(int itemCount) {
        Snackbar.make(fab, String.format(getText(R.string.item_add).toString(), itemCount), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showItemDetail(Document document) {
        Intent intent = new Intent(this, ItemDetailActivity.class);
        intent.putExtra(ItemDetailActivity.EXTRA_DOCUMENT, document);
        startActivity(intent);
    }

    @Override
    public void scrollToBottom() {
        recyclerView.scrollToPosition(adapter.getItemCount() - 1);
    }

    ItemListener itemListener = new ItemListener() {

        @Override
        public void onItemClick(Document document) {
            presenter.onItemClick(document);
        }
    };

    public interface ItemListener {
        void onItemClick(Document document);
    }

}
