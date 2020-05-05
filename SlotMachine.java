
package assignment2;

//Packages used in the SlotMachine program are imported here.

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.Random;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.image.ImageView ;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.text.Text;


public class SlotMachine extends Application
{
//All variables used in the program are declared here as private variables
    
private Text yesPress,tokenLabel,resultLabel;
private int numTokens,points,randSpin;
private Button b1,b2;
private Image start,aaa,aac,aao,aca,acc,aco,aoa,aoc,aoo,caa,cac,cao,cca,ccc,cco,coa,coc,coo,oaa,oac,oao,oca,occ,oco,ooa,ooc,ooo;
private ImageView fruitView;



@Override
public void start(Stage primaryStage)
{
 
 
    
    b1 = new Button("Spin");                                    //Creates button to spin slot machine
    b1.setOnAction(this::processButtonPress);
    b1.setPrefSize(125, 40);
    b1.setFont(Font.font("Arial", FontWeight.NORMAL, 20));


    b2 = new Button("Cash Out");                                //Creates cashout button
    b2.setOnAction(this::processButtonPress);
    b2.setPrefSize(125, 40);
    b2.setFont(Font.font("Arial", FontWeight.NORMAL, 20));

    yesPress = new Text("Click Spin to Start");
    yesPress.setFont(Font.font("Arial", FontWeight.NORMAL, 10));
    yesPress.setFill(Color.WHITE);



    FlowPane buttonPane = new FlowPane(b1,b2,yesPress);         //Flowpane is defined as buttonPane, b1 and b2 are added to it. 
    buttonPane.setStyle("-fx-background-color: blue");
    buttonPane.setAlignment(Pos.CENTER);
    buttonPane.setHgap(10);
    buttonPane.setVgap(10);
    
    numTokens=5;                                                //Number of tokens is set to the starting amount of 5
    tokenLabel= new Text ("Current Tokens: "+numTokens);        //Label for displaying current number of tokens is made.
    tokenLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 15));

    resultLabel=new Text ("Spin Result: "+points);              //Label for displaying result of spin is made.
    resultLabel.setFont(Font.font("Arial", FontWeight.NORMAL, 15));

    start = new Image("assignment2/start.png");                 //Import of opening slot machine image. 

    aaa= new Image("assignment2/aaa.png");                       //Import of all 27 fruit images to be displayed on the 
    aac= new Image("assignment2/aac.png");                       //slot machine display                        
    aao= new Image("assignment2/aao.png");
    aca= new Image("assignment2/aca.png");
    acc= new Image("assignment2/acc.png");
    aco= new Image("assignment2/aco.png");
    aoa= new Image("assignment2/aoa.png");
    aoc= new Image("assignment2/aoc.png");
    aoo= new Image("assignment2/aoo.png");
    caa= new Image("assignment2/caa.png");
    cac= new Image("assignment2/cac.png");
    cao= new Image("assignment2/cao.png");
    cca= new Image("assignment2/cca.png");
    ccc= new Image("assignment2/ccc.png");
    cco= new Image("assignment2/cco.png");
    coa= new Image("assignment2/coa.png");
    coc= new Image("assignment2/coc.png");
    coo= new Image("assignment2/coo.png");
    oaa= new Image("assignment2/oaa.png");
    oac= new Image("assignment2/oac.png");
    oao= new Image("assignment2/oao.png");
    oca= new Image("assignment2/oca.png");
    occ= new Image("assignment2/occ.png");
    oco= new Image("assignment2/oco.png");
    ooa= new Image("assignment2/ooa.png");
    ooc= new Image("assignment2/ooc.png");
    ooo= new Image("assignment2/ooo.png");
        
    fruitView = new ImageView(start);                           //Formats opening slot machine image to fit the slotsPane               
    fruitView.setFitHeight(50);
    fruitView.setFitWidth(190);


       
    FlowPane slotsPane = new FlowPane(tokenLabel,resultLabel,fruitView);     //Flowpane is defined as slotsPane,  
    slotsPane.setStyle("-fx-background-color: white");                       //tokenLabel,resultLabel,fruitView are added to it.
    slotsPane.setAlignment(Pos.BOTTOM_CENTER);
    slotsPane.setHgap(10);
    slotsPane.setVgap(10);
    
    VBox primary = new VBox();                                  //A Vbox is defined as primary, the slotsPane and buttonPane are added
    primary.setStyle("-fx-background-color: red");
    primary.setAlignment (Pos.CENTER);
    primary.getChildren ().addAll(slotsPane,buttonPane);
    
Scene scene = new Scene(primary, 300, 400,Color.RED);

primaryStage.setTitle("Slot Machine");                          // "Slot Machine" is given as the title of the scene
primaryStage.setScene(scene);
primaryStage.show();


}

public void processButtonPress(ActionEvent event)               // Beginning of the event method
    {
    Random generator = new Random();                                //Random package is used to generate a random interger between 0 and 26
    randSpin = generator.nextInt(26);                               //and defines the int to the variable fruitView.


    yesPress.setText("Game in Progress");                           
    tokenLabel.setText("Current Tokens: "+ numTokens);              //Label for displaying current number of tokens is updated for each spin.
    fruitView.setImage(start);

    if (event.getSource() == b1)  {                                 // When b1 is pressed by user the random number runs through the switch statement.
    switch (randSpin)                                            // The switch statement here is presented which contains the actual logic for                                                                
   {                                                            // each spin, the image to be presented and the number of points for each.
        case 0: 
            fruitView.setImage(aaa);
            points=5;
            numTokens += points;
            break;   
        case 1: 
            fruitView.setImage(aac);
            points=4;
            numTokens += points;
            break;
        case 2: 
            fruitView.setImage(aao);
            points=1;
            numTokens += points;
            break;  
        case 3: 
            fruitView.setImage(aca);
            points=2;
            numTokens += points;
            break; 
        case 4: 
            fruitView.setImage(acc);
            points=3;
            numTokens += points;
            break; 
        case 5: 
            fruitView.setImage(aco);
            points=0;
            numTokens += points;
            break; 
        case 6: 
            fruitView.setImage(aoa);
            points=1;
            numTokens += points;
            break;
        case 7: 
            fruitView.setImage(aoc);
            points=0;
            numTokens += points;
            break; 
        case 8: 
            fruitView.setImage(aoo);
            points=0;
            numTokens += points;
            break; 
        case 9: 
            fruitView.setImage(caa);
            points=3;
            numTokens += points;
            break; 
        case 10: 
            fruitView.setImage(cac);
            points=2;
            numTokens += points;
            break; 
        case 11: 
            fruitView.setImage(cao);
            points=0;
            numTokens += points;
            break; 
        case 12: 
            fruitView.setImage(cca);
            points=2;
            numTokens += points;
            break; 
        case 13: 
            fruitView.setImage(ccc);
            points=10;
            numTokens += points;
            break; 
        case 14: 
            fruitView.setImage(cco);
            points=2;
            numTokens += points;
            break; 
        case 15: 
            fruitView.setImage(coa); 
            points=0;
            numTokens += points;
            break; 
        case 16: 
            fruitView.setImage(coc);
            points=2; 
            numTokens += points;
            break; 
        case 17: 
            fruitView.setImage(oaa);
            points=1;
            numTokens += points;
            break; 
        case 18: 
            fruitView.setImage(oac);
            points=0;
            numTokens += points;
            break;
        case 19: 
            fruitView.setImage(oao);
            points=-1;
            numTokens += points;
            break; 
        case 20: 
            fruitView.setImage(oca);
            points=0;
            numTokens += points;
            break; 
        case 21: 
            fruitView.setImage(occ);
            points=1;
            numTokens += points;
            break; 
        case 22: 
            fruitView.setImage(oco);
            points=-1;
            numTokens += points;
            break; 
        case 23: 
            fruitView.setImage(ooa); 
            points=0;
            numTokens += points;
            break; 
        case 24: 
            fruitView.setImage(ooc);
            points=0;
            numTokens += points;
            break;
        case 25: 
            fruitView.setImage(ooo);
            points=-10;
            numTokens += points;
            break;
        case 26:
            fruitView.setImage(coo);
            points=0;
            numTokens += points;
            break; 
        
   }
    numTokens--;                                                            //Each spin decrements 1 token 
    resultLabel.setText("Spin Result: "+points);
    tokenLabel.setText("Current Tokens: "+ numTokens); }
    if(numTokens<0){                                                    // Prevents token count from dropping below 0.
       numTokens=0;
       fruitView.setImage(start);
       resultLabel.setText("     PLAY AGAIN?");                         // Presents endgame labels for "Game Over" and "Play again"
       tokenLabel.setText("GAME OVER");
       yesPress.setText("Select spin to play again");                           
    }
    if (event.getSource() == b2) {                                      // When b2 is pressed by user the tokens are cashed out.
       fruitView.setImage(start);
       resultLabel.setText("PRIZE: "+numTokens);
       tokenLabel.setText("GAME OVER");
       yesPress.setText("Select spin to play again");
       fruitView.setImage(start);
   
       
       
    }
}
public static void main(String[] args)                                  // Main method
{
launch(args);
}
}