package mtp.view;

import com.mtp.service.TestService;
import com.mtp.utils.TimeUtils;
import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import mtp.MtpUI;
import org.apache.logging.log4j.Logger;

import javax.ejb.EJB;
import javax.inject.Inject;
import java.util.Date;

/**
 * Created by morozov.yury on 31.5.15.
 */
@CDIView("")
public class MainView extends CustomComponent implements View {

    public static String NAME = "";

    @EJB
    private TestService testService;

    @Inject
    private Logger logger;

    private final VerticalLayout logLayout;

    public MainView() {
        logLayout = new VerticalLayout() {{
            setSpacing(true);
        }};
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        final HorizontalLayout hLayout = new HorizontalLayout();
        setCompositionRoot(hLayout);
        hLayout.setSizeFull();
        hLayout.setMargin(true);

        hLayout.addComponent(new VerticalLayout() {{
            setSpacing(true);

            addComponent(new Button("Go to admin page") {{
                addClickListener(new ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        MtpUI.getCurrent().getNavigator().navigateTo(AdminView.NAME);
                    }
                });
            }});

            addComponent(new Button("Ping EJB layer") {{
                addClickListener(new ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        pringLogMessage(testService.getOK());
                    }
                });
            }});

            addComponent(new Button("Test DB") {{
                setCaption("Ping neo4j REST server");
                addClickListener(new ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        pringLogMessage(testService.testDB());
                    }
                });
            }});

            addComponent(new HorizontalLayout() {{
                setSpacing(true);
                setCaption("Selects all nodes with specified property name");
                final TextField textField = new TextField();
                textField.setInputPrompt("Input property name");

                addComponent(new Button("Select") {{
                    addClickListener(new ClickListener() {
                        @Override
                        public void buttonClick(ClickEvent event) {
                            String propName = textField.getValue().trim();
                            if (textField.getValue().trim().length() > 0) {
                                String response = testService.getNodesWithProperty(propName, 25);
                                pringLogMessage(response);
                            } else {
                                pringLogMessage("Text field shouldn't be null");
                            }
                        }
                    });
                }});

                addComponent(textField);
            }});
        }});

        hLayout.addComponent(new VerticalLayout() {{
            setSpacing(true);
            addComponent(new Button("Clear log") {{
                addClickListener(new ClickListener() {
                    @Override
                    public void buttonClick(ClickEvent event) {
                        logLayout.removeAllComponents();
                    }
                });
            }});
            addComponent(logLayout);
        }});
    }

    private void pringLogMessage (String message) {
        message = TimeUtils.getCurrentTime() + ": " + message;
        logLayout.addComponent(new Label(message), 0);
    }

}
