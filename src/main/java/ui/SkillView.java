package ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import rules.MinimumWordCount;
import rules.Rule;

class SkillView extends HBox {
    private final TextField enterSkillTextField;
    private final TextField enterWordCountTextField;

    SkillView(Skill skill) {
        super();
        this.setSpacing(15);

        this.getChildren().add(new Label("Skill : "));

        enterSkillTextField = getTextField("Enter Skill ex: Selenium");
        this.getChildren().add(enterSkillTextField);

        enterWordCountTextField = getTextField("Enter Word Count");
        this.getChildren().add(enterWordCountTextField);

        createAddAnotherSkillButton(this, skill);
        createRemoveSkillButton(this, skill);
    }

    private void createAddAnotherSkillButton(SkillView skillView, Skill skill) {
        Button addAnotherSkillButton = getButton("Add Another Skill");
        addAnotherSkillButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                skill.addSkill();
            }
        });
        skillView.getChildren().add(addAnotherSkillButton);
    }

    private void createRemoveSkillButton(SkillView skillView, Skill skill) {
        Button removeSkillButton = getButton("Remove Skill");
        removeSkillButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                skill.removeSkill(SkillView.this);
            }
        });
        skillView.getChildren().add(removeSkillButton);
    }

    private TextField getTextField(String promptText) {
        TextField field = new TextField();
        field.setPromptText(promptText);
        return field;
    }

    private Button getButton(String textOnButton) {
        Button button = new Button();
        button.setText(textOnButton);
        return button;
    }

    boolean areSkillDetailsPresent() {
        return (!enterSkillTextField.getText().equals(null) && !enterSkillTextField.getText().equals("")) ||
                (!enterWordCountTextField.getText().equals(null) && !enterWordCountTextField.getText().equals(""));
    }

    Rule createRule() {
        final String word = enterSkillTextField.getText();
        final int count = Integer.parseInt(enterWordCountTextField.getText());
        return new MinimumWordCount(word, count);
    }
}
