package mtp.view.views;

import com.vaadin.navigator.View;
import com.vaadin.ui.CustomComponent;

/**
 * Created by morozov.yury on 6.7.15.
 */
public abstract class AbstractView extends CustomComponent implements View {

    public AbstractView() {
        addStyleName("content-tile");
    }
}
