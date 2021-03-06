package mtp.view.layout;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;

/**
 * Created by morozov.yury on 6.7.15.
 */
public abstract class MTPLayout extends HorizontalLayout implements ViewDisplay  {

    public MTPLayout() {
        setSizeFull();
    }

    @Override
    public void showView(View view) {
        if (view instanceof Component) {
            showView((Component) view);
        } else {
            throw new IllegalArgumentException("View is not a component: " + view);
        }
    }

    public abstract void showView(Component component);

}
