package fr.coinapp.application.bittrexWallet.currencydetails;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import fr.coinapp.application.bittrexWallet.BaseAnimationActivity;
import fr.coinapp.application.bittrexWallet.R;
import fr.coinapp.application.bittrexWallet.currencydetails.chartandtable.GraphFragment;
import fr.coinapp.application.bittrexWallet.news.NewsListActivity;


public class CurrencyDetailsTabsActivity extends BaseAnimationActivity {
    private SectionsPagerAdapterDetails mSectionsPagerAdapter;
    public CustomViewPager mViewPager;
    private Toolbar mToolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency_details_tabs);
        mToolbar = (Toolbar) findViewById(R.id.toolbar_currency_details);
        setSupportActionBar(mToolbar);
        String symbol = getIntent().getStringExtra(GraphFragment.ARG_SYMBOL);
        String id = getIntent().getStringExtra(GraphFragment.ARG_ID);
        mViewPager = (CustomViewPager) findViewById(R.id.currencyTabsViewPager);
        mSectionsPagerAdapter = new SectionsPagerAdapterDetails(getSupportFragmentManager(), symbol, id);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.setOffscreenPageLimit(2);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setSelectedTabIndicatorColor(Color.WHITE);
        getSupportActionBar().setTitle(symbol);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.currency_tabs_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()) {
            case R.id.news_button:
                startActivity(new Intent(this, NewsListActivity.class));
                return true;
        }
        finish();
        return true;
    }

}
