package mtp.view.layout;

import com.vaadin.server.FontAwesome;
import com.vaadin.shared.ui.label.ContentMode;
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
        gridLayout = new GridLayout(2, 3);
        gridLayout.setSizeUndefined();
        gridLayout.setWidth("1000px");
        gridLayout.setSpacing(true);

        super.addComponent(gridLayout);
        super.setComponentAlignment(gridLayout, Alignment.TOP_CENTER);

        gridLayout.setColumnExpandRatio(0, 0.15f);
        gridLayout.setColumnExpandRatio(1, 0.85f);
        gridLayout.setRowExpandRatio(2, 1);

        gridLayout.addComponent(new VerticalLayout() {{
            addStyleName("title-tile");
            setSpacing(true);
            addComponent(new Label(FontAwesome.SPINNER.getHtml() + " Title tile") {{
                setContentMode(ContentMode.HTML);
                addStyleName("h2");
            }});
        }}, 0, 0, 1, 0);

        gridLayout.addComponent(new VerticalLayout() {{
            addStyleName("footer-tile");
            setSpacing(true);
            addComponent(new Label("Footer tile") {{
                setContentMode(ContentMode.HTML);
                addStyleName("h2");
            }});
        }}, 0, 2, 1, 2);
    }

    @PostConstruct
    private void init () {
        gridLayout.addComponent(navigationTile, 0, 1);
    }

    @Override
    public void showView(Component component) {
        gridLayout.removeComponent(1, 1);
        gridLayout.addComponent(component, 1, 1);
    }
}
