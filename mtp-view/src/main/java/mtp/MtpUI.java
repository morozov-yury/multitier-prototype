package mtp;

import com.vaadin.annotations.Push;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Widgetset;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import mtp.layout.DinamicLayoutContainer;
import mtp.layout.MainLayout;

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
    private MainLayout mainLayout;

    private Navigator navigator;

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        navigator = new Navigator(this, new DinamicLayoutContainer());
        navigator.addProvider(viewProvider);
        setNavigator(navigator);
        navigator.navigateTo("");
    }

}
