package com.bf.bfandroidstudying;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2017/12/26.
 */

public class BFFragmentStatePagerActivity extends FragmentActivity {
    static final int NUM_TIMES = 10;
    ViewPager viewPager;
    MyAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_state_pager);

        viewPager = (ViewPager)findViewById(R.id.pager_fragment);
        adapter = new MyAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
    }

    /*
    * 自定义适配器
    * */
    public static class MyAdapter extends FragmentStatePagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // 返回带ListView的fagment
//            return BFArrayListFragment.newInstance(position);
            // 返回最基本的fragment
            return BFFragment.newInstance(position);
        }

        @Override
        public int getCount() {
            return NUM_TIMES;
        }
    }

    /*
    * 自定义ListFragment子类
    * */
    public static class BFArrayListFragment extends android.support.v4.app.ListFragment {
        int mNum;

        static BFArrayListFragment newInstance(int num) {
            BFArrayListFragment arrayListFragment = new BFArrayListFragment();
            Bundle bundle = new Bundle();
            bundle.putInt("num", num);
            arrayListFragment.setArguments(bundle);

            return arrayListFragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mNum = getArguments() != null ? getArguments().getInt("num") : 1;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//            return super.onCreateView(inflater, container, savedInstanceState);
            View view = inflater.inflate(R.layout.fragment_pager_list, container, false);
            ((TextView)view.findViewById(R.id.txt_title)).setText("Fragment #" + mNum);

            return view;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            List<String> strs = new ArrayList<String>();
            strs.add("1");
            strs.add("2");
            strs.add("3");
            strs.add("4");
            strs.add("5");
            setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, strs));
        }

        @Override
        public void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
            Log.d("BFTag", "Item clicked: " + position);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.d("BFTag", "destroy: " + mNum);
        }
    }

    /*
    * 子类Fragment
    * */
    public static class BFFragment extends Fragment {
        int fragmentNum;

        static BFFragment newInstance(int num) {
            BFFragment fragment = new BFFragment();

            Bundle args = new Bundle();
            args.putInt("num", num);
            fragment.setArguments(args);

            return fragment;
        }


        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            // 获取创建时传递的参数
            fragmentNum = getArguments().getInt("num");
        }

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//            return super.onCreateView(inflater, container, savedInstanceState);
            View fragmentView = inflater.inflate(R.layout.fragment_normal, container, false);
            ((TextView)fragmentView.findViewById(R.id.fragment_txt)).setText("fragment #:" + fragmentNum);

            return fragmentView;
        }

        @Override
        public void onActivityCreated(@Nullable Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
            Log.d("BFTag", "fragment created: " + fragmentNum);
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Log.d("BFTag", "fragment destoried: " + fragmentNum);
        }
    }
}
