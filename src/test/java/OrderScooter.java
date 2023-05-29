import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageorder.MainPage;
import pageorder.OrderPage;
import pageorder.RentPage;

import java.time.LocalDate;

@RunWith(Parameterized.class)
public class OrderScooter {
    private final String url = "https://qa-scooter.praktikum-services.ru/";

    private String firstName;
    private String secondName;
    private String adressName;
    private int indexMetroStation;
    private String telephoneNumber;

    static LocalDate currentDate = LocalDate.now();

    private int indexRentPeriod;

    private String commentForCourier;

    public OrderScooter(String firstName, String secondName, String adressName, int indexMetroStation, String telephoneNumber, LocalDate currentDate, int indexRentPeriod, String commentForCourier) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.adressName = adressName;
        this.indexMetroStation = indexMetroStation;
        this.telephoneNumber = telephoneNumber;
        this.currentDate = currentDate;
        this.indexRentPeriod = indexRentPeriod;
        this.commentForCourier = commentForCourier;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{{"Тест", "Тест", "Невский проспект 54", 9, "79052008682", currentDate, 5, "Полный заряд"},
                {"Тесто", "Тестово", "Ветеранов 169", 28, "89437658976", currentDate, 6, "Хочу красного цвета"}
        };
    }

    @Test

//Заказ самоката "Черный Жемчуг" через кнопку заказа в середине сайта

    public void orderBlackScooterThroughInMiddleButton() {

        //создаем драйвер для браузера
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // создаем объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        // клик по кнопке куки
        objMainPage.clickCoockieButton();

        //клик по кнопке "Заказать" в середине сайта сайта
        objMainPage.clickMiddleButtonOrder();

        //создаем объект класса страницы заказа
        OrderPage objOrderPage = new OrderPage(driver);

        // ввод имени
        objOrderPage.sendFirstName(firstName);

        //ввод фамилии
        objOrderPage.sendSecondName(secondName);

        //ввод адресса доставки
        objOrderPage.adressDeliverly(adressName);

        //выбор станции метро
        objOrderPage.choisMetro(indexMetroStation);

        //ввод номера телефона
        objOrderPage.sendNumberTelephone(telephoneNumber);

        //клик по кнопке далее
        objOrderPage.clickButtonNext();

        //создаем объект класса страницы с выбором аренды

        RentPage objRentPage = new RentPage(driver);

        //выбор даты аренды
        objRentPage.dateDelivrely(String.valueOf(currentDate));

        //выбор срока на который делается заказ аренды
        objRentPage.choisRentPeriod(indexRentPeriod);

        // выбор чек-бокса с цветом Самоката
        objRentPage.choiseColourBlackScooter();

        //ввод комментария для курьера
        objRentPage.sendCommentCourier(commentForCourier);

        // клик по кнопке заказать
        objRentPage.clickButtonOrder();

        // клик по кнопке да в модальном окне подтверждения
        objRentPage.clickButtonYes();

        //проверка отображения модального окна с номером заказа
        objRentPage.isDisplayModalOrder();

        //закрытие браузера
        driver.quit();
    }
    @Test
    public void orderScooterColourGreyTroughtButtonInHeader(){
        //создаем драйвер для браузера
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        // создаем объект класса главной страницы
        MainPage objMainPage = new MainPage(driver);

        // клик по кнопке куки
        objMainPage.clickCoockieButton();

        //клик по кнопке "Заказать" в хедере сайта
        objMainPage.clickButtonHeaderButtonOrder();

        //создаем объект класса страницы заказа
        OrderPage objOrderPage= new OrderPage(driver);

        // ввод имени
        objOrderPage.sendFirstName(firstName);

        //ввод фамилии
        objOrderPage.sendSecondName(secondName);

        //ввод адресса доставки
        objOrderPage.adressDeliverly(adressName);

        //выбор станции метро
        objOrderPage.choisMetro(indexMetroStation);

        //ввод номера телефона
        objOrderPage.sendNumberTelephone(telephoneNumber);

        // клик по кнопке далее
        objOrderPage.clickButtonNext();

        //создаем объект класса страницы с выбором аренды
        RentPage objRentPage= new RentPage(driver);

        //ввод даты аренды
        objRentPage.dateDelivrely(String.valueOf(currentDate));

        //ввод срока на который заказывается аренда
        objRentPage.choisRentPeriod(indexRentPeriod);

        //выбор чек-бокса с цветом самоката
        objRentPage.choiseColourGreyScooter();

        //Ввод комментария для курьера
        objRentPage.sendCommentCourier(commentForCourier);

        // клик по кнопке заказа
        objRentPage.clickButtonOrder();

        // клик по кнопке да в модальном окне
        objRentPage.clickButtonYes();

        //проверка отображения модального окна с номером заказа
        objRentPage.isDisplayModalOrder();

        // закрытие браузера
        driver.quit();
    }
}













