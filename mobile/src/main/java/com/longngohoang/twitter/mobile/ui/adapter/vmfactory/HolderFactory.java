package com.longngohoang.twitter.mobile.ui.adapter.vmfactory;

import android.view.View;

import com.longngohoang.twitter.mobile.ui.adapter.viewholder.BaseViewHolder;


/**
 * Created by Long on 10/5/2016.
 */

public interface HolderFactory extends ViewTypeFactory {
    BaseViewHolder createHolder(int type, View view);
}
