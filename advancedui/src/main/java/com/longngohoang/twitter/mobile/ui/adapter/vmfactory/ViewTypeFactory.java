package com.longngohoang.twitter.mobile.ui.adapter.vmfactory;

import com.longngohoang.twitter.mobile.ui.adapter.viewmodel.SectionVM;
import com.longngohoang.twitter.mobile.ui.adapter.viewmodel.SimpleHorizontalVM;
import com.longngohoang.twitter.mobile.ui.adapter.viewmodel.SimpleVerticalVM;

/**
 * Created by Long on 11/10/2016.
 */
public interface ViewTypeFactory {

    int getType(SimpleVerticalVM simpleVerticalVM);

    int getType(SectionVM sectionVM);

    int getType(SimpleHorizontalVM simpleHorizontalVM);
}
