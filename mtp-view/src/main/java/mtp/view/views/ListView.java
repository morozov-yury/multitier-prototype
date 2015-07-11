package mtp.view.views;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * Created by Yury_Morozov on 08.07.2015.
 */
@CDIView(value = "list", supportsParameters = true)
public class ListView extends AbstractView {


    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        final HorizontalLayout compositionRoot = new HorizontalLayout();
        setCompositionRoot(compositionRoot);
        compositionRoot.setSizeFull();

        compositionRoot.addComponent(new Label("ListView"));
    }
}
