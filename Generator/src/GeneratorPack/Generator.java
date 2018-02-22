package GeneratorPack;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;

/**
 * Created by Michał Nowak
 */

public class Generator {

    @FXML
    private TextField liczbaZnakowLogin;  // zmienna do loginu
    @FXML
    private TextField dataOd;       // zmienna do loginu
    @FXML
    private TextField dataDo;       // zmienna do loginu
    @FXML
    private TextField textLogin;            // zmienna do loginu


    @FXML
    private TextField liczbaZnakowHaslo;     // zmienna do hasła
    @FXML
    private TextField textHaslo;               // zmienna do hasła
    @FXML
    private ProgressBar progress;           // zmienna do hasła


    @FXML
    private TextField textMinutnik;    // zmienna minutnika
    @FXML
    private Label labelMinutnik;        // zmienna minutnika
    @FXML
    private ProgressBar progressMinutnik;    // zmienna minutnika




    private char znak;                      //zmienna do hasła i do loginu
    private int wylosowana;                 //zmienna do hasła i do loginu



    @FXML
    public void losujlogin(){

        int zmiennaDataOd;
        int zmiennaDataDo;
        int losowanieWilekosciLitery;
        String wylosowanaData="";
        String login="";

        try{

            int liczbaZnakow = Integer.parseInt( liczbaZnakowLogin.getText() );
            zmiennaDataOd = Integer.parseInt( dataOd.getText() );
            zmiennaDataDo = Integer.parseInt( dataDo.getText() );

            wylosowana = (int)( Math.random() * ( zmiennaDataDo - zmiennaDataOd )) + zmiennaDataOd; // losowanie części loginu z cyframi
            wylosowanaData = String.valueOf(wylosowana);

            if( zmiennaDataOd <= 0 || zmiennaDataDo >= 9999 || liczbaZnakow < 5 || liczbaZnakow > 40 )
            {
                throw new Exception();
            }

            for( int i=1;i <= liczbaZnakow-wylosowanaData.length(); i++ ) // losowanie części loginu z literami
            {
                losowanieWilekosciLitery = (int)(Math.random() * 2) + 1;    //losowanie liczby z zakresu <1,2>

                if( losowanieWilekosciLitery == 1 )
                {
                    wylosowana =(int)( Math.random() * 25) + 65;      //losowanie dużych liter
                    znak = (char) wylosowana;
                    login += znak;
                }
                else
                {
                    wylosowana =(int)(Math.random() * 25) + 97;      //losowanie małych liter
                    znak =( char ) wylosowana;
                    login += znak;
                }
            }

            login += wylosowanaData;
            textLogin.setText( "Wygenerowany login to: " + login );         // wypisanie w etykiecie logniu

        }catch( Exception e ){
            textLogin.setText( "Podałeś niewłaściwe dane!" );           // wypisanie w etykiecie ostrezrzenia
        }
    }

    @FXML
    private void losujHaslo(){
        String Haslo= "" ;

        try{

        int liczbaZnakow = Integer.parseInt(liczbaZnakowHaslo.getText());

        if( liczbaZnakow < 5 || liczbaZnakow > 30 )
        {
            throw new Exception();              //rzucenie wyjątkiem gdy liczba większa od 30 lub mniejsza od 5
        }

        for( int i=1; i <= liczbaZnakow; i++ )
        {
            wylosowana = (int)(Math.random() * 4);

            switch(wylosowana)
            {
                case 0:
                    wylosowana = (int)(Math.random() * 25) + 97;      //losowanie małej litery
                    znak = (char) wylosowana ;
                    Haslo += znak ;
                    break;

                case 1:
                    wylosowana = (int)(Math.random() * 25) + 65 ;      //losowanie dużej litery
                    znak = (char) wylosowana;
                    Haslo += znak ;
                    break;

                case 2:
                    wylosowana = (int)(Math.random() * 9) + 48 ;      //losowanie cyfry
                    znak = (char) wylosowana ;
                    Haslo += znak ;
                    break;

                case 3:
                    wylosowana = (int)(Math.random() * 5) + 33 ;      //losowanie znaku specjalnego
                    znak =(char) wylosowana ;
                    Haslo += znak ;
                    break;


            }
        }

            textHaslo.setText( Haslo );         // wypisanie w polu tekstowym hasła
            if(liczbaZnakow >= 5 && liczbaZnakow < 8 )
            {
                progress.setProgress(0.33);                // ustawienie progressu na 33%
                progress.setEffect( new ColorAdjust(-1.0,0.0,0.0,0.0 )); //ustawinie koloru na czerwony

            }
            else if( liczbaZnakow >= 8 && liczbaZnakow <= 15 )
            {
                progress.setProgress(0.67);             // ustawienie progressu na 67%
                progress.setEffect( new ColorAdjust(-0.75,0.0,0.0,0.0 )); //ustawinie koloru na żółty
            }
            else if( liczbaZnakow > 15 && liczbaZnakow <= 30 )
            {
                progress.setProgress(1.0);              // ustawienie progressu na 100%
                progress.setEffect( new ColorAdjust(-0.55,0.0,0.0,0.0 )); //ustawinie koloru na zielony
            }


        }catch (Exception e){
            textHaslo.setText("Podałeś za małą lub za dużą liczbę!");           // wypisanie w polu tekstowym ostrezrzenia
            progress.setProgress(1.0);
            progress.setEffect( new ColorAdjust(-1.0,0.0,0.0,0.0));

        }
    }



    @FXML
    private void minutnik() throws InterruptedException {
        int podanaIloscSekund=0;
        try{
            podanaIloscSekund=Integer.parseInt(textMinutnik.getText());
            if(podanaIloscSekund < 0)
            {
                throw new Exception();
            }
            for(int i = podanaIloscSekund; i > 0; i--)
            {
                Thread.sleep(1000);
            }
            progressMinutnik.setProgress(1.0 );
            progressMinutnik.setEffect( new ColorAdjust(-1.0,0.0,0.0,0.0));
            textMinutnik.setText(String.valueOf(0));
            labelMinutnik.setText("Koniec!");


        }catch( Exception e ){
           labelMinutnik.setText("Podałeś za małą lub za dużą liczbę");
        }
    }

    @FXML
    private void reset(){
        textMinutnik.setText(String.valueOf(10));
        progressMinutnik.setProgress( 0 );
        labelMinutnik.setText("");
    }
}
