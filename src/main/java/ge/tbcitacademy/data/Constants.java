package ge.tbcitacademy.data;

public class Constants {

    //          CommandsTest
    public static final String
            DYNAMIC_CONTROLS_PAGE = "https://the-internet.herokuapp.com/dynamic_controls",
            BUTTON_ENABLE_TEXT = "Enable",
            ENABLE_MESSAGE = "It's enabled!",
            BUTTON_DISABLED_TEXT = "Disable",
            INPUT_TEXT_EXAMPLE = "TBC IT Academy",
            MAIN_HEADING_TITLE = "Dynamic Controls";


    //          LocatorsTest
    public static final String
            UL_ELEMENTS_XPATH = "//aside/h3[contains(@class, 'widget-title') and text() = 'Effects']/following-sibling::ul/li",
            FILTER_LETTER = "o",
            ANCHOR_TAG = "a",
            ATTRIBUTE_HREF = "href",
            FILTER_WORD = "animate",
            ADD_ELEMENT_BUTTON_XPATH = "//*[@id=\"content\"]/div/button",
            LAST_ADDED_BUTTON_XPATH = "//*[@id=\"elements\"]/button[last()]",
            ATTRIBUTE_CLASS = "class",
            ATTRIBUTE_CLASS_VALUE = "added-manually",
            DELETE_BUTTONS_LIST_CSSSELECTOR = "button[onclick^='delete']",
            ATTRIBUTE_ONCLICK = "onclick",
            ATTRIBUTE_ONCLICK_VALUE = "deleteElement()",
            JQUERY_UI_PAGE = "https://jqueryui.com/slider/",
            ADD_REMOVE_ELEMENT_PAGE = "http://the-internet.herokuapp.com/add_remove_elements/",
            CHALLENGING_DOM_PAGE = "http://the-internet.herokuapp.com/challenging_dom",
            TABLE_ROWS_XPATH = ".//table/tbody/tr",
            CELLS_RELATIVE_XPATH = "./td",
            TARGET_CELL_PATH = "//tbody/tr[%s]/td[%s]",
            LOREM_VALUE_OF_IPSUM_XPATH = "./preceding-sibling::td",
            IPSUM_VALUE_XPATH = "//table/tbody/tr/td[text()='Apeirian9']",
            LOREM_VALUE_OF_IPSUM_XPATH2 = "./preceding-sibling::td",
            CELL_TEXT = "Apeirian9";

    //          NavigationTest
    public static final String
            ULTIMATE_QA_PAGE = "https://ultimateqa.com/automation",
            ULTIMATE_QA_CONSULTING_PAGE = "https://ultimateqa.com/consulting/";


    //          WebElementTest
    public static final String
            DRAG_AND_DROP_PAGE = "http://the-internet.herokuapp.com/drag_and_drop",
            DRAGGABLE_ATTRIBUTE = "draggable",
            ELEMENTAL_SELENIUM_PAGE = "http://elementalselenium.com/";


    //          FormsTest
    public static final String
            CUSTOM_DROPDOWN_PAGE = "https://tympanus.net/Tutorials/CustomDropDownListStyling/index2.html",
            DEMO_BTN_XPATH = ".//a[text()='Demo 2']",
            UL_LIST_RELATIVE_XPATH = "./ul[@class='dropdown']";

    //          nativeDropDownTest
    public static final String
            REGISTER_FORM_PAGE = "https://techcanvass.com/examples/register.html",
            MALE_RADIO_BUTTON_XPATH = ".//input[@value='male']",
            MODEL_DROPDOWN_XPATH = "select[name='model']",
            inputAddress1_XPATH = "//input[@type='text' and @value='Address1']",
            INPUTADDRESS2_XPATH = "//input[@type='text' and @value='Address2']",
            INPUTCITY_XPATH = ".//input[@value='City']",
            INPUT_CONTACT1_XPATH = ".//input[@value='Contact1']",
            INPUT_CONTACT2_XPATH = ".//input[@value='Contact2']",
            DELIVERY_XPATH = ".//input[@value='Yes']",
            SUBMIT_XPATH = ".//input[@type='submit']";


    //          WaitTests
    public static final String
            ENABLE_BUTTON_XPATH = "//*[@id=\"input-example\"]/button",
            PROGRESS_BAR_XPATH = ".//*[@id='loading']",
            INPUT_FIELD_XPATH = "//*[@id=\"input-example\"]/input",
            TOOLS_QA_PAGE = "https://demoqa.com/progress-bar";

    public static final String
            DEMOQA_ALERTS_PAGE = "https://demoqa.com/alerts";


    //      techListicTableTest1
    public static final String
            TECHLISTIC_PAGE = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html",
            TECHLISTIC_TABLE_ID = "customers",
            TECHLISTIC_ROW1 = "Helen Bennett",
            TECHLISTIC_COLUMN_HEADER1 = "Contact",
            EXPECTED_TECHLISTIC_ELEMENT1 = "Helen Bennett";

    //      techlisticTableTest2
    public static final String
            TECHLISTIC_TABLE_CSSSELECTOR = "table.tsc_table_s13",
            TECHLISTIC_ROW2 = "Financial Center",
            TECHLISTIC_COLUMN_HEADER2 = "Height",
            EXPECTED_TECHLISTIC_ELEMENT2 = "492m";

    //      techCanvasTableTest
    public static final String
            TECH_CANVAS_PAGE = "https://techcanvass.com/Examples/webtable.html",
            TECH_CANVAS_TABLE_ID = "t01",
            TECH_CANVAS_ROW = "Hyundai",
            TECH_CANVAS_COLUMN_HEADER = "Ex-showroom Price(INR)",
            EXPECTED_TECH_CANVAS_ELEMENT = "12,00,000";

    //      hardDomTableTest
    public static final String
            HARDDOM_TABLE_TAGNAME = "table",
            HARDDOM_ROW = "Iuvaret5",
            HARDDOM_COLUMN_NAME = "Amet",
            EPECTED_HARDDOM_ELEMENT = "Consequuntur5";

    //      expandTestinPageTableTest
    public static final String
            EXPAND_TESTING_PAGE = "https://practice.expandtesting.com/tables",
            EXPAND_TESTING_TABLE_ID = "table1",
            EXPAND_TESTING_ROW = "Doe",
            EXPAND_TESTING_COLUMN_HEADER = "Due",
            EXPECTED_EXPAND_TESTING_ELEMENT = "$100.00";

    //      demoQATest
    public static final String
            ALERT_BTN_ID = "alertButton";

    //      JSexecutor
    public static final String
            TO_DO_PAGE = "http://webdriveruniversity.com/To-Do-List/index.html",
            PRACTICE_MAGIC_DEL_BUTTON_XPATH = ".//li[normalize-space(text()) = 'Practice magic']/span",
            PRACTICE_MAGIC_BUTTON = ".//li[normalize-space(text()) = 'Practice magic']",
            CLICKING_THE_ELEMENT = "arguments[0].click();",
            UNEXPECTED_ELEMENT_MSG = "Element should not be displayed",
            ELEMENT_SUCCESSFULLY_DELETED_MSG = "Element was deleted successfully",
            TECHLISTIC_TABLES_PAGE = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html",
            CODE_EXAMPLE = "(.//pre[div[contains(.,'html')]] | //div[@trbidi='on']//pre/span/ancestor::div[1])",
            SCROLL_INTO_VIEW = "arguments[0].scrollIntoView();",
            POPULAR_TUTORIAL_TITLES_XPATH = ".//span[contains(text(), 'Popular Tutorials')]",
            POPULAR_TUTORIAL_LINKS_XPATH = ".//a[contains(text(), 'Appium Tutorial')]//ancestor::ul//li//a",
            SCROLL_TO_LOWEST = "window.scrollTo(0, document.body.scrollHeight)",
            WEBDRIVER_UNI_PAGE = "http://webdriveruniversity.com/Scrolling/index.html",
            GET_TEXT = "return arguments[0].innerText";

    //      Exceptions
    public static final String
            QA_TOUCH_PAGE = "https://www.qatouch.com/blog/dynamic-web-elements-in-selenium/",
            SOFTWARE_TESTING_LINK_XPATH = ".//span[@class='category-link']",
            NON_EXISTENT_WINDOW_MSG = "window that doesn't exist",
            MYHOME_PAGE = "https://www.myhome.ge/",
            HELP_BTN_XPATH = ".//a[text()='დახმარება']",
            FROM_DEVELOPERS_BTN_XPATH = ".//h4[text()='ბინები დეველოპერებისგან']",
            SELENIUM_PAGE = "https://www.selenium.dev/selenium/web/dynamic.html",
            RED_BOX_XPATH = "//div[@class='redbox']",
            HEROKUAPP_DROPDOWN_PAGE = "https://the-internet.herokuapp.com/dropdown",
            SELENIUM_FRAME_PAGE = "https://www.selenium.dev/selenium/web/click_tests/click_in_iframe.html",
            FORUM_PAGE = "https://forum.ge/",
            BLIZZARD_PAGE = "https://www.blizzard.com/en-us/",
            MOBILE_BTN_XPATH = "//*[@id='product-tab-button-3']";










}









