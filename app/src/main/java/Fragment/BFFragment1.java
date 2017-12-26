package Fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bf.bfandroidstudying.R;

/**
 * Created by 1 on 2017/12/26.
 */

public class BFFragment1 extends android.support.v4.app.Fragment {

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_page1, container, false);

        return view;
    }
}
