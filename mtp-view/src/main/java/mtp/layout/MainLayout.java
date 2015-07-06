package mtp.layout;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created by Yury_Morozov on 06.07.2015.
 */
@SessionScoped
@Named
public class MainLayout implements Serializable {

    public MainLayout() {

    }

    @PostConstruct
    private void init () {

    }
}
