package com.longngohoang.twitter.mobile.ui.adapter.viewmodel;

import com.longngohoang.twitter.mobile.ui.adapter.vmfactory.ViewTypeFactory;

/**
 * Created by Long on 11/10/2016.
 */
public class SimpleVM extends BaseVM {
    @Override
    public int getVMType(ViewTypeFactory vmTypeFactory) {
        return vmTypeFactory.getType(this);
    }
}
