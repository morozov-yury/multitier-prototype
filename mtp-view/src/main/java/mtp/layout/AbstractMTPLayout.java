package mtp.layout;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;
import com.vaadin.ui.VerticalLayout;

/**
 * Created by morozov.yury on 6.7.15.
 */
public abstract class AbstractMTPLayout implements ViewDisplay  {

    @Override
    public final void showView(View view) {
        if (view instanceof Component) {
            getViewHolder().addComponent((Component) view);
        } else {
            throw new IllegalArgumentException("View is not a component: " + view);
        }
    }

    protected abstract AbstractLayout getViewHolder();

}
