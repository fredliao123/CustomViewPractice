package bupt.liao.fred.customviewpractice;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v4.view.ViewPager;
import android.view.ViewStub;

import butterknife.BindView;
import cn.droidlover.xdroid.base.XLazyFragment;

/**
 * Created by Fred.Liao on 2017/11/17.
 * Email:fredliaobupt@qq.com
 */

public class PagerFragment extends XLazyFragment {
    ViewStub practiceStub;

    @LayoutRes int practiceLayout;

    @Override
    public void initData(Bundle savedInstanceState) {
        practiceStub = (ViewStub)getRealRootView().findViewById(R.id.practiceStub);
        Bundle bundle = getArguments();
        practiceLayout = bundle.getInt("practiceLayoutRes");
        practiceStub.setLayoutResource(practiceLayout);
        practiceStub.inflate();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_pager;
    }

    public static PagerFragment newInstance(@LayoutRes int practiceLayout){
        PagerFragment fragment = new PagerFragment();
        Bundle args = new Bundle();
        args.putInt("practiceLayoutRes", practiceLayout);
        fragment.setArguments(args);
        return fragment;
    }
}
