Tatyana's Bugs:

Bug 1) Wrong number of cards in hand after smithy is drawn.

Discussion: This was the bug I introduced myself. I made the whole thing into a weird loop with a fake hand. All I had to do to fix it was to fix the discard function to discard the card from the hand position that smithy was played from, and set the trash flag to 0 (since the discarded card isn't trashed).

Bug Resolution: This bug has been resolved by fixing the variables in the function call.

Bug 2) After Village card is played, a lower number of actions exists

Discussion: This was another bug I introduced myself. This bug set the action count equal to 2 no matter what. The correct course of action is to increase the action count by 2 not set it to 2.

Bug Resolution: This was resolved by changing the equals sign to a '+=' operator.

Bug 3) Adventurer Card not netting the correct number of cards

Discussion: Tatyana made mention that I had discovered an incorrect bug when I turned over my bug report. In fact, she is wrong and it is a bug I discovered properly in my testing. The adventure card when played has no discard call so it is never discarded from the players hand. 

Bug Resolution: I haven't been able to resolve this bug fully. I believe there is more error going on than just the discard bug I found. I am fairly confident the errors reside in my tests though.

Bug 4) Council Room card causing incorrect number of cards in players hand

Discussion: Tatyana ran her check for her council room card on my code when I had not actually changed the councilRoom card at all. She reports that my card is giving an error, although notes she may have made an error in her test. Looking at the source of the problem (my code!), I see that the draw card loop is accurate and draws 4 cards to the current players hand. The number of buys for the current player is also incremented (this is also accurate). Every player except the current player appear to draw a card, and then the card is discarded. I've noted in my own work that the discard card function has a bug, but the councilRoomm card appears as if it should be in working order.

After inspecting her test results she's showing the player started with 5 cards, and the error is that 9 cards are expected in the hand and instead its only seeing 8. This does appear to be an error in the test, as there should be a net gain of 3 cards (4 new cards, discard the councilRoom card).

Bug Resolution: No actions taken, bug appears to be in the test.

Bug 5) Discard Card not actually discarding cards

Discussion: I found this bug myself and noted it in bug1.c. The discardCard function doesn't actually remove any cards from the players hand. There is nothing for it. Further, the discardCount for the player is not properly affected either. The function is meant to move a card from the current players hand at hand position, to the top of the discard pile. The existing method for replacing the hole in the hand was to move the last card in the players hand to the new gap and change the last card to a -1 then decrement the hand count. I also noted some redundant code and removed it.

Bug Resolution: Lines were added to copy the current players card at handPos in their hand to the top of the discard pile. The discardCount for that player is then incremented. Redundant code was removed because if player has only 1 card in hand, the card is already the last index of the players hand and should be treated the same (card removed, card at highest index set to -1). 

Bug 6) isGameOver not returning accurate answer for highest card supplies empty

Discussion: I noted this bug myself and found that if the three highest value cards were all empty in the supply pile the isGameOver check would return an inaccurate result. This was noted because the supply piles it looks through was a hardcoded value and not the common convention enum treasure_map.

Bug Resolution: The hardcoded value was replaced with the enum value.


I didn't receive any coverage information to work with so coverage didn't help at all in my case. My personal tests though helped convince me my personal test coverage from the previous assignments were pretty solid. I am concerned about the results of my tests. I did encounter the fact that my adventurer test was working quite as expected. I had made a few false assumptions that turned out to not be quite true for the test cases I had created. Because I knew the card was faulty, I let the test code remain faulty which doesn't help anyone. The bugs were really straightforward to identify in the code. Tatyana gave me fairly clear bug reports so I could locate the problems fairly quickly and resolve them.

Sam Schultz's Bugs:

Sam did not send me a bug report in time to properly complete his bug fixes.
