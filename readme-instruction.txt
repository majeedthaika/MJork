Possible moves in game are the following:
>help: Display details of current valid commands and visitable locations.
>quit: Exit from current game (back to original console).
>info: Detailed information about player status and backpack items.
>go to <location>: Travel to given <location>.
>look Information about your current location.
>talk with <person>: Interact with <person>.

Possible characters that you can talk to:
>mom: Your hardworking and caring stay-at-home mother.
>bossy: Your DOTA-addicted, always-sleepy, dessert-making friend.
>tow: The always-reliable and helpful p'Tow.
>pj: Your high, 'special' friend.

Possible locations that you can visit:
>home: Your nice, comfy home.
>muic: Your college for the next 4 (or more) years.
>1408: Your 'work' home."); break;
>1409: Your other 'work' home.
>canteen: Your snacking paradise.
>lecture: Learn here, isn't that what you're in college for???

Possible items:
>Car, DotaGameAccount, Calculator, Chappati, CheatSheet, ChickyChic, MacBook

Player Info:
currentLevel -> Current level: [currentLevel = sqrt(studyExp + socialExp)/5 - 1] -> level used for energy calculation
studyExp -> Current Study exp: [capped at 2 * socialExp] -> when you go to lecture/do homework/revise
socialExp -> Current Social exp: [capped at 2 * studyExp] -> when you interact/play with others
preparedness -> How prepared are you for next Exam: on scale of 10 -> how prepared you are for each exam
energy -> Current Energy: [energyCap = 2 * currLevel + 5] -> your energy for each day