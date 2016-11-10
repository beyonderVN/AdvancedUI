package com.longngohoang.twitter.mobile.ui.adapter.viewmodel;

import com.longngohoang.twitter.mobile.ui.adapter.vmfactory.ViewTypeFactory;

/**
 * Created by Long on 10/5/2016.
 */

public interface Visitable {
    int getVMType(ViewTypeFactory vmTypeFactory);
}
