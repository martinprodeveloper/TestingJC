package com.example.testingjc.components

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class TextComponentTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            TextComponent()
        }

        //Finders
        composeTestRule.onNodeWithText("martin", ignoreCase = true)
        composeTestRule.onNodeWithTag("text2")
        composeTestRule.onNodeWithContentDescription("image1")

        composeTestRule.onAllNodesWithText("a")
        composeTestRule.onAllNodesWithTag("text1")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")

        //Actions
        composeTestRule.onNodeWithText("martin", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("a").onFirst().performClick()

        composeTestRule.onNodeWithText("martin").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        composeTestRule.onNodeWithText("martin").performScrollTo().performClick().performTextInput("")
        composeTestRule.onNodeWithText("martin").performImeAction()
        composeTestRule.onNodeWithText("martin").performTextClearance()
        composeTestRule.onNodeWithText("martin").performTextInput("textInput")
        composeTestRule.onNodeWithText("martin").performTextReplacement("textReplacement")

        //Assertions
        composeTestRule.onNodeWithText("martin").assertExists()
        composeTestRule.onNodeWithText("martin").assertDoesNotExist()
        composeTestRule.onNodeWithText("martin").assertContentDescriptionEquals("MARTIN")
        composeTestRule.onNodeWithText("martin").assertContentDescriptionContains("MARTIN")
        composeTestRule.onNodeWithText("martin").assertIsDisplayed()
        composeTestRule.onNodeWithText("martin").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("martin").assertIsEnabled()
        composeTestRule.onNodeWithText("martin").assertIsNotEnabled()
        composeTestRule.onNodeWithText("martin").assertIsSelected()
        composeTestRule.onNodeWithText("martin").assertIsNotSelected()
        composeTestRule.onNodeWithText("martin").assertIsFocused()
        composeTestRule.onNodeWithText("martin").assertIsNotFocused()
        composeTestRule.onNodeWithText("martin").assertIsOn()
        composeTestRule.onNodeWithText("martin").assertIsOff()
        composeTestRule.onNodeWithText("martin").assertTextEquals("")
        composeTestRule.onNodeWithText("martin").assertTextContains("Martin")

    }

    @Test
    fun whenComponentStart_thenVerifyContentIsMartin(){
        composeTestRule.setContent {
            TextComponent()
        }

        composeTestRule.onNodeWithText("martin", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("Martin")
    }

    @Test
    fun whenNameIsAdded_thenVerifyTextContainGreeting(){
        composeTestRule.setContent {
            TextComponent()
        }

        composeTestRule.onNodeWithTag("textFieldName").performTextClearance()
        composeTestRule.onNodeWithTag("textFieldName").performTextInput("Pepe")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Te llamas Pepe")
    }

}