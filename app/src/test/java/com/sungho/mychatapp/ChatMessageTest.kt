package com.sungho.mychatapp

import io.kotlintest.specs.BehaviorSpec

class ChatMessageTest : BehaviorSpec({
    Given("i launch the app") {
        When("there is another user waiting for the connection") {
            Then("i have to be connected to another user waiting") {

            }
        }
        When("there are no other users waiting") {
            Then("i must not to be connected to anyone") {

            }
        }
    }

    Given("i'm being connected to another user") {
        When("i send a message to her") {
            Then("the message have to be sent to her normally") {

            }
        }
        When("she send me a message") {
            Then("i have to be able to get the message") {

            }
        }
    }

    Given("i received some messages before") {
        When("the connection is still opened") {
            Then("messages have to remain") {

            }
        }
        When("the connection is closed") {
            Then("messages must not to remain") {

            }
        }
    }

    Given("i refresh the chat partner") {
        Then("existing messages have to be thrown away") {

        }
        When("there is another user waiting for the connection") {
            Then("i have to be connected to another user waiting") {

            }
        }
        When("there are no other users waiting") {
            Then("i must not to be connected to anyone") {

            }
        }
    }
})