# JavaDocs Developer's Log

1/19/2016

-Removed the Graphs button, taking the project in a new direction.

-No code done, just discussion of how our project has changed.

-Instead of graphs that display information about the text (and honestly, there's only so much to display), we will focus on perfecting the text editor itself. Word count and such can perhaps be an extra button.

-Things to work on next: 1. Fonts and format button can change only a highlighted portion of the text. 2. Word count and other info button. 3. Other general text editor stuff and making the GUI look better.

1/20/2016

-Made the interface larger.

-Switching to JEditorPane instead of JTextArea for easier formatting and such.

-Basic outline of getting selected text to change done, need to figure out how to change only the part they highlighted, as Strings do not have fonts.

1/21/2016

-Scrapping the partial formatting of selected text, will be worked on later.

-Word Count button added and mostly functional. Needs help with new lines without spaces but still have words.

-Things to work on next: 1. Perfect the Word Count. 2. Line count, Character Count, other counts. 3. Other To-Do stuff like vertical scroll functionality, prettier GUI, selecting a part of the text to format.

1/22/2016

-Word Count function reworked, I (Lawrence) had a brain fart and was using unnecessary code. Works for the most part, only bug is that new lines with words but no spaces count as a word.

-Finally found a way to implement scrolling correctly. Barebones scrolling, view is messed up.

1/23/2016

-Scrollbar now enabled. Text area should be fully functional with all the features included (except word count, which has only one slight bug, explained above).

-New GUI layout, includes rigid areas not shown.

-New bug: If you make the GUI window larger, then resize it smaller, the bounds of the text area increase and the horizontal scrollbar will appear. Purely visual, but still may need looking into.
