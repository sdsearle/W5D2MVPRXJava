package com.example.admin.w5d2mvprxjava.view.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.w5d2mvprxjava.R;
import com.example.admin.w5d2mvprxjava.mainactivity.DaggerMainActivityComponent;
import com.example.admin.w5d2mvprxjava.model.RXFunctions;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    private static final String TAG = "MaintActivityTag";

    @Inject
    MainActivityPresenter presenter;
    @BindView(R.id.btnJust)
    Button btnJust;
    @BindView(R.id.btnRange)
    Button btnRange;
    @BindView(R.id.btnRepeat)
    Button btnRepeat;
    @BindView(R.id.btnMap)
    Button btnMap;
    @BindView(R.id.btnScan)
    Button btnScan;
    @BindView(R.id.btnBuffer)
    Button btnBuffer;
    @BindView(R.id.btnTake)
    Button btnTake;
    @BindView(R.id.btnSkip)
    Button btnSkip;
    @BindView(R.id.btnDebounce)
    Button btnDebounce;
    @BindView(R.id.btnStartwith)
    Button btnStartwith;
    @BindView(R.id.btnCombine)
    Button btnCombine;
    @BindView(R.id.btnMerge)
    Button btnMerge;
    @BindView(R.id.btnSort)
    Button btnCount;
    @BindView(R.id.btnConcat)
    Button btnConcat;
    @BindView(R.id.btnReduce)
    Button btnReduce;
    @BindView(R.id.tvObserver)
    TextView tvObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        //DaggerMainComponent -- name of object graph
        setupDaggerComponent();


        presenter.attachView(this);
    }

    private void setupDaggerComponent() {
        DaggerMainActivityComponent.create().inject(this);
    }

    @Override
    public void showError(String s) {
        Log.d(TAG, "showError: " + s);
    }


    @OnClick({R.id.btnJust, R.id.btnRange, R.id.btnRepeat, R.id.btnMap, R.id.btnScan, R.id.btnBuffer, R.id.btnTake, R.id.btnSkip, R.id.btnDebounce, R.id.btnStartwith, R.id.btnCombine, R.id.btnMerge, R.id.btnSort, R.id.btnConcat, R.id.btnReduce})
    public void onObserverClicked(View view) {
        switch (view.getId()) {
            case R.id.btnJust:
                presenter.validateJust();
                break;
            case R.id.btnRange:
                presenter.validateRange();
                break;
            case R.id.btnRepeat:
                presenter.validateRepeat();
                break;
            case R.id.btnMap:
                presenter.validateMap();
                break;
            case R.id.btnScan:
                presenter.validateScan();
                break;
            case R.id.btnBuffer:
                presenter.validateBuffer();
                break;
            case R.id.btnTake:
                presenter.validateTake();
                break;
            case R.id.btnSkip:
                presenter.validateSkip();
                break;
            case R.id.btnDebounce:
                presenter.validateDebounce();
                break;
            case R.id.btnStartwith:
                presenter.validateStartwith();
                break;
            case R.id.btnCombine:
                presenter.validateCombine();
                break;
            case R.id.btnMerge:
                presenter.validateMerge();
                break;
            case R.id.btnSort:
                presenter.validateSort();
                break;
            case R.id.btnConcat:
                presenter.validateConcat();
                break;
            case R.id.btnReduce:
                presenter.validateReduce();
                break;
        }
    }

    @Override
    public void onObserverClicked(String s) {
        tvObserver.setText(s);
    }
}
