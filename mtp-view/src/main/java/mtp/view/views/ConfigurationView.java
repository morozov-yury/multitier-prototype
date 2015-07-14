package mtp.view.views;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.server.FontAwesome;
import com.vaadin.server.Sizeable;
import com.vaadin.ui.*;
import mtp.view.MtpUI;
import mtp.view.service.NavigationService;

import javax.inject.Inject;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by morozov.yury on 31.5.15.
 */
@CDIView("configuration")
public class ConfigurationView extends AbstractView {

    public static String NAME = "admin";

    @Inject
    private NavigationService navigationService;

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        final GridLayout gridLayout = new GridLayout(2, 2);
        gridLayout.setSizeFull();
        gridLayout.setHideEmptyRowsAndColumns(true);
        gridLayout.setSpacing(true);
        gridLayout.setColumnExpandRatio(0, 1);
        gridLayout.setColumnExpandRatio(1, 1);
        setCompositionRoot(new VerticalLayout() {{
            setSizeUndefined();
            setWidth("100%");
            addComponent(gridLayout);
        }});


        gridLayout.addComponent(generatePanel("DATA MODEL", new HashMap<String, String>(){{
            put("Entities", "configuration/entities");
            put("Link entities", "configuration/linkentities");
            put("Attribute definitions", "configuration/attrdef");
        }}), 0, 0);

        gridLayout.addComponent(generatePanel("TEMPLATE MANAGEMENT", new HashMap<String, String>(){{
            put("Entities", "configuration/templates");
        }}), 1, 0);

        gridLayout.addComponent(generatePanel("RIGHTS MANAGEMENT", new HashMap<String, String>(){{
            put("User roles", "configuration/");
            put("Rights", "configuration/");
        }}), 0, 1);

        gridLayout.addComponent(generatePanel("INTEGRATION", new HashMap<String, String>(){{
            put("Data import", "configuration/");
        }}), 1, 1);

    }

    private Panel generatePanel (String title, final Map<String, String> links) {
        Panel panel = new Panel(FontAwesome.COG.getHtml() + " " + title);
        panel.setSizeFull();
        panel.setHeight("100%");
        panel.setContent(new VerticalLayout() {{
            setSpacing(true);
            setMargin(true);
            for (final Map.Entry<String, String> entry: links.entrySet()) {
                addComponent(new Button(entry.getKey()) {{
                    addStyleName("link");
                    addClickListener(new ClickListener() {
                        @Override
                        public void buttonClick(ClickEvent event) {
                            navigationService.navigateTo(entry.getValue());
                        }
                    });
                }});
            }
        }});
        return panel;
    }
}
