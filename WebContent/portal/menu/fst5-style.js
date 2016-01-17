


addStylePad("pad", "item-offset:-1; offset-top:1;");
addStylePad("padSub", "item-offset:-1; offset-top:6; offset-left:-6;");

addStyleItem("itemTop", "css:itemTopOff, itemTopOn;");
addStyleItem("itemSub", "css:itemSubOff, itemSubOn;");

addStyleFont("fontTop", "css:fontOff, fontOn;");
addStyleFont("fontSub", "css:fontOff, fontOn;");

addStyleTag("tag", "css:tagOff, tagOn;");

addStyleMenu("menu", "pad", "itemTop", "fontTop", "", "", "");
addStyleMenu("sub", "pad", "itemSub", "fontSub", "tag", "", "");
addStyleMenu("sub2", "padSub", "itemSub", "fontSub", "", "", "");

addStyleGroup("group", "menu", "vtro-top");
addStyleGroup("group", "sub", "tool-sub", "game-sub", "forum-sub");
addStyleGroup("group", "sub2", "menu-sub");

addInstance("Vtro", "Vtro", "position:slot 5; menu-form:bar; align:center; valign:bottom; style:group;");
