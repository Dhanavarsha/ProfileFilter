package ui;

import app.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import rules.AllRules;
import rules.Rule;

import java.io.File;
import java.util.ArrayList;
import java.util.Optional;
import java.util.function.Function;

public class Controller implements SkillSet {

    private final DirectoryChooser chooser = new DirectoryChooser();
    private Optional<File> file = Optional.empty();
    private ArrayList<SkillSetView> skillSetViews = new ArrayList<>();

    @FXML
    private Label directorySelectionAlertLabel;

    @FXML
    VBox mainVBox;

    @FXML
    Label profilesDirectory;

    @FXML
    Button execute;

    public void initialize() {
        addSkillSet();
    }

    public void browseProfileDirectory(ActionEvent actionEvent) {
        chooser.setTitle("Choose Profiles Folder location");
        File chosenFile = chooser.showDialog(((Node) actionEvent.getTarget()).getScene().getWindow());
        file = Optional.ofNullable(chosenFile);
        profilesDirectory.setText("Profiles Folder Location : "
                + file.map((Function<File, Object>) File::getAbsolutePath).orElse(" No Directory Selected."));
        if (file.isPresent() && !file.get().equals(" No Directory Selected.")) {
            directorySelectionAlertLabel.setText("");
        }
    }

    public void executeRule() {
        ArrayList<Rule> selectionRules = new ArrayList<>();
        for (SkillSetView skillSetView : skillSetViews) {
            selectionRules.add(skillSetView.createRule());
        }

        if (!file.isPresent()) {
            directorySelectionAlertLabel.setText("Please select directory");
        } else if (file.get().equals(" No Directory Selected.")) {
            directorySelectionAlertLabel.setText("Please select directory");
        } else {
            new Application().parseProfiles(file.get(), new AllRules(selectionRules));
        }
    }

    @Override
    public void addSkillSet() {
        SkillSetView skillSetView = new SkillSetView(this);
        mainVBox.getChildren().add(skillSetView);
        skillSetViews.add(skillSetView);
    }

    @Override
    public void removeSkillSet(SkillSetView skillSetView) {
        if (skillSetViews.size() != 1) {
            mainVBox.getChildren().remove(skillSetView);
            skillSetViews.remove(skillSetView);
        }
    }
}
