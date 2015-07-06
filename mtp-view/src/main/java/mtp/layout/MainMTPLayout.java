package mtp.layout;

import com.vaadin.navigator.ViewDisplay;
import com.vaadin.ui.AbstractLayout;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Yury_Morozov on 06.07.2015.
 */
@SessionScoped
@Named
public class MainMTPLayout extends AbstractMTPLayout implements Serializable {

    private VerticalLayout viewHolder;

    public MainMTPLayout() {
        viewHolder.addComponent(new Label("MainMTPLayout"));
    }

    @PostConstruct
    private void init () {
        viewHolder = new VerticalLayout();
    }

    @Override
    protected AbstractLayout getViewHolder() {
        return viewHolder;
    }
}
