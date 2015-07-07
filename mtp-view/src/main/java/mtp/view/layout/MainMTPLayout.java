package mtp.view.layout;

import com.vaadin.ui.Component;
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
public class MainMTPLayout extends MTPLayout implements Serializable {

    private VerticalLayout viewHolder;

    public MainMTPLayout() {
        setSizeFull();



        viewHolder = new VerticalLayout();
        viewHolder.setSizeFull();
        addComponent(viewHolder);
    }

    @PostConstruct
    private void init () {

    }

    @Override
    public void showView(Component component) {
        viewHolder.removeAllComponents();
        viewHolder.addComponent(component);
    }
}
