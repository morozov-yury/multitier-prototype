package mtp.view;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import mtp.view.layout.MainMTPLayout;

import javax.inject.Inject;

/**
 *
 */
@CDIUI("")
@Push
@Theme("mytheme")
@Widgetset("mtp.MyAppWidgetset")
public class MtpUI extends UI {

    @Inject
    private CDIViewProvider viewProvider;

    @Inject
    private MainMTPLayout mainLayout;

    private Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {

        setContent(mainLayout);

        navigator = new Navigator(this, (ViewDisplay) mainLayout);
        navigator.addProvider(viewProvider);
        setNavigator(navigator);
        navigator.navigateTo("");
    }

}
