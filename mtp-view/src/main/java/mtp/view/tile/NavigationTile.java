package mtp.view.tile;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.VerticalLayout;
import mtp.view.MtpUI;
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

    private Navigator navigator;

    public NavigationTile() {

    }

    @PostConstruct
    private void init() {
        Map<String, String> navigationRefs = navigationService.getNavigationRefs();
        for (String entityTypeName : navigationRefs.keySet()) {
            Component navigationButton = getNavigationButton(entityTypeName, navigationRefs.get(entityTypeName));
            addComponent(navigationButton);
        }
    }

    @Override
    public void attach() {
        super.attach();
        navigator = MtpUI.getCurrent().getNavigator();
    }

    private Component getNavigationButton(String name, String ref) {
        return new Button(name) {{
           addClickListener(new ClickListener() {
               @Override
               public void buttonClick(ClickEvent event) {
                   navigator.navigateTo("ref");
               }
           });
        }};
    }
}
