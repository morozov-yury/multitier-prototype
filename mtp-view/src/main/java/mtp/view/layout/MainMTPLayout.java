package mtp.view.layout;

import com.vaadin.ui.*;
import mtp.view.tile.NavigationTile;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Yury_Morozov on 06.07.2015.
 */
@SessionScoped
@Named
public class MainMTPLayout extends MTPLayout implements Serializable {

    @Inject
    private NavigationTile navigationTile;

    private GridLayout gridLayout;

    public MainMTPLayout() {
        gridLayout = new GridLayout(2, 4);
        gridLayout.setSizeUndefined();
        gridLayout.setWidth("1000px");

        super.addComponent(gridLayout);
        super.setComponentAlignment(gridLayout, Alignment.TOP_CENTER);

        gridLayout.setColumnExpandRatio(0, 0);
        gridLayout.setColumnExpandRatio(1, 1);
        gridLayout.setRowExpandRatio(2, 1);

        gridLayout.addComponent(new VerticalLayout() {{
            setWidth("100%");
            addComponent(new Label("Title tile"));
        }}, 0, 0, 1, 0);

        gridLayout.addComponent(new VerticalLayout() {{
            setWidth("100%");
            addComponent(new Label("Content title"));
        }}, 1, 1);

        gridLayout.addComponent(new VerticalLayout() {{
            setWidth("100%");
            addComponent(new Label("Footer tile"));
        }}, 0, 3, 1, 3);
    }

    @PostConstruct
    private void init () {
        gridLayout.addComponent(navigationTile, 0, 1, 0, 2);
    }

    @Override
    public void showView(Component component) {
        gridLayout.removeComponent(1, 2);
        gridLayout.addComponent(component, 1, 2);
    }
}
