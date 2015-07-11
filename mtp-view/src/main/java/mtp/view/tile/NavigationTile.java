package mtp.view.tile;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.server.FontAwesome;
import mtp.view.service.NavigationService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

/**
 * Created by Yury_Morozov on 07.07.2015.
 */
@SessionScoped
@Named
public class NavigationTile extends VerticalLayout implements Serializable {

    @Inject
    private NavigationService navigationService;

    private static String SELECTED_BUTTON_STYLE_NAME = "primary";

    private Component selectedButton;

    public NavigationTile() {
        addStyleName("navigation-tile");
    }

    @PostConstruct
    private void init() {
        Map<String, String> navigationRefs = navigationService.getNavigationRefs();

        selectedButton = getNavigationButton("Main page", "");
        reselectButton(selectedButton);
        addComponent(selectedButton);

        for (String entityTypeName : navigationRefs.keySet()) {
            Component navigationButton = getNavigationButton(entityTypeName, navigationRefs.get(entityTypeName));
            addComponent(navigationButton);
        }
        addComponent(getNavigationButton("Configuration", ""));
    }

    private Component getNavigationButton(String name, final String ref) {
        return new Button(name) {{
           addClickListener(new ClickListener() {
               @Override
               public void buttonClick(ClickEvent event) {
                   reselectButton(event.getButton());
                   navigationService.navigateTo(ref);
               }

           });
        }};
    }

    private void reselectButton (Component component) {
        if (selectedButton != null) {
            selectedButton.removeStyleName(SELECTED_BUTTON_STYLE_NAME);
            selectedButton.setIcon(null);
        }
        selectedButton = component;
        selectedButton.setIcon(FontAwesome.ANGLE_DOUBLE_RIGHT);
        selectedButton.addStyleName(SELECTED_BUTTON_STYLE_NAME);
    }

}
