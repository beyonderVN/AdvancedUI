package com.longngohoang.twitter.mobile.ui.adapter.vmfactory;

import com.longngohoang.twitter.mobile.ui.adapter.viewmodel.SectionVM;
import com.longngohoang.twitter.mobile.ui.adapter.viewmodel.SimpleVM;

/**
 * Created by Long on 11/10/2016.
 */
public interface ViewTypeFactory {

    int getType(SimpleVM simpleVM);

    int getType(SectionVM sectionVM);
}
