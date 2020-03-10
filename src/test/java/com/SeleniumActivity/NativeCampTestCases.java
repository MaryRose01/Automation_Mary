package com.SeleniumActivity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NativeCampTestCases extends Common {

    public WebDriver driver;

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "webdrivers/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> preference = new HashMap<String, Object>();
        preference.put("profile.content_settings.exceptions.media_stream_camera.https://english.fdc-inc.com/.setting", "1");
        preference.put("profile.content_settings.exceptions.media_stream_mic.https://english.fdc-inc.com/.setting", "1");
        preference.put("credentials_enable_service", false);
        options.addArguments("start-maximized");
        options.addArguments("use-fake-ui-for-media-stream");
        options.setExperimentalOption("prefs", preference);
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        driver = new ChromeDriver(options);
    }

    // Perform authorized student login
    @Test
    public void TestSuccessLogin() throws InterruptedException {
        driver.get(DEVURL + "/login");
        driver.findElement(By.id("UserEmail")).sendKeys("maryrosecarcueva1+jpy08@gmail.com");
        driver.findElement(By.id("UserPassword")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@class='btn_style btn_green']")).click();
        Thread.sleep(1000);
        driver.get("https://english-staging.fdc-inc.com/mypage");
    }

    // Perform student registration
    @Test
    public void TestRegistration() throws InterruptedException {
        driver.get(DEVURL + "/register");
        String email = "maryrosecarcueva1+NCAutomation013@gmail.com";
        driver.findElement(By.id("UserEmail")).sendKeys(email);
        driver.findElement(By.id("UserEmailConfirm")).sendKeys(email);
        driver.findElement(By.id("UserPassword")).sendKeys("admin123");
        driver.findElement(By.id("UserPasswordConfirm")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@class='btn_style btn_orange m_b_20']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("UserNickname")).clear();
        Thread.sleep(1000);
        driver.findElement(By.id("UserNickname")).sendKeys("Maria Rosa");
        Thread.sleep(1000);
        Select year = new Select(driver.findElement(By.xpath("//select[@id='UserByear']")));
        year.selectByVisibleText("1995");
        Thread.sleep(1000);
        Select month = new Select(driver.findElement(By.xpath("//select[@id='UserBmonth']")));
        month.selectByVisibleText("12");
        Thread.sleep(1000);
        Select day = new Select(driver.findElement(By.xpath("//select[@id='UserBday']")));
        day.selectByVisibleText("19");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='gender_female']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn_style btn_orange']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='btn_style btn_orange func_toggle']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("zeus_token_card_number")).sendKeys("4574933171272280");
        Thread.sleep(1000);
        Select ExpiredMonth = new Select(driver.findElement(By.xpath("//select[@id='zeus_token_card_expires_month']")));
        ExpiredMonth.selectByVisibleText("4");
        Thread.sleep(1000);
        Select ExpiredYear = new Select(driver.findElement(By.xpath("//select[@id='zeus_token_card_expires_year']")));
        ExpiredYear.selectByVisibleText("2024");
        Thread.sleep(1000);
        driver.findElement(By.id("zeus_token_card_name")).sendKeys("FDC TEST ONLY");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='check_agreement']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn_style btn_orange btn_form_payment_anti_spam']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn_style btn_orange']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='quest_job1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='quest_trigger5']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='quest_reason2']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn_style btn_orange']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/mypage']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='btn_connect_test_first']"));
        String winHandleBefore = driver.getWindowHandle();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='btn_connect_test_first']")).click();
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        driver.findElement(By.xpath("//button[@id='btn_check-system_browser']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='btn_check-device_camera']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='btn_check-device_mic']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='btn_check-manual_video']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='radio_testing_video_1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='btn_check-manual_mic']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='radio_testing_mic_1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='btn_check-manual_speaker']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='radio_testing_speaker_1']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='chat_frame_row--middle']//a[@href='#']")).click();
        Thread.sleep(1000);
        driver.switchTo().window(winHandleBefore);
        driver.findElement(By.xpath("//a[@id='btn_connect_test_next']")).click();
        Thread.sleep(1000);
    }

    // Add Lesson Request and Perform Sudden Lesson
    @Test
    public void TestSuddenLesson() throws InterruptedException {
        driver.get(DEVURL + "/login");
        driver.findElement(By.xpath("//input[@id='UserEmail']")).sendKeys("maryrosecarcueva1+jpy08@gmail.com");
        driver.findElement(By.xpath("//input[@id='UserPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@class='btn_style btn_green']")).click();
        Thread.sleep(1000);

        // Add Lesson Request
        Actions action = new Actions(driver);
        WebElement Menu = driver.findElement(By.xpath("//span[@class='menu_parent_ttl menu_parent_ttl-study']"));
        WebElement MenuItem = driver.findElement(By.xpath("//div[@class='menu_links_wrap']//a[@href='#dialog_requests_for_lessons']"));
        action.moveToElement(Menu).perform();
        MenuItem.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='request1-2']")).click();
        Thread.sleep(1000);
        Select Grammar = new Select(driver.findElement(By.xpath("//select[@id='request2']")));
        Grammar.selectByVisibleText("積極的に指摘して欲しい");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//textarea[@id='request3']")).sendKeys("This is just an example message request! ");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='btn_lesson_request_save']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='dialog_requests_for_lessons-reserved']//a[@class='btn_style btn_green close_modal']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='radio_status_3']")).click();
        Thread.sleep(1000);
        Select Gender = new Select(driver.findElement(By.xpath("//select[@id='genderRadio']")));
        Gender.selectByVisibleText("女性");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='feature_12']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='feature_10']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='feature_13']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("teacherName")).sendKeys("FDC MARY");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='btn_reserve_search']")).click();
        Thread.sleep(1000);

        // Perform Sudden Lesson
        driver.findElement(By.xpath("//a[@href='/waiting/detail/1546']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='btn_style btn_lesson btn_lesson_status-standby']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='selectDefaultTextbook btn_style btn_blue close_modal']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='tooltip_btn_refresh_modal_btn_ok']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='text_chat']")).sendKeys("Hello! Teacher Mary. Good morning. Nice to meet you!");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='text_chat_submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='text_chat']")).sendKeys("How are you today? I hope you have a nice day today.");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='text_chat_submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='text_chat']")).sendKeys("Thank you so much for today's lesson Teacher Mary.");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='text_chat_submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='btn btn_exit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='btnQuit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='rating_connect_good']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='btn_modal_rating_lesson_connect_next']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='rating_text_good']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//textarea[@id='text_comment']")).sendKeys("It was very good!");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='btn_modal_rating_lesson_text_next']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@class='star rating_rate5']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='btn_comment t_link fs_16 fw_b']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//textarea[@id='user_comment2']")).sendKeys("Thank you for today's lesson Teacher Mary. See you on the next lesson!");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='rating_submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='campaign_valentine']//a[@class='btn_style btn_gray close_modal click_delay']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='dialog_rating_complete']//div[@class='rating_complete_wrap']//a[@class='btn_style btn_gray close_modal']")).click();
    }

    // View Lesson History
    @Test
    public void ViewLessonHistory() throws InterruptedException {
        driver.get(DEVURL + "/login");
        driver.findElement(By.xpath("//input[@id='UserEmail']")).sendKeys("maryrosecarcueva1+jpy08@gmail.com");
        driver.findElement(By.xpath("//input[@id='UserPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@class='btn_style btn_green']")).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement Menu = driver.findElement(By.xpath("//span[@class='menu_parent_ttl menu_parent_ttl-study']"));
        WebElement MenuItem = driver.findElement(By.xpath("//div[@class='menu_panel_inner']//a[@href='/lesson-history']"));
        action.moveToElement(Menu).perform();
        MenuItem.click();
        Thread.sleep(1000);
        Select Month = new Select(driver.findElement(By.xpath("//select[@id='select_lesson_month']")));
        Month.selectByVisibleText("2020年01月");
    }

    // Reservation and cancel of reserved lesson
    @Test
    public void TestReservedLesson() throws InterruptedException {
        driver.get(DEVURL + "/login");
        driver.findElement(By.xpath("//input[@id='UserEmail']")).sendKeys("maryrosecarcueva1+jpy08@gmail.com");
        driver.findElement(By.xpath("//input[@id='UserPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@class='btn_style btn_green']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@href='/waiting/detail/1546']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='btn_schedule_scroll']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@id='ls202000']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='dialog_reserve_cancel_rate_alert']//a[@class='btn_style btn_green close_modal']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='dialog_schedule_reserve']//a[@id='chooseReservedSchedule']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span[@class='nc_ui_checkbox_switch_slider']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='modal_window dialog dialog_alt_teacher_setting static_overlay hide']//a[@class='btn_style btn_green close_modal']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='btn_style btn_green close_modal btnReservationConfirmed']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='dialog_schedule_reserve_complete']//a[@class='btn_style btn_gray close_modal']")).click();
        Thread.sleep(1000);

        // Cancellation of reserve lesson
        Actions action = new Actions(driver);
        WebElement Menu = driver.findElement(By.xpath("//span[@class='menu_parent_ttl menu_parent_ttl-teacher']"));
        WebElement MenuItem = driver.findElement(By.xpath("//div[@class='menu_panel_inner']//a[@href='/lesson-reservation']"));
        action.moveToElement(Menu).perform();
        MenuItem.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='func_dropdown_btn dropdown_control btn_style btn_green']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='dropdown_btn btn_cancel btn_check_if_refundable']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='cancelReservedSchedule']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='dialog_schedule_cancel_refund_complete']//a[@class='btn_style btn_green close_modal']")).click();
    }

    // Perform Purchase Textbook
    @Test
    public void TestPurchaseTextbook() throws InterruptedException {
        driver.get(DEVURL + "/login");
        driver.findElement(By.xpath("//input[@id='UserEmail']")).sendKeys("maryrosecarcueva1+jpy08@gmail.com");
        driver.findElement(By.xpath("//input[@id='UserPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@class='btn_style btn_green']")).click();
        Thread.sleep(1000);
        Actions action = new Actions(driver);
        WebElement Menu = driver.findElement(By.xpath("//span[@class='menu_parent_ttl menu_parent_ttl-study']"));
        WebElement MenuItem = driver.findElement(By.xpath("//div[@class='menu_panel_inner']//a[@href='/store']"));
        action.moveToElement(Menu).perform();
        MenuItem.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='store_item_12_13']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='store_item_12_14']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//label[@for='store_item_12_15']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@class='btn_style btn_green btn_textbook_store_selector']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@id='registered_card_submit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='container cf']//a[@class='btn_style btn_green']")).click();
    }

    // Family Plan
    @Test
    public void TestFamilyPlan()throws InterruptedException {
        driver.get(DEVURL + "/login");
        driver.findElement(By.xpath("//input[@id='UserEmail']")).sendKeys("maryrosecarcueva1+NCAutomation01@gmail.com");
        driver.findElement(By.xpath("//input[@id='UserPassword']")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@class='btn_style btn_green']")).click();
        Thread.sleep(1000);

        //Add new family member
        driver.get("https://english.fdc-inc.com/account");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/family']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/family/add']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@href='/family/add_new']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='UsersEmail']")).sendKeys("maryrosecarcueva1+newchild09@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='UsersEmailConfirm']")).sendKeys("maryrosecarcueva1+newchild09@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='UsersPassword']")).sendKeys("admin123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='UsersPasswordConfirm']")).sendKeys("admin123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='UsersNickname']")).sendKeys("Mary");
        Thread.sleep(2000);
        Select DobYear = new Select(driver.findElement(By.xpath("//select[@id='UsersDobYear']")));
        DobYear.selectByVisibleText("1995");
        Thread.sleep(2000);
        Select DobMonth = new Select(driver.findElement(By.xpath("//select[@id='UsersDobMonth']")));
        DobMonth.selectByVisibleText("12");
        Thread.sleep(2000);
        Select DobDay = new Select(driver.findElement(By.xpath("//select[@id='UsersDobDay']")));
        DobDay.selectByVisibleText("17");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//label[@for='gender_famale']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn_style btn_green add_new_btn']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='ApplyPlanFamilyName']")).sendKeys("Maria Rose Carcueva");
        Thread.sleep(2000);
        Select FamilyRelation = new Select(driver.findElement(By.xpath("//select[@id='ApplyPlanRelation']")));
        FamilyRelation.selectByVisibleText("配偶者");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='submitBtnApplyPlan']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn_style btn_orange']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/family']")).click();
        Thread.sleep(2000);

        //Add existing family member
        driver.findElement(By.xpath("//a[@href='/family/add']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/family/add_exist']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='InviteEmail']")).sendKeys("maryrosecarcueva1+NCAutomation013@gmail.com");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='InvitePassword']")).sendKeys("admin123");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='btn_wrap btn_center m_t_30 m_b_30']//button[@class='btn_style btn_green']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='btn_wrap btn_center m_t_30 m_b_40']//a[@class='btn_style btn_green']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='ApplyPlanParentName']")).sendKeys("Mary Rose Canedo Carcueva");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id='ApplyPlanFamilyName']")).sendKeys("Maria Magdalena Carcueva");
        Thread.sleep(2000);
        Select ExistFamilyRelation = new Select(driver.findElement(By.xpath("//select[@id='ApplyPlanRelation']")));
        ExistFamilyRelation.selectByVisibleText("兄弟 (姉妹)");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='submitBtnApplyPlan']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@class='btn_style btn_orange']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@href='/family']")).click();
    }

    @After
        public void CloseBrowser() {
        driver.get("https://english.fdc-inc.com/logout");
        driver.quit();
        }
    }
