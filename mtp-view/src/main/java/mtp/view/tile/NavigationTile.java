package mtp.view.tile;

import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
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

    public NavigationTile() {
        setSizeUndefined();
    }

    @PostConstruct
    private void init() {
        Map<String, String> navigationRefs = navigationService.getNavigationRefs();
        addComponent(getNavigationButton("Main page", ""));
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
                   navigationService.navigateTo(ref);
               }
           });
        }};
    }
}
