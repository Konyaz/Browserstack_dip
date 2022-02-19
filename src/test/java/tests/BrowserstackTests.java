package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;

@Tag("selenide_android")
public class BrowserstackTests extends TestBase {

    @Test
    @DisplayName("Successful tests in GoogleTranslate android app")
    void searchTest() {

        step("Go to the home page check", () -> {
            $(MobileBy.id("com.google.android.apps.translate:id/button_done")).click();
            $(MobileBy.id("com.google.android.apps.translate:id/design_menu_item_text")).click();
            $(MobileBy.id("com.google.android.apps.translate:id/toolbar_logo_text")).shouldHave(text("Translate"));

        });
        step("Input check", () -> {
            $(MobileBy.id("com.google.android.apps.translate:id/touch_to_type_text")).click();
            $(MobileBy.id("com.google.android.apps.translate:id/edit_input")).val("Hello");
            $(MobileBy.id("com.google.android.apps.translate:id/result_selector")).click();
            $(MobileBy.id("android:id/text1")).shouldHave(text("Hello"));
        });

        step("Switch language check", () -> {
            $(MobileBy.id("com.google.android.apps.translate:id/btn_lang_picker_swap")).click();
            $(MobileBy.id("com.google.android.apps.translate:id/picker1")).shouldHave(text("Spanish"));
        });
    }
}