package mtp.view.views;

import com.mtp.service.TestService;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import mtp.view.tile.NavigationTile;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;

/**
 * Created by morozov.yury on 31.5.15.
 */
@CDIView("")
public class MainView extends AbstractView {

    public static String NAME = "";

    @EJB
    private TestService testService;

    @Inject
    private Logger logger;

    public MainView() {

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        final HorizontalLayout compositionRoot = new HorizontalLayout();
        setCompositionRoot(compositionRoot);
        compositionRoot.setSizeFull();

        compositionRoot.addComponent(new Label("MainView"));

    }

}
