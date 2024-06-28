package Actions;

import WebElements.TrainingElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Training {

    private Actions action;
    private TrainingElements elements;

    public Training(WebDriver driver){
        this.elements = new TrainingElements(driver);
        action = new Actions(driver);
    }

    public void clickGenerateProgram(){
        if(!elements.generateProgram().getAttribute("disabled").equals("true")){
            elements.generateProgram().click();
        }
    }

    public void dragAndDropTraining(WebElement sourceLocator, WebElement destinationLocator){
        action.dragAndDrop(sourceLocator, destinationLocator).build().perform();
    }

    public void createAProgram(){
        dragAndDropTraining(elements.chest(),elements.Monday());
        dragAndDropTraining(elements.legs(),elements.Wednesday());
        dragAndDropTraining(elements.biceps(),elements.Sunday());
        dragAndDropTraining(elements.triceps(),elements.Friday());
        dragAndDropTraining(elements.chest(),elements.Tuesday());
        dragAndDropTraining(elements.triceps(),elements.Tuesday());
    }
}
