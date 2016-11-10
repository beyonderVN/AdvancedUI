package com.longngohoang.twitter.mobile.ui.adapter.vmfactory;

import android.view.View;

import com.longngohoang.twitter.mobile.R;
import com.longngohoang.twitter.mobile.ui.adapter.viewholder.BaseViewHolder;
import com.longngohoang.twitter.mobile.ui.adapter.viewholder.SectionHolder;
import com.longngohoang.twitter.mobile.ui.adapter.viewholder.SimpleHolder;
import com.longngohoang.twitter.mobile.ui.adapter.viewmodel.SectionVM;
import com.longngohoang.twitter.mobile.ui.adapter.viewmodel.SimpleVM;


/**
 * Created by Long on 10/5/2016.
 */

public class HolderFactoryImpl implements HolderFactory {

    private static final int SECTION_VM = R.layout.layout_section;
    private static final int SIMPLE_VM = R.layout.layout_item_horizontal;

    @Override
    public BaseViewHolder createHolder(int type, View view) {
        switch(type) {
            case SECTION_VM: return new SectionHolder(view);
            case SIMPLE_VM: return new SimpleHolder(view);

        }
        return null;
    }

    @Override
    public int getType(SimpleVM simpleVM) {
        return SIMPLE_VM;
    }

    @Override
    public int getType(SectionVM sectionVM) {
        return SECTION_VM;
    }


}
